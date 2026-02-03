package com.plantshop.app.dtos;

import com.plantshop.app.enums.TipoPlanta;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlantaDTO {
    private Long id;

    @NotBlank(message = "El nombre de la planta es obligatorio")
    private String nombre;

    private String descripcion;

    @Positive(message = "El precio debe ser mayor a cero")
    private Double precio;

    @Min(value = 0, message = "El stock no puede ser menor a cero")
    private Integer stock;

    @NotBlank(message = "El código SKU es obligatorio")

    private String codigoSKU;
    private Boolean activo;

    @Min(value = 5, message = "El stock no puede ser menor a 5")
    private Integer minStock;

    private String tamaño;

    // Campos específicos de Planta
    private TipoPlanta tipoPlanta;
    private String frecuenciaRiego;
    private String requerimientosLuz;
    private Double alturaMaxima;
    private String nivelCuidado;
    private String temporada;
}