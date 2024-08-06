package com.logistica.api.dto;

import com.logistica.api.model.enums.Status;

public record AtualizarStatusDTO(
        Status status
) {
}
