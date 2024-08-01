package org.evaluacion;

import org.evaluacion.modelo.*;
import org.evaluacion.repositorio.CrudRepositorio;
import org.evaluacion.repositorio.ListRepositorio;

import javax.swing.*;
import java.util.List;

public class PruebaEvaluacionRepositorio {
    public static void main(String[] args) {
        // Crear repositorios para cada tipo de producto
        CrudRepositorio<Lacteo> repoLacteos = new ListRepositorio<>();
        CrudRepositorio<Fruta> repoFrutas = new ListRepositorio<>();
        CrudRepositorio<Limpieza> repoLimpieza = new ListRepositorio<>();
        CrudRepositorio<NoPerecible> repoNoPerecibles = new ListRepositorio<>();

        boolean continuar = true;
        while (continuar) {
            //Creación de arreglo de productos
            String [] productos = {"Fruta", "Lacteo", "Limpieza", "NoPerecible"};

            String eleccion = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de producto",
                    "Elección de producto", JOptionPane.QUESTION_MESSAGE, null, productos, productos[0]);


            if (eleccion != null) {
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
                String precioStr = JOptionPane.showInputDialog("Ingrese el precio del producto:");
                double precio = Double.parseDouble(precioStr);

                switch (eleccion) {
                    case "Lacteo":
                        String cantidadStr = JOptionPane.showInputDialog("Ingrese la cantidad:");
                        int cantidad = Integer.parseInt(cantidadStr);
                        String proteinasStr = JOptionPane.showInputDialog("Ingrese las proteinas:");
                        int proteinas = Integer.parseInt(proteinasStr);
                        repoLacteos.crear(new Lacteo(nombre, precio, cantidad, proteinas));
                        imprimirRepositorio(repoLacteos);
                        break;
                    case "Fruta":
                        String pesoStr = JOptionPane.showInputDialog("Ingrese el peso:");
                        double peso = Double.parseDouble(pesoStr);
                        String color = JOptionPane.showInputDialog("Ingrese el color:");
                        repoFrutas.crear(new Fruta(nombre, precio, peso, color));
                        imprimirRepositorio(repoFrutas);
                        break;
                    case "Limpieza":
                        String componentes = JOptionPane.showInputDialog("Ingrese los componentes:");
                        String litrosStr = JOptionPane.showInputDialog("Ingrese los litros:");
                        double litros = Double.parseDouble(litrosStr);
                        repoLimpieza.crear(new Limpieza(nombre, precio, componentes, litros));
                        break;
                    case "No Perecible":
                        String contenidoStr = JOptionPane.showInputDialog("Ingrese el contenido:");
                        int contenido = Integer.parseInt(contenidoStr);
                        String caloriasStr = JOptionPane.showInputDialog("Ingrese las calorías:");
                        int calorias = Integer.parseInt(caloriasStr);
                        repoNoPerecibles.crear(new NoPerecible(nombre, precio, contenido, calorias));
                        break;
                }

                // Preguntar al usuario si desea continuar agregando productos
                int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea agregar otro producto?", "Continuar", JOptionPane.YES_NO_OPTION);
                if (respuesta != JOptionPane.YES_OPTION) {
                    continuar = false;
                }
            } else {
                continuar = false;
            }
        }

        // Probar actualización de un producto
        System.out.println("\nActualización de un producto:");
        Lacteo lacteoActualizado = new Lacteo("Leche", 1.75, 3, 9); // Simulando la actualización de la leche
        repoLacteos.editar(lacteoActualizado);
        imprimirRepositorio(repoLacteos);

        // Probar eliminación de un producto
        System.out.println("\nEliminación de un producto:");
        repoLacteos.eliminar("Leche");
        imprimirRepositorio(repoLacteos);
    }

    private static <T extends Producto> void imprimirRepositorio(CrudRepositorio<T> crud) {
        List<T> productos = crud.listar();
        for (T producto : productos) {
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