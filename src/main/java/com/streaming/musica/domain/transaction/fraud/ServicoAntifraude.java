package com.streaming.musica.domain.transaction.fraud;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoAntifraude {

    private final List<RegraAntifraude> regras;

    public ServicoAntifraude(List<RegraAntifraude> regras) {
        this.regras = regras;
    }

    public List<FraudViolation> validar(FraudValidationContext contexto) {
        return regras.stream()
                .map(regra -> regra.validar(contexto))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }
}
