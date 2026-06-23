package com.streaming.musica.interfaces.dto;

import com.streaming.musica.domain.subscription.PlanType;
import com.streaming.musica.domain.subscription.Subscription;

import java.time.LocalDateTime;
import java.util.UUID;

public record AssinaturaResponse(
        UUID id,
        UUID contaId,
        PlanType tipoPlano,
        boolean ativa,
        LocalDateTime assinadoEm,
        LocalDateTime canceladoEm
) {
    public static AssinaturaResponse from(Subscription assinatura) {
        return new AssinaturaResponse(
                assinatura.getId(),
                assinatura.getAccountId(),
                assinatura.getPlanType(),
                assinatura.isActive(),
                assinatura.getSubscribedAt(),
                assinatura.getCancelledAt()
        );
    }
}
