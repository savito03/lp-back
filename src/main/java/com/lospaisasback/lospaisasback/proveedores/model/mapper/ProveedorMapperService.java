package com.lospaisasback.lospaisasback.proveedores.model.mapper;

import com.lospaisasback.lospaisasback.inventario.model.dto.ProductoDTO;
import com.lospaisasback.lospaisasback.inventario.model.entity.Producto;
import com.lospaisasback.lospaisasback.proveedores.model.dto.ProveedorDTO;
import com.lospaisasback.lospaisasback.proveedores.model.entity.Proveedor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProveedorMapperService {

    private final ModelMapper modelMapper;

    @Autowired
    public ProveedorMapperService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProveedorDTO toDTO(Proveedor proveedor) {
        return modelMapper.map(proveedor, ProveedorDTO.class);
    }

    public Proveedor toEntity(ProveedorDTO proveedorDTO) {
        return modelMapper.map(proveedorDTO, Proveedor.class);
    }

}
