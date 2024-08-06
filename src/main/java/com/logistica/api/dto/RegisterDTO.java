package com.logistica.api.dto;

import com.logistica.api.model.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterDTO(
        @NotBlank
        @Email
        String email,
        @NotBlank
        String senha,
        UserRole role
) {
}
