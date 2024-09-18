package com.BesysoftSA.Tienda.dominio;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private String nombre;
    private double precio;
    @OneToOne
    private Categoria categoria;
}
