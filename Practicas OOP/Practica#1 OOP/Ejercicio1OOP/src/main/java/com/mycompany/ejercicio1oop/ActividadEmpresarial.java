package com.mycompany.ejercicio1oop;

public class ActividadEmpresarial extends Actividad {
    private String sitio;

    public ActividadEmpresarial(String tituloActividad, String fechaActividad, String sitio) {
        super(tituloActividad, fechaActividad);
        this.sitio = sitio;
    }

    public String obtenerSitio() {
        return sitio;
    }

    public void actualizarSitio(String sitio) {
        this.sitio = sitio;
    }

    @Override
    public String toString() {
        return super.toString() + ", Sitio: " + sitio;
    }   
}
