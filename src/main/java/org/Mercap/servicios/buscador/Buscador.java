package org.Mercap.servicios.buscador;

import org.Mercap.modelos.Producto;

import java.util.List;

public interface Buscador {

    public List<Producto> obtenerProductos(String argumento);
}
