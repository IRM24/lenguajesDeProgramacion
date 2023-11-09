package com.mycompany.sistemabiblioteca;

import java.util.Date;
import java.util.LinkedList;

public class Alquiler {
    private int codigoLibro;
    private int numeroSocio;
    private Date fecha;

    public Alquiler(int codigoLibro, int numeroSocio, Date fecha) {
        this.codigoLibro = codigoLibro;
        this.numeroSocio = numeroSocio;
        this.fecha = fecha;
    }

    public int getCodigoLibro() {
        return this.codigoLibro;
    }

    public static void mostrarAlquileres(LinkedList<Alquiler> alquileres) {
        for (Alquiler alquiler : alquileres) {
            System.out.println("Código del libro: " + alquiler.getCodigoLibro() + " - Número de socio: " + alquiler.numeroSocio);
        }
    }
}
