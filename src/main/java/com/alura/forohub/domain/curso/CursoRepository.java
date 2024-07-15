package com.alura.forohub.domain.curso;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    // Encuentra todos los cursos que están activos y los pagina
    Page<Curso> findByActivoTrue(Pageable paginacion);

    // Verifica si existe un curso con el nombre dado
    Boolean existsByNombre(String nombre);

    // Encuentra un curso por su nombre
    Curso findByNombre(String nombre);
}
