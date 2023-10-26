package com.lospaisasback.lospaisasback.proveedores.service.impl;

import com.lospaisasback.lospaisasback.compartidos.model.dto.ResultadoDTO;
import com.lospaisasback.lospaisasback.proveedores.model.dto.ProveedorDTO;
import com.lospaisasback.lospaisasback.proveedores.model.dto.ProveedorOutDTO;
import com.lospaisasback.lospaisasback.proveedores.model.entity.Proveedor;
import com.lospaisasback.lospaisasback.proveedores.model.mapper.ProveedorMapperService;
import com.lospaisasback.lospaisasback.proveedores.repository.IProveedorRepository;
import com.lospaisasback.lospaisasback.proveedores.service.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProveedorService implements IProveedorService {

    @Autowired
    private ProveedorMapperService proveedorMapperService;

    @Autowired
    private IProveedorRepository proveedorRepository;


    @Override
    public ProveedorOutDTO obtenerProveedorPorNit(String nit) {
        ProveedorOutDTO proveedorOutDTO = new ProveedorOutDTO();
        proveedorOutDTO.setExitoso(Boolean.FALSE);

        if (nit == null || nit.isEmpty()) {
            proveedorOutDTO.setMensaje("El nit no puede ser nulo o vacio");
            return proveedorOutDTO;
        }

        Proveedor proveedor = proveedorRepository.findByNumeroIdentificacion(nit);

        if (proveedor == null) {
            proveedorOutDTO.setMensaje("No se encontro el proveedor con el nit: " + nit);
            return proveedorOutDTO;
        }

        proveedorOutDTO.setProveedorDTO(proveedorMapperService.toDTO(proveedor));
        proveedorOutDTO.setExitoso(Boolean.TRUE);

        return proveedorOutDTO;
    }

    @Override
    public ProveedorOutDTO obtenerTodosLosProveedores() {
        ProveedorOutDTO proveedorOutDTO = new ProveedorOutDTO();
        proveedorOutDTO.setExitoso(Boolean.FALSE);

        List<Proveedor> listProveedor = proveedorRepository.findAll();

        if (listProveedor.isEmpty()) {
            proveedorOutDTO.setMensaje("No se encontraron proveedores");
            return proveedorOutDTO;
        }

        List<ProveedorDTO> listProveedorDTO = listProveedor.stream().map(proveedorMapperService::toDTO).collect(Collectors.toList());

        proveedorOutDTO.setListProveedorDTO(listProveedorDTO);
        proveedorOutDTO.setTotalProveedores((long) listProveedorDTO.size());
        proveedorOutDTO.setMensaje("Se encontraron " + listProveedorDTO.size() + " proveedores");
        proveedorOutDTO.setExitoso(Boolean.TRUE);

        return proveedorOutDTO;
    }

    @Override
    public ResultadoDTO guardarProveedor(ProveedorDTO proveedorDTO) {
        ResultadoDTO resultadoDTO = new ResultadoDTO();
        resultadoDTO.setExitoso(Boolean.FALSE);

        if (proveedorDTO == null) {
            resultadoDTO.setMensaje("El proveedor no puede ser nulo");
            return resultadoDTO;
        }

        Proveedor proveedorEx    istente = proveedorRepository.findByNumeroIdentificacion(proveedorDTO.getNumeroIdentificacion());

        if (proveedorExistente != null) {
            resultadoDTO.setMensaje("Ya existe un proveedor con el nit: " + proveedorDTO.getNumeroIdentificacion());
            return resultadoDTO;
        }

        StringBuilder nombreCompleto = new StringBuilder();
        nombreCompleto.append(proveedorDTO.getNombre()).append(" ").append(proveedorDTO.getApellido());
        if (proveedorDTO.getSegundoApellido() != null && !proveedorDTO.getSegundoApellido().isEmpty()) {
            nombreCompleto.append(" ").append(proveedorDTO.getSegundoApellido());
        }
        proveedorDTO.setNombreCompleto(nombreCompleto.toString());

        Proveedor proveedor = proveedorMapperService.toEntity(proveedorDTO);

        try {
            proveedorRepository.save(proveedor);
        } catch (Exception e) {
            resultadoDTO.setMensaje("No se pudo guardar el proveedor");
            return resultadoDTO;
        }

        resultadoDTO.setMensaje("Se guardo el proveedor con exito");
        resultadoDTO.setExitoso(Boolean.TRUE);

        return resultadoDTO;
    }

    @Override
    public ResultadoDTO actualizarProveedor(ProveedorDTO proveedorDTO) {
        ResultadoDTO resultadoDTO = new ResultadoDTO();
        resultadoDTO.setExitoso(Boolean.FALSE);

        if (proveedorDTO == null) {
            resultadoDTO.setMensaje("El proveedor no puede ser nulo");
            return resultadoDTO;
        }

        StringBuilder nombreCompleto = new StringBuilder();
        nombreCompleto.append(proveedorDTO.getNombre()).append(" ").append(proveedorDTO.getApellido());

        if (proveedorDTO.getSegundoApellido() != null && !proveedorDTO.getSegundoApellido().isEmpty()) {
            nombreCompleto.append(" ").append(proveedorDTO.getSegundoApellido());
        }

        proveedorDTO.setNombreCompleto(nombreCompleto.toString());

        Proveedor proveedor = proveedorMapperService.toEntity(proveedorDTO);

        try {
            proveedorRepository.save(proveedor);
        } catch (Exception e) {
            resultadoDTO.setMensaje("No se pudo actualizar el proveedor");
            return resultadoDTO;
        }

        resultadoDTO.setMensaje("Se actualizo el proveedor con exito");
        resultadoDTO.setExitoso(Boolean.TRUE);
        return resultadoDTO;
    }
}
