package com.streaming.musica.domain.transaction;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class TransactionTest {

    private final UUID contaId = UUID.randomUUID();

    @Test
    void deveSerSemelhanteQuandoMesmoValorEComerciante() {
        // Arrange
        var transacao = new Transaction(contaId, new Money(BigDecimal.valueOf(50)), new Merchant("Burger King"));
        var outra = new Transaction(contaId, new Money(BigDecimal.valueOf(50)), new Merchant("Burger King"));

        // Act
        var semelhante = transacao.isSimilarTo(outra);

        // Assert
        assertThat(semelhante).isTrue();
    }

    @Test
    void naoDeveSerSemelhanteComValorDiferente() {
        // Arrange
        var transacao = new Transaction(contaId, new Money(BigDecimal.valueOf(50)), new Merchant("Burger King"));
        var outra = new Transaction(contaId, new Money(BigDecimal.valueOf(40)), new Merchant("Burger King"));

        // Act
        var semelhante = transacao.isSimilarTo(outra);

        // Assert
        assertThat(semelhante).isFalse();
    }

    @Test
    void naoDeveSerSemelhanteComComercianteDiferente() {
        // Arrange
        var transacao = new Transaction(contaId, new Money(BigDecimal.valueOf(50)), new Merchant("Burger King"));
        var outra = new Transaction(contaId, new Money(BigDecimal.valueOf(50)), new Merchant("McDonald's"));

        // Act
        var semelhante = transacao.isSimilarTo(outra);

        // Assert
        assertThat(semelhante).isFalse();
    }
}
