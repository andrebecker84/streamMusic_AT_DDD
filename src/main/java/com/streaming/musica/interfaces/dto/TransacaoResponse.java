package com.streaming.musica.interfaces.dto;

import com.streaming.musica.application.transaction.ResultadoTransacao;
import com.streaming.musica.domain.transaction.fraud.FraudViolation;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record TransacaoResponse(
        UUID transacaoId,
        UUID contaId,
        BigDecimal valor,
        String nomeComercio,
        LocalDateTime realizadaEm,
        boolean aprovada,
        List<String> violacoes
) {
    public static TransacaoResponse from(ResultadoTransacao resultado) {
        return new TransacaoResponse(
                resultado.transacao().getId(),
                resultado.transacao().getAccountId(),
                resultado.transacao().getAmount().getAmount(),
                resultado.transacao().getMerchant().getName(),
                resultado.transacao().getOccurredAt(),
                resultado.isAprovada(),
                resultado.violacoes().stream().map(FraudViolation::getCodigo).toList()
        );
    }
}
