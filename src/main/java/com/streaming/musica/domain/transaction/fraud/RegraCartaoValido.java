package com.streaming.musica.domain.transaction.fraud;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Order(1)
public class RegraCartaoValido implements RegraAntifraude {

    @Override
    public Optional<FraudViolation> validar(FraudValidationContext contexto) {
        if (!contexto.cartaoCadastrado()) {
            return Optional.of(FraudViolation.CARTAO_CREDITO_INVALIDO);
        }
        return Optional.empty();
    }
}
