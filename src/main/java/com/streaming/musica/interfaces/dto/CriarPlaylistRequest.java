package com.streaming.musica.interfaces.dto;

import jakarta.validation.constraints.NotBlank;

public record CriarPlaylistRequest(
        @NotBlank(message = "Nome da playlist é obrigatório") String nome
) {}
