package com.lospaisasback.lospaisasback.proveedores.model.dto;

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
public class ProveedorOutDTO extends ResultadoDTO {

    private ProveedorDTO proveedorDTO;
    private List<ProveedorDTO> listProveedorDTO;
    private Long totalProveedores;
}
