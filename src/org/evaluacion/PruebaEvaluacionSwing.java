package org.evaluacion;

import org.evaluacion.modelo.*;
import org.evaluacion.servicio.BolsaSupermercado;

import javax.swing.*;

import static javax.swing.JOptionPane.YES_OPTION;

public class PruebaEvaluacionSwing {
    public static void main(String[] args) {

        //Crear las bolsas para los productos
        BolsaSupermercado<Fruta> bolsaFrutas = new BolsaSupermercado<>(5);
        BolsaSupermercado<Lacteo> bolsaLacteos = new BolsaSupermercado<>(5);
        BolsaSupermercado<Limpieza> bolsaLimpieza = new BolsaSupermercado<>(5);
        BolsaSupermercado<NoPerecible> bolsaNoPerecibles = new BolsaSupermercado<>(5);

        boolean continuar = true;

        while(continuar){
            //Creación de arreglo de productos
            String [] productos = {"Fruta", "Lacteo", "Limpieza", "NoPerecible"};

            String eleccion = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de producto",
                    "Elección de producto", JOptionPane.QUESTION_MESSAGE, null, productos, productos[0]);

            if(eleccion != null){
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto");
                Double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto"));

                switch(eleccion) {
                    case "Fruta" :
                        double peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso de la fruta"));
                        String color = JOptionPane.showInputDialog("Ingrese el color de la fruta");
                        bolsaFrutas.addProducto(new Fruta(nombre, precio, peso, color));
                        imprimirBolsa(bolsaFrutas);
                        break;
                    case "Lacteo" :
                        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad: "));
                        int proteinas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de proteínas: "));
                        bolsaLacteos.addProducto(new Lacteo(nombre, precio, cantidad, proteinas));
                        imprimirBolsa(bolsaLacteos);
                        break;
                    case "Limpieza" :
                        String componentes = JOptionPane.showInputDialog("Ingrese los componentes del producto de limpieza: ");
                        double litros = Double.parseDouble(JOptionPane.showInputDialog("Ingrese los litros: "));
                        bolsaLimpieza.addProducto(new Limpieza(nombre, precio, componentes, litros));
                        imprimirBolsa(bolsaLimpieza);
                        break;
                    case "NoPerecible" :
                        int contenido = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el contenido: "));
                        int calorias = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los litros: "));
                        bolsaNoPerecibles.addProducto(new NoPerecible(nombre, precio, contenido, calorias));
                        imprimirBolsa(bolsaNoPerecibles);
                        break;
                }

                //Preguntar al usuario si desea continuar
                int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea agregar otro producto?", "Continuar", JOptionPane.YES_NO_OPTION);
                if (respuesta != JOptionPane.YES_OPTION) {
                    continuar = false;
                }
            } else {
                continuar = false;
            }

        }
    }

    private static <T extends Producto> void imprimirBolsa(BolsaSupermercado<T> bolsa ){
        System.out.println("\nProductos en la bolsa: ");
        System.out.println("-----------------------------");
        for(T producto : bolsa.getProductos()){
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Precio: " + producto.getPrecio());
            if(producto instanceof Lacteo lacteo){
                System.out.println("Cantidad: " + lacteo.getCantidad());
                System.out.println("Proteinas: " + lacteo.getProteinas());
            } else if(producto instanceof Fruta fruta){
                System.out.println("Peso: " + fruta.getPeso());
                System.out.println("Color: " + fruta.getColor());
            } else if(producto instanceof Limpieza limpieza){
                System.out.println("Componentes: " + limpieza.getComponentes());
                System.out.println("Litros: " + limpieza.getLitros());
            } else if(producto instanceof NoPerecible noPerecible){
                System.out.println("Contenido: " + noPerecible.getContenido());
                System.out.println("Calorías: " + noPerecible.getCalorias());
            }
        }
    }
}

