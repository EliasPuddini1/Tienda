package com.BesysoftSA.Tienda.Servicios.menu;

import com.BesysoftSA.Tienda.Servicios.menu.funcionalidades.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Menu {

    @Autowired
    private Busqueda busqueda;
    @Autowired
    private Comisiones comisiones;
    @Autowired
    private RegistroVendedor registroVendedor;
    @Autowired
    private RegistroProducto registroProducto;
    @Autowired
    private RegistroVenta registroVenta;

    public void runMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Registrar producto");
            System.out.println("2. Registrar vendedor");
            System.out.println("3. Registrar venta");
            System.out.println("4. Calcular comisiones");
            System.out.println("5. Buscar producto por categoría");
            System.out.println("6. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            switch (opcion) {
                case 1:
                    registroProducto.registrarProducto();
                    break;
                case 2:
                    registroVendedor.registrarVendedor();
                    break;
                case 3:
                    registroVenta.registrarVenta();
                    break;
                case 4:
                    comisiones.calcularComisiones();
                    break;
                case 5:
                    busqueda.buscarProductoPorCategoria();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        }
    }
}
