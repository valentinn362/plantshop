package com.plantshop.app.controllers;

import com.plantshop.app.dtos.PedidoDTO;
import com.plantshop.app.dtos.PedidoResponseDTO;
import com.plantshop.app.services.impl.PedidoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoServiceImpl pedidoService;

    @PostMapping("/")
    public ResponseEntity<PedidoResponseDTO> crear(@Valid @RequestBody PedidoDTO pedidoDTO) {
        PedidoResponseDTO respuesta = pedidoService.crearPedido(pedidoDTO);
        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<PedidoResponseDTO>> listarPedidos() {
        List<PedidoResponseDTO> pedidos = pedidoService.obtenerTodos();
        return ResponseEntity.ok(pedidos);
    }
}
