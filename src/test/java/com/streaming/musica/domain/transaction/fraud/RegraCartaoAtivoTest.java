package com.streaming.musica.domain.transaction.fraud;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RegraCartaoAtivoTest {

    private final RegraCartaoAtivo regra = new RegraCartaoAtivo();

    @Test
    void deveRetornarViolacaoQuandoCartaoCadastradoMasInativo() {
        // Arrange
        var contexto = new FraudValidationContext(true, false, true, 0, 0);

        // Act
        var resultado = regra.validar(contexto);

        // Assert
        assertThat(resultado).isPresent();
        assertThat(resultado.get()).isEqualTo(FraudViolation.CARTAO_NAO_ATIVO);
    }

    @Test
    void naoDeveRetornarViolacaoQuandoCartaoAtivo() {
        // Arrange
        var contexto = new FraudValidationContext(true, true, true, 0, 0);

        // Act
        var resultado = regra.validar(contexto);

        // Assert
        assertThat(resultado).isEmpty();
    }

    @Test
    void naoDeveRetornarViolacaoQuandoNaoHaCartao() {
        // Arrange — sem cartão é tratado por RegraCartaoValido, não por esta regra
        var contexto = new FraudValidationContext(false, false, true, 0, 0);

        // Act
        var resultado = regra.validar(contexto);

        // Assert
        assertThat(resultado).isEmpty();
    }
}
