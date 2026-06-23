package com.streaming.musica.interfaces.dto;

import com.streaming.musica.domain.subscription.PlanType;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AssinarRequest(
        @NotNull(message = "ID da conta é obrigatório") UUID contaId,
        @NotNull(message = "Tipo de plano é obrigatório") PlanType tipoPlano
) {}
