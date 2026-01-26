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
@RequestMapping("/api/plantas")
public class PlantaController {

    @Autowired
    private IPlantaService plantaService;

    @GetMapping
    public List<PlantaDTO> obtenerTodas() {
        return plantaService.obtenerTodasPlantas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlantaDTO> obtenerPorId(@PathVariable Long id) {
        // Si el ID no existe, el Service lanza ResourceNotFoundException
        // y el GlobalExceptionHandler responde con un 404 automáticamente.
        return ResponseEntity.ok(plantaService.obtenerPlantaPorId(id));
    }

    @PostMapping
    public ResponseEntity<PlantaDTO> crear(@Valid @RequestBody PlantaDTO plantaDTO) {
        return new ResponseEntity<>(plantaService.crearPlanta(plantaDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlantaDTO> actualizar(@PathVariable Long id, @Valid @RequestBody PlantaDTO plantaDTO) {
        return ResponseEntity.ok(plantaService.actualizarPlanta(id, plantaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        plantaService.eliminarPlanta(id);
        return ResponseEntity.noContent().build();
    }
}