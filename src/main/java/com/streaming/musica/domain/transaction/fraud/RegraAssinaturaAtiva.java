package com.streaming.musica.domain.transaction.fraud;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Order(3)
public class RegraAssinaturaAtiva implements RegraAntifraude {

    @Override
    public Optional<FraudViolation> validar(FraudValidationContext contexto) {
        if (!contexto.assinaturaAtiva()) {
            return Optional.of(FraudViolation.PLANO_ATIVO_INVALIDO);
        }
        return Optional.empty();
    }
}
