package com.lospaisasback.lospaisasback.empleados.service.impl;

import com.lospaisasback.lospaisasback.compartidos.model.dto.ResultadoDTO;
import com.lospaisasback.lospaisasback.empleados.model.dto.EmpleadoDTO;
import com.lospaisasback.lospaisasback.empleados.model.dto.EmpleadoOutDTO;
import com.lospaisasback.lospaisasback.empleados.model.entity.Empleado;
import com.lospaisasback.lospaisasback.empleados.model.mapper.EmpleadoMapperService;
import com.lospaisasback.lospaisasback.empleados.repository.IEmpleadoRepository;
import com.lospaisasback.lospaisasback.empleados.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpleadoService implements IEmpleadoService {

    @Autowired
    private EmpleadoMapperService empleadoMapperService;
    @Autowired
    private IEmpleadoRepository empleadoRepository;

    @Override
    public EmpleadoOutDTO obtenerEmpleadoPorCedula(String cedula) {
        EmpleadoOutDTO empleadoOutDTO = new EmpleadoOutDTO();
        empleadoOutDTO.setExitoso(Boolean.FALSE);

        if (cedula == null || cedula.isEmpty()) {
            empleadoOutDTO.setMensaje("La cedula no puede ser vacia");
            return empleadoOutDTO;
        }

        Empleado empleado = empleadoRepository.findByNumeroIdentificacion(cedula);

        if (empleado == null) {
            empleadoOutDTO.setMensaje("No se encontro el empleado con la cedula: " + cedula);
            return empleadoOutDTO;
        }

        empleadoOutDTO.setEmpleadoDTO(empleadoMapperService.toDTO(empleado));
        empleadoOutDTO.setExitoso(Boolean.TRUE);

        return empleadoOutDTO;
    }

    @Override
    public EmpleadoOutDTO obtenerTodosLosEmpleados() {
        EmpleadoOutDTO empleadoOutDTO = new EmpleadoOutDTO();
        empleadoOutDTO.setExitoso(Boolean.FALSE);

        List<Empleado> listEmpleado = empleadoRepository.findAll();

        if (listEmpleado.isEmpty()) {
            empleadoOutDTO.setMensaje("No se encontraron empleados");
            return empleadoOutDTO;
        }

        List<EmpleadoDTO> listEmpleadoDTO = listEmpleado.stream().map(empleadoMapperService::toDTO).collect(Collectors.toList());

        empleadoOutDTO.setListaEmpleadoDTO(listEmpleadoDTO);
        empleadoOutDTO.setExitoso(Boolean.TRUE);
        empleadoOutDTO.setMensaje("Se encontraron " + listEmpleadoDTO.size() + " empleados");
        empleadoOutDTO.setTotalEmpleados((long) listEmpleadoDTO.size());

        return empleadoOutDTO;
    }

    @Override
    public ResultadoDTO guardarEmpleado(EmpleadoDTO empleadoDTO) {
        ResultadoDTO resultadoDTO = new ResultadoDTO();
        resultadoDTO.setExitoso(Boolean.FALSE);

        if (empleadoDTO == null) {
            resultadoDTO.setMensaje("El empleado no puede ser nulo");
            return resultadoDTO;
        }

        Empleado empleado = empleadoMapperService.toEntity(empleadoDTO);

        try {
            empleadoRepository.save(empleado);
        } catch (Exception e) {
            resultadoDTO.setMensaje("No se pudo guardar el empleado");
            return resultadoDTO;
        }

        resultadoDTO.setMensaje("Se guardo el empleado con exito");
        resultadoDTO.setExitoso(Boolean.TRUE);
        return resultadoDTO;
    }

    @Override
    public ResultadoDTO actualizarEmpleado(EmpleadoDTO empleadoDTO) {
        ResultadoDTO resultadoDTO = new ResultadoDTO();
        resultadoDTO.setExitoso(Boolean.FALSE);

        if (empleadoDTO == null) {
            resultadoDTO.setMensaje("El empleado no puede ser nulo");
            return resultadoDTO;
        }

        Empleado empleado = empleadoMapperService.toEntity(empleadoDTO);

        try {
            empleadoRepository.save(empleado);
        } catch (Exception e) {
            resultadoDTO.setMensaje("No se pudo actualizar el empleado");
            return resultadoDTO;
        }

        resultadoDTO.setMensaje("Se actualizo el empleado con exito");
        resultadoDTO.setExitoso(Boolean.TRUE);
        return resultadoDTO;
    }
}
