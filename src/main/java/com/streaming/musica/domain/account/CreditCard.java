package com.streaming.musica.domain.account;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreditCard {

    @Column(name = "card_number")
    private String number;

    @Column(name = "card_active")
    private boolean active;

    @Column(name = "card_limit")
    private BigDecimal limit;

    public CreditCard(String number, boolean active, BigDecimal limit) {
        Objects.requireNonNull(number, "Número do cartão é obrigatório");
        Objects.requireNonNull(limit, "Limite do cartão é obrigatório");
        this.number = number;
        this.active = active;
        this.limit = limit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreditCard card)) return false;
        return Objects.equals(number, card.number);
    }

    @Override
    public int hashCode() { return Objects.hash(number); }
}
