package com.BesysoftSA.Tienda.Servicios.buscador.implementaciones;

import com.BesysoftSA.Tienda.Servicios.buscador.Filtro;
import com.BesysoftSA.Tienda.dominio.Producto;
import com.BesysoftSA.Tienda.repositorios.ProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class FiltroCodigo implements Filtro {
    @Autowired
    ProductoRepo productoRepo;

    public List<Producto> obtenerProductos(String codigo){
        return productoRepo.findAll().stream().filter(producto -> producto.getCodigo().contains(codigo)) //filtro por codigo
                .collect(Collectors.toList());
    }
}
