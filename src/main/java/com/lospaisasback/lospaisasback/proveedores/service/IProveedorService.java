package com.lospaisasback.lospaisasback.proveedores.service;

import com.lospaisasback.lospaisasback.compartidos.model.dto.ResultadoDTO;
import com.lospaisasback.lospaisasback.proveedores.model.dto.ProveedorDTO;
import com.lospaisasback.lospaisasback.proveedores.model.dto.ProveedorOutDTO;

public interface IProveedorService {

    ProveedorOutDTO obtenerProveedorPorNit(String nit);

    ProveedorOutDTO obtenerTodosLosProveedores();

    ResultadoDTO guardarProveedor(ProveedorDTO proveedorDTO);

    ResultadoDTO actualizarProveedor(ProveedorDTO proveedorDTO);
}
