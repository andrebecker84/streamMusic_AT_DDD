package com.streaming.musica.interfaces.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.streaming.musica.application.account.ContaApplicationService;
import com.streaming.musica.application.account.CriarContaCommand;
import com.streaming.musica.application.subscription.AssinarCommand;
import com.streaming.musica.application.subscription.AssinaturaApplicationService;
import com.streaming.musica.domain.subscription.PlanType;
import com.streaming.musica.interfaces.dto.AutorizarTransacaoRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.UUID;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@Transactional
@ActiveProfiles("test")
class TransacaoControllerTest {

    @Autowired private WebApplicationContext wac;
    @Autowired private ContaApplicationService contaService;
    @Autowired private AssinaturaApplicationService assinaturaService;

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    private UUID contaAtivaId;
    private UUID contaInativaId;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

        var joao = contaService.criarConta(new CriarContaCommand(
                "João Teste", "joao.tx@test.com", "4111-1111-1111-1111", true, BigDecimal.valueOf(5000)));
        assinaturaService.assinar(new AssinarCommand(joao.getId(), PlanType.PREMIUM));
        contaAtivaId = joao.getId();

        var pedro = contaService.criarConta(new CriarContaCommand(
                "Pedro Teste", "pedro.tx@test.com", "3714-496353-98431", false, BigDecimal.valueOf(2000)));
        contaInativaId = pedro.getId();
    }

    @Test
    void deveAutorizarTransacaoComContaValida() throws Exception {
        // Arrange
        var request = new AutorizarTransacaoRequest(contaAtivaId, BigDecimal.valueOf(29.90), "StreamStore");
        var body = objectMapper.writeValueAsString(request);

        // Act
        var result = mockMvc.perform(post("/api/transacoes/autorizar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body));

        // Assert
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.aprovada").value(true))
                .andExpect(jsonPath("$.violacoes", empty()));
    }

    @Test
    void deveRejeitarTransacaoComCartaoInativo() throws Exception {
        // Arrange
        var request = new AutorizarTransacaoRequest(contaInativaId, BigDecimal.valueOf(10.00), "CinemaPlus");
        var body = objectMapper.writeValueAsString(request);

        // Act
        var result = mockMvc.perform(post("/api/transacoes/autorizar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body));

        // Assert
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.aprovada").value(false))
                .andExpect(jsonPath("$.violacoes", hasItem("cartão-não-ativo")));
    }

    @Test
    void deveDetectarTransacaoDuplicada() throws Exception {
        // Arrange
        var request = new AutorizarTransacaoRequest(contaAtivaId, BigDecimal.valueOf(99.90), "MegaStore");
        var body = objectMapper.writeValueAsString(request);
        mockMvc.perform(post("/api/transacoes/autorizar").contentType(MediaType.APPLICATION_JSON).content(body));
        mockMvc.perform(post("/api/transacoes/autorizar").contentType(MediaType.APPLICATION_JSON).content(body));

        // Act
        var result = mockMvc.perform(post("/api/transacoes/autorizar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body));

        // Assert
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.aprovada").value(false))
                .andExpect(jsonPath("$.violacoes", hasItem("transação-duplicada")));
    }

    @Test
    void deveRetornarErroParaContaInexistente() throws Exception {
        // Arrange
        var request = new AutorizarTransacaoRequest(UUID.randomUUID(), BigDecimal.TEN, "Loja");
        var body = objectMapper.writeValueAsString(request);

        // Act
        var result = mockMvc.perform(post("/api/transacoes/autorizar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body));

        // Assert
        result.andExpect(status().isNotFound());
    }
}
