package com.streaming.musica.application.music;

import java.util.UUID;

public record AdicionarMusicaPlaylistCommand(UUID contaId, UUID playlistId, UUID musicaId) {}
