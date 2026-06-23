package com.streaming.musica.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("StreamMusic API")
                        .description("""
                                API REST de plataforma de streaming de música implementada com
                                Domain-Driven Design (DDD), SOLID e Design Patterns.

                                **Bounded Contexts:**
                                - **Conta** — Criação de contas e gerenciamento de cartão de crédito
                                - **Assinatura** — Planos de assinatura (BASICO, PREMIUM, FAMILIA)
                                - **Transação** — Autorização com motor de antifraude (Strategy Pattern)
                                - **Música** — Catálogo, favoritos e playlists
                                """)
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("André Becker")))
                .tags(List.of(
                        new Tag().name("Contas").description("Gerenciamento de contas de usuário"),
                        new Tag().name("Assinaturas").description("Planos de assinatura"),
                        new Tag().name("Transações").description("Autorização de transações com antifraude"),
                        new Tag().name("Músicas").description("Catálogo de músicas, favoritos e playlists")
                ));
    }
}
