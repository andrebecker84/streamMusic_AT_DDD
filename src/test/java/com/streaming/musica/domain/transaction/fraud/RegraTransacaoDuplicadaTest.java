package com.streaming.musica.domain.transaction.fraud;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RegraTransacaoDuplicadaTest {

    private final RegraTransacaoDuplicada regra = new RegraTransacaoDuplicada();

    @Test
    void deveRetornarViolacaoComDuasOuMaisTransacoesSemelhantes() {
        // Arrange
        var contexto = new FraudValidationContext(true, true, true, 2, 2);

        // Act
        var resultado = regra.validar(contexto);

        // Assert
        assertThat(resultado).isPresent();
        assertThat(resultado.get()).isEqualTo(FraudViolation.TRANSACAO_DUPLICADA);
    }

    @Test
    void naoDeveRetornarViolacaoComMenosDeDuasTransacoesSemelhantes() {
        // Arrange
        var contexto = new FraudValidationContext(true, true, true, 3, 1);

        // Act
        var resultado = regra.validar(contexto);

        // Assert
        assertThat(resultado).isEmpty();
    }
}
