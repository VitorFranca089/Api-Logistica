package com.logistica.api.dto;

import com.logistica.api.model.Status;

import java.time.LocalDateTime;

public record EntregaDTO(
        Status status,
        String lojaResponsavel,
        EnderecoDTO origemCep,
        EnderecoDTO destinoCep,
        LocalDateTime dataCriacao
) {
}
