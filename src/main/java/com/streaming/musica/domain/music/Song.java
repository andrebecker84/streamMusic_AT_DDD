package com.streaming.musica.domain.music;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "songs")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Song {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String artist;

    @Column(nullable = false)
    private String album;

    @Column(name = "duration_seconds", nullable = false)
    private int durationSeconds;

    public Song(String title, String artist, String album, int durationSeconds) {
        Objects.requireNonNull(title, "Título é obrigatório");
        Objects.requireNonNull(artist, "Artista é obrigatório");
        Objects.requireNonNull(album, "Álbum é obrigatório");
        if (durationSeconds <= 0) throw new IllegalArgumentException("Duração deve ser positiva");
        this.id = UUID.randomUUID();
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.durationSeconds = durationSeconds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song song)) return false;
        return Objects.equals(id, song.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
