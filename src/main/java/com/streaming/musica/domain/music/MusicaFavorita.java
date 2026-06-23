package com.streaming.musica.domain.music;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(
        name = "musicas_favoritas",
        uniqueConstraints = @UniqueConstraint(columnNames = {"account_id", "song_id"})
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MusicaFavorita {

    @Id
    private UUID id;

    @Column(name = "account_id", nullable = false)
    private UUID accountId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "song_id", nullable = false)
    private Song song;

    @Column(nullable = false)
    private LocalDateTime favoritadoEm;

    public MusicaFavorita(UUID accountId, Song song) {
        Objects.requireNonNull(accountId, "Account ID is required");
        Objects.requireNonNull(song, "Song is required");
        this.id = UUID.randomUUID();
        this.accountId = accountId;
        this.song = song;
        this.favoritadoEm = LocalDateTime.now();
    }
}
