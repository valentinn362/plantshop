package com.plantshop.app.repositories;

import com.plantshop.app.models.Planta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantaRepository extends JpaRepository<Planta, Long> {
    List<Planta> findByActivoTrue();
    List<Planta> findByTipoPlanta(com.plantshop.app.enums.TipoPlanta tipoPlanta);
    boolean existsByCodigoSKU(String codigoSKU);
}