package com.BesysoftSA.Tienda.repositorios;

import com.BesysoftSA.Tienda.dominio.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductoRepo extends JpaRepository<Producto,Long> {
}
