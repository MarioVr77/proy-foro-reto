package com.alura.forohub.domain.respuesta;

import com.alura.forohub.domain.topico.Topico;
import com.alura.forohub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "respuestas") // Define el nombre de la tabla en la base de datos
@Entity(name = "Respuesta") // Define que esta clase es una entidad JPA llamada "Respuesta"
@Getter // Genera automáticamente métodos getter para todos los campos
@NoArgsConstructor // Genera un constructor sin argumentos
@AllArgsConstructor // Genera un constructor con todos los argumentos
@EqualsAndHashCode(of = "id") // Genera automáticamente los métodos equals() y hashCode() usando solo el campo "id"

public class Respuesta {

    @Id // Marca el campo como la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática de valores para la clave primaria
    private Long id;

    private String mensaje; // Mensaje de la respuesta

    @ManyToOne // Relación muchos a uno con la entidad Topico
    private Topico topico; // Tópico al cual pertenece esta respuesta

    private LocalDateTime fechaCreacion; // Fecha y hora de creación de la respuesta

    private Usuario autor; // Usuario que creó la respuesta

    private Boolean solucion; // Indicador de si esta respuesta es la solución al problema

    // Métodos, getters y setters son generados automáticamente por las anotaciones de Lombok
}

