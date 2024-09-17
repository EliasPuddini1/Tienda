package com.BesysoftSA.Tienda.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Entity
public class Producto {

    @Id
    @GeneratedValue
    private long id;
    private String codigo;
    private String nombre;
    private double precio;
    private Categoria categoria;
}
