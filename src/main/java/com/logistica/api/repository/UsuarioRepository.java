package com.logistica.api.repository;

import com.logistica.api.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
     UserDetails findByEmail(String email);
     Optional<Usuario> findUsuarioByEmail(String email);
}
