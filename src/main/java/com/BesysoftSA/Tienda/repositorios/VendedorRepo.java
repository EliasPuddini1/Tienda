package com.BesysoftSA.Tienda.repositorios;

import com.BesysoftSA.Tienda.dominio.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VendedorRepo extends JpaRepository<Vendedor,Long> {
}
