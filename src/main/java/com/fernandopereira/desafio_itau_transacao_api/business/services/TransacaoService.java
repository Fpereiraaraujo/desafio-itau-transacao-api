package com.fernandopereira.desafio_itau_transacao_api.business.services;

import com.fernandopereira.desafio_itau_transacao_api.controller.dtos.TransacaoRequestDTO;
import com.fernandopereira.desafio_itau_transacao_api.infraestructure.exceptions.UnprocessableEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransacaoService {

    private final List<TransacaoRequestDTO> listaTransacoes = new ArrayList<>();

    public void adicionarTransacoes(TransacaoRequestDTO dto) {
        log.info("iniciado o processamento de gravar transacoes");

        if (dto.dataRecord().isAfter(OffsetDateTime.now())) {
            log.error("data e hora maiores que a transacao atual");
            throw new UnprocessableEntity("Data e hora maiores que a data e hora atuais");
        }

        if (dto.valor() < 0) {
            log.error("valor negativo");
            throw new UnprocessableEntity("valor nao pode ser menor que zero ")
        }


        listaTransacoes.add(dto);
    }
}
