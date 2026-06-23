package com.streaming.musica.domain.transaction;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "transactions")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Transaction {

    @Id
    private UUID id;

    @Column(name = "account_id", nullable = false)
    private UUID accountId;

    @Embedded
    private Money amount;

    @Embedded
    private Merchant merchant;

    @Column(nullable = false)
    private LocalDateTime occurredAt;

    @Column(nullable = false)
    private boolean approved;

    public Transaction(UUID accountId, Money amount, Merchant merchant) {
        Objects.requireNonNull(accountId, "ID da conta é obrigatório");
        Objects.requireNonNull(amount, "Valor é obrigatório");
        Objects.requireNonNull(merchant, "Comerciante é obrigatório");
        this.id = UUID.randomUUID();
        this.accountId = accountId;
        this.amount = amount;
        this.merchant = merchant;
        this.occurredAt = LocalDateTime.now();
        this.approved = false;
    }

    public void approve() {
        this.approved = true;
    }

    public boolean isSimilarTo(Transaction other) {
        return this.amount.equals(other.amount) && this.merchant.equals(other.merchant);
    }
}
