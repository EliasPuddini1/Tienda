package com.BesysoftSA.Tienda.Servicios.menu.funcionalidades;

import com.BesysoftSA.Tienda.Servicios.generarCodigo.GeneradorCodigo;
import com.BesysoftSA.Tienda.dominio.Producto;
import com.BesysoftSA.Tienda.dominio.Vendedor;
import com.BesysoftSA.Tienda.dominio.Venta;
import com.BesysoftSA.Tienda.repositorios.ProductoRepo;
import com.BesysoftSA.Tienda.repositorios.VendedorRepo;
import com.BesysoftSA.Tienda.repositorios.VentaRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegistroVenta {

    @Autowired
    private VentaRepo ventaRepo;
    @Autowired
    private VendedorRepo vendedorRepo;
    @Autowired
    private ProductoRepo productoRepo;
    private GeneradorCodigo generadorCodigo;

    public void registrarVenta() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Registrar nueva venta:");

            // Registrar productos
            List<Producto> productos = new ArrayList<>();
            while (true) {
                System.out.print("Ingrese el código del producto (o 'fin' para terminar): ");
                String codigoProducto = scanner.nextLine().trim();
                if (codigoProducto.equalsIgnoreCase("fin")) {
                    break;
                }

                Producto producto = productoRepo.findAll().stream()
                        .filter(p -> p.getCodigo().equalsIgnoreCase(codigoProducto))
                        .findFirst()
                        .orElse(null);

                if (producto != null) {
                    productos.add(producto);
                } else {
                    System.out.println("Producto con código " + codigoProducto + " no encontrado.");
                }
            }

            if (productos.isEmpty()) {
                System.out.println("Debe ingresar al menos un producto para registrar una venta.");
                continue;
            }

            // Registrar vendedor
            Vendedor vendedor = null;
            while (vendedor == null) {
                System.out.print("Ingrese el código del vendedor: ");
                String codigoVendedor = scanner.nextLine().trim();

                vendedor = vendedorRepo.findAll().stream()
                        .filter(v -> v.getCodigo().equalsIgnoreCase(codigoVendedor))
                        .findFirst()
                        .orElse(null);

                if (vendedor == null) {
                    System.out.println("Vendedor con código " + codigoVendedor + " no encontrado.");
                }
            }

            // Calcular el total de la venta
            double total = productos.stream().mapToDouble(Producto::getPrecio).sum();

            // Generar el código de venta automáticamente basado en el último código de la base de datos
            String codigoVenta = generadorCodigo.generarCodigoVenta();

            // Crear un nuevo objeto Venta con los datos validados
            Venta nuevaVenta = new Venta();
            nuevaVenta.setCodigo(codigoVenta);
            nuevaVenta.setFecha(LocalDateTime.now());
            nuevaVenta.setProductos(productos);
            nuevaVenta.setVendedor(vendedor);
            nuevaVenta.setTotal(total);

            // Guardar la venta en la base de datos usando ventaRepo
            ventaRepo.save(nuevaVenta);

            System.out.println("Venta registrada con éxito: " + nuevaVenta.getCodigo() + " (Total: " + total + ")");

            System.out.print("¿Desea registrar otra venta? (Si/No): ");
            String continuar = scanner.nextLine().trim();
            if (!continuar.equalsIgnoreCase("Si")) {
                break;
            }
        }
    }

}
