package com.BesysoftSA.Tienda.repositorios;

import com.BesysoftSA.Tienda.dominio.Producto;
import com.BesysoftSA.Tienda.dominio.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface VentaRepo extends JpaRepository<Venta,Long> {
    @Query("SELECT v.codigo FROM Venta v ORDER BY v.codigo DESC")
    List<String> findTopCodigo();
    List<Venta> findByCodigo(String codigo);

    boolean existsByCodigo(String codigo);
}
