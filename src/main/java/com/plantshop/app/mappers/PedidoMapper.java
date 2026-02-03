package com.plantshop.app.mappers;

import com.plantshop.app.dtos.PedidoResponseDTO;
import com.plantshop.app.models.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PedidoMapper {
    @Mapping(source = "cliente.nombre", target = "nombreCliente")
    PedidoResponseDTO toResponseDTO(Pedido pedido);
}
