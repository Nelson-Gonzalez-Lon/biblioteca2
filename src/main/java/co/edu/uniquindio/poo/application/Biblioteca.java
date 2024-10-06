package co.edu.uniquindio.poo.application;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.HashMap;

public class Biblioteca {

    private String nombre;
    LinkedList<Libro> listaLibros = new LinkedList<>();
    LinkedList<Prestamo> listaPrestamos = new LinkedList<>();
    HashMap<String, Estudiante> listaEstudiantes = new HashMap<>();
    private Bibliotecario[] listaBibliotecarios = new Bibliotecario[10];


    public Biblioteca(String nombre){
        this.nombre = nombre;
    }


    //Este método almacena un nuevo libro, solo si no ha sido registrado.
    public String añadirLibro (Libro nuevoLibro){
        String mensaje = "";
        System.out.println("Intento");
        Libro libroEncontrado = buscarLibro(nuevoLibro.getCodigo());
        if (libroEncontrado != null) {
            mensaje = "\nEl libro ya se encuentra registrado.";
        } else {
            listaLibros.add(nuevoLibro);
            mensaje = "\nEl libro se a almacenado exitosamente.";
        }
        return mensaje;
    }  
    
    //Este método busca un libro un base a su codigo.
    public Libro buscarLibro(String codigo) {
        Libro libroEncontrado = null;

        for (Libro libroAux: listaLibros) {
            if (libroAux != null) {
                if (libroAux.getCodigo().equals(codigo)) {
                    libroEncontrado = libroAux;
                    return libroEncontrado;
                }
            }          
        }
        return libroEncontrado;
    }

    //Este método actualiza la información de un libro previamente buscado.
    public String actualizarLibro(String codigo, String autor, String titulo, String editorial,LocalDate fecha, Libro libroEncontrado) {
        libroEncontrado.setCodigo(codigo);
        libroEncontrado.setAutor(autor);
        libroEncontrado.setTitulo(titulo);
        libroEncontrado.setEditorial(editorial);
        libroEncontrado.setFecha(fecha);
        String mensaje = "Libro actualizado con éxito";
        return mensaje;
    }

    //Este método elimina un libro, si lo encuentra.
    public String eliminarLibro(String isbn) {
        String mensaje = "\nEl libro no se encuentra registrado.";

        for (Libro libroAux : listaLibros) {
            if (libroAux != null) {
                if (libroAux.getIsbn().equals(isbn)) {
                    listaLibros.remove(libroAux);
                    mensaje = "\nEl libro ha sido eliminado correctamente.";
                    return mensaje;
                }                
            }           
        }
        return mensaje;
    }

    //Este método almacena un nuevo estudiante, solo si no ha sido registrado.
    public String añadirEstudiante (Estudiante nuevoEstudiante){
        String mensaje = "";
        String cedula = nuevoEstudiante.getCedula();
        Estudiante estudianteEncontrado = buscarEstudiante(cedula);
        if (estudianteEncontrado != null) {
            mensaje = "\nEl estudiante ya se encuentra registrado.";
        } else {
            listaEstudiantes.put(cedula, nuevoEstudiante);
            mensaje = "\nEl estudiante se a almacenado exitosamente.";
        }
        return mensaje;
    }
    
    //Este método busca un estudiante un base a su cédula.
    public Estudiante buscarEstudiante(String cedula) {
        Estudiante estudianteEncontrado = null;

        for (String cedulaAux: listaEstudiantes.keySet()) {
            Estudiante estudianteAux = listaEstudiantes.get(cedulaAux);
            if (estudianteAux != null) {
                if (estudianteAux.getCedula().equals(cedula)) {
                    estudianteEncontrado = estudianteAux;
                    return estudianteEncontrado;
                }
            }          
        }
        return estudianteEncontrado;
    }

    //Este método actualiza la información de un estudiante previamente buscado.
    public String actualizarEstudiante(String nombre, String cedula, String telefono, String correo, Estudiante estudianteEncontrado) {
        Estudiante nuevoEstudiante = new Estudiante(nombre, cedula, telefono, correo);
        listaEstudiantes.put(estudianteEncontrado.getCedula(),nuevoEstudiante);
        String mensaje = "Estudiante actualizado con éxito";
        return mensaje;
    }  
    
    //Este método elimina un estudiante, si lo encuentra.
    public String eliminarEstudiante(String cedula) {
        String mensaje = "\nEl libro no se encuentra registrado.";

        for (String cedulaAux : listaEstudiantes.keySet()) {
            if (cedulaAux != null) {
                if (cedulaAux.equals(cedula)) {
                    listaEstudiantes.remove(cedulaAux);
                    mensaje = "\nEl estudiante ha sido eliminado correctamente.";
                    return mensaje;
                }                
            }           
        }
        return mensaje;
    }

    //Este método almacena un nuevo bibliotecario, solo si hay espacios disponibles y el bibliotecario aun no ha sido registrado.
    public String crearBibliotecario(Bibliotecario nuevoBibliotecario) {
        String mensaje = "";
        int posicionDisponible = 0;
        Bibliotecario bibliotecarioEncontrado = null;
        posicionDisponible = buscarPosicionDisponible();

        if (posicionDisponible == -1) {
            mensaje = "\nNo hay espacio para un nuevo bibliotecario.";
            return mensaje;
        } else {
            bibliotecarioEncontrado = buscarBibliotecario(nuevoBibliotecario.getCedula());

            if (bibliotecarioEncontrado != null) {
                mensaje = "\nEl bibliotecario ya se encuentra registrado.";
            } else {
                listaBibliotecarios[posicionDisponible] = nuevoBibliotecario;
                mensaje = "\nEl bibliotecario se a almacenado exitosamente.";
            }
        }
        return mensaje;
    }

    //Este método busca una posición disponible y la retorna, en caso de no haber, retorna -1.
    private int buscarPosicionDisponible() {
        int posicionDisponible = -1;

        for (int i = 0; i < listaBibliotecarios.length; i++) {
            Bibliotecario bibliotecarioAux = listaBibliotecarios[i];
            if (bibliotecarioAux == null) {
                posicionDisponible = i;
                return posicionDisponible;
            }
        }
        return posicionDisponible;
    }

    //Este método busca un Bibliotecario un base a su cedula.
    public Bibliotecario buscarBibliotecario(String cedula) {
        Bibliotecario bibliotecarioEncontrado = null;

        for (int i = 0; i < listaBibliotecarios.length; i++) {
            Bibliotecario bibliotecarioAux = listaBibliotecarios[i];
            if (bibliotecarioAux != null) {
                if (bibliotecarioAux.getCedula().equals(cedula)) {
                    bibliotecarioEncontrado = bibliotecarioAux;
                    return bibliotecarioEncontrado;
                }
            }
        }
        return bibliotecarioEncontrado;
    }

    //Este método elimina un bibliotecario, si lo encuentra.
    public String eliminarBibliotecario(String cedula) {
        String mensaje = "\nEl bibliotecario no existe.";

        for (int i = 0; i < listaBibliotecarios.length; i++) {
            Bibliotecario bibliotecarioAux = listaBibliotecarios[i];
            if (bibliotecarioAux != null) {
                if (bibliotecarioAux.getNombre().equals(cedula)) {
                    listaBibliotecarios[i] = null;
                    mensaje = "\nEl bibliotecario ha sido eliminado correctamente.";
                    return mensaje;
                }                
            }           
        }
        return mensaje;
    }

    //Este método recibe la información de los libros prestados, y crea con ello los detalles de préstamo.
    public String procesarPrestamo(Prestamo prestamo, LinkedList<String> listaCodigos, LinkedList<Integer> listaCantidades){
        String mensaje = "";
        LinkedList<String> listaNombres = new LinkedList<>();
        LinkedList<Float> listaTarifas = new LinkedList<>();
        int i = 0;
        for (String codigoAux : listaCodigos) {
            Libro libroEncontrado = buscarLibro(codigoAux);
            System.out.println(libroEncontrado);
            if (libroEncontrado == null) {
                mensaje = "Uno de los códigos ingresados no es valido";
                return mensaje; 
            }else{
                String nombreLibro = libroEncontrado.getTitulo();
                float tarifaLibro = libroEncontrado.getTarifa();
                listaNombres.add(nombreLibro);
                listaTarifas.add(tarifaLibro);
            }       
        }
        for (String codigoAux2 : listaCodigos) {
            Libro libroEncontrado = buscarLibro(codigoAux2);
            int cantidadActual = libroEncontrado.getCantidad();
            int cantidadPrestada = listaCantidades.get(i);
            libroEncontrado.setCantidad(cantidadActual - cantidadPrestada);
            int cantidadPrestamosActual = libroEncontrado.getCantidadPrestamos();
            libroEncontrado.setCantidadPrestamos(cantidadPrestamosActual + 1);
            i++;          
        }
        prestamo.crearDatosVariosPrestamos(listaNombres, listaCantidades, listaTarifas, listaCodigos); 
        return mensaje;
    }

    //Este método almacena un nuevo préstamo, solo si no ha sido registrado.
    public String añadirPrestamo (Prestamo nuevoPrestamo){
        String mensaje = "";
        if (nuevoPrestamo == null) {
            mensaje = "\nNo se puede almacenar un préstamo sin información";
            return mensaje;
        }
        Prestamo prestamoEncontrado = buscarPrestamo(nuevoPrestamo.getCodigo());
        if (prestamoEncontrado != null) {
            mensaje = "\nYa hay un préstamo con este código.";
        } else {
            listaPrestamos.add(nuevoPrestamo);
            mensaje = "\nEl préstamo se a almacenado exitosamente.";
        }
        return mensaje;
    }  
    
    //Este método busca un préstamo un base a su código.
    public Prestamo buscarPrestamo(String codigo) {
        Prestamo prestamoEncontrado = null;

        for (Prestamo prestamoAux : listaPrestamos) {
            if (prestamoAux != null) {
                if (prestamoAux.getCodigo().equals(codigo)) {
                    prestamoEncontrado = prestamoAux;
                    return prestamoEncontrado;
                }
            }          
        }
        return prestamoEncontrado;
    }

    //Este método elimina un préstamo, si lo encuentra.
    public String eliminarPrestamo(String codigo) {
        String mensaje = "\nEl Prestamo no se encuentra registrado.";

        for (Prestamo prestamoAux : listaPrestamos) {
            if (prestamoAux != null) {
                if (prestamoAux.getCodigo().equals(codigo)) {
                    listaPrestamos.remove(prestamoAux);
                    mensaje = "\nEl préstamo ha sido eliminado correctamente.";
                    return mensaje;
                }                
            }           
        }
        return mensaje;
    }

    //Este método marca un prestamo como terminado, calculando el valor total del prestamo.
    public String terminarPrestamo(String codigo){
        String mensaje = "";
        Prestamo prestamoEncontrado = buscarPrestamo(codigo);
        if (prestamoEncontrado == null) {
            mensaje = "\nNo se encontró un prestamo con este codigo";
            return mensaje;
        }else{
            prestamoEncontrado.finalizarPrestamo(LocalDate.now());
            for (int i = 0; i < prestamoEncontrado.listaDetallePrestamos.size(); i++) {
                String codigoLibro = prestamoEncontrado.listaDetallePrestamos.get(i).getCodigoLibro();
                int cantidadPrestada = prestamoEncontrado.listaDetallePrestamos.get(i).getCantidad();
                Libro liborEndontrado = buscarLibro(codigoLibro);
                if(liborEndontrado != null){
                    int cantidadActual = liborEndontrado.getCantidad();
                    liborEndontrado.setCantidad(cantidadActual + cantidadPrestada);
                }
            }
            
            mensaje = "\nEl prestamo a terminado con éxito.";
        } 
        return mensaje;
    }

    

    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public LinkedList<Libro> getListaLibros() {
        return listaLibros;
    }


    public void setListaLibros(LinkedList<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }


    public LinkedList<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }


    public void setListaPrestamos(LinkedList<Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }


    public HashMap<String, Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }


    public void setListaEstudiantes(HashMap<String, Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }


    public Bibliotecario[] getListaBibliotecarios() {
        return listaBibliotecarios;
    }


    public void setListaBibliotecarios(Bibliotecario[] listaBibliotecarios) {
        this.listaBibliotecarios = listaBibliotecarios;
    }


    @Override
    public String toString() {
        return "Biblioteca [nombre=" + nombre + ", listaLibros=" + listaLibros + "]";
    } 
}