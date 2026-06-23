package com.streaming.musica.infrastructure.persistence;

import com.streaming.musica.domain.music.Song;
import com.streaming.musica.domain.music.SongRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SongJpaRepository extends JpaRepository<Song, UUID>, SongRepository {
}
