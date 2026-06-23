package com.streaming.musica.interfaces.rest;

import com.streaming.musica.application.account.ContaApplicationService;
import com.streaming.musica.application.account.CriarContaCommand;
import com.streaming.musica.interfaces.dto.ContaResponse;
import com.streaming.musica.interfaces.dto.CriarContaRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/contas")
@Tag(name = "Contas")
public class ContaController {

    private final ContaApplicationService contaService;

    public ContaController(ContaApplicationService contaService) {
        this.contaService = contaService;
    }

    @PostMapping
    @Operation(summary = "Criar conta", description = "Cria uma nova conta com cartão de crédito")
    public ResponseEntity<ContaResponse> criar(@RequestBody @Valid CriarContaRequest request) {
        var command = new CriarContaCommand(
                request.nome(), request.email(),
                request.numeroCartao(), request.cartaoAtivo(), request.limiteCartao()
        );
        var conta = contaService.criarConta(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(ContaResponse.from(conta));
    }

    @GetMapping
    @Operation(summary = "Listar contas", description = "Retorna todas as contas cadastradas")
    public ResponseEntity<List<ContaResponse>> listar() {
        var contas = contaService.listarTodas().stream()
                .map(ContaResponse::from)
                .toList();
        return ResponseEntity.ok(contas);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar conta", description = "Retorna uma conta pelo ID")
    public ResponseEntity<ContaResponse> buscarPorId(@PathVariable UUID id) {
        var conta = contaService.buscarPorId(id);
        return ResponseEntity.ok(ContaResponse.from(conta));
    }
}
