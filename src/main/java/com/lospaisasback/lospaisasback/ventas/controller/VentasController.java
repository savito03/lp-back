package com.lospaisasback.lospaisasback.ventas.controller;

import com.lospaisasback.lospaisasback.compartidos.model.dto.ResultadoDTO;
import com.lospaisasback.lospaisasback.ventas.model.dto.VentaDTO;
import com.lospaisasback.lospaisasback.ventas.model.dto.VentasOutDTO;
import com.lospaisasback.lospaisasback.ventas.service.IVentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ventas")
public class VentasController {

    @Autowired
    private IVentasService ventasService;

    @PostMapping("/guardarVenta")
    public ResultadoDTO guardarVentas(@RequestBody VentaDTO ventaDTO) {
        return ventasService.guardarVenta(ventaDTO);
    }

    @GetMapping("/obtenerVentas")
    public VentasOutDTO obtenerVentas() {
        return ventasService.obtenerVentas();
    }
}
