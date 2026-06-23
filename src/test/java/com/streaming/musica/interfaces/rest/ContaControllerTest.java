package com.streaming.musica.interfaces.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.streaming.musica.interfaces.dto.CriarContaRequest;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@Transactional
@ActiveProfiles("test")
class ContaControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @BeforeEach
    void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    void deveCriarContaComSucesso() throws Exception {
        // Arrange
        var request = new CriarContaRequest("Carlos", "carlos@test.com", "4111-1111-1111-1111", true, BigDecimal.valueOf(5000));
        var body = objectMapper.writeValueAsString(request);

        // Act
        var result = mockMvc.perform(post("/api/contas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body));

        // Assert
        result.andExpect(status().isCreated())
                .andExpect(jsonPath("$.nome").value("Carlos"))
                .andExpect(jsonPath("$.email").value("carlos@test.com"))
                .andExpect(jsonPath("$.cartaoAtivo").value(true));
    }

    @Test
    void deveRetornarErroComEmailDuplicado() throws Exception {
        // Arrange
        var request = new CriarContaRequest("Carlos", "duplicado@test.com", "1234", true, BigDecimal.TEN);
        var body = objectMapper.writeValueAsString(request);
        mockMvc.perform(post("/api/contas").contentType(MediaType.APPLICATION_JSON).content(body));

        // Act
        var result = mockMvc.perform(post("/api/contas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body));

        // Assert
        result.andExpect(status().isUnprocessableEntity());
    }

    @Test
    void deveRetornarErroDeValidacaoComEmailInvalido() throws Exception {
        // Arrange
        var request = new CriarContaRequest("Carlos", "email-invalido", "1234", true, BigDecimal.TEN);
        var body = objectMapper.writeValueAsString(request);

        // Act
        var result = mockMvc.perform(post("/api/contas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body));

        // Assert
        result.andExpect(status().isBadRequest());
    }

    @Test
    void deveListarContasCadastradas() throws Exception {
        // Arrange
        var request = new CriarContaRequest("Ana Lista", "ana.lista@test.com", "4111-1111-1111-1111", true, BigDecimal.valueOf(5000));
        var body = objectMapper.writeValueAsString(request);
        mockMvc.perform(post("/api/contas").contentType(MediaType.APPLICATION_JSON).content(body));

        // Act
        var result = mockMvc.perform(get("/api/contas"));

        // Assert
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[?(@.email == 'ana.lista@test.com')]").exists());
    }

    @Test
    void deveRetornarErroQuandoContaNaoEncontrada() throws Exception {
        // Arrange — nenhum pré-requisito; UUID inexistente garantido

        // Act
        var result = mockMvc.perform(get("/api/contas/00000000-0000-0000-0000-000000000000"));

        // Assert
        result.andExpect(status().isNotFound());
    }
}
