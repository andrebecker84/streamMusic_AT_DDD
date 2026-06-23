package com.streaming.musica.interfaces.rest;

import com.streaming.musica.application.music.AdicionarMusicaPlaylistCommand;
import com.streaming.musica.application.music.CriarPlaylistCommand;
import com.streaming.musica.application.music.FavoritarMusicaCommand;
import com.streaming.musica.application.music.MusicaApplicationService;
import com.streaming.musica.interfaces.dto.AdicionarMusicaPlaylistRequest;
import com.streaming.musica.interfaces.dto.CriarPlaylistRequest;
import com.streaming.musica.interfaces.dto.FavoritarMusicaRequest;
import com.streaming.musica.interfaces.dto.FavoritoResponse;
import com.streaming.musica.interfaces.dto.MusicaResponse;
import com.streaming.musica.interfaces.dto.PlaylistResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@Tag(name = "Músicas")
public class MusicaController {

    private final MusicaApplicationService musicaService;

    public MusicaController(MusicaApplicationService musicaService) {
        this.musicaService = musicaService;
    }

    @GetMapping("/musicas")
    @Operation(summary = "Listar músicas", description = "Retorna o catálogo completo de músicas")
    public ResponseEntity<List<MusicaResponse>> listarMusicas() {
        return ResponseEntity.ok(musicaService.listarMusicas().stream().map(MusicaResponse::from).toList());
    }

    @PostMapping("/contas/{contaId}/favoritos")
    @Operation(summary = "Favoritar música")
    public ResponseEntity<FavoritoResponse> favoritar(
            @PathVariable UUID contaId,
            @RequestBody @Valid FavoritarMusicaRequest request) {
        var favorito = musicaService.favoritarMusica(new FavoritarMusicaCommand(contaId, request.musicaId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(FavoritoResponse.from(favorito));
    }

    @GetMapping("/contas/{contaId}/favoritos")
    @Operation(summary = "Listar favoritos")
    public ResponseEntity<List<FavoritoResponse>> listarFavoritos(@PathVariable UUID contaId) {
        return ResponseEntity.ok(musicaService.listarFavoritos(contaId).stream().map(FavoritoResponse::from).toList());
    }

    @DeleteMapping("/contas/{contaId}/favoritos/{musicaId}")
    @Operation(summary = "Remover dos favoritos")
    public ResponseEntity<Void> removerFavorito(@PathVariable UUID contaId, @PathVariable UUID musicaId) {
        musicaService.removerFavorito(contaId, musicaId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/contas/{contaId}/playlists")
    @Operation(summary = "Criar playlist")
    public ResponseEntity<PlaylistResponse> criarPlaylist(
            @PathVariable UUID contaId,
            @RequestBody @Valid CriarPlaylistRequest request) {
        var playlist = musicaService.criarPlaylist(new CriarPlaylistCommand(contaId, request.nome()));
        return ResponseEntity.status(HttpStatus.CREATED).body(PlaylistResponse.from(playlist));
    }

    @GetMapping("/contas/{contaId}/playlists")
    @Operation(summary = "Listar playlists da conta")
    public ResponseEntity<List<PlaylistResponse>> listarPlaylists(@PathVariable UUID contaId) {
        return ResponseEntity.ok(musicaService.listarPlaylists(contaId).stream().map(PlaylistResponse::from).toList());
    }

    @PostMapping("/playlists/{playlistId}/musicas")
    @Operation(summary = "Adicionar música na playlist")
    public ResponseEntity<PlaylistResponse> adicionarMusica(
            @PathVariable UUID playlistId,
            @RequestBody @Valid AdicionarMusicaPlaylistRequest request) {
        var playlist = musicaService.adicionarMusicaNaPlaylist(
                new AdicionarMusicaPlaylistCommand(request.contaId(), playlistId, request.musicaId()));
        return ResponseEntity.ok(PlaylistResponse.from(playlist));
    }

    @DeleteMapping("/contas/{contaId}/playlists/{playlistId}/musicas/{musicaId}")
    @Operation(summary = "Remover música da playlist")
    public ResponseEntity<PlaylistResponse> removerMusica(
            @PathVariable UUID contaId,
            @PathVariable UUID playlistId,
            @PathVariable UUID musicaId) {
        var playlist = musicaService.removerMusicaDaPlaylist(contaId, playlistId, musicaId);
        return ResponseEntity.ok(PlaylistResponse.from(playlist));
    }
}
