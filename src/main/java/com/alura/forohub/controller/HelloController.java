package com.alura.forohub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String helloWorld() {
        // Retorna un mensaje indicando que no hay problemas en la configuración inicial
        return "Sin problemas en la configuracion inicial!";
    }

}
