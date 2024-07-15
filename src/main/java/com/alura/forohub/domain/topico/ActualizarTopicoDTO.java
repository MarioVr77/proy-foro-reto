package com.alura.forohub.domain.topico;

import java.time.LocalDateTime;

// DTO utilizado para actualizar un tópico
public record ActualizarTopicoDTO(
        String titulo, // Nuevo título del tópico
        String mensaje, // Nuevo mensaje del tópico
        String status, // Nuevo estado del tópico
        String curso // Nuevo nombre del curso asociado al tópico
) {

}
