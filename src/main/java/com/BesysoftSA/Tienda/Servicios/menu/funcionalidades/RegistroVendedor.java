package com.BesysoftSA.Tienda.Servicios.menu.funcionalidades;

import com.BesysoftSA.Tienda.Servicios.generarCodigo.GeneradorCodigo;
import com.BesysoftSA.Tienda.dominio.Vendedor;
import com.BesysoftSA.Tienda.repositorios.VendedorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.Scanner;

@Service
public class RegistroVendedor {

    @Autowired
    private VendedorRepo vendedorRepo;
    @Autowired
    private GeneradorCodigo generadorCodigo;

    public void registrarVendedor() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Registrar nuevo vendedor:");

            String nombre;
            do {
                System.out.print("Ingrese el nombre del vendedor: ");
                nombre = scanner.nextLine().trim();
                if (nombre.isEmpty()) {
                    System.out.println("El nombre no puede estar vacío.");
                }
            } while (nombre.isEmpty());

            String apellido;
            do {
                System.out.print("Ingrese el apellido del vendedor: ");
                apellido = scanner.nextLine().trim();
                if (apellido.isEmpty()) {
                    System.out.println("El apellido no puede estar vacío.");
                }
            } while (apellido.isEmpty());

            double dni = -1;
            do {
                try {
                    System.out.print("Ingrese el DNI del vendedor: ");
                    dni = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar el buffer
                    if (dni <= 0) {
                        System.out.println("El DNI debe ser un valor positivo.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Ingrese un valor numérico válido para el DNI.");
                    scanner.nextLine(); // Limpiar el buffer
                }
            } while (dni <= 0);

            double sueldo = -1;
            do {
                try {
                    System.out.print("Ingrese el sueldo del vendedor: ");
                    sueldo = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar el buffer
                    if (sueldo <= 0) {
                        System.out.println("El DNI debe ser un valor positivo.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Ingrese un valor numérico válido para el DNI.");
                    scanner.nextLine(); // Limpiar el buffer
                }
            } while (sueldo <= 0);

            // Generar el código de vendedor automáticamente basado en el último código de la base de datos
            String codigo = generadorCodigo.generarCodigoVendedor(vendedorRepo);

            // Crear un nuevo objeto Vendedor con los datos validados
            Vendedor nuevoVendedor = new Vendedor();
            nuevoVendedor.setNombre(nombre);
            nuevoVendedor.setApellido(apellido);
            nuevoVendedor.setDni(dni);
            nuevoVendedor.setCodigo(codigo);
            nuevoVendedor.setSueldo(sueldo);

            // Guardar el vendedor en la base de datos usando vendedorRepo
            vendedorRepo.save(nuevoVendedor);

            System.out.println("Vendedor registrado con éxito: " + nuevoVendedor.getNombre() + " " + nuevoVendedor.getApellido() + " (Código: " + codigo + ")");

            System.out.print("¿Desea registrar otro vendedor? (Si/No): ");
            String continuar = scanner.nextLine().trim();
            if (!continuar.equalsIgnoreCase("Si")) {
                break;
            }
        }
    }
}
