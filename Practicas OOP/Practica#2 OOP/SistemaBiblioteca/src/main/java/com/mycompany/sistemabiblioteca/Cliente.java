package com.mycompany.sistemabiblioteca;

import java.util.Date;
import java.util.LinkedList;

public class Cliente {
    private int numeroSocio;
    private String nombre;
    private String direccion;
    private LinkedList<Alquiler> alquileres;

    public Cliente(int numeroSocio, String nombre, String direccion) {
        this.numeroSocio = numeroSocio;
        this.nombre = nombre;
        this.direccion = direccion;
        this.alquileres = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void tomarPrestado(Libro libro) {
        if (libro.estaDisponible()) {
            this.alquileres.add(new Alquiler(libro.getCodigo(), this.numeroSocio, new Date()));
            libro.tomarEnPrestamo();
            System.out.println(this.nombre + " ha tomado en préstamo el libro " + libro.getTitulo() + ".");
        } else {
            System.out.println("El libro " + libro.getTitulo() + " no está disponible para préstamo.");
        }
    }

    public void devolver(Libro libro) {
        Alquiler alquiler = encontrarPrestamo(libro.getCodigo());
        if (alquiler != null) {
            this.alquileres.remove(alquiler);
            libro.devolver();
            System.out.println(this.nombre + " ha devuelto el libro " + libro.getTitulo() + ".");
        } else {
            System.out.println(this.nombre + " no tiene en préstamo el libro " + libro.getTitulo() + ".");
        }
    }

    public int contarLibrosPrestados() {
        return this.alquileres.size();
    }

    private Alquiler encontrarPrestamo(int codigoLibro) {
        for (Alquiler prestamo : this.alquileres) {
            if (prestamo.getCodigoLibro() == codigoLibro) {
                return prestamo;
            }
        }
        return null;
    }
}
