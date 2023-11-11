package com.mycompany.laboratorio4ian;

import java.util.Objects;

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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ActividadPersonal that = (ActividadPersonal) o;
        return Objects.equals(detalles, that.detalles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), detalles);
    }
}