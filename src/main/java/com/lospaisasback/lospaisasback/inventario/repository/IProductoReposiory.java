package com.lospaisasback.lospaisasback.inventario.repository;

import com.lospaisasback.lospaisasback.inventario.model.entity.Producto;
import jakarta.inject.Singleton;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Singleton
@Repository
public interface IProductoReposiory extends JpaRepository<Producto, Long> {
}
