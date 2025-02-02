package com.fernandopereira.desafio_itau_transacao_api.business.services;


import com.fernandopereira.desafio_itau_transacao_api.controller.dtos.EstatisticasResponseDTO;
import com.fernandopereira.desafio_itau_transacao_api.controller.dtos.TransacaoRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EstatisticasServices {
    private final TransacaoService transacaoService;

    public EstatisticasResponseDTO calcularEstatisticasTransacoes(Integer intervaloBusca) {
        log.info("inicianda busca de estatisticas");

        List<TransacaoRequestDTO> transacoes = transacaoService.buscarTransacoes(intervaloBusca);

        DoubleSummaryStatistics estatisticasTransacoes = transacoes.stream().mapToDouble(TransacaoRequestDTO::valor).summaryStatistics();


        log.info("Estatisticas retornada com sucesso");
        return new EstatisticasResponseDTO(estatisticasTransacoes.getCount(),
                estatisticasTransacoes.getSum(),
                estatisticasTransacoes.getAverage(),
                estatisticasTransacoes.getMin(),
                estatisticasTransacoes.getMax()
        );
    }
}
