package com.lospaisasback.lospaisasback.proveedores.controller;

import com.lospaisasback.lospaisasback.compartidos.model.dto.ResultadoDTO;
import com.lospaisasback.lospaisasback.proveedores.model.dto.ProveedorDTO;
import com.lospaisasback.lospaisasback.proveedores.model.dto.ProveedorOutDTO;
import com.lospaisasback.lospaisasback.proveedores.service.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("Proveedor")
public class ProveedorController {

    @Autowired
    private IProveedorService proveedorService;

    @GetMapping("/obtenerTodosLosProveedores")
    public ProveedorOutDTO obtenerTodosLosProveedores() {
        return proveedorService.obtenerTodosLosProveedores();
    }

    @GetMapping("/obtenerProveedorPorNit")
    public ProveedorOutDTO obtenerProveedorPorNit(@RequestParam(name = "nit") String nit) {
        return proveedorService.obtenerProveedorPorNit(nit);
    }

    @PostMapping("/guardarProveedor")
    public ResultadoDTO guardarProveedor(@RequestBody ProveedorDTO proveedorDTO) {
        return proveedorService.guardarProveedor(proveedorDTO);
    }

    @PostMapping("/actualizarProveedor")
    public ResultadoDTO actualizarProveedor(@RequestBody ProveedorDTO proveedorDTO) {
        return proveedorService.actualizarProveedor(proveedorDTO);
    }
}
