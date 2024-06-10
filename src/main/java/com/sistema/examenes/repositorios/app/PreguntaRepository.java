package com.sistema.examenes.repositorios.app;

import com.sistema.examenes.entidades.app.Examen;
import com.sistema.examenes.entidades.app.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {
    Set<Pregunta> findByExamen(Examen examen);
}
