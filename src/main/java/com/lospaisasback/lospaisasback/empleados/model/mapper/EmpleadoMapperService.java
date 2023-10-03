package com.lospaisasback.lospaisasback.empleados.model.mapper;

import com.lospaisasback.lospaisasback.empleados.model.dto.EmpleadoDTO;
import com.lospaisasback.lospaisasback.empleados.model.entity.Empleado;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoMapperService {
    private final ModelMapper modelMapper;

    @Autowired
    public EmpleadoMapperService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public EmpleadoDTO toDTO(Empleado empleado) {
        return modelMapper.map(empleado, EmpleadoDTO.class);
    }

    public Empleado toEntity(EmpleadoDTO empleadoDTO) {
        return modelMapper.map(empleadoDTO, Empleado.class);
    }
}
