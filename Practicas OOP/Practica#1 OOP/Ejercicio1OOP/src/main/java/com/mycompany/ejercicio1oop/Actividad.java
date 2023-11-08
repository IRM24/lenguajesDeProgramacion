package com.mycompany.ejercicio1oop;

public class Actividad {
    private String tituloActividad;
    private String fechaActividad;

    public Actividad(String tituloActividad, String fechaActividad) {
        this.tituloActividad = tituloActividad;
        this.fechaActividad = fechaActividad;
    }

    public String obtenerTituloActividad() {
        return tituloActividad;
    }

    public void actualizarTituloActividad(String tituloActividad) {
        this.tituloActividad = tituloActividad;
    }

    public String obtenerFechaActividad() {
        return fechaActividad;
    }

    public void actualizarFechaActividad(String fechaActividad) {
        this.fechaActividad = fechaActividad;
    }

    @Override
    public String toString() {
        return "Título de la actividad: " + tituloActividad + ", Fecha: " + fechaActividad;
    }
}