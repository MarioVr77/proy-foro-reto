package com.alura.forohub.domain.topico;

import java.time.LocalDateTime;

// DTO utilizado para enviar información básica de un tópico como respuesta
public record ResponseTopicoDTO(
        Long id, // ID del tópico
        String titulo, // Título del tópico
        String mensaje, // Mensaje del tópico
        LocalDateTime fechaCreacion // Fecha de creación del tópico
) {

    // Constructor que recibe un objeto Topico y asigna sus valores a los campos del DTO
    public ResponseTopicoDTO(Topico topico) {
        this(topico.getId(), // Asigna el ID del tópico
                topico.getTitulo(), // Asigna el título del tópico
                topico.getMensaje(), // Asigna el mensaje del tópico
                topico.getFechaCreacion() // Asigna la fecha de creación del tópico
        );
    }
}

