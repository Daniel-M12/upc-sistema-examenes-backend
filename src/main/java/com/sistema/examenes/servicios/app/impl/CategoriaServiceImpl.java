package com.sistema.examenes.servicios.app.impl;

import com.sistema.examenes.entidades.app.Categoria;
import com.sistema.examenes.repositorios.app.CategoriaRepository;
import com.sistema.examenes.servicios.app.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    private final CategoriaRepository repository;

    @Autowired
    public CategoriaServiceImpl(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Categoria agregarCategoria(Categoria categoria) {
        return repository.save(categoria);
    }

    @Override
    public Categoria actualizarCategoria(Categoria categoria) {
        return repository.save(categoria);
    }

    @Override
    public Set<Categoria> obtenerCategorias() {
        return new LinkedHashSet<>(repository.findAll());
    }

    @Override
    public Categoria obtenerCategoria(Long categoriaId) {
        return repository.findById(categoriaId).get();
    }

    @Override
    public void eliminarCategoria(Long categoriaId) {
        Categoria categoria = new Categoria();
        categoria.setCategoriaId(categoriaId);
        repository.delete(categoria);
    }
}
