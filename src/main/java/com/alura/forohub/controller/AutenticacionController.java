package com.alura.forohub.controller;

import jakarta.validation.Valid;
import com.alura.forohub.domain.usuario.AutenticacionUsuarioDTO;
import com.alura.forohub.domain.usuario.Usuario;
import com.alura.forohub.infra.security.DatosJWTToken;
import com.alura.forohub.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid AutenticacionUsuarioDTO datosAutenticacionUsuario) {
        // Crear el token de autenticación con las credenciales del usuario
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.email(),
                datosAutenticacionUsuario.contrasena());
        // Autenticar el token
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        // Generar el token JWT
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        // Devolver el token en la respuesta
        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
    }
}