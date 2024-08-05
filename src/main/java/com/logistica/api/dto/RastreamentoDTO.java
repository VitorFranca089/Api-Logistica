package com.logistica.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record RastreamentoDTO(
        @NotBlank
        String descricaoLocalizacao,
        @Valid
        EnderecoDTO endereco,
        LocalDateTime dataHora
) {
}
