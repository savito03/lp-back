package com.lospaisasback.lospaisasback.inventario.service.impl;

import com.lospaisasback.lospaisasback.compartidos.model.dto.ResultadoDTO;
import com.lospaisasback.lospaisasback.inventario.model.dto.InventarioOutDTO;
import com.lospaisasback.lospaisasback.inventario.model.entity.Producto;
import com.lospaisasback.lospaisasback.inventario.model.dto.ProductoDTO;
import com.lospaisasback.lospaisasback.inventario.model.mapper.ProductoMapperService;
import com.lospaisasback.lospaisasback.inventario.repository.IProductoReposiory;
import com.lospaisasback.lospaisasback.inventario.service.IInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventarioService implements IInventarioService {

    @Autowired
    private ProductoMapperService productoMapperService;

    @Autowired
    private IProductoReposiory productoReposiory;


    @Override
    public InventarioOutDTO obtenerProductoPorID(Long id) {
        InventarioOutDTO inventarioOutDTO = new InventarioOutDTO();
        inventarioOutDTO.setExitoso(Boolean.FALSE);

        if (id == null) {
            inventarioOutDTO.setMensaje("El id del producto es requerido");
            return inventarioOutDTO;
        }

        Producto producto = productoReposiory.findById(id).orElse(null);

        if (producto == null) {
            inventarioOutDTO.setMensaje("El producto no existe");
            return inventarioOutDTO;
        }

        inventarioOutDTO.setProductoDTO(productoMapperService.toDTO(producto));
        inventarioOutDTO.setExitoso(Boolean.TRUE);

        return inventarioOutDTO;
    }

    @Override
    public InventarioOutDTO obtenerProductos() {
        InventarioOutDTO inventarioOutDTO = new InventarioOutDTO();
        inventarioOutDTO.setExitoso(Boolean.FALSE);

        List<Producto> listaProductos = productoReposiory.findAll();

        if (listaProductos.isEmpty()) {
            inventarioOutDTO.setMensaje("No hay productos registrados");
            return inventarioOutDTO;
        }

        List<ProductoDTO> listaProductosDTO = listaProductos.stream().map(producto -> productoMapperService.toDTO(producto)).collect(Collectors.toList());

        inventarioOutDTO.setListProductoDTO(listaProductosDTO);
        inventarioOutDTO.setMensaje("Se encontraron " + listaProductosDTO.size() + " productos");
        inventarioOutDTO.setTotalProductos((long) listaProductosDTO.size());
        inventarioOutDTO.setExitoso(Boolean.TRUE);

        return inventarioOutDTO;
    }

    @Override
    public ResultadoDTO guardarProducto(ProductoDTO productoDTO) {
        ResultadoDTO resultadoDTO = new ResultadoDTO();
        resultadoDTO.setExitoso(Boolean.FALSE);

        if (productoDTO == null) {
            resultadoDTO.setMensaje("El producto es requerido");
            return resultadoDTO;
        }

        Producto producto = productoMapperService.toEntity(productoDTO);

        productoReposiory.save(producto);

        resultadoDTO.setMensaje("El producto se guardo correctamente");
        resultadoDTO.setExitoso(Boolean.TRUE);

        return resultadoDTO;
    }

    @Override
    public ResultadoDTO actualizarProducto(ProductoDTO productoDTO) {
        ResultadoDTO resultadoDTO = new ResultadoDTO();
        resultadoDTO.setExitoso(Boolean.FALSE);

        if (productoDTO == null) {
            resultadoDTO.setMensaje("El producto es requerido");
            return resultadoDTO;
        }

        Producto producto = productoMapperService.toEntity(productoDTO);

        try {
            productoReposiory.save(producto);
        } catch (Exception e) {
            resultadoDTO.setMensaje("El producto no se pudo actualizar");
            return resultadoDTO;
        }

        resultadoDTO.setMensaje("El producto se actualizo correctamente");
        resultadoDTO.setExitoso(Boolean.TRUE);

        return resultadoDTO;
    }
}
