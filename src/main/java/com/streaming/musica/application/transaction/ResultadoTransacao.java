package com.streaming.musica.application.transaction;

import com.streaming.musica.domain.transaction.Transaction;
import com.streaming.musica.domain.transaction.fraud.FraudViolation;

import java.util.List;

public record ResultadoTransacao(
        Transaction transacao,
        List<FraudViolation> violacoes
) {
    public boolean isAprovada() {
        return violacoes.isEmpty();
    }
}
