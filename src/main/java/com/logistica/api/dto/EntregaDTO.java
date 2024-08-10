package com.logistica.api.dto;

import com.logistica.api.model.enums.Status;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record EntregaDTO(
        Status status,
        @NotBlank
        String lojaResponsavel,
        @Valid
        EnderecoDTO origemCep,
        @Valid
        EnderecoDTO destinoCep,
        LocalDateTime dataCriacao,
        String emailUsuario
) {
}
