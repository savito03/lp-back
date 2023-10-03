package com.lospaisasback.lospaisasback.empleados.service;

import com.lospaisasback.lospaisasback.compartidos.model.dto.ResultadoDTO;
import com.lospaisasback.lospaisasback.empleados.model.dto.EmpleadoDTO;
import com.lospaisasback.lospaisasback.empleados.model.dto.EmpleadoOutDTO;

public interface IEmpleadoService {

    EmpleadoOutDTO obtenerEmpleadoPorCedula(String cedula);

    EmpleadoOutDTO obtenerTodosLosEmpleados();

    ResultadoDTO guardarEmpleado(EmpleadoDTO empleadoDTO);

    ResultadoDTO actualizarEmpleado(EmpleadoDTO empleadoDTO);
}
