package com.lospaisasback.lospaisasback.clientes.service;

import com.lospaisasback.lospaisasback.clientes.model.dto.ClienteDTO;
import com.lospaisasback.lospaisasback.clientes.model.dto.ClientesOutDTO;
import com.lospaisasback.lospaisasback.compartidos.model.dto.ResultadoDTO;

public interface IClienteService {

    ClientesOutDTO obtenerClientePorCedula(String cedula);

    ClientesOutDTO obtenerTodosLosClientes();

    ResultadoDTO guardarCliente(ClienteDTO clienteDTO);

    ResultadoDTO actualizarCliente(ClienteDTO clienteDTO);

}
