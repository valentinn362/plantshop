package com.plantshop.app.repositories;

import com.plantshop.app.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Métodos generales si los necesitas más adelante
}