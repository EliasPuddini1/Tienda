package com.BesysoftSA.Tienda.Servicios.buscador.implementaciones;

import com.BesysoftSA.Tienda.Servicios.buscador.Filtro;
import com.BesysoftSA.Tienda.dto.ProductoDTO;
import com.BesysoftSA.Tienda.repositorios.ProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class FiltroCategoria implements Filtro {

    @Autowired
    ProductoRepo productoRepo;

    public List<ProductoDTO> obtenerProductos(String categoria) {
        return productoRepo.findAll().stream()
                .filter(producto -> producto.getCategoria() // obtengo la categoría del producto
                        .getNombre().equalsIgnoreCase(categoria)) // filtro por el nombre de la categoría (ignorando mayúsculas/minúsculas)
                .map(ProductoDTO::new) // convertir los productos a DTO
                .collect(Collectors.toList()); // los recolecto en una lista
    }

}
