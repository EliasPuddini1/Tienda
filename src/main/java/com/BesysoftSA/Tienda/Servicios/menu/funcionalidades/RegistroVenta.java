package com.BesysoftSA.Tienda.Servicios.menu.funcionalidades;

import com.BesysoftSA.Tienda.Servicios.generarCodigo.GeneradorCodigo;
import com.BesysoftSA.Tienda.dominio.Producto;
import com.BesysoftSA.Tienda.dominio.Vendedor;
import com.BesysoftSA.Tienda.dominio.Venta;
import com.BesysoftSA.Tienda.repositorios.ProductoRepo;
import com.BesysoftSA.Tienda.repositorios.VendedorRepo;
import com.BesysoftSA.Tienda.repositorios.VentaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class RegistroVenta {

    @Autowired
    private VentaRepo ventaRepo;
    @Autowired
    private VendedorRepo vendedorRepo;
    @Autowired
    private ProductoRepo productoRepo;
    @Autowired
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
                    System.out.println("Producto encontrado: " + producto.getNombre() + " - Precio: " + producto.getPrecio());
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
            String codigoVenta = generadorCodigo.generarCodigoVenta(ventaRepo);

            // Crear un nuevo objeto Venta con los datos validados
            Venta nuevaVenta = new Venta();
            nuevaVenta.setCodigo(codigoVenta);
            nuevaVenta.setFecha(LocalDateTime.now());
            nuevaVenta.setProductos(productos);
            nuevaVenta.setVendedor(vendedor);
            nuevaVenta.setTotal(total);

            boolean error=false;
            // Guardar la venta en la base de datos usando ventaRepo
            try {
                ventaRepo.save(nuevaVenta);
            } catch (DataIntegrityViolationException e) {
                // Manejar la excepción, tal vez con un mensaje de error o registro
                System.out.println("Error: no pudo registrarse la venta.");
                error = true;
            }
            if (!error) {
                // Mostrar detalles de la venta
                System.out.println("Venta registrada con éxito:");
                System.out.println("Código de venta: " + nuevaVenta.getCodigo());
                System.out.println("Fecha: " + nuevaVenta.getFecha());
                System.out.println("Vendedor: " + vendedor.getNombre() + " " + vendedor.getApellido());
                System.out.println("Total: " + nuevaVenta.getTotal());
                System.out.println("Productos:");

                // Mostrar detalles de los productos en la venta
                for (Producto p : nuevaVenta.getProductos()) {
                    System.out.println(" - " + p.getNombre() + " - Precio: " + p.getPrecio());
                }
            }

            System.out.print("¿Desea registrar otra venta? (Si/No): ");
            String continuar = scanner.nextLine().trim();
            if (!continuar.equalsIgnoreCase("Si")) {
                break;
            }
        }
    }

}
