package com.BesysoftSA.Tienda.dominio;

import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Entity
public class Categoria {
    @Id
    private long id;
    private String nombre;
}
