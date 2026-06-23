package com.streaming.musica.application.transaction;

import com.streaming.musica.domain.account.Account;
import com.streaming.musica.domain.account.AccountRepository;
import com.streaming.musica.domain.account.CreditCard;
import com.streaming.musica.domain.subscription.PlanType;
import com.streaming.musica.domain.subscription.Subscription;
import com.streaming.musica.domain.subscription.SubscriptionRepository;
import com.streaming.musica.domain.transaction.Merchant;
import com.streaming.musica.domain.transaction.Money;
import com.streaming.musica.domain.transaction.Transaction;
import com.streaming.musica.domain.transaction.TransactionRepository;
import com.streaming.musica.domain.transaction.fraud.FraudValidationContext;
import com.streaming.musica.domain.transaction.fraud.FraudViolation;
import com.streaming.musica.domain.transaction.fraud.ServicoAntifraude;
import com.streaming.musica.shared.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransacaoApplicationServiceTest {

    @Mock AccountRepository accountRepository;
    @Mock SubscriptionRepository subscriptionRepository;
    @Mock TransactionRepository transactionRepository;
    @Mock ServicoAntifraude servicoAntifraude;

    @InjectMocks
    TransacaoApplicationService service;

    @Test
    void deveAprovarTransacaoQuandoSemViolacoes() {
        // Arrange
        var conta = contaAtiva();
        var assinatura = Optional.of(new Subscription(conta.getId(), PlanType.PREMIUM));
        var command = new AutorizarTransacaoCommand(conta.getId(), BigDecimal.TEN, "StreamStore");
        when(accountRepository.findById(conta.getId())).thenReturn(Optional.of(conta));
        when(subscriptionRepository.findActiveByAccountId(conta.getId())).thenReturn(assinatura);
        when(transactionRepository.findByAccountIdAndOccurredAtAfter(any(), any())).thenReturn(List.of());
        when(servicoAntifraude.validar(any(FraudValidationContext.class))).thenReturn(List.of());
        when(transactionRepository.save(any())).thenAnswer(inv -> inv.getArgument(0));

        // Act
        var resultado = service.autorizar(command);

        // Assert
        assertThat(resultado.isAprovada()).isTrue();
        assertThat(resultado.violacoes()).isEmpty();
        verify(transactionRepository).save(argThat(Transaction::isApproved));
    }

    @Test
    void deveRejeitarTransacaoComCartaoInativo() {
        // Arrange
        var conta = contaComCartaoInativo();
        var command = new AutorizarTransacaoCommand(conta.getId(), BigDecimal.TEN, "CinemaPlus");
        when(accountRepository.findById(conta.getId())).thenReturn(Optional.of(conta));
        when(subscriptionRepository.findActiveByAccountId(conta.getId())).thenReturn(Optional.empty());
        when(transactionRepository.findByAccountIdAndOccurredAtAfter(any(), any())).thenReturn(List.of());
        when(servicoAntifraude.validar(any())).thenReturn(
                List.of(FraudViolation.CARTAO_NAO_ATIVO, FraudViolation.PLANO_ATIVO_INVALIDO));
        when(transactionRepository.save(any())).thenAnswer(inv -> inv.getArgument(0));

        // Act
        var resultado = service.autorizar(command);

        // Assert
        assertThat(resultado.isAprovada()).isFalse();
        assertThat(resultado.violacoes()).containsExactlyInAnyOrder(
                FraudViolation.CARTAO_NAO_ATIVO, FraudViolation.PLANO_ATIVO_INVALIDO);
        verify(transactionRepository).save(argThat(t -> !t.isApproved()));
    }

    @Test
    void deveSempreSalvarTransacaoMesmoRejeitada() {
        // Arrange
        var conta = contaAtiva();
        var command = new AutorizarTransacaoCommand(conta.getId(), BigDecimal.ONE, "iFood");
        when(accountRepository.findById(conta.getId())).thenReturn(Optional.of(conta));
        when(subscriptionRepository.findActiveByAccountId(any())).thenReturn(Optional.empty());
        when(transactionRepository.findByAccountIdAndOccurredAtAfter(any(), any())).thenReturn(List.of());
        when(servicoAntifraude.validar(any())).thenReturn(List.of(FraudViolation.PLANO_ATIVO_INVALIDO));
        when(transactionRepository.save(any())).thenAnswer(inv -> inv.getArgument(0));

        // Act
        service.autorizar(command);

        // Assert
        verify(transactionRepository, times(1)).save(any());
    }

    @Test
    void deveLancarExcecaoQuandoContaNaoEncontrada() {
        // Arrange
        var command = new AutorizarTransacaoCommand(
                java.util.UUID.randomUUID(), BigDecimal.TEN, "StreamStore");
        when(accountRepository.findById(any())).thenReturn(Optional.empty());

        // Act & Assert
        assertThatThrownBy(() -> service.autorizar(command))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessageContaining("Conta não encontrada");
    }

    @Test
    void deveChamarTodasAsRegrasDeAntifraude() {
        // Arrange
        var conta = contaAtiva();
        var transacoes = List.of(
                new Transaction(conta.getId(), new Money(BigDecimal.TEN), new Merchant("StreamStore")),
                new Transaction(conta.getId(), new Money(BigDecimal.TEN), new Merchant("StreamStore")),
                new Transaction(conta.getId(), new Money(BigDecimal.TEN), new Merchant("StreamStore"))
        );
        var command = new AutorizarTransacaoCommand(conta.getId(), BigDecimal.TEN, "StreamStore");
        when(accountRepository.findById(conta.getId())).thenReturn(Optional.of(conta));
        when(subscriptionRepository.findActiveByAccountId(any())).thenReturn(Optional.empty());
        when(transactionRepository.findByAccountIdAndOccurredAtAfter(any(), any())).thenReturn(transacoes);
        when(servicoAntifraude.validar(any())).thenReturn(List.of());
        when(transactionRepository.save(any())).thenAnswer(inv -> inv.getArgument(0));

        // Act
        service.autorizar(command);

        // Assert
        verify(servicoAntifraude).validar(argThat(ctx ->
                ctx.quantidadeTransacoesRecentes() == 3));
    }

    private Account contaAtiva() {
        return new Account("João", "joao@test.com",
                new CreditCard("4111-1111-1111-1111", true, BigDecimal.valueOf(5000)));
    }

    private Account contaComCartaoInativo() {
        return new Account("Pedro", "pedro@test.com",
                new CreditCard("3714-496353-98431", false, BigDecimal.valueOf(8000)));
    }
}
