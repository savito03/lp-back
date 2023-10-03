package com.lospaisasback.lospaisasback.ventas.model.mapper;

import com.lospaisasback.lospaisasback.ventas.model.dto.VentasDTO;
import com.lospaisasback.lospaisasback.ventas.model.entity.Venta;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaMapperService {

    private final ModelMapper modelMapper;

    @Autowired
    public VentaMapperService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public VentasDTO toDTO(Venta venta) {
        return modelMapper.map(venta, VentasDTO.class);
    }

    public Venta toEntity(VentasDTO ventaDTO) {
        return modelMapper.map(ventaDTO, Venta.class);
    }
}
