package com.logistica.api.service.impl;

import com.logistica.api.dto.AuthenticationDTO;
import com.logistica.api.dto.RegisterDTO;
import com.logistica.api.dto.TokenDTO;
import com.logistica.api.infra.security.TokenService;
import com.logistica.api.model.Usuario;
import com.logistica.api.repository.UsuarioRepository;
import com.logistica.api.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public TokenDTO login(AuthenticationDTO authenticationDTO){
        var usernamePassword = new UsernamePasswordAuthenticationToken(
                authenticationDTO.email(),
                authenticationDTO.senha()
        );
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = this.tokenService.generateToken((Usuario) auth.getPrincipal());

        return new TokenDTO(token);
    }

    @Override
    public Boolean register(RegisterDTO registerDTO){
        if(this.usuarioRepository.findByEmail(registerDTO.email()) != null) return false;

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.senha());
        Usuario newUsuario = new Usuario(registerDTO.email(), encryptedPassword, registerDTO.role());

        this.usuarioRepository.save(newUsuario);

        return true;
    }

}
