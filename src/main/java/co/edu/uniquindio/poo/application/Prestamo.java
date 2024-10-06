package co.edu.uniquindio.poo.application;

import java.time.LocalDate;
import java.util.LinkedList;

public class Prestamo {
    
    LinkedList<DetallePrestamo> listaDetallePrestamos = new LinkedList<>();
    String codigo;
    LocalDate fechaPrestamo;
    LocalDate fechaEntrega;
    float valorTotal;


    public Prestamo(String codigo, LocalDate fechaPrestamo) {
        this.codigo = codigo;
        this.fechaPrestamo = fechaPrestamo;
    }

    //Este método almacena un grupo de detalles.
    public void crearDatosVariosPrestamos(LinkedList<String> listaNombresLibros, LinkedList<Integer> listaCantidadesLibros, LinkedList<Float> listaTarifas, LinkedList<String> listaCodigos){     
        int i = 0;
        for (String nombreLibro : listaNombresLibros) {
            int cantidadPrestada = listaCantidadesLibros.get(i);
            float tarifaLibro = listaTarifas.get(i);
            String codigoLibro = listaCodigos.get(i);
            DetallePrestamo nuevoDetallePrestamo = new DetallePrestamo(nombreLibro, codigoLibro, cantidadPrestada, tarifaLibro);
            listaDetallePrestamos.add(nuevoDetallePrestamo);
        }
    }

    //Este método finaliza el préstamo, llenando los datos faltantes en su detalle.
    public void finalizarPrestamo(LocalDate hoy){
        for (DetallePrestamo detalleAux : listaDetallePrestamos) {
            detalleAux.calcularSubtotal(fechaPrestamo, hoy);
        }
    }

    //Este método calcula el valor total del préstamo, sumando el subtotal de todos los detalles.
    public void calcularValorTotal(){
        float valorTotal = 0;
        for (DetallePrestamo detallePrestamoAux : listaDetallePrestamos) {
            valorTotal += detallePrestamoAux.getSubtotal();
        }
        this.valorTotal = valorTotal;
    }
    
       
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }
    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }
    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public LinkedList<DetallePrestamo> getListaDetallePrestamos() {
        return listaDetallePrestamos;
    }

    public void setListaDetallePrestamos(LinkedList<DetallePrestamo> listaDetallePrestamos) {
        this.listaDetallePrestamos = listaDetallePrestamos;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Prestamo [listaDetallePrestamos=" + listaDetallePrestamos + ", codigo=" + codigo + ", fechaPrestamo="
                + fechaPrestamo + ", fechaEntrega=" + fechaEntrega + "]";
    }    
    
}

