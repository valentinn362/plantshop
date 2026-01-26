package com.plantshop.app.models;

import com.plantshop.app.enums.TipoPlanta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "plantas")
@PrimaryKeyJoinColumn(name = "producto_id")
public class Planta extends Producto {

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_planta")
    private TipoPlanta tipoPlanta;

    @Column(name = "frecuencia_riego")
    private String frecuenciaRiego;

    @Column(name = "requerimientos_luz")
    private String requerimientosLuz;

    @Column(name = "altura_maxima")
    private Double alturaMaxima;

    @Column(name = "nivel_cuidado")
    private String nivelCuidado;

    @Column(name = "temporada")
    private String temporada;
}