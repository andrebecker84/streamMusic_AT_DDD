package com.streaming.musica.application.transaction;

import java.math.BigDecimal;
import java.util.UUID;

public record AutorizarTransacaoCommand(
        UUID contaId,
        BigDecimal valor,
        String nomeComercio
) {}
