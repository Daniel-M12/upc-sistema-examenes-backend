package com.sistema.examenes.servicios.impl;

import com.sistema.examenes.entidades.Usuario;
import com.sistema.examenes.entidades.UsuarioRol;
import com.sistema.examenes.excepciones.UsuarioFoundException;
import com.sistema.examenes.repositorios.RolRepository;
import com.sistema.examenes.repositorios.UsuarioRepository;
import com.sistema.examenes.repositorios.UsuarioRolRepository;
import com.sistema.examenes.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private UsuarioRolRepository usuarioRolRepository;

    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
        Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
        if(usuarioLocal!=null){
            System.out.println("el usuario ya existe");
            throw new Exception("El usuario ya esta presente");
        }
        else {
            for(UsuarioRol usuarioRol : usuarioRoles){
                rolRepository.save(usuarioRol.getRol());

                // Asigna el usuario al rol de usuario
                usuarioRol.setUsuario(usuario);

            }
            // Guarda el usuario
            usuarioLocal = usuarioRepository.save(usuario);

            // Guarda los roles de usuario explícitamente
            for (UsuarioRol usuarioRol : usuarioRoles) {
                usuarioRolRepository.save(usuarioRol); // Guarda el usuarioRol
            }

            // Asigna los roles guardados al usuario
            usuario.getUsuarioRoles().addAll(usuarioRoles);

        }
        return usuarioLocal;
    }

    @Override
    public Usuario obtenerUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public void eliminarUsuario(Long usuarioId) {
    usuarioRepository.deleteById(usuarioId);
    }
}
