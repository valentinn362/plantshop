package com.plantshop.app.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PedidoResponseDTO {
    private Long id;
    private LocalDateTime fecha;
    private Double total;
    private String estado;
    private String nombreCliente;
}
