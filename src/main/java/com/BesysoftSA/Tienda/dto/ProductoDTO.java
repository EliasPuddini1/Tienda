package com.BesysoftSA.Tienda.dto;

import com.BesysoftSA.Tienda.dominio.Producto;
import jakarta.persistence.OneToOne;
import lombok.Getter;

@Getter
public class ProductoDTO {

    private Long id;
    private String codigo;
    private String nombre;
    private double precio;
    private CategoriaDTO categoria;

    public ProductoDTO(Producto producto){
        this.id = producto.getId();
        this.codigo = producto.getCodigo();
        this.nombre = producto.getNombre();
        this.precio = producto.getPrecio();
        this.categoria = new CategoriaDTO(producto.getCategoria());
    }
}
