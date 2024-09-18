package com.BesysoftSA.Tienda.dominio;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private LocalDateTime fecha;
    @OneToMany
    private List<Producto> productos;
    @OneToOne
    private Vendedor vendedor;
    private double total;


    public Venta(){
        this.fecha = LocalDateTime.now();
    }

    public void setProductos(List<Producto> productos){
        this.productos = productos;
        this.total = productos.stream().mapToDouble(Producto::getPrecio).sum();
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
