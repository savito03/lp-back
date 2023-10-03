package com.lospaisasback.lospaisasback.empleados.model.dto;

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
public class EmpleadoOutDTO extends ResultadoDTO {

    private EmpleadoDTO empleadoDTO;
    private List<EmpleadoDTO> listaEmpleadoDTO;
    private Long totalEmpleados;

}
