package com.logistica.api.service;

import com.logistica.api.dto.AuthenticationDTO;
import com.logistica.api.dto.RegisterDTO;
import com.logistica.api.dto.TokenDTO;
import com.logistica.api.model.Usuario;

public interface AuthenticationService {
    TokenDTO login(AuthenticationDTO authenticationDTO);
    Boolean register(RegisterDTO registerDTO);
    Usuario registerCliente(String email);
}
