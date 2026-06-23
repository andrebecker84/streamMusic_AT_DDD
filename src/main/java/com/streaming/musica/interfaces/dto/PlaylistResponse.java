package com.streaming.musica.interfaces.dto;

import com.streaming.musica.domain.music.Playlist;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record PlaylistResponse(
        UUID id,
        UUID contaId,
        String nome,
        List<MusicaResponse> musicas,
        LocalDateTime criadaEm
) {
    public static PlaylistResponse from(Playlist playlist) {
        return new PlaylistResponse(
                playlist.getId(),
                playlist.getAccountId(),
                playlist.getName(),
                playlist.getSongs().stream().map(MusicaResponse::from).toList(),
                playlist.getCreatedAt()
        );
    }
}
