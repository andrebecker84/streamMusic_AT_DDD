package com.streaming.musica.domain.transaction.fraud;

import java.util.Optional;

public interface RegraAntifraude {

    Optional<FraudViolation> validar(FraudValidationContext contexto);
}
