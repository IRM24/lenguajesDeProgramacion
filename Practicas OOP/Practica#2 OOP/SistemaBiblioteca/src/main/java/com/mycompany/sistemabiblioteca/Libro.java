package com.mycompany.sistemabiblioteca;

import java.util.LinkedList;

public class Libro {
    private int codigo;
    private String titulo;
    private String autor;
    private boolean disponible;

    public Libro(int codigo, String titulo, String autor) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
    }

    public String autor(){
        return this.autor;
    }
    
    public boolean estaDisponible() {
        return this.disponible;
    }

    public void tomarEnPrestamo() {
        this.disponible = false;
    }

    public void devolver() {
        this.disponible = true;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public static void mostrarEstadoLibros(LinkedList<Libro> libros) {
    StringBuilder estadoLibros = new StringBuilder("Estado de los libros en la biblioteca:\n");

    for (Libro libro : libros) {
        String disponibilidad = libro.estaDisponible() ? "Disponible" : "No disponible";
        estadoLibros.append("Libro: ").append(libro.getTitulo()).append(" - Estado: ").append(disponibilidad).append(" ").append("autor: ").append(libro.autor()).append("\n");
    }

    System.out.println(estadoLibros.toString());
}
    }
