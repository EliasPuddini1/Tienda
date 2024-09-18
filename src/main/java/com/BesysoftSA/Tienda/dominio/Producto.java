package com.BesysoftSA.Tienda.dominio;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String codigo;
    private String nombre;
    private double precio;
    @OneToOne
    private Categoria categoria;
}
