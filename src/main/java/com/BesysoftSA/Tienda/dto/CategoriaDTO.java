package com.BesysoftSA.Tienda.dto;

import com.BesysoftSA.Tienda.dominio.Categoria;
import lombok.Getter;

@Getter
public class CategoriaDTO {
    private Long id;
    private String nombre;

    public CategoriaDTO(Categoria categoria){
        this.id = categoria.getId();
        this.nombre = categoria.getNombre();
    }
}
