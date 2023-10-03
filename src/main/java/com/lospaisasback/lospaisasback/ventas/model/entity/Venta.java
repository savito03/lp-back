package com.lospaisasback.lospaisasback.ventas.model.entity;

import com.lospaisasback.lospaisasback.clientes.model.entity.Cliente;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "LP_VENTA")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Venta {

    @Id
    @Column(name = "LPIDVENTA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LP_VENTA_SEQ")
    private Long idVenta;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LPIDCLIENTE")
    private Cliente cliente;

    @Column(name = "LPFECHA")
    private LocalDate fecha;

    @Column(name = "LPTOTAL")
    private BigDecimal total;
}
