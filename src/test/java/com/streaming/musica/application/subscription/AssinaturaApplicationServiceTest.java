package com.streaming.musica.application.subscription;

import com.streaming.musica.domain.account.Account;
import com.streaming.musica.domain.account.AccountRepository;
import com.streaming.musica.domain.account.CreditCard;
import com.streaming.musica.domain.subscription.PlanType;
import com.streaming.musica.domain.subscription.Subscription;
import com.streaming.musica.domain.subscription.SubscriptionRepository;
import com.streaming.musica.shared.BusinessRuleException;
import com.streaming.musica.shared.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AssinaturaApplicationServiceTest {

    @Mock SubscriptionRepository subscriptionRepository;
    @Mock AccountRepository accountRepository;

    @InjectMocks
    AssinaturaApplicationService service;

    @Test
    void deveAssinarPlanoComSucesso() {
        // Arrange
        var conta = contaDeTeste();
        var command = new AssinarCommand(conta.getId(), PlanType.PREMIUM);
        when(accountRepository.findById(conta.getId())).thenReturn(Optional.of(conta));
        when(subscriptionRepository.hasActiveSubscription(conta.getId())).thenReturn(false);
        when(subscriptionRepository.save(any())).thenAnswer(inv -> inv.getArgument(0));

        // Act
        var assinatura = service.assinar(command);

        // Assert
        assertThat(assinatura.getPlanType()).isEqualTo(PlanType.PREMIUM);
        assertThat(assinatura.isActive()).isTrue();
        verify(subscriptionRepository).save(any(Subscription.class));
    }

    @Test
    void deveLancarExcecaoQuandoJaPossuiPlanoAtivo() {
        // Arrange
        var conta = contaDeTeste();
        var command = new AssinarCommand(conta.getId(), PlanType.BASICO);
        when(accountRepository.findById(conta.getId())).thenReturn(Optional.of(conta));
        when(subscriptionRepository.hasActiveSubscription(conta.getId())).thenReturn(true);

        // Act & Assert
        assertThatThrownBy(() -> service.assinar(command))
                .isInstanceOf(BusinessRuleException.class)
                .hasMessageContaining("plano ativo");
        verify(subscriptionRepository, never()).save(any());
    }

    @Test
    void deveLancarExcecaoQuandoContaNaoEncontradaAoAssinar() {
        // Arrange
        var command = new AssinarCommand(java.util.UUID.randomUUID(), PlanType.PREMIUM);
        when(accountRepository.findById(any())).thenReturn(Optional.empty());

        // Act & Assert
        assertThatThrownBy(() -> service.assinar(command))
                .isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void deveCancelarAssinaturaAtiva() {
        // Arrange
        var conta = contaDeTeste();
        var assinatura = new Subscription(conta.getId(), PlanType.PREMIUM);
        when(subscriptionRepository.findActiveByAccountId(conta.getId()))
                .thenReturn(Optional.of(assinatura));
        when(subscriptionRepository.save(any())).thenAnswer(inv -> inv.getArgument(0));

        // Act
        service.cancelar(conta.getId());

        // Assert
        assertThat(assinatura.isActive()).isFalse();
        assertThat(assinatura.getCancelledAt()).isNotNull();
        verify(subscriptionRepository).save(assinatura);
    }

    @Test
    void deveLancarExcecaoAoCancelarSemAssinaturaAtiva() {
        // Arrange
        var contaId = java.util.UUID.randomUUID();
        when(subscriptionRepository.findActiveByAccountId(contaId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThatThrownBy(() -> service.cancelar(contaId))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessageContaining("Nenhuma assinatura ativa");
    }

    private Account contaDeTeste() {
        return new Account("Test User", "test@test.com",
                new CreditCard("4111-1111-1111-1111", true, BigDecimal.valueOf(5000)));
    }
}
