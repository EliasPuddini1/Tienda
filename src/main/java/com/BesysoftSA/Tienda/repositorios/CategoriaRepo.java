package com.BesysoftSA.Tienda.repositorios;

import com.BesysoftSA.Tienda.dominio.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CategoriaRepo extends JpaRepository<Categoria,Long>{
}
