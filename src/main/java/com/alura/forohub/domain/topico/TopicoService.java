package com.alura.forohub.domain.topico;

import com.alura.forohub.domain.curso.Curso;
import com.alura.forohub.domain.curso.CursoRepository;
import com.alura.forohub.domain.topico.validaciones.ValidadorDeTopicos;
import com.alura.forohub.domain.usuario.Usuario;
import com.alura.forohub.domain.usuario.UsuarioRepository;
import com.alura.forohub.infra.errores.ValidacionDeIntegridad;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private List<ValidadorDeTopicos> validaciones;

    public Topico registrarTopico(RequestTopicoDTO datos){

        // Validar si el usuario existe en la base de datos
        if (!usuarioRepository.findById(datos.usuarioId()).isPresent()) {
            throw new ValidacionDeIntegridad("Este ID de usuario no fue encontrado");
        }

        // Validar si el curso existe en la base de datos
        if (!cursoRepository.existsByNombre(datos.curso())) {
            throw new ValidacionDeIntegridad("Este curso no fue encontrado");
        }

        // Ejecutar las validaciones personalizadas
        for (ValidadorDeTopicos validador : validaciones) {
            validador.validarTopico(datos.titulo(), datos.mensaje());
        }

        // Obtener el curso y el usuario asociados al tópico
        Curso curso = cursoRepository.findByNombre(datos.curso());
        Usuario usuario = usuarioRepository.getReferenceById(datos.usuarioId());

        // Crear y guardar el nuevo tópico
        Topico topico = new Topico(
                datos.titulo(),
                datos.mensaje(),
                usuario,
                curso
        );
        topicoRepository.save(topico);

        return topico;
    }

    public Topico actualizarTopico(@PathVariable Long id, @RequestBody @Valid ActualizarTopicoDTO datos){
        // Obtener el tópico por su ID
        Topico topico = topicoRepository.getReferenceById(id);

        // Validar si el curso existe en la base de datos
        if (!cursoRepository.existsByNombre(datos.curso())) {
            throw new ValidacionDeIntegridad("Este curso no fue encontrado");
        }

        // Ejecutar las validaciones personalizadas
        for (ValidadorDeTopicos validador : validaciones) {
            validador.validarTopico(datos.titulo(), datos.mensaje());
        }

        // Obtener el curso asociado al tópico
        Curso curso = cursoRepository.findByNombre(datos.curso());

        // Actualizar los datos del tópico
        topico.actualizarTopico(
                datos.titulo(),
                datos.mensaje(),
                datos.status(),
                curso
        );

        return topico;
    }
}
