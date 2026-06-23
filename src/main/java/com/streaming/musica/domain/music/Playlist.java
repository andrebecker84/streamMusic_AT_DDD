package com.streaming.musica.domain.music;

import com.streaming.musica.shared.BusinessRuleException;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "playlists")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Playlist {

    @Id
    private UUID id;

    @Column(name = "account_id", nullable = false)
    private UUID accountId;

    @Column(nullable = false)
    private String name;

    @Getter(AccessLevel.NONE)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "playlist_songs",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    private List<Song> songs = new ArrayList<>();

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public Playlist(UUID accountId, String name) {
        Objects.requireNonNull(accountId, "Account ID is required");
        Objects.requireNonNull(name, "Playlist name is required");
        if (name.isBlank()) throw new IllegalArgumentException("Playlist name cannot be blank");
        this.id = UUID.randomUUID();
        this.accountId = accountId;
        this.name = name;
        this.createdAt = LocalDateTime.now();
    }

    public void adicionarMusica(Song song) {
        Objects.requireNonNull(song, "Song is required");
        if (songs.contains(song)) {
            throw new BusinessRuleException("Música já está na playlist: " + song.getTitle());
        }
        songs.add(song);
    }

    public void removerMusica(UUID songId) {
        songs.removeIf(s -> s.getId().equals(songId));
    }

    public List<Song> getSongs() {
        return Collections.unmodifiableList(songs);
    }
}
