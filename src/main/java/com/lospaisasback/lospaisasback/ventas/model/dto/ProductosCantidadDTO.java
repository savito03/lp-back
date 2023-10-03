package com.lospaisasback.lospaisasback.ventas.model.dto;

import com.lospaisasback.lospaisasback.inventario.model.dto.ProductoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductosCantidadDTO {

    private Long idProductoCantidad;
    private Long idVenta;
    private ProductoDTO productoDTO;
    private Integer cantidad;
}
