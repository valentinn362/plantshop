package com.plantshop.app.mappers;

import com.plantshop.app.dtos.PlantaDTO;
import com.plantshop.app.models.Planta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", imports = {com.plantshop.app.enums.TipoProducto.class})public interface PlantaMapper {

    // MapStruct asocia campos con el mismo nombre automáticamente
    PlantaDTO toDTO(Planta planta);

    // Para convertir de DTO a Entidad
    @Mapping(target = "tipoProducto", expression = "java(TipoProducto.PLANTA)")
    @Mapping(target = "fechaCreacion", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "activo", constant = "true")
    Planta toEntity(PlantaDTO plantaDTO);

    /**
     * Actualiza una instancia existente de Planta con los datos del DTO.
     * @MappingTarget indica cuál es el objeto que recibirá los cambios.
     */
    void actualizarPlantaDesdeDto(PlantaDTO dto, @MappingTarget Planta entidad);
}