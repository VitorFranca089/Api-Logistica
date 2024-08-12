package com.logistica.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record RastreamentoDTO(
        @NotBlank
        String descricaoLocalizacao,
        @Valid
        EnderecoDTO endereco
) {
}
