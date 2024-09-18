package com.BesysoftSA.Tienda.repositorios;

import com.BesysoftSA.Tienda.dominio.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.awt.print.Pageable;
import java.util.List;

@RepositoryRestResource
public interface ProductoRepo extends JpaRepository<Producto,Long> {
    @Query("SELECT p.codigo FROM Producto p ORDER BY p.id DESC")
    List<String> findTopCodigo();

    List<Producto> findByCodigo(String codigo);
}
