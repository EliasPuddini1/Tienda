package com.BesysoftSA.Tienda.Servicios.buscador;

import com.BesysoftSA.Tienda.dominio.Producto;
import com.BesysoftSA.Tienda.dto.ProductoDTO;

import java.util.List;

public interface Filtro {
    public List<ProductoDTO> obtenerProductos(String argumento);
}
