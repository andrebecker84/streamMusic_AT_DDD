package com.streaming.musica.domain.music;

import java.util.List;
import java.util.UUID;

public interface MusicaFavoritaRepository {

    MusicaFavorita save(MusicaFavorita musicaFavorita);

    List<MusicaFavorita> findByAccountId(UUID accountId);

    boolean existsByAccountIdAndSongId(UUID accountId, UUID songId);

    void deleteByAccountIdAndSongId(UUID accountId, UUID songId);
}
