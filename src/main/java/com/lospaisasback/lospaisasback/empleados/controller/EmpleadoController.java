package com.lospaisasback.lospaisasback.empleados.controller;

import com.lospaisasback.lospaisasback.compartidos.model.dto.ResultadoDTO;
import com.lospaisasback.lospaisasback.empleados.model.dto.EmpleadoDTO;
import com.lospaisasback.lospaisasback.empleados.model.dto.EmpleadoOutDTO;
import com.lospaisasback.lospaisasback.empleados.repository.IEmpleadoRepository;
import com.lospaisasback.lospaisasback.empleados.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Empleado")
public class EmpleadoController {

    @Autowired
    private IEmpleadoService empleadoService;


    @GetMapping("/obtenerTodosLosEmpleados")
    public EmpleadoOutDTO obtenerTodosLosEmpleados() {
        return empleadoService.obtenerTodosLosEmpleados();
    }

    @GetMapping("/obtenerEmpleadoPorCedula")
    public EmpleadoOutDTO obtenerEmpleadoPorCedula(@RequestParam(name = "cedula") String cedula) {
        return empleadoService.obtenerEmpleadoPorCedula(cedula);
    }

    @PostMapping("/guardarEmpleado")
    public ResultadoDTO guardarEmpleado(@RequestBody EmpleadoDTO empleadoDTO) {
        return empleadoService.guardarEmpleado(empleadoDTO);
    }

    @PostMapping("/actualizarEmpleado")
    public ResultadoDTO actualizarEmpleado(@RequestBody EmpleadoDTO empleadoDTO) {
        return empleadoService.actualizarEmpleado(empleadoDTO);
    }

}
