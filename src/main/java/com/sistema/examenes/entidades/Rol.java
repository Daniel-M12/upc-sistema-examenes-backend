package com.sistema.examenes.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "roles")
public class Rol {
    @Id
    private Long rolid;
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY , mappedBy = "rol")
    private Set<UsuarioRol> usuarioRoles = new HashSet<>();
}
