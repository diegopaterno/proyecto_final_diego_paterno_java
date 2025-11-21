package com.tuempresa.articulosapi.dto;

import java.math.BigDecimal;

public record ProductoResponse(
        Long id,
        String nombre,
        String descripcion,
        BigDecimal precio,
        String categoria,
        String imagenUrl,
        Integer stock
) {}
