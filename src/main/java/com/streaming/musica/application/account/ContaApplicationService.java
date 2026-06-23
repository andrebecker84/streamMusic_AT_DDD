package com.streaming.musica.application.account;

import com.streaming.musica.domain.account.Account;
import com.streaming.musica.domain.account.AccountRepository;
import com.streaming.musica.domain.account.CreditCard;
import com.streaming.musica.shared.BusinessRuleException;
import com.streaming.musica.shared.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ContaApplicationService {

    private final AccountRepository accountRepository;

    public ContaApplicationService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account criarConta(CriarContaCommand command) {
        if (accountRepository.existsByEmail(command.email())) {
            throw new BusinessRuleException("E-mail já cadastrado: " + command.email());
        }
        var conta = new Account(command.nome(), command.email(), cartaoDoComando(command));
        return accountRepository.save(conta);
    }

    private CreditCard cartaoDoComando(CriarContaCommand command) {
        if (command.numeroCartao() == null || command.numeroCartao().isBlank()) {
            return null;
        }
        return new CreditCard(command.numeroCartao(), command.cartaoAtivo(), command.limiteCartao());
    }

    @Transactional(readOnly = true)
    public List<Account> listarTodas() {
        return accountRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Account buscarPorId(UUID contaId) {
        return accountRepository.findById(contaId)
                .orElseThrow(() -> new EntityNotFoundException("Conta não encontrada: " + contaId));
    }
}
