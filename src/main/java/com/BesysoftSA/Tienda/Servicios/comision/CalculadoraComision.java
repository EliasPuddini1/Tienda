package com.BesysoftSA.Tienda.Servicios.comision;

import com.BesysoftSA.Tienda.dominio.CoeficientesReconocimiento;
import com.BesysoftSA.Tienda.dominio.Producto;
import com.BesysoftSA.Tienda.dominio.Vendedor;
import com.BesysoftSA.Tienda.dominio.Venta;
import com.BesysoftSA.Tienda.repositorios.VendedorRepo;
import com.BesysoftSA.Tienda.repositorios.VentaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service
public class CalculadoraComision {

    private CoeficientesReconocimiento coeficientes;
    @Autowired
    private VentaRepo ventaRepo;

    public double calcularComision(Vendedor vendedor){ //suposicion: las comisiones se calculan de forma mensual

        double id = vendedor.getId();
        List<Venta> ventas = ventaRepo.findAll().stream().filter(
                                venta -> venta.getVendedor().equals(vendedor) //filtro vendedor
                                        && venta.getFecha().isAfter(LocalDateTime.now().minusMonths(1))) //filtro mensual
                                .toList();


        List<Venta> ventasHDOS = ventas.stream().filter(venta -> venta.getProductos().stream().count() < 3).toList();// filtro cantidad de productos
        List<Venta> ventasMDOS = ventas.stream().filter(venta -> venta.getProductos().stream().count() > 2).toList();// filtro cantidad de productos

        double totalHDOS = ventasHDOS.stream()
                .mapToDouble(Venta::getTotal)
                .sum()
                * coeficientes.getHastaDosProductos();

        double totalMDOS = ventasMDOS.stream()
                .mapToDouble(Venta::getTotal)
                .sum()
                * coeficientes.getMasDeDosProductos();

        return totalMDOS + totalHDOS;
    }
}
