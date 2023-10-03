package com.lospaisasback.lospaisasback.empleados.model.dto;

import com.lospaisasback.lospaisasback.compartidos.model.dto.PersonaDTO;
import com.lospaisasback.lospaisasback.compartidos.model.enums.CargoEmpleadoEnum;
import com.lospaisasback.lospaisasback.compartidos.model.enums.EstadoEmpleadoEnum;
import com.lospaisasback.lospaisasback.compartidos.model.enums.SexoEnum;
import com.lospaisasback.lospaisasback.compartidos.model.enums.TipoIdentificacionEnum;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpleadoDTO{

    private Long idEmpleado;
    private CargoEmpleadoEnum cargoEmpleadoEnum;
    private BigDecimal salario;
    private LocalDate fechaIngreso;
    private LocalDate fechaRetiro;
    private EstadoEmpleadoEnum estadoEmpleadoEnum;
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
