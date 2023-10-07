package com.lospaisasback.lospaisasback.ventas.service;

import com.lospaisasback.lospaisasback.compartidos.model.dto.ResultadoDTO;
import com.lospaisasback.lospaisasback.ventas.model.dto.VentaDTO;
import com.lospaisasback.lospaisasback.ventas.model.dto.VentasOutDTO;

public interface IVentasService {

    ResultadoDTO guardarVenta(VentaDTO ventaDTO);

    VentasOutDTO obtenerVentas();
}
