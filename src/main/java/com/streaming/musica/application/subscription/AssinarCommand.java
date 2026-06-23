package com.streaming.musica.application.subscription;

import com.streaming.musica.domain.subscription.PlanType;

import java.util.UUID;

public record AssinarCommand(UUID contaId, PlanType tipoPlano) {}
