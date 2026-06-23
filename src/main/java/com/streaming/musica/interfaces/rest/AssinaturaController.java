package com.streaming.musica.interfaces.rest;

import com.streaming.musica.application.subscription.AssinarCommand;
import com.streaming.musica.application.subscription.AssinaturaApplicationService;
import com.streaming.musica.interfaces.dto.AssinarRequest;
import com.streaming.musica.interfaces.dto.AssinaturaResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/assinaturas")
@Tag(name = "Assinaturas")
public class AssinaturaController {

    private final AssinaturaApplicationService assinaturaService;

    public AssinaturaController(AssinaturaApplicationService assinaturaService) {
        this.assinaturaService = assinaturaService;
    }

    @PostMapping
    @Operation(summary = "Assinar plano", description = "Assina um plano (BASICO, PREMIUM, FAMILIA). Regra: apenas um plano ativo por conta.")
    public ResponseEntity<AssinaturaResponse> assinar(@RequestBody @Valid AssinarRequest request) {
        var command = new AssinarCommand(request.contaId(), request.tipoPlano());
        var assinatura = assinaturaService.assinar(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(AssinaturaResponse.from(assinatura));
    }

    @DeleteMapping("/contas/{contaId}")
    @Operation(summary = "Cancelar assinatura", description = "Cancela a assinatura ativa da conta")
    public ResponseEntity<Void> cancelar(@PathVariable UUID contaId) {
        assinaturaService.cancelar(contaId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/contas/{contaId}/ativa")
    @Operation(summary = "Buscar assinatura ativa", description = "Retorna a assinatura ativa da conta, se houver")
    public ResponseEntity<AssinaturaResponse> buscarAtiva(@PathVariable UUID contaId) {
        return assinaturaService.buscarAtivaPorConta(contaId)
                .map(a -> ResponseEntity.ok(AssinaturaResponse.from(a)))
                .orElse(ResponseEntity.notFound().build());
    }
}
