package com.streaming.musica.application.transaction;

import com.streaming.musica.domain.account.AccountRepository;
import com.streaming.musica.domain.subscription.SubscriptionRepository;
import com.streaming.musica.domain.transaction.Merchant;
import com.streaming.musica.domain.transaction.Money;
import com.streaming.musica.domain.transaction.Transaction;
import com.streaming.musica.domain.transaction.TransactionRepository;
import com.streaming.musica.domain.transaction.fraud.FraudValidationContext;
import com.streaming.musica.domain.transaction.fraud.ServicoAntifraude;
import com.streaming.musica.shared.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class TransacaoApplicationService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final ServicoAntifraude servicoAntifraude;

    public TransacaoApplicationService(
            TransactionRepository transactionRepository,
            AccountRepository accountRepository,
            SubscriptionRepository subscriptionRepository,
            ServicoAntifraude servicoAntifraude) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.subscriptionRepository = subscriptionRepository;
        this.servicoAntifraude = servicoAntifraude;
    }

    public ResultadoTransacao autorizar(AutorizarTransacaoCommand command) {
        var conta = accountRepository.findById(command.contaId())
                .orElseThrow(() -> new EntityNotFoundException("Conta não encontrada: " + command.contaId()));

        var assinaturaAtiva = subscriptionRepository.findActiveByAccountId(command.contaId());

        var transacao = new Transaction(
                command.contaId(),
                new Money(command.valor()),
                new Merchant(command.nomeComercio())
        );

        var transacoesRecentes = transactionRepository.findByAccountIdAndOccurredAtAfter(
                command.contaId(),
                LocalDateTime.now().minusMinutes(2)
        );

        var transacoesSemelhantes = transacoesRecentes.stream()
                .filter(transacaoRecente -> transacaoRecente.isSimilarTo(transacao))
                .count();

        var contexto = new FraudValidationContext(
                conta.hasCreditCard(),
                conta.isCardActive(),
                assinaturaAtiva.isPresent(),
                transacoesRecentes.size(),
                (int) transacoesSemelhantes
        );
        var violacoes = servicoAntifraude.validar(contexto);

        if (violacoes.isEmpty()) {
            transacao.approve();
        }

        transactionRepository.save(transacao);
        return new ResultadoTransacao(transacao, violacoes);
    }
}
