package com.streaming.musica.interfaces.dto;

import com.streaming.musica.domain.account.Account;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ContaResponse(
        UUID id,
        String nome,
        String email,
        String numeroCartao,
        boolean cartaoAtivo,
        BigDecimal limiteCartao,
        LocalDateTime criadoEm
) {
    public static ContaResponse from(Account conta) {
        var cartao = conta.getCreditCard();
        return new ContaResponse(
                conta.getId(),
                conta.getName(),
                conta.getEmail(),
                cartao != null ? cartao.getNumber() : null,
                conta.isCardActive(),
                cartao != null ? cartao.getLimit() : null,
                conta.getCreatedAt()
        );
    }
}
