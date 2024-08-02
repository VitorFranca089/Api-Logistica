package com.logistica.api.dto;

import java.time.LocalDateTime;

public record RastreamentoDTO(
        String descricaoLocalizacao,
        EnderecoDTO endereco,
        LocalDateTime dataHora
) {
}
