package com.BesysoftSA.Tienda.repositorios;

import com.BesysoftSA.Tienda.dominio.Producto;
import com.BesysoftSA.Tienda.dominio.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface VendedorRepo extends JpaRepository<Vendedor,Long> {

    @Query("SELECT v.codigo FROM Vendedor v ORDER BY v.id DESC")
    List<String> findTopCodigo();
    public default Vendedor findBydni(double dni) {
        return this.findAll().stream().filter(vendedor -> vendedor.getDni() == dni).findFirst().orElse(null);
    }
    List<Vendedor> findByCodigo(String codigo);
}
