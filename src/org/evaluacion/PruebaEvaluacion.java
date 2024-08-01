package org.evaluacion;

import org.evaluacion.modelo.*;
import org.evaluacion.servicio.BolsaSupermercado;

public class PruebaEvaluacion {

    public static void main(String[] args) {
        // Crear bolsas para cada tipo de producto
        BolsaSupermercado<Lacteo> bolsaLacteos = new BolsaSupermercado<>(5);
        BolsaSupermercado<Fruta> bolsaFrutas = new BolsaSupermercado<>(5);
        BolsaSupermercado<Limpieza> bolsaLimpieza = new BolsaSupermercado<>(5);
        BolsaSupermercado<NoPerecible> bolsaNoPerecibles = new BolsaSupermercado<>(5);

        // Agregar productos a las bolsas
        bolsaLacteos.addProducto(new Lacteo("Leche", 1.50, 2, 8));
        bolsaLacteos.addProducto(new Lacteo("Queso", 2.50, 1, 20));
        bolsaLacteos.addProducto(new Lacteo("Yogurt", 1.00, 3, 5));
        bolsaLacteos.addProducto(new Lacteo("Mantequilla", 1.75, 1, 10));
        bolsaLacteos.addProducto(new Lacteo("Crema", 2.00, 2, 15));

        bolsaFrutas.addProducto(new Fruta("Manzana", 0.75, 0.2, "Rojo"));
        bolsaFrutas.addProducto(new Fruta("Banana", 0.50, 0.3, "Amarillo"));
        bolsaFrutas.addProducto(new Fruta("Naranja", 0.60, 0.25, "Naranja"));
        bolsaFrutas.addProducto(new Fruta("Pera", 0.80, 0.22, "Verde"));
        bolsaFrutas.addProducto(new Fruta("Uva", 1.20, 0.15, "Morado"));

        bolsaLimpieza.addProducto(new Limpieza("Detergente", 3.50, "Químicos", 1.5));
        bolsaLimpieza.addProducto(new Limpieza("Jabón", 2.00, "Glicerina", 1.0));
        bolsaLimpieza.addProducto(new Limpieza("Desinfectante", 4.00, "Cloro", 2.0));
        bolsaLimpieza.addProducto(new Limpieza("Suavizante", 3.00, "Aromas", 1.8));
        bolsaLimpieza.addProducto(new Limpieza("Limpiador", 2.50, "Ácido", 1.2));

        bolsaNoPerecibles.addProducto(new NoPerecible("Arroz", 1.00, 500, 350));
        bolsaNoPerecibles.addProducto(new NoPerecible("Pasta", 1.20, 400, 300));
        bolsaNoPerecibles.addProducto(new NoPerecible("Lentejas", 1.50, 250, 200));
        bolsaNoPerecibles.addProducto(new NoPerecible("Harina", 0.80, 1000, 500));
        bolsaNoPerecibles.addProducto(new NoPerecible("Azúcar", 0.90, 750, 600));

        // Mostrar detalles de los productos en cada bolsa
        imprimirBolsa(bolsaLacteos);
        imprimirBolsa(bolsaFrutas);
        imprimirBolsa(bolsaLimpieza);
        imprimirBolsa(bolsaNoPerecibles);
    }

    private static <T extends Producto> void imprimirBolsa(BolsaSupermercado<T> bolsa) {
        for (T producto : bolsa.getProductos()) {
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Precio: " + producto.getPrecio());
            if (producto instanceof Lacteo lacteo) {
                System.out.println("Cantidad: " + lacteo.getCantidad());
                System.out.println("Proteinas: " + lacteo.getProteinas());
            } else if (producto instanceof Fruta fruta) {
                System.out.println("Peso: " + fruta.getPeso());
                System.out.println("Color: " + fruta.getColor());
            } else if (producto instanceof Limpieza limpieza) {
                System.out.println("Componentes: " + limpieza.getComponentes());
                System.out.println("Litros: " + limpieza.getLitros());
            } else if (producto instanceof NoPerecible noPerecible) {
                System.out.println("Contenido: " + noPerecible.getContenido());
                System.out.println("Calorías: " + noPerecible.getCalorias());
            }
            System.out.println("-----------------------------");
        }
    }
}
