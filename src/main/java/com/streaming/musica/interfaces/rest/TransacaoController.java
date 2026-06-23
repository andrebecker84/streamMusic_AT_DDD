package com.streaming.musica.interfaces.rest;

import com.streaming.musica.application.transaction.AutorizarTransacaoCommand;
import com.streaming.musica.application.transaction.TransacaoApplicationService;
import com.streaming.musica.interfaces.dto.AutorizarTransacaoRequest;
import com.streaming.musica.interfaces.dto.TransacaoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transacoes")
@Tag(name = "Transações")
public class TransacaoController {

    private final TransacaoApplicationService transacaoService;

    public TransacaoController(TransacaoApplicationService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping("/autorizar")
    @Operation(
            summary = "Autorizar transação",
            description = """
                    Autoriza uma transação aplicando todas as regras de antifraude (Strategy Pattern):
                    - **cartão-de-crédito-inválido**: conta sem cartão cadastrado
                    - **cartão-não-ativo**: cartão inativo
                    - **plano-ativo-inválido**: sem assinatura ativa
                    - **alta-frequência-pequeno-intervalo**: mais de 3 transações em 2 minutos
                    - **transação-duplicada**: mesmo valor e comércio, mais de 2x em 2 minutos
                    """)
    public ResponseEntity<TransacaoResponse> autorizar(@RequestBody @Valid AutorizarTransacaoRequest request) {
        var command = new AutorizarTransacaoCommand(request.contaId(), request.valor(), request.nomeComercio());
        var resultado = transacaoService.autorizar(command);
        return ResponseEntity.ok(TransacaoResponse.from(resultado));
    }
}
