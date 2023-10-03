package com.lospaisasback.lospaisasback.empleados.repository;

import com.lospaisasback.lospaisasback.empleados.model.entity.Empleado;
import jakarta.inject.Singleton;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Singleton
@Repository
public interface IEmpleadoRepository extends JpaRepository<Empleado, Long> {

        Empleado findByNumeroIdentificacion(String cedula);
}
