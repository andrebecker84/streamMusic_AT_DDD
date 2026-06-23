package com.streaming.musica.interfaces.dto;

import com.streaming.musica.domain.music.MusicaFavorita;

import java.time.LocalDateTime;
import java.util.UUID;

public record FavoritoResponse(
        UUID id,
        UUID contaId,
        MusicaResponse musica,
        LocalDateTime favoritadoEm
) {
    public static FavoritoResponse from(MusicaFavorita favorita) {
        return new FavoritoResponse(
                favorita.getId(),
                favorita.getAccountId(),
                MusicaResponse.from(favorita.getSong()),
                favorita.getFavoritadoEm()
        );
    }
}
