package org.Mercap.modelos;

import jdk.vm.ci.meta.Local;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Venta {

    private String codigo;
    private LocalDateTime fecha;
    private List<Producto> productos;
    private Vendedor vendedor;
    private double total;

    public Venta(){
        this.fecha = LocalDateTime.now();
    }
}
