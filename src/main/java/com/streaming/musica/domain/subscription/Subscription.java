package com.streaming.musica.domain.subscription;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "subscriptions")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Subscription {

    @Id
    private UUID id;

    @Column(name = "account_id", nullable = false)
    private UUID accountId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PlanType planType;

    @Column(nullable = false)
    private boolean active;

    @Column(nullable = false)
    private LocalDateTime subscribedAt;

    private LocalDateTime cancelledAt;

    public Subscription(UUID accountId, PlanType planType) {
        Objects.requireNonNull(accountId, "ID da conta é obrigatório");
        Objects.requireNonNull(planType, "Tipo de plano é obrigatório");
        this.id = UUID.randomUUID();
        this.accountId = accountId;
        this.planType = planType;
        this.active = true;
        this.subscribedAt = LocalDateTime.now();
    }

    public void cancel() {
        if (!active) {
            throw new IllegalStateException("Assinatura já foi cancelada");
        }
        this.active = false;
        this.cancelledAt = LocalDateTime.now();
    }
}
