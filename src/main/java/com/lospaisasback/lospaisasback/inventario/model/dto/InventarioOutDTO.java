package com.lospaisasback.lospaisasback.inventario.model.dto;

import com.lospaisasback.lospaisasback.compartidos.model.dto.ResultadoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InventarioOutDTO extends ResultadoDTO {

    private ProductoDTO productoDTO;
    private List<ProductoDTO> listProductoDTO;
    private Long totalProductos;
}
