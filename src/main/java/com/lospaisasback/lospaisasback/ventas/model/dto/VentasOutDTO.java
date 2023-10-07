package com.lospaisasback.lospaisasback.ventas.model.dto;

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
public class VentasOutDTO extends ResultadoDTO {

    private VentaDTO ventaDTO;
    private List<VentaDTO> listVentaDTO;
    private Long totalVentas;
}
