package com.streaming.musica.domain.transaction.fraud;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RegraCartaoValidoTest {

    private final RegraCartaoValido regra = new RegraCartaoValido();

    @Test
    void deveRetornarViolacaoQuandoContaNaoTemCartao() {
        // Arrange
        var contexto = new FraudValidationContext(false, false, true, 0, 0);

        // Act
        var resultado = regra.validar(contexto);

        // Assert
        assertThat(resultado).isPresent();
        assertThat(resultado.get()).isEqualTo(FraudViolation.CARTAO_CREDITO_INVALIDO);
    }

    @Test
    void naoDeveRetornarViolacaoQuandoContaTemCartao() {
        // Arrange
        var contexto = new FraudValidationContext(true, true, true, 0, 0);

        // Act
        var resultado = regra.validar(contexto);

        // Assert
        assertThat(resultado).isEmpty();
    }
}
