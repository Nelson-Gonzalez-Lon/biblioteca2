package co.edu.uniquindio.poo.application;

import java.util.LinkedList;

public class Persona {

    protected String nombre;
    protected String cedula;
    protected String telefono;
    protected String correo;
    protected LinkedList<Prestamo> listaPrestamos = new LinkedList<>();

    public Persona(String nombre, String cedula, String telefono, String correo){
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
    }

    //Este método añade un préstamo a la lista de prestamos relacionados a una persona.
    public String añadirPrestamo(String codigo){
        String mensaje = "";
        Prestamo prestamoEncontrado = buscarPrestamo(codigo);
        listaPrestamos.add(prestamoEncontrado);
        mensaje = "\nEl préstamo se a añadido exitosamente a la lista de prestamos del";
        return mensaje;
    }

    //Este método busca un prestamo un base a su codigo.
    public Prestamo buscarPrestamo(String codigo) {
        Prestamo prestamoEncontrado = null;

        for (Prestamo prestamoAux: listaPrestamos) {
            if (prestamoAux != null) {
                if (prestamoAux.getCodigo().equals(codigo)) {
                    prestamoEncontrado = prestamoAux;
                    return prestamoEncontrado;
                }
            }          
        }
        return prestamoEncontrado;
    }

    //Este método elimina un prestamo, si lo encuentra.
    public String eliminarPrestamo(String codigo) {
        String mensaje = "\nEl prestamo no esta registrado a esta persona o no existe.";

        for (Prestamo prestamoAux : listaPrestamos) {
            if (prestamoAux != null) {
                if (prestamoAux.getCodigo().equals(codigo)) {
                    listaPrestamos.remove(prestamoAux);
                    mensaje = "\nEl prestamo ha sido eliminado correctamente.";
                    return mensaje;
                }                
            }           
        }
        return mensaje;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public LinkedList<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }
    public void setListaPrestamos(LinkedList<Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }

}
