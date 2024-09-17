package org.Mercap;

import java.util.Scanner;

public class App
{


    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Registrar producto");
            System.out.println("2. Registrar vendedor");
            System.out.println("3. Registrar venta");
            System.out.println("4. Calcular comisiones");
            System.out.println("5. Buscar producto");
            System.out.println("6. Salir");

            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    // Lógica para agregar producto
                    break;
                case 2:
                    // Lógica para agregar vendedor
                    break;
                case 3:
                    // Lógica para registrar venta
                    break;
                case 4:
                    // Lógica para calcular comisiones
                    break;
                case 5:
                    // Lógica para buscar producto
                    break;
                case 6:
                    System.exit(0);

                default:
                    System.out.println(" Opcion no reconocida. ");
            }
        }

    }
}
