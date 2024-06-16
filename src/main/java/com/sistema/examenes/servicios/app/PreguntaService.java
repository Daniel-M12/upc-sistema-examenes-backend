package com.sistema.examenes.servicios.app;

import com.sistema.examenes.entidades.app.Examen;
import com.sistema.examenes.entidades.app.Pregunta;

import java.util.Set;

public interface PreguntaService {
    Pregunta agregarPregunta(Pregunta pregunta);

    Pregunta actualizarPregunta(Pregunta pregunta);

    Set<Pregunta> obtenerPreguntas();

    Pregunta obtenerPregunta(Long preguntaId);

    Set<Pregunta> obtenerPreguntasDelExamen(Examen examen);

    void eliminarPregunta(Long preguntaId);

    Pregunta listarPregunta(Long preguntaId);
}
