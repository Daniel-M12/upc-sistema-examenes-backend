package com.sistema.examenes.servicios.app.impl;

import com.sistema.examenes.entidades.app.Categoria;
import com.sistema.examenes.entidades.app.Examen;
import com.sistema.examenes.repositorios.app.ExamenRepository;
import com.sistema.examenes.servicios.app.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class ExamenServiceImpl implements ExamenService {
    private final ExamenRepository repository;

    @Autowired
    public ExamenServiceImpl(ExamenRepository repository) {
        this.repository = repository;
    }

    @Override
    public Examen agregarExamen(Examen examen) {
        return repository.save(examen);
    }

    @Override
    public Examen actualizarExamen(Examen examen) {
        return repository.save(examen);
    }

    @Override
    public Set<Examen> obtenerExamenes() {
        return new LinkedHashSet<>(repository.findAll());
    }

    @Override
    public Examen obtenerExamen(Long examenId) {
        return repository.findById(examenId).get();
    }

    @Override
    public void eliminarExamen(Long examenId) {
        Examen examen = new Examen();
        examen.setExamenId(examenId);
        repository.delete(examen);
    }

    @Override
    public List<Examen> listarExamenesDeUnaCategoria(Categoria categoria) {
        return repository.findByCategoria(categoria);
    }

    @Override
    public List<Examen> obtenerExamenesActivos() {
        return repository.findByActivo(true);
    }

    @Override
    public List<Examen> obtenerExamenesActivosDeUnaCategoria(Categoria categoria) {
        return repository.findByCategoriaAndActivo(categoria, true);
    }
}
