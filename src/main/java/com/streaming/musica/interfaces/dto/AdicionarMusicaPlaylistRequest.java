package com.streaming.musica.interfaces.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AdicionarMusicaPlaylistRequest(
        @NotNull(message = "ID da conta é obrigatório") UUID contaId,
        @NotNull(message = "ID da música é obrigatório") UUID musicaId
) {}
