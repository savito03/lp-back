package com.lospaisasback.lospaisasback.ventas.model.dto;

import com.lospaisasback.lospaisasback.clientes.model.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VentasDTO {

    private Long idVenta;
    private Cliente cliente;
    private LocalDate fecha;
    private List<ProductosCantidadDTO> productosCantidadDTO;
    private BigDecimal total;


}
