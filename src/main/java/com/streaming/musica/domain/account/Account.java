package com.streaming.musica.domain.account;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "accounts")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Embedded
    private CreditCard creditCard;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public Account(String name, String email) {
        this(name, email, null);
    }

    public Account(String name, String email, CreditCard creditCard) {
        Objects.requireNonNull(name, "Nome é obrigatório");
        Objects.requireNonNull(email, "E-mail é obrigatório");
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.creditCard = creditCard;
        this.createdAt = LocalDateTime.now();
    }

    public boolean hasCreditCard() {
        return creditCard != null;
    }

    public boolean isCardActive() {
        return hasCreditCard() && creditCard.isActive();
    }
}
