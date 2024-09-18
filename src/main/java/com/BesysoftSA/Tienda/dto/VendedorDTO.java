package com.BesysoftSA.Tienda.dto;

import com.BesysoftSA.Tienda.dominio.Vendedor;
import lombok.Getter;

@Getter
public class VendedorDTO {

    private Long id;
    private String codigo;
    private String nombre;
    private String apellido;
    private double dni;

    public VendedorDTO(Vendedor vendedor){
        this.id = vendedor.getId();
        this.codigo = vendedor.getCodigo();
        this.nombre = vendedor.getNombre();
        this.apellido = vendedor.getApellido();
        this.dni = vendedor.getDni();
    }
}
