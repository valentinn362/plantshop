package com.plantshop.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Usamos @Controller (no RestController) para devolver HTML
public class ViewController {

    @GetMapping("/")
    public String index() {
        return "index"; // Busca un archivo llamado index.html en /templates
    }
}