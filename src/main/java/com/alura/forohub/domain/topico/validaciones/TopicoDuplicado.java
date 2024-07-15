package com.alura.forohub.domain.topico.validaciones;

import com.alura.forohub.domain.topico.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicoDuplicado implements ValidadorDeTopicos {

    @Autowired
    private TopicoRepository repositorio;

    @Override
    public void validarTopico(String titulo, String mensaje) {
        // Verificar si ya existe un tópico con el mismo título y mensaje
        if (repositorio.existsByTituloAndMensaje(titulo, mensaje)) {
            throw new ValidationException("Este tópico ya existe");
        }
    }

}
