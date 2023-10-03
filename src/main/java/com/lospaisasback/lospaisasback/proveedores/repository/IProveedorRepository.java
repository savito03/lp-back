package com.lospaisasback.lospaisasback.proveedores.repository;

import com.lospaisasback.lospaisasback.empleados.model.entity.Empleado;
import com.lospaisasback.lospaisasback.proveedores.model.entity.Proveedor;
import jakarta.inject.Singleton;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Singleton
@Repository
public interface IProveedorRepository extends JpaRepository<Proveedor, Long> {

    Proveedor findByNumeroIdentificacion(String numeroIdentificacion);


}
