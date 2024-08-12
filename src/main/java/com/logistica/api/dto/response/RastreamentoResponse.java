package com.logistica.api.dto.response;

import com.logistica.api.dto.EnderecoDTO;

import java.time.LocalDateTime;

public record RastreamentoResponse(
        Integer id,
        String descricaoLocalizacao,
        EnderecoDTO endereco,
        LocalDateTime dataHora
) {
}
