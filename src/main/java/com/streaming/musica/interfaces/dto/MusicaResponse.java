package com.streaming.musica.interfaces.dto;

import com.streaming.musica.domain.music.Song;

import java.util.UUID;

public record MusicaResponse(
        UUID id,
        String titulo,
        String artista,
        String album,
        int duracaoSegundos
) {
    public static MusicaResponse from(Song song) {
        return new MusicaResponse(
                song.getId(),
                song.getTitle(),
                song.getArtist(),
                song.getAlbum(),
                song.getDurationSeconds()
        );
    }
}
