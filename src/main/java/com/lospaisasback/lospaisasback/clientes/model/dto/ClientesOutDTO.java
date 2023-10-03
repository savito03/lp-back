package com.lospaisasback.lospaisasback.clientes.model.dto;

import com.lospaisasback.lospaisasback.compartidos.model.dto.ResultadoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClientesOutDTO extends ResultadoDTO {

    private ClienteDTO clienteDTO;
    private List<ClienteDTO> listClienteDTO;
    private Long totalClientes;
}
