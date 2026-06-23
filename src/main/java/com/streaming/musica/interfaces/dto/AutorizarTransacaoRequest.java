package com.streaming.musica.interfaces.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record AutorizarTransacaoRequest(
        @NotNull(message = "ID da conta é obrigatório") UUID contaId,
        @NotNull(message = "Valor é obrigatório") @DecimalMin(value = "0.01", message = "Valor deve ser positivo") BigDecimal valor,
        @NotBlank(message = "Nome do comércio é obrigatório") String nomeComercio
) {}
