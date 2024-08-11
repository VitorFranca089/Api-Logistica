package com.logistica.api.util;

import com.logistica.api.model.Entrega;
import com.logistica.api.model.Usuario;
import com.logistica.api.model.enums.UserRole;
import org.springframework.stereotype.Component;

@Component
public class UsuarioUtils {

    public Boolean usuarioPodeAcessarEntrega(Entrega entrega, Usuario usuario) {
        return usuario.getRole() == UserRole.ADMIN ||
               usuario.getRole() == UserRole.FUNCIONARIO ||
               (usuario.getRole() == UserRole.CLIENTE && usuario.getId().equals(entrega.getUsuario().getId()));
    }

}
