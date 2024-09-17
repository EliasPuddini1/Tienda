package com.BesysoftSA.Tienda.dominio;

import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Entity
public class Vendedor {
    @Id
    private long id;

    private String codigo;
    private String nombre;
    private String apellido;
    private double dni;
}
