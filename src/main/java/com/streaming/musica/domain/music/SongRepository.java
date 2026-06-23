package com.streaming.musica.domain.music;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SongRepository {

    Song save(Song song);

    Optional<Song> findById(UUID id);

    List<Song> findAll();
}
