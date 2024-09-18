package com.BesysoftSA.Tienda.Servicios.menu.funcionalidades;

import com.BesysoftSA.Tienda.Servicios.comision.CalculadoraComision;
import com.BesysoftSA.Tienda.dominio.Vendedor;
import com.BesysoftSA.Tienda.repositorios.ProductoRepo;
import com.BesysoftSA.Tienda.repositorios.VendedorRepo;
import com.BesysoftSA.Tienda.repositorios.VentaRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class Comisiones {

    @Autowired
    private VendedorRepo vendedorRepo;
    @Autowired
    private CalculadoraComision calculadoraComision;

    public void calcularComisiones() {

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Ingrese el dni del vendedor. ");
            double dni = scanner.nextDouble();

            Vendedor vendedor = vendedorRepo.findBydni(dni);

            double comision = calculadoraComision.calcularComision(vendedor);

            System.out.println("Comision = " + comision);
            System.out.println("Calcular la comision de otro vendedor? 1.Si 2.No");

        } while (scanner.nextInt() ==1);
    }
}
