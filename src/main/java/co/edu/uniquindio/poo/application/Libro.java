package co.edu.uniquindio.poo.application;

import java.time.LocalDate;

public class Libro {

    private String codigo;
    private String isbn;
    private String autor;
    private String titulo;
    private String editorial;
    private LocalDate fecha;
    private int cantidad;
    private float tarifa;
    private int cantidadPrestamos;

    public Libro(String codigo, String isbn, String autor, String titulo, String editorial,LocalDate fecha, int cantidad, float tarifa){
        this.codigo = codigo;
        this.isbn = isbn;
        this.autor = autor;
        this.titulo = titulo;
        this.editorial = editorial;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.tarifa = tarifa;
        this.cantidadPrestamos = 0;
    }


    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getEditorial() {
        return editorial;
    }
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public int getCantidadPrestamos() {
        return cantidadPrestamos;
    }
    public void setCantidadPrestamos(int cantidadPrestamos) {
        this.cantidadPrestamos = cantidadPrestamos;
    }
    public float getTarifa() {
        return tarifa;
    }
    public void setTarifa(float tarifa) {
        this.tarifa = tarifa;
    }


    @Override
    public String toString() {
        return "Libro [codigo=" + codigo + ", isbn=" + isbn + ", autor=" + autor + ", titulo=" + titulo + ", editorial="
                + editorial + ", fecha=" + fecha + "]";
    }





}
