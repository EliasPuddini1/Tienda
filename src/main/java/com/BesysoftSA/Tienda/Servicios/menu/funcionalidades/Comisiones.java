package com.BesysoftSA.Tienda.Servicios.menu.funcionalidades;

import com.BesysoftSA.Tienda.Servicios.comision.CalculadoraComision;
import com.BesysoftSA.Tienda.dominio.Vendedor;
import com.BesysoftSA.Tienda.repositorios.ProductoRepo;
import com.BesysoftSA.Tienda.repositorios.VendedorRepo;
import com.BesysoftSA.Tienda.repositorios.VentaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class Comisiones {

    @Autowired
    private VendedorRepo vendedorRepo;
    @Autowired
    private CalculadoraComision calculadoraComision;

    public void calcularComisiones() {

        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.println("Ingrese el dni del vendedor. ");
            double dni = scanner.nextDouble();

            double comision;
            Vendedor vendedor;

            vendedor = vendedorRepo.findBydni(dni);

            if(vendedor != null){
                comision = calculadoraComision.calcularComision(vendedor);
                System.out.println("Comision = " + comision);
            }else{
                System.out.println("No se ha encontrado al vendedor. Intente de nuevo");
            }

            System.out.println("Calcular la comision de otro vendedor? (Si/No)");
            input = scanner.next();
        } while (!input.equals("No"));
    }
}
