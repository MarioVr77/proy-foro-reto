package com.alura.forohub.domain.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cursos") // Define el nombre de la tabla en la base de datos
@Entity(name = "Curso") // Define que esta clase es una entidad JPA llamada "Curso"
@Getter // Genera automáticamente métodos getter para todos los campos
@NoArgsConstructor // Genera un constructor sin argumentos
@AllArgsConstructor // Genera un constructor con todos los argumentos
@EqualsAndHashCode(of = "id") // Genera automáticamente los métodos equals() y hashCode() usando solo el campo "id"

public class Curso {

    @Id // Marca el campo como la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática de valores para la clave primaria
    private Long id;

    private String nombre; // Nombre del curso

    private String categoria; // Categoría del curso

    private Boolean activo; // Indicador de si el curso está activo o no

    // Métodos, getters y setters son generados automáticamente por las anotaciones de Lombok
}
