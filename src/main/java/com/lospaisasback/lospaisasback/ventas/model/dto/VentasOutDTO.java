package com.lospaisasback.lospaisasback.ventas.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VentasOutDTO {

    private VentasDTO ventasDTO;
    private List<VentasDTO> listVentasDTO;
    private Long totalVentas;
}
