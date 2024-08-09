package com.logistica.api.service;

import com.logistica.api.dto.AuthenticationDTO;
import com.logistica.api.dto.RegisterDTO;
import com.logistica.api.dto.TokenDTO;

public interface AuthenticationService {
    TokenDTO login(AuthenticationDTO authenticationDTO);
    Boolean register(RegisterDTO registerDTO);
}
