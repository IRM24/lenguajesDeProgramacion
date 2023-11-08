package com.mycompany.planificadorsingelton;

public class ActividadEmpresarialS extends ActividadS {
    private String sitio;

    ActividadEmpresarialS(String tituloActividad, String fechaActividad, String sitio) {
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


