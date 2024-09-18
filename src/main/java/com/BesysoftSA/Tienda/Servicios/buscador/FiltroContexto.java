package com.BesysoftSA.Tienda.Servicios.buscador;

import com.BesysoftSA.Tienda.dominio.Producto;
import com.BesysoftSA.Tienda.dto.ProductoDTO;

import java.util.List;

public class FiltroContexto {

    private Filtro filtro;


    public List<ProductoDTO> obtenerProductos(String argumento){
        return filtro.obtenerProductos(argumento);
    }

    public void cambiarBuscador(Filtro filtro){
        this.filtro = filtro;
    }
}
