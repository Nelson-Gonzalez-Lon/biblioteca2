package co.edu.uniquindio.poo.application;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

public class DetallePrestamo {

    private String nombreLibro;
    private String codigoLibro;
    private int cantidad;
    private float tarifa;
    private float subtotal;
    
    public DetallePrestamo(String nombreLibro, String codigoLibro, int cantidad, float tarifa) {
        this.nombreLibro = nombreLibro;
        this.codigoLibro = codigoLibro;
        this.cantidad = cantidad;
        this.tarifa = tarifa;
    }

    public void calcularSubtotal(LocalDate fechaPrestamo, LocalDate fechaEntrega){
        float subtotal = 0;
        long dias = DAYS.between(fechaPrestamo, fechaEntrega);
        subtotal = dias*tarifa*cantidad;
        this.subtotal = subtotal;
    }

    
    public int getCantidad() {
        return cantidad;
    }
    public float getSubtotal() {
        return subtotal;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getTarifa() {
        return tarifa;
    }

    public void setTarifa(float tarifa) {
        this.tarifa = tarifa;
    }
    
    public String getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(String codigoLibro) {
        this.codigoLibro = codigoLibro;
    }
    
    @Override
    public String toString() {
        return "DetallePrestamo [nombreLibro=" + nombreLibro + ", cantidad=" + cantidad + ", subtotal=" + subtotal
                + "]";
    }



    

}
