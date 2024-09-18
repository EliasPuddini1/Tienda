package com.BesysoftSA.Tienda.repositorios;

import com.BesysoftSA.Tienda.dominio.CoeficientesReconocimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CoeficientesReconocimientoRepo extends JpaRepository<CoeficientesReconocimiento,Long> {
}
