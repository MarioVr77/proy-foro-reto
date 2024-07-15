# Foro Hub

> Una API REST para la gestión de un foro, permitiendo la creación de dudas llamadas tópicos.

## Tabla de Contenidos

- [Descripción](#descripción)
- [Características](#características)
- [Tecnologías Usadas](#tecnologías-usadas)
- [Dependencias](#dependencias)
- [Imágenes](#imágenes)
- [Instalación y Ejecución](#instalación-y-ejecución)
- [Uso](#uso)
- [Estado del Proyecto](#estado-del-proyecto)


## Descripción

El challenge Foro Hub consiste en una API REST para la gestión de un foro que permite la creación de dudas llamadas tópicos. De acuerdo al challenge del programa Oracle Next Education y AluraLatam, el foro es un espacio donde todos los participantes de una plataforma pueden plantear sus preguntas sobre determinados tópicos.

## Características

- La API se centra específicamente en los tópicos y permite realizar las operaciones CRUD: Crear, Consultar, Actualizar y Eliminar tópicos.
- Los datos se guardan en una base de datos relacional llamada `foro_hub` para la persistencia de la información, la cual incluye las siguientes tablas:
  - Topicos
  - Respuesta
  - Curso
  - Usuario
- Se implementa la autenticación de JWT (JSON Web Token) para validar usuarios con correo y contraseña, los cuales están registrados en la base de datos de usuarios.
- Se implementan las validaciones de negocio para no recibir solicitudes con campos nulos y para no permitir el registro de tópicos duplicados con el mismo título y mensaje.
- Se siguen las mejores prácticas y el modelo de desarrollo SOLID, permitiendo continuar con el desarrollo y la implementación de nuevas funcionalidades en la API Foro Hub.

## Tecnologías Usadas

- Java 17
- Spring Boot 3.0
- Spring Data JPA
- Hibernate
- Maven
- Lombok

## Dependencias

- `spring-boot-starter-data-jpa`: Para la integración de JPA con Spring Boot.
- `spring-boot-starter-security`: Para la seguridad y autenticación.
- `spring-boot-starter-validation`: Para la validación de datos.
- `spring-boot-starter-web`: Para crear aplicaciones web, incluyendo RESTful services.
- `flyway-core` y `flyway-mysql`: Para la migración y gestión de la base de datos.
- `spring-boot-devtools`: Para el desarrollo, con reinicio automático.
- `mysql-connector-j`: Para la conexión con la base de datos MySQL.
- `lombok`: Para reducir el código boilerplate.
- `spring-boot-starter-test`: Para pruebas unitarias y de integración.
- `spring-security-test`: Para pruebas de seguridad.
- `java-jwt`: Para trabajar con JSON Web Tokens.

## Imágenes

1. Autenticación exitosa
   ![Autenticación exitosa](url-de-la-imagen)
2. Eliminación de un tópico
   ![Eliminar Tópico](url-de-la-imagen)
3. Modificación del título de un tópico
   ![Modificar Título](url-de-la-imagen)
4. Error de autenticación
   ![Error de Autenticación](url-de-la-imagen)
5. Registro exitoso de un tópico
   ![Registrar Tópico Correcto](url-de-la-imagen)
6. Intento de inicio de sesión fallido
   ![Bad Login](url-de-la-imagen)
7. Error de recurso no encontrado
   ![Error Not Found](url-de-la-imagen)
8. Tópico duplicado
   ![Tópico Duplicado](url-de-la-imagen)
9. Detalle de un tópico
   ![Detallar Tópico](url-de-la-imagen)
10. Listado de tópicos
    ![Listar Tópicos](url-de-la-imagen)

## Instalación y Ejecución

1. Clonar el repositorio:
    ```bash
    git clone https://github.com/user-name-c/forohub_challenge.git
    ```

2. Navegar al directorio del proyecto:
    ```bash
    cd forohub_challenge
    ```

3. Configurar las propiedades de la base de datos en `application.properties`.

4. Ejecutar la aplicación:
    ```bash
    mvn spring-boot:run
    ```

## Uso

1. Autenticarse y obtener un token JWT desde el endpoint `/login`.
2. Usar el token para acceder a los endpoints protegidos como `/topicos`.

## Estado del Proyecto

El proyecto se encuentra en estado de finalización con los requisitos básicos completados, incluyendo la autenticación de usuario usando JWT y los endpoints de la ruta `/topicos` con sus respectivas validaciones de negocio propuestas en el Challenge.