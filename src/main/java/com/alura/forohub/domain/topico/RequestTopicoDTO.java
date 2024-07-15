package com.alura.forohub.domain.topico;

import jakarta.validation.constraints.NotNull;

// DTO utilizado para recibir datos al momento de registrar un nuevo tópico
public record RequestTopicoDTO(
        @NotNull
        String titulo, // Título del tópico (no puede ser nulo)
        @NotNull
        String mensaje, // Mensaje del tópico (no puede ser nulo)
        @NotNull
        Long usuarioId, // ID del usuario que crea el tópico (no puede ser nulo)
        @NotNull
        String curso // Nombre del curso asociado al tópico (no puede ser nulo)
) {

}