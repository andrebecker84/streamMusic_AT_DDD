package com.streaming.musica.application.music;

import java.util.UUID;

public record FavoritarMusicaCommand(UUID contaId, UUID musicaId) {}
