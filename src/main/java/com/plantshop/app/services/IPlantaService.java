package com.plantshop.app.services;

import com.plantshop.app.dtos.PlantaDTO;

import java.util.List;

public interface IPlantaService {
    List<PlantaDTO> obtenerTodasPlantas();
    PlantaDTO obtenerPlantaPorId(Long id);
    PlantaDTO crearPlanta(PlantaDTO crearPlantaDTO);
    PlantaDTO actualizarPlanta(Long id, PlantaDTO crearPlantaDTO);
    void eliminarPlanta(Long id);

    void reactivarPlanta(Long id);
}