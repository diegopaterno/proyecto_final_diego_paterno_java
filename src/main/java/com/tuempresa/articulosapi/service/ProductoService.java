package com.tuempresa.articulosapi.service;

import com.tuempresa.articulosapi.dto.*;

import java.util.List;

public interface ProductoService {

    List<ProductoResponse> listar();

    ProductoResponse obtenerPorId(Long id);

    List<ProductoResponse> buscarPorNombre(String nombre);

    ProductoResponse crear(ProductoRequest request);

    ProductoResponse actualizar(Long id, ProductoRequest request);

    ProductoResponse actualizarParcial(Long id, ProductoPatchRequest request);

    void eliminar(Long id);
}
