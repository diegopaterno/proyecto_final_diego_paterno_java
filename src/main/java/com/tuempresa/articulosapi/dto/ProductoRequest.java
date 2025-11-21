package com.tuempresa.articulosapi.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record ProductoRequest(

        @NotBlank(message = "El nombre es obligatorio")
        @Size(max = 120)
        String nombre,

        @NotBlank(message = "La descripción es obligatoria")
        @Size(max = 500)
        String descripcion,

        @NotNull(message = "El precio es obligatorio")
        @DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0")
        BigDecimal precio,

        @NotBlank(message = "La categoría es obligatoria")
        @Size(max = 80)
        String categoria,

        @Size(max = 500)
        String imagenUrl,

        @NotNull(message = "El stock es obligatorio")
        @Min(value = 0, message = "El stock no puede ser negativo")
        Integer stock
) {}
