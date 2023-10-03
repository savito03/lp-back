package com.lospaisasback.lospaisasback.inventario.controller;

import com.lospaisasback.lospaisasback.compartidos.model.dto.ResultadoDTO;
import com.lospaisasback.lospaisasback.inventario.model.dto.InventarioOutDTO;
import com.lospaisasback.lospaisasback.inventario.model.dto.ProductoDTO;
import com.lospaisasback.lospaisasback.inventario.service.IInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Inventario")
public class InventarioController {

    @Autowired
    private IInventarioService inventarioService;

    @GetMapping("/obtenerProductos")
    public InventarioOutDTO obtenerProductos() {
        return inventarioService.obtenerProductos();
    }

    @GetMapping("/obtenerProductosPorNombre")
    public InventarioOutDTO obtenerProductosPorNombre(@RequestParam(name = "id") Long id) {
        return inventarioService.obtenerProductoPorID(id);
    }

    @PostMapping("/guardarProducto")
    public ResultadoDTO guardarProducto(@RequestBody ProductoDTO productoDTO) {
        return inventarioService.guardarProducto(productoDTO);
    }

    @PostMapping("/actualizarProducto")
    public ResultadoDTO actualizarProducto(@RequestBody ProductoDTO productoDTO) {
        return inventarioService.actualizarProducto(productoDTO);
    }
}
