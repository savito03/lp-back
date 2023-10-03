package com.lospaisasback.lospaisasback.ventas.model.entity;

import com.lospaisasback.lospaisasback.inventario.model.dto.ProductoDTO;
import com.lospaisasback.lospaisasback.inventario.model.entity.Producto;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "LP_PRODUCTOS_CANTIDAD")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductosCantidad {

    @Id
    @Column(name = "LPIDPRODUCTOCANTIDAD")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LP_PRODUCTOS_CANTIDAD_SEQ")
    private Long idProductoCantidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LPIDVENTA")
    private Venta venta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LPIDPRODUCTO")
    private Producto producto;

    @Column(name = "LPCANTIDAD")
    private Integer cantidad;
}
