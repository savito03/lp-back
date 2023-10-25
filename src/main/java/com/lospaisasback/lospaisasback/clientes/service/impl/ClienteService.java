package com.lospaisasback.lospaisasback.clientes.service.impl;

import com.lospaisasback.lospaisasback.clientes.model.dto.ClienteDTO;
import com.lospaisasback.lospaisasback.clientes.model.dto.ClientesOutDTO;
import com.lospaisasback.lospaisasback.clientes.model.entity.Cliente;
import com.lospaisasback.lospaisasback.clientes.model.mapper.ClienteMapperService;
import com.lospaisasback.lospaisasback.clientes.repository.IClienteRepository;
import com.lospaisasback.lospaisasback.clientes.service.IClienteService;
import com.lospaisasback.lospaisasback.compartidos.model.dto.ResultadoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService implements IClienteService {
    @Autowired
    private ClienteMapperService clienteMapperService;

    @Autowired
    private IClienteRepository clienteRepository;


    @Override
    public ClientesOutDTO obtenerClientePorCedula(String cedula) {
        ClientesOutDTO clientesOutDTO = new ClientesOutDTO();
        clientesOutDTO.setExitoso(Boolean.FALSE);

        if (cedula == null || cedula.isEmpty()) {
            clientesOutDTO.setMensaje("La cedula no puede ser nula o vacia");
            return clientesOutDTO;
        }

        Cliente cliente = clienteRepository.findByNumeroIdentificacion(cedula);

        if (cliente == null) {
            clientesOutDTO.setMensaje("No se encontro el cliente con la cedula: " + cedula);
            return clientesOutDTO;
        }

        ClienteDTO clienteDTO = clienteMapperService.toDTO(cliente);
        clientesOutDTO.setClienteDTO(clienteDTO);
        clientesOutDTO.setExitoso(Boolean.TRUE);

        return clientesOutDTO;
    }

    @Override
    public ClientesOutDTO obtenerTodosLosClientes() {
        ClientesOutDTO clientesOutDTO = new ClientesOutDTO();
        clientesOutDTO.setExitoso(Boolean.FALSE);

        List<Cliente> listCliente = clienteRepository.findAll();

        if (listCliente.isEmpty()) {
            clientesOutDTO.setMensaje("No se encontraron clientes");
            return clientesOutDTO;
        }

        List<ClienteDTO> listClienteDTO = listCliente.stream().map(clienteMapperService::toDTO).collect(Collectors.toList());

        clientesOutDTO.setListClienteDTO(listClienteDTO);
        clientesOutDTO.setTotalClientes((long) listClienteDTO.size());
        clientesOutDTO.setExitoso(Boolean.TRUE);
        clientesOutDTO.setMensaje("Se encontraron " + listClienteDTO.size() + " clientes");

        return clientesOutDTO;
    }

    @Override
    public ResultadoDTO guardarCliente(ClienteDTO clienteDTO) {
        ResultadoDTO resultadoDTO = new ResultadoDTO();
        resultadoDTO.setExitoso(Boolean.FALSE);

        if (clienteDTO == null) {
            resultadoDTO.setMensaje("El cliente no puede ser nulo");
            return resultadoDTO;
        }

        if (clienteDTO.getNumeroIdentificacion() == null || clienteDTO.getNumeroIdentificacion().isEmpty()) {
            resultadoDTO.setMensaje("La cedula no puede ser nula o vacia");
            return resultadoDTO;
        }

        Cliente clienteExistente = clienteRepository.findByNumeroIdentificacion(clienteDTO.getNumeroIdentificacion());

        if (clienteExistente != null) {
            resultadoDTO.setMensaje("Ya existe un cliente con la cedula: " + clienteDTO.getNumeroIdentificacion());
            return resultadoDTO;
        }

        StringBuilder nombreCompleto = new StringBuilder();

        nombreCompleto.append(clienteDTO.getNombre()).append(" ").append(clienteDTO.getApellido());
        if (clienteDTO.getSegundoApellido() != null && !clienteDTO.getSegundoApellido().isEmpty())
            nombreCompleto.append(" ").append(clienteDTO.getSegundoApellido());

        clienteDTO.setNombreCompleto(nombreCompleto.toString());

        Cliente cliente = clienteMapperService.toEntity(clienteDTO);

        try {
            clienteRepository.save(cliente);
        } catch (Exception e) {
            resultadoDTO.setMensaje("Error al guardar el cliente");
            return resultadoDTO;
        }

        resultadoDTO.setExitoso(Boolean.TRUE);
        resultadoDTO.setMensaje("Se guardo el cliente con exito");

        return resultadoDTO;
    }

    @Override
    public ResultadoDTO actualizarCliente(ClienteDTO clienteDTO) {
        ResultadoDTO resultadoDTO = new ResultadoDTO();
        resultadoDTO.setExitoso(Boolean.FALSE);

        if (clienteDTO == null) {
            resultadoDTO.setMensaje("El cliente no puede ser nulo");
            return resultadoDTO;
        }

        StringBuilder nombreCompleto = new StringBuilder();

        nombreCompleto.append(clienteDTO.getNombre()).append(" ").append(clienteDTO.getApellido());

        if (clienteDTO.getSegundoApellido() != null && !clienteDTO.getSegundoApellido().isEmpty()) {
            nombreCompleto.append(" ").append(clienteDTO.getSegundoApellido());
        }

        clienteDTO.setNombreCompleto(nombreCompleto.toString());

        Cliente cliente = clienteMapperService.toEntity(clienteDTO);

        try {
            clienteRepository.save(cliente);
        } catch (Exception e) {
            resultadoDTO.setMensaje("Error al actualizar el cliente");
            return resultadoDTO;
        }

        resultadoDTO.setExitoso(Boolean.TRUE);
        resultadoDTO.setMensaje("Se actualizo el cliente con exito");

        return resultadoDTO;
    }
}
