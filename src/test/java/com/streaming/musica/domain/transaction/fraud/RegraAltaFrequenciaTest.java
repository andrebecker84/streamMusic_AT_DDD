package com.streaming.musica.domain.transaction.fraud;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RegraAltaFrequenciaTest {

    private final RegraAltaFrequenciaPequenoIntervalo regra = new RegraAltaFrequenciaPequenoIntervalo();

    @Test
    void deveRetornarViolacaoQuandoTresOuMaisTransacoesRecentes() {
        // Arrange
        var contexto = new FraudValidationContext(true, true, true, 3, 0);

        // Act
        var resultado = regra.validar(contexto);

        // Assert
        assertThat(resultado).isPresent();
        assertThat(resultado.get()).isEqualTo(FraudViolation.ALTA_FREQUENCIA_PEQUENO_INTERVALO);
    }

    @Test
    void naoDeveRetornarViolacaoComMenosDeTresTransacoesRecentes() {
        // Arrange
        var contexto = new FraudValidationContext(true, true, true, 2, 0);

        // Act
        var resultado = regra.validar(contexto);

        // Assert
        assertThat(resultado).isEmpty();
    }
}
