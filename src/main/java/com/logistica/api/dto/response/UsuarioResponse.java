package com.logistica.api.dto.response;

import com.logistica.api.model.enums.UserRole;

public record UsuarioResponse(
        Integer id,
        String email,
        UserRole userRole
) {
}
