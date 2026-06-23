package com.streaming.musica.domain.transaction.fraud;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Order(4)
public class RegraAltaFrequenciaPequenoIntervalo implements RegraAntifraude {

    private static final int LIMITE_TRANSACOES = 3;

    @Override
    public Optional<FraudViolation> validar(FraudValidationContext contexto) {
        if (contexto.quantidadeTransacoesRecentes() >= LIMITE_TRANSACOES) {
            return Optional.of(FraudViolation.ALTA_FREQUENCIA_PEQUENO_INTERVALO);
        }
        return Optional.empty();
    }
}
