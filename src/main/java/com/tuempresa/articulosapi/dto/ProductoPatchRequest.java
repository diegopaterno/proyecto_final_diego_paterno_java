package com.tuempresa.articulosapi.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import java.math.BigDecimal;

public record ProductoPatchRequest(

        @DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0")
        BigDecimal precio,

        @Min(value = 0, message = "El stock no puede ser negativo")
        Integer stock
) {}
