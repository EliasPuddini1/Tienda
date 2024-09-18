package com.BesysoftSA.Tienda.dto;

import com.BesysoftSA.Tienda.dominio.Producto;
import com.BesysoftSA.Tienda.dominio.Vendedor;
import com.BesysoftSA.Tienda.dominio.Venta;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class VentaDTO {

    private Long id;
    private String codigo;
    private LocalDateTime fecha;
    private List<ProductoDTO> productos;
    private VendedorDTO vendedor;
    private double total;

    public VentaDTO(Venta venta){
        this.id = venta.getId();
        this.codigo = venta.getCodigo();
        this.fecha = venta.getFecha();
        this.productos = venta.getProductos()
                .stream()
                .map(ProductoDTO::new)
                .collect(Collectors.toList());
        this.vendedor = new VendedorDTO(venta.getVendedor());
        this.total = venta.getTotal();
    }
}
