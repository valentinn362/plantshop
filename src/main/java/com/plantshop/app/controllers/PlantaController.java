package com.plantshop.app.controllers;

import com.plantshop.app.dtos.PlantaDTO;
import com.plantshop.app.services.IPlantaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plantas")
public class PlantaController {

    @Autowired
    private IPlantaService plantaService;

    @GetMapping
    public List<PlantaDTO> obtenerTodas() {
        return plantaService.obtenerTodasPlantas();
    }

    @PostMapping
    public ResponseEntity<PlantaDTO> crear(@Valid @RequestBody PlantaDTO plantaDTO) {
        return new ResponseEntity<>(plantaService.crearPlanta(plantaDTO), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        plantaService.eliminarPlanta(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/activar")
    public ResponseEntity<Void> reactivar(@PathVariable Long id) {
        plantaService.reactivarPlanta(id);
        return ResponseEntity.noContent().build();
    }
}