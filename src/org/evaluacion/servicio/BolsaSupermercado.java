package org.evaluacion.servicio;

import java.util.ArrayList;
import java.util.List;

public class BolsaSupermercado <T>{

    private List<T> productos;
    private int max = 5;

    public BolsaSupermercado(int max) {
        this.max = max;
        this.productos = new ArrayList<>();
    }

    public void addProducto(T producto) {
        if (productos.size() < max) {
            productos.add(producto);
        } else {
            throw new RuntimeException("Bolsa llena.");
        }
    }

    public List<T> getProductos() {
        return productos;
    }
}
