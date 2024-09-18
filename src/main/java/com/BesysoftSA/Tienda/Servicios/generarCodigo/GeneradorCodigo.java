package com.BesysoftSA.Tienda.Servicios.generarCodigo;

import com.BesysoftSA.Tienda.dominio.Producto;
import com.BesysoftSA.Tienda.repositorios.ProductoRepo;
import com.BesysoftSA.Tienda.repositorios.VendedorRepo;
import com.BesysoftSA.Tienda.repositorios.VentaRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class GeneradorCodigo {

    @Autowired
    ProductoRepo productoRepo;
    @Autowired
    VendedorRepo vendedorRepo;

    @Autowired
    VentaRepo ventaRepo;

    public String generarCodigoVendedor() {
        // Obtener el último producto registrado
        Producto ultimoProducto = vendedorRepo.findTopByOrderByIdDesc(); // Método que obtiene el último producto según su ID
        if (ultimoProducto != null) {
            // Extraer el número del último código y aumentarlo en 1
            String ultimoCodigo = ultimoProducto.getCodigo();
            int numero = Integer.parseInt(ultimoCodigo.replaceAll("[^0-9]", "")); // Extraer el número del código
            numero++; // Incrementar el número
            return "P" + String.format("%05d", numero); // Generar el nuevo código (ejemplo: P00001)
        } else {
            // Si no hay productos, comenzar con el primer código
            return "V00001";
        }
    }

    public String generarCodigoProducto() {
        // Obtener el último producto registrado
        Producto ultimoProducto = productoRepo.findTopByOrderByIdDesc(); // Método que obtiene el último producto según su ID
        if (ultimoProducto != null) {
            // Extraer el número del último código y aumentarlo en 1
            String ultimoCodigo = ultimoProducto.getCodigo();
            int numero = Integer.parseInt(ultimoCodigo.replaceAll("[^0-9]", "")); // Extraer el número del código
            numero++; // Incrementar el número
            return "P" + String.format("%05d", numero); // Generar el nuevo código (ejemplo: P00001)
        } else {
            // Si no hay productos, comenzar con el primer código
            return "P00001";
        }
    }

    public String generarCodigoVenta() {
        // Obtener el último producto registrado
        Producto ultimoProducto = ventaRepo.findTopByOrderByIdDesc(); // Método que obtiene el último producto según su ID
        if (ultimoProducto != null) {
            // Extraer el número del último código y aumentarlo en 1
            String ultimoCodigo = ultimoProducto.getCodigo();
            int numero = Integer.parseInt(ultimoCodigo.replaceAll("[^0-9]", "")); // Extraer el número del código
            numero++; // Incrementar el número
            return "P" + String.format("%05d", numero); // Generar el nuevo código (ejemplo: P00001)
        } else {
            // Si no hay productos, comenzar con el primer código
            return "V00001";
        }
    }
}
