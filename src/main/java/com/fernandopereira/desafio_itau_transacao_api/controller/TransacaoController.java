package com.fernandopereira.desafio_itau_transacao_api.controller;


import com.fernandopereira.desafio_itau_transacao_api.business.services.TransacaoService;
import com.fernandopereira.desafio_itau_transacao_api.controller.dtos.TransacaoRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/trasacao")
public class TransacaoController {

    private final TransacaoService transacaoService;


    @PostMapping
    @Operation(description = "endpoint responsavel por adicionar transações")
    @ApiResponse(value = {
            @ApiResponse(ResponseCode = "201", description = "transacoes gravada com sucesso"),
            @ApiResponse(responseCode = "422", description = "dados invalidos"),
            @ApiResponse(responseCode = "400", description = "erro de requisicao"),
            @ApiResponse(responseCode = "500", description = "erro interno do servidor")

    })
    public ResponseEntity<Void> adicionarTransacao(@RequestBody TransacaoRequestDTO dto) {
        transacaoService.adicionarTransacoes(dto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    @Operation(description = "endpoint responsavel por excluir transações")
    @ApiResponse(value = {
            @ApiResponse(ResponseCode = "201", description = "transacoes gravada com sucesso"),
            @ApiResponse(responseCode = "422", description = "dados invalidos"),
            @ApiResponse(responseCode = "400", description = "erro de requisicao"),
            @ApiResponse(responseCode = "500", description = "erro interno do servidor")

    })
    public ResponseEntity<Void> deletarTransacoes() {
        transacaoService.limparTransacoes();

        return ResponseEntity.ok().build();
    }
}
