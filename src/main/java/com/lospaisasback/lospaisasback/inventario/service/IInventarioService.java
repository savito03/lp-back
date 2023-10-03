package com.lospaisasback.lospaisasback.inventario.service;

import com.lospaisasback.lospaisasback.compartidos.model.dto.ResultadoDTO;
import com.lospaisasback.lospaisasback.inventario.model.dto.InventarioOutDTO;
import com.lospaisasback.lospaisasback.inventario.model.dto.ProductoDTO;

public interface IInventarioService {

    InventarioOutDTO obtenerProductoPorID(Long id);

    InventarioOutDTO obtenerProductos();

    ResultadoDTO guardarProducto(ProductoDTO productoDTO);

    ResultadoDTO actualizarProducto(ProductoDTO productoDTO);
}
