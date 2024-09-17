package com.BesysoftSA.Tienda.repositorios;

import com.BesysoftSA.Tienda.dominio.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VentaRepo extends JpaRepository<Venta,Long> {
}
