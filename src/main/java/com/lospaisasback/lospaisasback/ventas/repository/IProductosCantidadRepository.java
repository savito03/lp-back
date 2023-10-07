package com.lospaisasback.lospaisasback.ventas.repository;

import com.lospaisasback.lospaisasback.ventas.model.entity.ProductosCantidad;
import com.lospaisasback.lospaisasback.ventas.model.entity.Venta;
import jakarta.inject.Singleton;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Singleton
@Repository
public interface IProductosCantidadRepository extends JpaRepository<ProductosCantidad, Long> {

    //do an findByVentaId

    List<ProductosCantidad> findByVenta(Venta venta);
}
