package com.plantshop.app.services.impl;

import com.plantshop.app.dtos.PlantaDTO;
import com.plantshop.app.exceptions.ResourceNotFoundException;
import com.plantshop.app.mappers.PlantaMapper;
import com.plantshop.app.models.Planta;
import com.plantshop.app.repositories.PlantaRepository;
import com.plantshop.app.services.IPlantaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PlantaServiceImpl implements IPlantaService {

    @Autowired
    private PlantaRepository plantaRepository;

    @Autowired
    private PlantaMapper plantaMapper;  // Inyectas el mapper

    @Transactional(readOnly = true)
    @Override
    public List<PlantaDTO> obtenerTodasPlantas() {
        return plantaRepository.findByActivoTrue()
                .stream()
                .map(plantaMapper::toDTO)  // Usas el mapper aquí
                .collect(Collectors.toList());
    }

    @Override
    public PlantaDTO obtenerPlantaPorId(Long id) {
        Planta planta = plantaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró la planta con ID: " + id));
        return plantaMapper.toDTO(planta);  // Usas el mapper
    }

    @Transactional
    @Override
    public PlantaDTO crearPlanta(PlantaDTO plantaDTO) {
        if (plantaRepository.existsByCodigoSKU(plantaDTO.getCodigoSKU())) {
            throw new RuntimeException("Ya existe una planta con el SKU: " + plantaDTO.getCodigoSKU());
        }

        // El mapper ahora se encarga de casi todo, incluyendo tipoProducto y fecha
        Planta planta = plantaMapper.toEntity(plantaDTO);
        planta.setFechaCreacion(LocalDateTime.now());
        planta.setFechaActualizacion(LocalDateTime.now());

        Planta guardada = plantaRepository.save(planta);
        return plantaMapper.toDTO(guardada);
    }

    @Transactional
    @Override
    public PlantaDTO actualizarPlanta(Long id, PlantaDTO plantaDTO) {
        // 1. Buscamos la entidad existente
        Planta planta = plantaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Planta no encontrada"));

        // 2. MapStruct vuelca los datos del DTO sobre la entidad encontrada
        plantaMapper.actualizarPlantaDesdeDto(plantaDTO, planta);

        // 3. Solo manejamos manualmente lo que no está en el DTO (como la fecha)
        planta.setFechaActualizacion(LocalDateTime.now());

        // 4. Guardamos y devolvemos el DTO actualizado
        Planta actualizada = plantaRepository.save(planta);
        return plantaMapper.toDTO(actualizada);
    }

    @Transactional
    @Override
    public void eliminarPlanta(Long id) {
        Planta planta = plantaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Planta no encontrada"));

        planta.setActivo(false);
        planta.setFechaActualizacion(LocalDateTime.now());
        plantaRepository.save(planta);
    }

    @Override
    @Transactional
    public void reactivarPlanta(Long id) {
        Planta planta = plantaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Planta no encontrada con ID: " + id));

        planta.setActivo(true);
        // Al estar en un método @Transactional, Hibernate detecta el cambio
        // y hace el update automáticamente al finalizar.

        plantaRepository.save(planta); // El método que uses para pasar de Entity a DTO
    }
}