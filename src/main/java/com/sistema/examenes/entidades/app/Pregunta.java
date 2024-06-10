package com.sistema.examenes.entidades.app;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "preguntas")
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long preguntaId;

    @Column(length = 5000)
    private String contenido;

    private String imagen;
    private String opcion1;
    private String opcion2;
    private String opcion3;
    private String opcion4;
    @Transient
    private String respuestaDada;

    private String respuesta;

    @ManyToOne(fetch = FetchType.EAGER)
    private Examen examen;
}
