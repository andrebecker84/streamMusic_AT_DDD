package com.streaming.musica.application.subscription;

import com.streaming.musica.domain.account.AccountRepository;
import com.streaming.musica.domain.subscription.Subscription;
import com.streaming.musica.domain.subscription.SubscriptionRepository;
import com.streaming.musica.shared.BusinessRuleException;
import com.streaming.musica.shared.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class AssinaturaApplicationService {

    private final SubscriptionRepository subscriptionRepository;
    private final AccountRepository accountRepository;

    public AssinaturaApplicationService(
            SubscriptionRepository subscriptionRepository,
            AccountRepository accountRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.accountRepository = accountRepository;
    }

    public Subscription assinar(AssinarCommand command) {
        accountRepository.findById(command.contaId())
                .orElseThrow(() -> new EntityNotFoundException("Conta não encontrada: " + command.contaId()));

        if (subscriptionRepository.hasActiveSubscription(command.contaId())) {
            throw new BusinessRuleException("Conta já possui um plano ativo. Cancele o atual antes de assinar um novo.");
        }

        var assinatura = new Subscription(command.contaId(), command.tipoPlano());
        return subscriptionRepository.save(assinatura);
    }

    public void cancelar(UUID contaId) {
        var assinatura = subscriptionRepository.findActiveByAccountId(contaId)
                .orElseThrow(() -> new EntityNotFoundException("Nenhuma assinatura ativa encontrada para a conta: " + contaId));
        assinatura.cancel();
        subscriptionRepository.save(assinatura);
    }

    @Transactional(readOnly = true)
    public Optional<Subscription> buscarAtivaPorConta(UUID contaId) {
        return subscriptionRepository.findActiveByAccountId(contaId);
    }
}
