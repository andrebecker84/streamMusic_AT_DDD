package com.streaming.musica.application.music;

import com.streaming.musica.domain.account.AccountRepository;
import com.streaming.musica.domain.music.MusicaFavorita;
import com.streaming.musica.domain.music.MusicaFavoritaRepository;
import com.streaming.musica.domain.music.Playlist;
import com.streaming.musica.domain.music.PlaylistRepository;
import com.streaming.musica.domain.music.Song;
import com.streaming.musica.domain.music.SongRepository;
import com.streaming.musica.shared.BusinessRuleException;
import com.streaming.musica.shared.EntityNotFoundException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class MusicaApplicationService {

    private final SongRepository songRepository;
    private final PlaylistRepository playlistRepository;
    private final MusicaFavoritaRepository musicaFavoritaRepository;
    private final AccountRepository accountRepository;

    public MusicaApplicationService(
            SongRepository songRepository,
            PlaylistRepository playlistRepository,
            MusicaFavoritaRepository musicaFavoritaRepository,
            AccountRepository accountRepository) {
        this.songRepository = songRepository;
        this.playlistRepository = playlistRepository;
        this.musicaFavoritaRepository = musicaFavoritaRepository;
        this.accountRepository = accountRepository;
    }

    @Cacheable("musicas")
    @Transactional(readOnly = true)
    public List<Song> listarMusicas() {
        return songRepository.findAll();
    }

    public MusicaFavorita favoritarMusica(FavoritarMusicaCommand command) {
        accountRepository.findById(command.contaId())
                .orElseThrow(() -> new EntityNotFoundException("Conta não encontrada: " + command.contaId()));

        var musica = songRepository.findById(command.musicaId())
                .orElseThrow(() -> new EntityNotFoundException("Música não encontrada: " + command.musicaId()));

        if (musicaFavoritaRepository.existsByAccountIdAndSongId(command.contaId(), command.musicaId())) {
            throw new BusinessRuleException("Música já está nos favoritos: " + musica.getTitle());
        }

        return musicaFavoritaRepository.save(new MusicaFavorita(command.contaId(), musica));
    }

    @Transactional(readOnly = true)
    public List<MusicaFavorita> listarFavoritos(UUID contaId) {
        return musicaFavoritaRepository.findByAccountId(contaId);
    }

    public void removerFavorito(UUID contaId, UUID musicaId) {
        musicaFavoritaRepository.deleteByAccountIdAndSongId(contaId, musicaId);
    }

    public Playlist criarPlaylist(CriarPlaylistCommand command) {
        accountRepository.findById(command.contaId())
                .orElseThrow(() -> new EntityNotFoundException("Conta não encontrada: " + command.contaId()));

        return playlistRepository.save(new Playlist(command.contaId(), command.nome()));
    }

    @Transactional(readOnly = true)
    public List<Playlist> listarPlaylists(UUID contaId) {
        return playlistRepository.findByAccountId(contaId);
    }

    public Playlist adicionarMusicaNaPlaylist(AdicionarMusicaPlaylistCommand command) {
        var playlist = playlistRepository.findById(command.playlistId())
                .orElseThrow(() -> new EntityNotFoundException("Playlist não encontrada: " + command.playlistId()));

        if (!playlist.getAccountId().equals(command.contaId())) {
            throw new BusinessRuleException("Playlist não pertence a esta conta");
        }

        var musica = songRepository.findById(command.musicaId())
                .orElseThrow(() -> new EntityNotFoundException("Música não encontrada: " + command.musicaId()));

        playlist.adicionarMusica(musica);
        return playlistRepository.save(playlist);
    }

    public Playlist removerMusicaDaPlaylist(UUID contaId, UUID playlistId, UUID musicaId) {
        var playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new EntityNotFoundException("Playlist não encontrada: " + playlistId));

        if (!playlist.getAccountId().equals(contaId)) {
            throw new BusinessRuleException("Playlist não pertence a esta conta");
        }

        playlist.removerMusica(musicaId);
        return playlistRepository.save(playlist);
    }
}
