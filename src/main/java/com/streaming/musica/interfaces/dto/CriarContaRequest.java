package com.streaming.musica.interfaces.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record CriarContaRequest(
        @NotBlank(message = "Nome é obrigatório") String nome,
        @NotBlank(message = "E-mail é obrigatório") @Email(message = "E-mail inválido") String email,
        String numeroCartao,
        boolean cartaoAtivo,
        @DecimalMin(value = "0.0", message = "Limite deve ser não-negativo") BigDecimal limiteCartao
) {}
