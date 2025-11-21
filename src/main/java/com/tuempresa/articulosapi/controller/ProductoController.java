package com.tuempresa.articulosapi.controller;

import com.tuempresa.articulosapi.dto.*;
import com.tuempresa.articulosapi.service.ProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService service;

    // 1) Listar productos
    @GetMapping
    public List<ProductoResponse> listar() {
        return service.listar();
    }

    // 2) Obtener detalle por ID
    @GetMapping("/{id}")
    public ProductoResponse obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    // 3) Buscar por nombre
    @GetMapping("/buscar")
    public List<ProductoResponse> buscarPorNombre(@RequestParam String nombre) {
        return service.buscarPorNombre(nombre);
    }

    // 4) Crear producto
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductoResponse crear(@Valid @RequestBody ProductoRequest request) {
        return service.crear(request);
    }

    // 5) Actualizar completo
    @PutMapping("/{id}")
    public ProductoResponse actualizar(@PathVariable Long id,
                                       @Valid @RequestBody ProductoRequest request) {
        return service.actualizar(id, request);
    }

    // 6) Actualizar parcial (precio/stock opcional)
    @PatchMapping("/{id}")
    public ProductoResponse actualizarParcial(@PathVariable Long id,
                                              @Valid @RequestBody ProductoPatchRequest request) {
        return service.actualizarParcial(id, request);
    }

    // 7) Eliminar
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
