package com.streaming.musica.domain.music;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlaylistRepository {

    Playlist save(Playlist playlist);

    Optional<Playlist> findById(UUID id);

    List<Playlist> findByAccountId(UUID accountId);
}
