package com.lospaisasback.lospaisasback.compartidos.model.entity;

import com.lospaisasback.lospaisasback.compartidos.model.enums.SexoEnum;
import com.lospaisasback.lospaisasback.compartidos.model.enums.TipoIdentificacionEnum;
import lombok.*;

import javax.persistence.*;

@MappedSuperclass
public class Persona {

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
