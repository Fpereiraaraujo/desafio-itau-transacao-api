package com.fernandopereira.desafio_itau_transacao_api.controller;


import com.fernandopereira.desafio_itau_transacao_api.business.services.EstatisticasServices;
import com.fernandopereira.desafio_itau_transacao_api.controller.dtos.EstatisticasResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
@RequiredArgsConstructor
public class EstatisticasController {

    private final EstatisticasServices estatisticasServices;

    @GetMapping
    @Operation(description = "endpoint responsavel por Buscar estatisticas das transações")
    @ApiResponse(value = {
            @ApiResponse(ResponseCode = "200", description = "Busca efetuada com sucesso"),
            @ApiResponse(responseCode = "400", description = "erro na bsuca de estatisticas de transacoes"),
            @ApiResponse(responseCode = "500", description = "erro interno do servidor")

    })
    public ResponseEntity<EstatisticasResponseDTO> buscarEstatisticas(@RequestParam(value = "intervalorBusca", required = false, defaultValue = "60") Integer valorBusca) {

        return ResponseEntity.ok(estatisticasServices.calcularEstatisticasTransacoes(valorBusca));

    }


}
