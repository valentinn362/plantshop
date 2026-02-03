package com.plantshop.app.services.impl;

import com.plantshop.app.dtos.DetallePedidoDTO;
import com.plantshop.app.dtos.PedidoDTO;
import com.plantshop.app.dtos.PedidoResponseDTO;
import com.plantshop.app.exceptions.ResourceNotFoundException;
import com.plantshop.app.mappers.PedidoMapper;
import com.plantshop.app.models.Cliente;
import com.plantshop.app.models.DetallePedido;
import com.plantshop.app.models.Pedido;
import com.plantshop.app.models.Producto;
import com.plantshop.app.repositories.ClienteRepository;
import com.plantshop.app.repositories.PedidoRepository;
import com.plantshop.app.repositories.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.plantshop.app.enums.EstadoPedido;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PedidoServiceImpl {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired private ProductoRepository productoRepository;
    @Autowired private ClienteRepository clienteRepository;
    @Autowired private PedidoMapper pedidoMapper;

    public PedidoResponseDTO crearPedido(PedidoDTO dto) {
        Pedido pedido = new Pedido();
        pedido.setFecha(LocalDateTime.now());
        pedido.setEstado(EstadoPedido.PENDIENTE);

        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));
        pedido.setCliente(cliente);

        double totalAcumulado = 0;

        for (DetallePedidoDTO itemDto : dto.getDetalles()) {
            Producto producto = productoRepository.findById(itemDto.getProductoId())
                    .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));

            // Validar stock
            if (producto.getStock() < itemDto.getCantidad()) {
                throw new RuntimeException("Stock insuficiente para: " + producto.getNombre());
            }

            // Actualizar stock del producto
            producto.setStock(producto.getStock() - itemDto.getCantidad());
            productoRepository.save(producto);

            // Crear detalle
            DetallePedido detalle = new DetallePedido();
            detalle.setProducto(producto);
            detalle.setCantidad(itemDto.getCantidad());
            detalle.setPrecioUnitario(producto.getPrecio());
            detalle.setSubtotal(producto.getPrecio() * itemDto.getCantidad());
            detalle.setPedido(pedido);

            pedido.getDetalles().add(detalle);
            totalAcumulado += detalle.getSubtotal();
        }

        pedido.setTotal(totalAcumulado);
        Pedido guardado = pedidoRepository.save(pedido);
        return pedidoMapper.toResponseDTO(guardado);
    }


    public List<PedidoResponseDTO> obtenerTodos() {
        return pedidoRepository.findAll()
                .stream()
                .map(pedidoMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}
