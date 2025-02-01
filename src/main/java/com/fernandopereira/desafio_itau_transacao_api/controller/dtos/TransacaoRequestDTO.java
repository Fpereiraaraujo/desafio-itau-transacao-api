package com.fernandopereira.desafio_itau_transacao_api.controller.dtos;
import java.time.OffsetDateTime;

public record TransacaoRequestDTO(Double valor, OffsetDateTime dataRecord) {
}
