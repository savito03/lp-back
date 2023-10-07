package com.lospaisasback.lospaisasback.ventas.model.mapper;

import com.lospaisasback.lospaisasback.ventas.model.dto.ProductosCantidadDTO;
import com.lospaisasback.lospaisasback.ventas.model.entity.ProductosCantidad;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductosCantidadMapperService {

    private final ModelMapper modelMapper;

    @Autowired
    public ProductosCantidadMapperService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProductosCantidadDTO toDTO(ProductosCantidad productosCantidad) {
        return modelMapper.map(productosCantidad, ProductosCantidadDTO.class);
    }

    public ProductosCantidad toEntity(ProductosCantidadDTO productosCantidadDTO) {
        return modelMapper.map(productosCantidadDTO, ProductosCantidad.class);
    }
}
