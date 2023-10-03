package com.lospaisasback.lospaisasback.empleados.model.entity;

import com.lospaisasback.lospaisasback.compartidos.model.enums.CargoEmpleadoEnum;
import com.lospaisasback.lospaisasback.compartidos.model.enums.EstadoEmpleadoEnum;
import com.lospaisasback.lospaisasback.compartidos.model.enums.SexoEnum;
import com.lospaisasback.lospaisasback.compartidos.model.enums.TipoIdentificacionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "LP_EMPLEADO")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Empleado{

    @Id
    @Column(name = "LPIDEMPLEADO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LP_EMPLEADO_SEQ")
    private Long idEmpleado;

    @Column(name = "LPCARGOEMPLEADO")
    @Enumerated(EnumType.STRING)
    private CargoEmpleadoEnum cargoEmpleadoEnum;

    @Column(name = "LPSALARIO")
    private BigDecimal salario;

    @Column(name = "LPFECHAINGRESO")
    private LocalDate fechaIngreso;
    @Column(name = "LPFECHARETIRO")
    private LocalDate fechaRetiro;

    @Column(name = "LPESTADOEMPLEADO")
    @Enumerated(EnumType.STRING)
    private EstadoEmpleadoEnum estadoEmpleadoEnum;

    @Column(name = "LPNOMBRE")
    private String nombre;

    @Column(name = "LPAPELLIDO")
    private String apellido;

    @Column(name = "LPSEGUNDOAPELLIDO")
    private String segundoApellido;

    @Column(name = "LPNOMBRECOMPLETO")
    private String nombreCompleto;

    @Column(name = "LPCORREO")
    private String correo;

    @Column(name = "LPTELEFONO")
    private String telefono;

    @Column(name = "LPTIPOIDENTIFICACION")
    @Enumerated(EnumType.STRING)
    private TipoIdentificacionEnum tipoIdentificacion;

    @Column(name = "LPNUMEROIDENTIFICACION")
    private String numeroIdentificacion;

    @Column(name = "LPDIRECCION")
    private String direccion;

    @Column(name = "LPSEXO")
    @Enumerated(EnumType.STRING)
    private SexoEnum sexo;
}
