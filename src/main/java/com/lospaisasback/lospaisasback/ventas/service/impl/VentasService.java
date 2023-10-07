package com.lospaisasback.lospaisasback.ventas.service.impl;

import com.lospaisasback.lospaisasback.clientes.model.entity.Cliente;
import com.lospaisasback.lospaisasback.clientes.repository.IClienteRepository;
import com.lospaisasback.lospaisasback.compartidos.model.dto.ResultadoDTO;
import com.lospaisasback.lospaisasback.inventario.model.entity.Producto;
import com.lospaisasback.lospaisasback.inventario.repository.IProductoReposiory;
import com.lospaisasback.lospaisasback.ventas.model.dto.ProductosCantidadDTO;
import com.lospaisasback.lospaisasback.ventas.model.dto.VentaDTO;
import com.lospaisasback.lospaisasback.ventas.model.dto.VentasOutDTO;
import com.lospaisasback.lospaisasback.ventas.model.entity.ProductosCantidad;
import com.lospaisasback.lospaisasback.ventas.model.entity.Venta;
import com.lospaisasback.lospaisasback.ventas.model.mapper.ProductosCantidadMapperService;
import com.lospaisasback.lospaisasback.ventas.model.mapper.VentaMapperService;
import com.lospaisasback.lospaisasback.ventas.repository.IProductosCantidadRepository;
import com.lospaisasback.lospaisasback.ventas.repository.IVentasReposotory;
import com.lospaisasback.lospaisasback.ventas.service.IVentasService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VentasService implements IVentasService {

    @Autowired
    private IVentasReposotory ventasReposotory;

    @Autowired
    private VentaMapperService ventaMapperService;

    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private IProductoReposiory productoReposiory;

    @Autowired
    private IProductosCantidadRepository productosCantidadRepository;

    @Autowired
    private ProductosCantidadMapperService productosCantidadMapperService;

    @Override
    public ResultadoDTO guardarVenta(VentaDTO ventaDTO) {
        ResultadoDTO resultadoDTO = new ResultadoDTO();
        resultadoDTO.setExitoso(Boolean.FALSE);

        if (ventaDTO == null) {
            resultadoDTO.setMensaje("La venta no puede ser nula");
            return resultadoDTO;
        }

        for(ProductosCantidadDTO productosCantidadDTO : ventaDTO.getProductosCantidadDTO()){
            Producto producto = productoReposiory.findById(productosCantidadDTO.getProductoDTO().getIdProducto()).orElse(null);
            if(producto == null){
                resultadoDTO.setMensaje("El producto con id " + productosCantidadDTO.getProductoDTO().getIdProducto() + " no existe");
                return resultadoDTO;
            }

            if(producto.getCantidad() < productosCantidadDTO.getCantidad()){
                resultadoDTO.setMensaje("El producto con id " + productosCantidadDTO.getProductoDTO().getIdProducto() + " no tiene la cantidad suficiente");
                return resultadoDTO;
            }

            producto.setCantidad(producto.getCantidad() - productosCantidadDTO.getCantidad());
            productoReposiory.save(producto);


            Cliente cliente = clienteRepository.findById(ventaDTO.getCliente().getIdCliente()).orElse(null);
            if(cliente == null){
                resultadoDTO.setMensaje("El cliente con id " + ventaDTO.getCliente().getIdCliente() + " no existe");
                return resultadoDTO;
            }
        }
        try {
            Venta venta = ventaMapperService.toEntity(ventaDTO);
            venta = ventasReposotory.save(venta);

            Venta finalVenta = venta;
            ventaDTO.getProductosCantidadDTO().forEach(productoCantidadDTO -> {
                productoCantidadDTO.setIdVenta(finalVenta.getIdVenta());
                productosCantidadRepository.save(productosCantidadMapperService.toEntity(productoCantidadDTO));
            });
            resultadoDTO.setExitoso(Boolean.TRUE);
        } catch (Exception e) {
            resultadoDTO.setMensaje(e.getMessage());
        }

        resultadoDTO.setExitoso(Boolean.TRUE);
        resultadoDTO.setMensaje("Venta guardada correctamente");
        return resultadoDTO;
    }

    @Override
    public VentasOutDTO obtenerVentas() {
        VentasOutDTO ventasOutDTO = new VentasOutDTO();
        ventasOutDTO.setExitoso(Boolean.FALSE);

        List<Venta> listaVentas = ventasReposotory.findAll();

        if (listaVentas.isEmpty()) {
            ventasOutDTO.setMensaje("No hay ventas");
            return ventasOutDTO;
        }

        for (Venta venta : listaVentas) {
            Hibernate.initialize(venta.getCliente());
        }

        List<VentaDTO> listaVentasDTO = listaVentas.stream().map(ventaMapperService::toDTO).collect(Collectors.toList());

        listaVentasDTO.forEach(ventaDTO -> {
            List<ProductosCantidad> productosCantidad = productosCantidadRepository.findByVenta(ventaMapperService.toEntity(ventaDTO));
            ventaDTO.setProductosCantidadDTO(productosCantidad.stream().map(productosCantidadMapperService::toDTO).collect(Collectors.toList()));
        });

        ventasOutDTO.setListVentaDTO(listaVentasDTO);
        ventasOutDTO.setExitoso(Boolean.TRUE);
        return ventasOutDTO;
    }
}
