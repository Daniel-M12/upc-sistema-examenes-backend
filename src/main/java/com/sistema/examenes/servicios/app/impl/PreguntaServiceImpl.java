package com.sistema.examenes.servicios.app.impl;

import com.sistema.examenes.entidades.app.Examen;
import com.sistema.examenes.entidades.app.Pregunta;
import com.sistema.examenes.repositorios.app.PreguntaRepository;
import com.sistema.examenes.servicios.app.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PreguntaServiceImpl implements PreguntaService {
    private final PreguntaRepository repository;

    @Autowired
    public PreguntaServiceImpl(PreguntaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pregunta agregarPregunta(Pregunta pregunta) {
        return repository.save(pregunta);
    }

    @Override
    public Pregunta actualizarPregunta(Pregunta pregunta) {
        return repository.save(pregunta);
    }

    @Override
    public Set<Pregunta> obtenerPreguntas() {
        return (Set<Pregunta>) repository.findAll();
    }

    @Override
    public Pregunta obtenerPregunta(Long preguntaId) {
        return repository.findById(preguntaId).get();
    }

    @Override
    public Set<Pregunta> obtenerPreguntasDelExamen(Examen examen) {
        return repository.findByExamen(examen);
    }

    @Override
    public void eliminarPregunta(Long preguntaId) {
        Pregunta pregunta = new Pregunta();
        pregunta.setPreguntaId(preguntaId);
        repository.delete(pregunta);
    }

    @Override
    public Pregunta listarPregunta(Long preguntaId) {
        return this.repository.getReferenceById(preguntaId);
    }
}
