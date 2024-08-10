package com.logistica.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(
        @NotBlank
        @Email
        String email,
        String senha
) {
}
