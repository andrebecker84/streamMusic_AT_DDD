package com.streaming.musica.application.account;

import java.math.BigDecimal;

public record CriarContaCommand(
        String nome,
        String email,
        String numeroCartao,
        boolean cartaoAtivo,
        BigDecimal limiteCartao
) {}
