package com.BesysoftSA.Tienda.repositorios;

import com.BesysoftSA.Tienda.dominio.Producto;
import com.BesysoftSA.Tienda.dominio.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VendedorRepo extends JpaRepository<Vendedor,Long> {

    Producto findTopByOrderByIdDesc();
    public default Vendedor findBydni(double dni) {
        return this.findAll().stream().filter(vendedor -> vendedor.getDni() == dni).findFirst().orElse(null);
    }
}
