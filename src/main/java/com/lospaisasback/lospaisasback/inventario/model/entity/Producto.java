package com.lospaisasback.lospaisasback.inventario.model.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "LP_PRODUCTO")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @Column(name = "LPIDPRODUCTO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LP_PRODUCTO_SEQ")
    private Long idProducto;

    @Column(name = "LPNOMBRE")
    private String nombre;

    @Column(name = "LPDESCRIPCION")
    private String descripcion;

    @Column(name = "LPPRECIO")
    private BigDecimal precio;

    @Column(name = "LPCANTIDAD")
    private Integer cantidad;
}
