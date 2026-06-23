package com.streaming.musica.domain.transaction.fraud;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Order(2)
public class RegraCartaoAtivo implements RegraAntifraude {

    @Override
    public Optional<FraudViolation> validar(FraudValidationContext contexto) {
        if (contexto.cartaoCadastrado() && !contexto.cartaoAtivo()) {
            return Optional.of(FraudViolation.CARTAO_NAO_ATIVO);
        }
        return Optional.empty();
    }
}
