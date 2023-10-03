package com.lospaisasback.lospaisasback.clientes.model.mapper;

import com.lospaisasback.lospaisasback.clientes.model.dto.ClienteDTO;
import com.lospaisasback.lospaisasback.clientes.model.entity.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteMapperService {
    private final ModelMapper modelMapper;

    @Autowired
    public ClienteMapperService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ClienteDTO toDTO(Cliente cliente) {
        return modelMapper.map(cliente, ClienteDTO.class);
    }

    public Cliente toEntity(ClienteDTO clienteDTO) {
        return modelMapper.map(clienteDTO, Cliente.class);
    }
}
