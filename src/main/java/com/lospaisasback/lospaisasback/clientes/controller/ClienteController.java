package com.lospaisasback.lospaisasback.clientes.controller;

import com.lospaisasback.lospaisasback.clientes.model.dto.ClienteDTO;
import com.lospaisasback.lospaisasback.clientes.model.dto.ClientesOutDTO;
import com.lospaisasback.lospaisasback.clientes.service.IClienteService;
import com.lospaisasback.lospaisasback.compartidos.model.dto.ResultadoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Cliente")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/obtenerClientePorCedula")
    public ClientesOutDTO obtenerClientePorCedula(String cedula) {
        return clienteService.obtenerClientePorCedula(cedula);
    }

    @GetMapping("/obtenerTodosLosClientes")
    public ClientesOutDTO
    obtenerTodosLosClientes() {
        return clienteService.obtenerTodosLosClientes();
    }

    @PostMapping("/guardarCliente")
    public ResultadoDTO guardarCliente(@RequestBody ClienteDTO clienteDTO) {
        return clienteService.guardarCliente(clienteDTO);
    }

    @PostMapping("/actualizarCliente")
    public ResultadoDTO
    actualizarCliente(@RequestBody ClienteDTO clienteDTO) {
        return clienteService.actualizarCliente(clienteDTO);
    }


}
