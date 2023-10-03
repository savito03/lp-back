package com.lospaisasback.lospaisasback.clientes.repository;

import com.lospaisasback.lospaisasback.clientes.model.entity.Cliente;
import jakarta.inject.Singleton;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Singleton
@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByNumeroIdentificacion(String numeroIdentificacion);

}
