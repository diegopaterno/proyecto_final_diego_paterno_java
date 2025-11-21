package com.tuempresa.articulosapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "productos")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=120)
    private String nombre;

    @Column(nullable=false, length=500)
    private String descripcion;

    @Column(nullable=false, precision=12, scale=2)
    private BigDecimal precio;

    @Column(nullable=false, length=80)
    private String categoria;

    @Column(length=500)
    private String imagenUrl;

    @Column(nullable=false)
    private Integer stock;
}
