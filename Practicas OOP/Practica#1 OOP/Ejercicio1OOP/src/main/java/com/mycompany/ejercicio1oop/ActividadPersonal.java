package com.mycompany.ejercicio1oop;

public class ActividadPersonal extends Actividad {
    private String detalles;

    public ActividadPersonal(String tituloActividad, String fechaActividad, String detalles) {
        super(tituloActividad, fechaActividad);
        this.detalles = detalles;
    }

    public String obtenerDetalles() {
        return detalles;
    }

    public void actualizarDetalles(String detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return super.toString() + ", Detalles: " + detalles;
    }
}