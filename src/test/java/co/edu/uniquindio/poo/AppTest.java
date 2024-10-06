/**
 * Clase para probar el funcionamiento del código
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */

 //Estoy probar
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.application.Biblioteca;
import co.edu.uniquindio.poo.application.Bibliotecario;
import co.edu.uniquindio.poo.application.DetallePrestamo;
import co.edu.uniquindio.poo.application.Estudiante;
import co.edu.uniquindio.poo.application.Libro;
import co.edu.uniquindio.poo.application.Prestamo;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    /**
     * Rigorous Test :-)
     */
    @Test
    //Este Test verifica si se pueden añadir libros a la biblioteca.
    public void testAñadirLibro() {
        LOG.info("Iniciado test testAñadirLibro");

        Biblioteca ElViajero = new Biblioteca("El Viajero");
        Libro ElPrincipito = new Libro("1900", "109990", "Antoine de Saint-Exupéry", "El principito", "Planeta", LocalDate.of(1943, 04, 06), 100, 7000);
        ElViajero.añadirLibro(ElPrincipito);
        ArrayList<Libro> listaEsperada = new ArrayList<>(Arrays.asList(ElPrincipito));
        assertIterableEquals(listaEsperada, ElViajero.getListaLibros());

        LOG.info("Finalizando test testAñadirLibro");
    }
    @Test
    //Este Test intenta añadir un libro repetido.
    public void testAñadirLibroRepetido() {
        LOG.info("Iniciado test testAñadirLibroRepetido");

        Biblioteca ElViajero = new Biblioteca("El Viajero");
        Libro ElPrincipito = new Libro("1900", "109990", "Antoine de Saint-Exupéry", "El principito", "Planeta", LocalDate.of(1943, 04, 06), 100, 7000);
        ElViajero.añadirLibro(ElPrincipito);
        String mensaje = ElViajero.añadirLibro(ElPrincipito);
        assertEquals("\nEl libro ya se encuentra registrado.", mensaje);

        LOG.info("Finalizando test testAñadirLibroRepetido");
    }

    @Test
    //Este Test verifica si se pueden añadir Estudiantes a la biblioteca.
    public void testAñadirEstudiante() {
        LOG.info("Iniciado test testAñadirEstudiante");

        Biblioteca ElViajero = new Biblioteca("El Viajero");
        Estudiante juanEstudiante = new Estudiante("Juan", "109898", "3232432", "juanito@gmail.com");
        ElViajero.añadirEstudiante(juanEstudiante);
        HashMap<String, Estudiante> listaEsperada = new HashMap<>(){{
            put(juanEstudiante.getCedula(), juanEstudiante);
        }};
        assertEquals(listaEsperada, ElViajero.getListaEstudiantes());

        LOG.info("Finalizando test testAñadirEstudiante");
    }    

    @Test
    //Este Test verifica si se pueden eliminar un Estudiantes de la biblioteca.
    public void testEliminarEstudiante() {
        LOG.info("Iniciado test testEliminarEstudiante");

        Biblioteca ElViajero = new Biblioteca("El Viajero");
        Estudiante juanEstudiante = new Estudiante("Juan", "109898", "3232432", "juanito@gmail.com");
        ElViajero.añadirEstudiante(juanEstudiante);
        ElViajero.eliminarEstudiante("109898");
        HashMap<String, Estudiante> listaEsperada = new HashMap<>();
        assertEquals(listaEsperada, ElViajero.getListaEstudiantes());

        LOG.info("Finalizando test testEliminarEstudiante");
    }    

    @Test
    //Este Test verifica si se pueden añadir Bibliotecarios a la biblioteca.
    public void testAñadirBibliotecario() {
        LOG.info("Iniciado test testAñadirBibliotecario");

        Biblioteca ElViajero = new Biblioteca("El Viajero");
        Bibliotecario nuevobBibliotecario = new Bibliotecario("Juan", "109898", "3232432", "juanito@gmail.com");
        ElViajero.crearBibliotecario(nuevobBibliotecario);
        Bibliotecario[] listaBibliotecarios = new Bibliotecario[10];
        listaBibliotecarios[0] = nuevobBibliotecario;
        assertArrayEquals(listaBibliotecarios, ElViajero.getListaBibliotecarios());

        LOG.info("Finalizando test testAñadirBibliotecario");
    }   
 
    @Test
    //Este Test intenta eliminar de la biblioteca un bibliotecario que no existe.
    public void testEliminarBibliotecarioFalso() {
        LOG.info("Iniciado test testEliminarBibliotecarioFalso");

        Biblioteca ElViajero = new Biblioteca("El Viajero");
        Bibliotecario nuevobBibliotecario = new Bibliotecario("Juan", "109898", "3232432", "juanito@gmail.com");
        ElViajero.crearBibliotecario(nuevobBibliotecario);
        String mensaje = ElViajero.eliminarBibliotecario("100008");
        assertEquals("\nEl bibliotecario no existe.", mensaje);

        LOG.info("Finalizando test testEliminarBibliotecarioFalso");
    }   

    @Test
    //Este Test verifica si se pueden añadir prestamos a la biblioteca.
    public void testAñadirPrestamo() {
        LOG.info("Iniciado test testAñadirPrestamo");

        Biblioteca ElViajero = new Biblioteca("El Viajero");
        Prestamo nuevoPrestamo = new Prestamo("35135", LocalDate.of(2024, 04, 06));
        ElViajero.añadirPrestamo(nuevoPrestamo);
        ArrayList<Prestamo> listaEsperada = new ArrayList<>(Arrays.asList(nuevoPrestamo));
        assertIterableEquals(listaEsperada, ElViajero.getListaPrestamos());

        LOG.info("Finalizando test testAñadirPrestamo");
    }


    @Test
    //Este Test intenta añadir un préstamo vacío.
    public void testAñadirPrestamoVacio() {
        LOG.info("Iniciado test testAñadirPrestamoVacio");

        Biblioteca ElViajero = new Biblioteca("El Viajero");
        Prestamo nuevoPrestamo = null;
        String mensaje = ElViajero.añadirPrestamo(nuevoPrestamo);
        assertEquals("\nNo se puede almacenar un préstamo sin información", mensaje);

        LOG.info("Finalizando test testAñadirPrestamoVacio");
    }

    @Test
    //Este Test verifica si se puede añadir un detalle a un prestamo.
    public void testAñadirDetallePrestamo() {
        LOG.info("Iniciado test testAñadirDetallePrestamo");

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
        DetallePrestamo detalle = new DetallePrestamo("El principito", "1900", 3, 7000);
        LinkedList<DetallePrestamo> listaEsperada = new LinkedList<>(Arrays.asList(detalle));
        assertIterableEquals(listaEsperada, nuevoPrestamo.getListaDetallePrestamos());

        LOG.info("Finalizando test testAñadirDetallePrestamo");
    }

    @Test
    //Este Test comprueba que el valor el subtotal de un detalle se calcule correctamente.
    public void testFinalizarDetallePrestamo() {
        LOG.info("Iniciado test testAñadirDetallePrestamo");

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
        float subtotal = nuevoPrestamo.getListaDetallePrestamos().get(0).getSubtotal();
        assertEquals(3843000.0, subtotal);

        LOG.info("Finalizando test testAñadirDetallePrestamo");
    }
}
