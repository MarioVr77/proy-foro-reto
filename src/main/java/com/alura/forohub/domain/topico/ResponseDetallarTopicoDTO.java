package com.alura.forohub.domain.topico;


import java.time.LocalDateTime;

// DTO utilizado para enviar detalles específicos de un tópico como respuesta
public record ResponseDetallarTopicoDTO(
        Long id, // ID del tópico
        String titulo, // Título del tópico
        String mensaje, // Mensaje del tópico
        LocalDateTime fechaCreacion, // Fecha de creación del tópico
        String status, // Estado del tópico
        String usuario, // Nombre del usuario que creó el tópico
        String curso // Nombre del curso asociado al tópico
) {

    // Constructor que recibe un objeto Topico y asigna sus valores a los campos del DTO
    public ResponseDetallarTopicoDTO(Topico topico) {
        this(topico.getId(), // Asigna el ID del tópico
                topico.getTitulo(), // Asigna el título del tópico
                topico.getMensaje(), // Asigna el mensaje del tópico
                topico.getFechaCreacion(), // Asigna la fecha de creación del tópico
                topico.getStatus(), // Asigna el estado del tópico
                topico.getUsuario().getNombre(), // Asigna el nombre del usuario que creó el tópico
                topico.getCurso().getNombre() // Asigna el nombre del curso asociado al tópico
        );
    }
}
