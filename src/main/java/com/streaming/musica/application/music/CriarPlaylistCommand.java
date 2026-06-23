package com.streaming.musica.application.music;

import java.util.UUID;

public record CriarPlaylistCommand(UUID contaId, String nome) {}
