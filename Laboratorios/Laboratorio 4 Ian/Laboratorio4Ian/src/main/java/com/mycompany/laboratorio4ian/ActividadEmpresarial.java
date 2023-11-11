package com.mycompany.laboratorio4ian;

import java.util.Objects;

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
    
    @Override
    public String getObj() {
        return super.getObj() + "Lugar: " + sitio;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ActividadEmpresarial that = (ActividadEmpresarial) o;
        return Objects.equals(sitio, that.sitio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sitio);
    }
}


