package com.mycompany.planificadorsingelton;

public class ActividadPersonalS extends ActividadS {
    private String detalles;
    

    ActividadPersonalS(String tituloActividad, String fechaActividad, String detalles) {
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
