package com.BesysoftSA.Tienda.dominio;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Data
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(unique = true)
    private String codigo;
    private String nombre;
    private double precio;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    @ManyToMany(mappedBy = "productos")  // Esto indica que la relación se gestiona en la clase Venta
    private List<Venta> ventas;
}
