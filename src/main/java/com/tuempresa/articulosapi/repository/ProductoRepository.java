package com.tuempresa.articulosapi.repository;

import com.tuempresa.articulosapi.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByNombreContainingIgnoreCase(String nombre);

    Optional<Producto> findByNombreIgnoreCase(String nombre);
}
