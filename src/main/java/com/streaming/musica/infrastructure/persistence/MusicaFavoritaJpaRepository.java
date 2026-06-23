package com.streaming.musica.infrastructure.persistence;

import com.streaming.musica.domain.music.MusicaFavorita;
import com.streaming.musica.domain.music.MusicaFavoritaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MusicaFavoritaJpaRepository extends JpaRepository<MusicaFavorita, UUID>, MusicaFavoritaRepository {

    List<MusicaFavorita> findByAccountId(UUID accountId);

    @Query("SELECT COUNT(f) > 0 FROM MusicaFavorita f WHERE f.accountId = :accountId AND f.song.id = :songId")
    boolean existsByAccountIdAndSongId(@Param("accountId") UUID accountId, @Param("songId") UUID songId);

    @Modifying
    @Query("DELETE FROM MusicaFavorita f WHERE f.accountId = :accountId AND f.song.id = :songId")
    void deleteByAccountIdAndSongId(@Param("accountId") UUID accountId, @Param("songId") UUID songId);
}
