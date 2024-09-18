package com.BesysoftSA.Tienda.Servicios.generarCodigo;

import com.BesysoftSA.Tienda.dominio.Producto;
import com.BesysoftSA.Tienda.repositorios.ProductoRepo;
import com.BesysoftSA.Tienda.repositorios.VendedorRepo;
import com.BesysoftSA.Tienda.repositorios.VentaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneradorCodigo {

    @Autowired
    ProductoRepo productoRepo;
    @Autowired
    VendedorRepo vendedorRepo;

    @Autowired
    VentaRepo ventaRepo;

    public String generarCodigoProducto() {
        List<String> codigos = productoRepo.findTopCodigo();  // Obtén la lista de códigos más altos

        if (codigos.isEmpty()) {
            return "PROD001";  // Código inicial si no hay productos
        }

        String ultimoCodigo = codigos.get(0);
        int numero = Integer.parseInt(ultimoCodigo.substring(4));  // Suponiendo que el código tiene el formato "PROD" + número

        // Generar códigos hasta encontrar uno único
        while (true) {
            String codigo = "PROD" + String.format("%03d", numero + 1);  // Genera el siguiente código

            // Verificar si el código ya existe en la base de datos
            boolean codigoExiste = !productoRepo.findByCodigo(codigo).isEmpty();

            if (!codigoExiste) {
                return codigo;  // Retorna el primer código único encontrado
            } else {
                numero++;  // Incrementa el número para probar el siguiente código
            }
        }
    }

    public String generarCodigoVendedor() {
        List<String> codigos = vendedorRepo.findTopCodigo();  // Asegúrate de que este método en VendedorRepo devuelva la lista de códigos

        if (codigos.isEmpty()) {
            return "VEN001";  // Código inicial si no hay vendedores
        }

        String ultimoCodigo = codigos.get(0);
        int numero = Integer.parseInt(ultimoCodigo.substring(3));  // Suponiendo que "VEN" + número

        while(true){
            String codigo = "VEN" + String.format("%03d", numero + 1);  // Genera el siguiente código
            boolean codigoExiste = !vendedorRepo.findByCodigo(codigo).isEmpty();

            if (!codigoExiste) {
                return codigo;  // Retorna el primer código único encontrado
            } else {
                numero++;  // Incrementa el número para probar el siguiente código
            }
        }

    }

    public String generarCodigoVenta() {
        List<String> codigos = ventaRepo.findTopCodigo(); // Asegúrate de que este método esté en el repositorio
        if (codigos.isEmpty()) {
            return "VENT001";  // Código inicial si no hay ventas
        }
        String ultimoCodigo = codigos.get(0);
        int numero = Integer.parseInt(ultimoCodigo.substring(3));

        while(true){
            String codigo = "VENT" + String.format("%03d", Integer.parseInt(ultimoCodigo.substring(4)) + 1);
            boolean codigoExiste = !ventaRepo.findByCodigo(codigo).isEmpty();

            if (!codigoExiste) {
                return codigo;  // Retorna el primer código único encontrado
            } else {
                numero++;  // Incrementa el número para probar el siguiente código
            }

        }
    }
}
