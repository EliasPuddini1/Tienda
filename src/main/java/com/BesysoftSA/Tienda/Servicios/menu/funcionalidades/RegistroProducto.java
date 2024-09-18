package com.BesysoftSA.Tienda.Servicios.menu.funcionalidades;

import com.BesysoftSA.Tienda.Servicios.generarCodigo.GeneradorCodigo;
import com.BesysoftSA.Tienda.dominio.Categoria;
import com.BesysoftSA.Tienda.dominio.Producto;
import com.BesysoftSA.Tienda.repositorios.CategoriaRepo;
import com.BesysoftSA.Tienda.repositorios.ProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.Scanner;

@Service
public class RegistroProducto {

    @Autowired
    private ProductoRepo productoRepo;
    @Autowired
    private CategoriaRepo categoriaRepo;
    @Autowired
    private GeneradorCodigo generadorCodigo;

    public void registrarProducto() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Registrar nuevo producto:");

            String nombre;
            do {
                System.out.print("Ingrese el nombre del producto: ");
                nombre = scanner.nextLine().trim();
                if (nombre.isEmpty()) {
                    System.out.println("El nombre no puede estar vacío.");
                }
            } while (nombre.isEmpty());

            String categoriaSTR;
            Categoria categoria;

            do {
                System.out.print("Ingrese la categoría del producto: ");
                categoriaSTR = scanner.nextLine().trim();
                if (categoriaSTR.isEmpty()) {
                    System.out.println("La categoría no puede estar vacía.");
                }

                String finalCategoriaSTR = categoriaSTR;
                categoria = categoriaRepo.findAll().stream().filter(categoria1 -> categoria1.getNombre().equalsIgnoreCase(finalCategoriaSTR)).findFirst().orElse(null);

                if (categoria == null){
                    categoria = new Categoria();
                    categoria.setNombre(categoriaSTR);
                    categoriaRepo.save(categoria);
                }

            } while (categoriaSTR.isEmpty());

            double precio = -1;
            do {
                try {
                    System.out.print("Ingrese el precio del producto: ");
                    precio = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar el buffer
                    if (precio < 0) {
                        System.out.println("El precio debe ser un valor positivo.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Ingrese un valor numérico válido para el precio.");
                    scanner.nextLine(); // Limpiar el buffer
                }
            } while (precio < 0);

            // Generar el código de producto automáticamente basado en el último código de la base de datos
            String codigo = generadorCodigo.generarCodigoProducto();

            // Crear un nuevo objeto Producto con los datos validados
            Producto nuevoProducto = new Producto();
            nuevoProducto.setNombre(nombre);
            nuevoProducto.setCodigo(codigo);
            nuevoProducto.setCategoria(categoria);
            nuevoProducto.setPrecio(precio);

            // Guardar el producto en la base de datos usando productoRepo
            productoRepo.save(nuevoProducto);

            System.out.println("Producto registrado con éxito: " + nuevoProducto.getNombre() + " (Código: " + codigo + ")");


            System.out.print("¿Desea registrar otro producto? (Si/No): ");
            String continuar = scanner.nextLine().trim();
            if (!continuar.equalsIgnoreCase("Si")) {
                break;
            }
        }
    }



}
