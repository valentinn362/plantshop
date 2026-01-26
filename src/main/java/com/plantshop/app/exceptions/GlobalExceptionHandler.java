package com.plantshop.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> manejarRecursoNoEncontrado(ResourceNotFoundException ex) {
        Map<String, Object> cuerpo = new LinkedHashMap<>();
        cuerpo.put("timestamp", LocalDateTime.now());
        cuerpo.put("estado", HttpStatus.NOT_FOUND.value());
        cuerpo.put("error", "No encontrado");
        cuerpo.put("mensaje", ex.getMessage());

        return new ResponseEntity<>(cuerpo, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> manejarErroresValidacion(MethodArgumentNotValidException ex) {
        Map<String, Object> cuerpo = new LinkedHashMap<>();
        cuerpo.put("timestamp", LocalDateTime.now());
        cuerpo.put("estado", HttpStatus.BAD_REQUEST.value());

        // Creamos un mapa solo para los errores de los campos
        Map<String, String> errores = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errores.put(error.getField(), error.getDefaultMessage())
        );

        cuerpo.put("errores", errores);

        return new ResponseEntity<>(cuerpo, HttpStatus.BAD_REQUEST);
    }
}