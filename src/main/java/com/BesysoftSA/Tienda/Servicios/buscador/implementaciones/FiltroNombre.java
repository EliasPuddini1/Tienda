package com.BesysoftSA.Tienda.Servicios.buscador.implementaciones;

import com.BesysoftSA.Tienda.Servicios.buscador.Filtro;
import com.BesysoftSA.Tienda.dominio.Producto;
import com.BesysoftSA.Tienda.repositorios.ProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class FiltroNombre implements Filtro {

    @Autowired
    ProductoRepo productoRepo;

    public List<Producto> obtenerProductos(String nombre){
        return productoRepo.findAll().stream().filter(producto -> producto.getNombre().contains(nombre))
                .collect(Collectors.toList());
    }
}
