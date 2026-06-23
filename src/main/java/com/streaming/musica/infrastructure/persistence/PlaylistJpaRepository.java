package com.streaming.musica.infrastructure.persistence;

import com.streaming.musica.domain.music.Playlist;
import com.streaming.musica.domain.music.PlaylistRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PlaylistJpaRepository extends JpaRepository<Playlist, UUID>, PlaylistRepository {

    List<Playlist> findByAccountId(UUID accountId);
}
