package com.BesysoftSA.Tienda.Servicios.buscador.implementaciones;

import com.BesysoftSA.Tienda.Servicios.buscador.Filtro;
import com.BesysoftSA.Tienda.dominio.Producto;
import com.BesysoftSA.Tienda.repositorios.ProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class FiltroCategoria implements Filtro {

    @Autowired
    ProductoRepo productoRepo;

    public List<Producto> obtenerProductos(String categoria){
        return productoRepo.findAll().stream().filter(producto -> producto.getCategoria() //obtengo categoria
                        .getNombre().contains(categoria)) //filtro por su nombre
                .collect(Collectors.toList()); //lo guardo en lista
    }
}
