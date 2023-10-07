package com.lospaisasback.lospaisasback.ventas.repository;

import com.lospaisasback.lospaisasback.ventas.model.entity.Venta;
import jakarta.inject.Singleton;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Singleton
@Repository
public interface IVentasReposotory extends JpaRepository<Venta, Long> {
}
