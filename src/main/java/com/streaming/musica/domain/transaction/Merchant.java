package com.streaming.musica.domain.transaction;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Merchant {

    @Column(name = "merchant_name", nullable = false)
    private String name;

    public Merchant(String name) {
        Objects.requireNonNull(name, "Nome do comerciante é obrigatório");
        if (name.isBlank()) {
            throw new IllegalArgumentException("Nome do comerciante não pode ser vazio");
        }
        this.name = name.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Merchant merchant)) return false;
        return Objects.equals(name, merchant.name);
    }

    @Override
    public int hashCode() { return Objects.hash(name); }
}
