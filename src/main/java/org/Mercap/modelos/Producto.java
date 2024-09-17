package org.Mercap.modelos;

import lombok.Data;

@Data
public class Producto {

    private String codigo;
    private String nombre;
    private double precio;
    private Categoria categoria;

}
