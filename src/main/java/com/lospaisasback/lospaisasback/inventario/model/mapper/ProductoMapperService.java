package com.lospaisasback.lospaisasback.inventario.model.mapper;

import com.lospaisasback.lospaisasback.inventario.model.dto.ProductoDTO;
import com.lospaisasback.lospaisasback.inventario.model.entity.Producto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoMapperService {
    private final ModelMapper modelMapper;

    @Autowired
    public ProductoMapperService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProductoDTO toDTO(Producto producto) {
        return modelMapper.map(producto, ProductoDTO.class);
    }

    public Producto toEntity(ProductoDTO productoDTO) {
        return modelMapper.map(productoDTO, Producto.class);
    }
}
