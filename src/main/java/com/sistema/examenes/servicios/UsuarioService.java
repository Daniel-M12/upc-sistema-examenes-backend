package com.sistema.examenes.servicios;

import com.sistema.examenes.entidades.Usuario;
import com.sistema.examenes.entidades.UsuarioRol;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario , Set<UsuarioRol> usuarioRoles) throws Exception;


}
