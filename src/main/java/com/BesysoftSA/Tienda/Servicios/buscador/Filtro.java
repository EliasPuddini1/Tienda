package com.BesysoftSA.Tienda.Servicios.buscador;

import com.BesysoftSA.Tienda.dominio.Producto;

import java.util.List;

public interface Filtro {
    public List<Producto> obtenerProductos(String argumento);
}
