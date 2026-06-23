package com.streaming.musica.interfaces.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record FavoritarMusicaRequest(
        @NotNull(message = "ID da música é obrigatório") UUID musicaId
) {}
