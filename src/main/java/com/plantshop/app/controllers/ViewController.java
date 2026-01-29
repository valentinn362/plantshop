package com.plantshop.app.controllers;

import com.plantshop.app.dtos.PlantaDTO;
import com.plantshop.app.services.impl.PlantaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // Usamos @Controller (no RestController) para devolver HTML
public class ViewController {

    @Autowired
    private PlantaServiceImpl plantaService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("plantas", plantaService.obtenerTodasPlantas());
        model.addAttribute("nuevaPlanta", new PlantaDTO()); // Objeto vacío para el formulario
        return "index";
    }

    @PostMapping("/guardar")
    public String guardarPlanta(@ModelAttribute("nuevaPlanta") PlantaDTO dto) {
        plantaService.crearPlanta(dto);
        return "redirect:/"; // Esto recarga la página principal
    }
}