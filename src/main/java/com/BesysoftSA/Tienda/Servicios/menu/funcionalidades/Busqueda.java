package com.BesysoftSA.Tienda.Servicios.menu.funcionalidades;

import com.BesysoftSA.Tienda.Servicios.buscador.FiltroContexto;
import com.BesysoftSA.Tienda.Servicios.buscador.implementaciones.FiltroCategoria;
import com.BesysoftSA.Tienda.Servicios.buscador.implementaciones.FiltroCodigo;
import com.BesysoftSA.Tienda.Servicios.buscador.implementaciones.FiltroNombre;
import com.BesysoftSA.Tienda.dto.ProductoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class Busqueda {

    private FiltroContexto filtroContexto = new FiltroContexto();
    @Autowired
    private FiltroCategoria filtroCategoria;
    @Autowired
    private FiltroNombre filtroNombre;
    @Autowired
    private FiltroCodigo filtroCodigo;

    public void buscarProducto() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Ingrese la opción de búsqueda.");
            System.out.println("1. Buscar por nombre.");
            System.out.println("2. Buscar por código.");
            System.out.println("3. Buscar por categoría.");
            System.out.println("4. Volver atrás.");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Introducir el nombre del producto: ");
                    String nombre = scanner.next();

                    // Cambiar el buscador a filtroNombre y buscar productos por nombre
                    filtroContexto.cambiarBuscador(filtroNombre);
                    List<ProductoDTO> productosPorNombre = filtroContexto.obtenerProductos(nombre);

                    // Mostrar productos en la consola
                    mostrarProductosEnConsola(productosPorNombre);
                    break;

                case 2:
                    System.out.println("Introducir el código del producto: ");
                    String codigo = scanner.next();

                    // Cambiar el buscador a filtroCodigo y buscar productos por código
                    filtroContexto.cambiarBuscador(filtroCodigo);
                    List<ProductoDTO> productosPorCodigo = filtroContexto.obtenerProductos(codigo);

                    // Mostrar productos en la consola
                    mostrarProductosEnConsola(productosPorCodigo);
                    break;

                case 3:
                    System.out.println("Introducir la categoría del producto: ");
                    String categoria = scanner.next();

                    // Cambiar el buscador a filtroCategoria y buscar productos por categoría
                    filtroContexto.cambiarBuscador(filtroCategoria);
                    List<ProductoDTO> productosPorCategoria = filtroContexto.obtenerProductos(categoria);

                    // Mostrar productos en la consola
                    mostrarProductosEnConsola(productosPorCategoria);
                    break;

                case 4:
                    System.out.println("Volviendo atrás...");
                    break;

                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
                    break;
            }

            if (opcion == 4) {
                break; // Salir del ciclo do-while
            }

        } while (true);
    }

    // Método para mostrar la lista de productos en la consola
    private void mostrarProductosEnConsola(List<ProductoDTO> productos) {
        if (productos.isEmpty()) {
            System.out.println("No se encontraron productos con ese parametro.");
        } else {
            System.out.println("Productos encontrados:");
            for (ProductoDTO producto : productos) {
                System.out.println("ID: " + producto.getId());
                System.out.println("Nombre: " + producto.getNombre());
                System.out.println("Código: " + producto.getCodigo());
                System.out.println("Categoría: " + producto.getCategoria().getNombre());
                System.out.println("Precio: " + producto.getPrecio());
                System.out.println("-----------------------------------");
            }
        }
        System.out.println("Presiona Enter para continuar...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
