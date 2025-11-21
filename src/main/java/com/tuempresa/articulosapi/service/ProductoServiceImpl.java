package com.tuempresa.articulosapi.service;

import com.tuempresa.articulosapi.dto.*;
import com.tuempresa.articulosapi.entity.Producto;
import com.tuempresa.articulosapi.exception.ResourceNotFoundException;
import com.tuempresa.articulosapi.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository repo;

    @Override
    public List<ProductoResponse> listar() {
        return repo.findAll().stream().map(this::toResponse).toList();
    }

    @Override
    public ProductoResponse obtenerPorId(Long id) {
        Producto p = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con id: " + id));
        return toResponse(p);
    }

    @Override
    public List<ProductoResponse> buscarPorNombre(String nombre) {
        return repo.findByNombreContainingIgnoreCase(nombre)
                   .stream().map(this::toResponse).toList();
    }

    @Override
    public ProductoResponse crear(ProductoRequest r) {
        Producto p = Producto.builder()
                .nombre(r.nombre())
                .descripcion(r.descripcion())
                .precio(r.precio())
                .categoria(r.categoria())
                .imagenUrl(r.imagenUrl())
                .stock(r.stock())
                .build();

        return toResponse(repo.save(p));
    }

    @Override
    public ProductoResponse actualizar(Long id, ProductoRequest r) {
        Producto p = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con id: " + id));

        p.setNombre(r.nombre());
        p.setDescripcion(r.descripcion());
        p.setPrecio(r.precio());
        p.setCategoria(r.categoria());
        p.setImagenUrl(r.imagenUrl());
        p.setStock(r.stock());

        return toResponse(repo.save(p));
    }

    @Override
    public ProductoResponse actualizarParcial(Long id, ProductoPatchRequest r) {
        Producto p = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con id: " + id));

        if (r.precio() != null) p.setPrecio(r.precio());
        if (r.stock() != null) p.setStock(r.stock());

        return toResponse(repo.save(p));
    }

    @Override
    public void eliminar(Long id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Producto no encontrado con id: " + id);
        }
        repo.deleteById(id);
    }

    private ProductoResponse toResponse(Producto p) {
        return new ProductoResponse(
                p.getId(),
                p.getNombre(),
                p.getDescripcion(),
                p.getPrecio(),
                p.getCategoria(),
                p.getImagenUrl(),
                p.getStock()
        );
    }
}
