package com.alura.forohub.domain.topico;

import com.alura.forohub.domain.curso.Curso;
import com.alura.forohub.domain.respuesta.Respuesta;
import com.alura.forohub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "topicos") // Nombre de la tabla en la base de datos
@Entity(name = "topico") // Nombre de la entidad JPA
@Getter // Genera automáticamente los métodos getter para todos los campos
@NoArgsConstructor // Genera un constructor sin argumentos
@AllArgsConstructor // Genera un constructor con todos los argumentos
@EqualsAndHashCode(of = "id") // Genera automáticamente los métodos equals() y hashCode() usando solo el campo "id"

public class Topico {

    @Id // Marca el campo como clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática de valores para la clave primaria
    private Long id;

    private String titulo; // Título del tópico

    private String mensaje; // Mensaje del tópico

    private LocalDateTime fechaCreacion; // Fecha y hora de creación del tópico

    private String status; // Estado del tópico

    @ManyToOne(fetch = FetchType.LAZY) // Relación muchos a uno con Usuario, carga perezosa
    @JoinColumn(name = "usuario_id") // Nombre de la columna en la base de datos
    private Usuario usuario; // Usuario que creó el tópico

    @ManyToOne(fetch = FetchType.LAZY) // Relación muchos a uno con Curso, carga perezosa
    @JoinColumn(name = "curso_id") // Nombre de la columna en la base de datos
    private Curso curso; // Curso al que pertenece el tópico

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL) // Relación uno a muchos con Respuesta, cascada todas las operaciones
    private List<Respuesta> respuestas; // Lista de respuestas asociadas a este tópico

    private Boolean activo; // Indicador de si el tópico está activo o no

    // Constructor para inicializar un nuevo tópico
    public Topico(String titulo, String mensaje, Usuario usuario, Curso curso) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaCreacion = LocalDateTime.now();
        this.status = "1";
        this.usuario = usuario;
        this.curso = curso;
        this.activo = true;
    }

    // Método para desactivar lógicamente el tópico
    public void desactivarTopico() {
        this.activo = false;
    }

    // Método para actualizar los datos del tópico
    public void actualizarTopico(String titulo, String mensaje, String status, Curso curso) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.status = status;
        this.curso = curso;
    }
}
