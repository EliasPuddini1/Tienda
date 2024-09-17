package com.BesysoftSA.Tienda.dominio;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class CoeficientesReconocimiento {
    private double hastaDosProductos;
    private double masDeDosProductos;
}
