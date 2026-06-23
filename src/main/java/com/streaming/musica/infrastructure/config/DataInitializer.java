package com.streaming.musica.infrastructure.config;

import com.streaming.musica.application.account.ContaApplicationService;
import com.streaming.musica.application.account.CriarContaCommand;
import com.streaming.musica.application.music.AdicionarMusicaPlaylistCommand;
import com.streaming.musica.application.music.CriarPlaylistCommand;
import com.streaming.musica.application.music.FavoritarMusicaCommand;
import com.streaming.musica.application.music.MusicaApplicationService;
import com.streaming.musica.application.subscription.AssinarCommand;
import com.streaming.musica.application.subscription.AssinaturaApplicationService;
import com.streaming.musica.domain.subscription.PlanType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Component
@Profile("!test")
public class DataInitializer implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DataInitializer.class);

    private static final UUID SONG_LUSH_LIFE     = UUID.fromString("a1b2c3d4-e5f6-7890-abcd-ef1234567890");
    private static final UUID SONG_PARADISE      = UUID.fromString("b2c3d4e5-f6a7-8901-bcde-f01234567891");
    private static final UUID SONG_EAZY_LIVIN    = UUID.fromString("c3d4e5f6-a7b8-9012-cdef-012345678902");
    private static final UUID SONG_DREAM_ON      = UUID.fromString("d4e5f6a7-b8c9-0123-def0-123456789013");
    private static final UUID SONG_WINTER_GLOW   = UUID.fromString("c9d0e1f2-a3b4-5678-2345-678901234568");
    private static final UUID SONG_SAKURA_DREAMS = UUID.fromString("e1f2a3b4-c5d6-7890-4567-890123456780");

    private final ContaApplicationService contaService;
    private final AssinaturaApplicationService assinaturaService;
    private final MusicaApplicationService musicaService;

    public DataInitializer(ContaApplicationService contaService,
                           AssinaturaApplicationService assinaturaService,
                           MusicaApplicationService musicaService) {
        this.contaService = contaService;
        this.assinaturaService = assinaturaService;
        this.musicaService = musicaService;
    }

    @Override
    public void run(String... args) {
        log.info("Inicializando dados de demonstração...");

        var joao = contaService.criarConta(new CriarContaCommand(
                "João Silva", "joao@demo.com", "4111-1111-1111-1111", true, BigDecimal.valueOf(5000)));
        assinaturaService.assinar(new AssinarCommand(joao.getId(), PlanType.PREMIUM));

        for (UUID songId : List.of(SONG_LUSH_LIFE, SONG_PARADISE, SONG_EAZY_LIVIN, SONG_SAKURA_DREAMS)) {
            musicaService.favoritarMusica(new FavoritarMusicaCommand(joao.getId(), songId));
        }

        var playlist = musicaService.criarPlaylist(new CriarPlaylistCommand(joao.getId(), "Lo-Fi Essentials"));
        for (UUID songId : List.of(SONG_LUSH_LIFE, SONG_PARADISE, SONG_DREAM_ON, SONG_WINTER_GLOW)) {
            musicaService.adicionarMusicaNaPlaylist(
                    new AdicionarMusicaPlaylistCommand(joao.getId(), playlist.getId(), songId));
        }

        var maria = contaService.criarConta(new CriarContaCommand(
                "Maria Oliveira", "maria@demo.com", "5500-0000-0000-0004", true, BigDecimal.valueOf(3000)));
        assinaturaService.assinar(new AssinarCommand(maria.getId(), PlanType.BASICO));

        var pedro = contaService.criarConta(new CriarContaCommand(
                "Pedro Santos", "pedro@demo.com", "3714-496353-98431", false, BigDecimal.valueOf(8000)));

        log.info("Contas demo — João: {}, Maria: {}, Pedro: {}", joao.getId(), maria.getId(), pedro.getId());
        log.info("Frontend:   http://localhost:8087");
        log.info("Swagger UI: http://localhost:8087/swagger-ui.html");
        log.info("H2 Console: http://localhost:8087/h2-console");
    }
}
