package com.plantshop.app.dtos;

import lombok.Data;
import java.util.List;

// DTO para recibir la orden completa
@Data
public class PedidoDTO {
    private Long clienteId;
    private List<DetallePedidoDTO> detalles;
}
