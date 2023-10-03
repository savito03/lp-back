package com.lospaisasback.lospaisasback.compartidos.model.dto;

import com.lospaisasback.lospaisasback.compartidos.model.enums.SexoEnum;
import com.lospaisasback.lospaisasback.compartidos.model.enums.TipoIdentificacionEnum;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDTO {

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
