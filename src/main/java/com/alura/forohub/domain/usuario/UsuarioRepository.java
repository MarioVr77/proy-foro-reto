package com.alura.forohub.domain.usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Método para encontrar usuarios activos paginados
    Page<Usuario> findByActivoTrue(Pageable paginacion);

    // Método para encontrar detalles de usuario por correo electrónico
    UserDetails findByCorreoElectronico(String correoElectronico);
}
