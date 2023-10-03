package com.lospaisasback.lospaisasback.clientes.model.dto;


import com.lospaisasback.lospaisasback.compartidos.model.dto.PersonaDTO;
import com.lospaisasback.lospaisasback.compartidos.model.enums.SexoEnum;
import com.lospaisasback.lospaisasback.compartidos.model.enums.TipoIdentificacionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO extends PersonaDTO {

    private Long idCliente;
    private BigDecimal totalCompra;
    private String nombre;
    private String apellido;
    private String segundoApellido;
    private String nombreCompleto;
    private String correo;
    private String telefono;
    private TipoIdentificacionEnum tipoIdentificacion;
    private String numeroIdentificacion;
    private String direccion;
    private SexoEnum sexo;

}
