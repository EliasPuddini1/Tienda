package com.BesysoftSA.Tienda.dto;

import com.BesysoftSA.Tienda.dominio.CoeficientesReconocimiento;
import lombok.Getter;

@Getter
public class CoeficientesReconocimientoDTO {

    private Long id;
    private double hastaDosProductos;
    private double masDeDosProductos;

    public CoeficientesReconocimientoDTO(CoeficientesReconocimiento coeficientesReconocimiento){
        this.id = coeficientesReconocimiento.getId();
        this.hastaDosProductos = coeficientesReconocimiento.getHastaDosProductos();
        this.masDeDosProductos = coeficientesReconocimiento.getMasDeDosProductos();
    }
}
