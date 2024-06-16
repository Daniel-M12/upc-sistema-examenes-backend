package com.sistema.examenes.repositorios.app;

import com.sistema.examenes.entidades.app.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
