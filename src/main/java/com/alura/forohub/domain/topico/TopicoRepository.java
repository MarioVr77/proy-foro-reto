package com.alura.forohub.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    // Encuentra todos los tópicos activos y los pagina
    Page<Topico> findByActivoTrue(Pageable paginacion);

    // Consulta personalizada para verificar si un tópico está activo por su ID
    @Query("""
            SELECT t.activo
            FROM Topico t
            WHERE t.id = :idTopico
            """)
    Boolean findActivoById(Long idTopico);

    // Verifica si existe un tópico con el título y mensaje dados
    boolean existsByTituloAndMensaje(String titulo, String mensaje);
}
