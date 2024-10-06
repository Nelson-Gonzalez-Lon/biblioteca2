package co.edu.uniquindio.poo.application;

import java.util.LinkedList;
import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        Biblioteca ElViajero = new Biblioteca("El Viajero");
        Prestamo nuevoPrestamo = new Prestamo("35135", LocalDate.of(2024, 04, 06));
        ElViajero.añadirPrestamo(nuevoPrestamo);
        Libro ElPrincipito = new Libro("1900", "109990", "Antoine de Saint-Exupéry", "El principito", "Planeta", LocalDate.of(1943, 04, 06), 100, 7000);
        ElViajero.añadirLibro(ElPrincipito);
        LinkedList<String> listaCodigos = new LinkedList<>(){{
                                                add("1900");
                                                }};
        LinkedList<Integer> listaCantidades = new LinkedList<>(){{
                                                add(3);
                                                }};
        ElViajero.procesarPrestamo(nuevoPrestamo, listaCodigos, listaCantidades);
        nuevoPrestamo.finalizarPrestamo(LocalDate.now());
        System.out.println(nuevoPrestamo.getListaDetallePrestamos().get(0).getSubtotal());
    }
}
