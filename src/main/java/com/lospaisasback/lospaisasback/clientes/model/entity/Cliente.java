package com.lospaisasback.lospaisasback.clientes.model.entity;

import com.lospaisasback.lospaisasback.compartidos.model.enums.SexoEnum;
import com.lospaisasback.lospaisasback.compartidos.model.enums.TipoIdentificacionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "LP_CLIENTE")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente{


    @Id
    @Column(name = "LPIDCLIENTE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LP_CLIENTE_SEQ")
    private Long idCliente;

    @Column(name = "LPTOTALCOMPRA")
    private BigDecimal totalCompra;

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
