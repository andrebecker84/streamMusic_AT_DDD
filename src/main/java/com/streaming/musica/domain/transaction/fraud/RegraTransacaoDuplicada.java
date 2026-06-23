package com.streaming.musica.domain.transaction.fraud;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Order(5)
public class RegraTransacaoDuplicada implements RegraAntifraude {

    private static final int LIMITE_SIMILARES = 2;

    @Override
    public Optional<FraudViolation> validar(FraudValidationContext contexto) {
        if (contexto.quantidadeTransacoesSemelhantes() >= LIMITE_SIMILARES) {
            return Optional.of(FraudViolation.TRANSACAO_DUPLICADA);
        }
        return Optional.empty();
    }
}
