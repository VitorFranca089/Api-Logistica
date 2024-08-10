package com.logistica.api.dto.response;

import com.logistica.api.dto.EnderecoDTO;
import com.logistica.api.model.enums.Status;

import java.time.LocalDateTime;

public record EntregaResponse(
        Integer id,
        Status status,
        String lojaResponsavel,
        EnderecoDTO origemCep,
        EnderecoDTO destinoCep,
        LocalDateTime dataCriacao,
        UsuarioResponse usuario
) {
}
