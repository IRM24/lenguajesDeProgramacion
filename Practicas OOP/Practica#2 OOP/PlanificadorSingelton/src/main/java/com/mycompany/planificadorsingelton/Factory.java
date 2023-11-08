
package com.mycompany.planificadorsingelton;

public abstract class Factory {
    public abstract PersonaS crearContacto(String nombre, String direccion, String tipo, String puestoRelacion);
    public abstract ActividadS crearEvento(String nombre, String fecha, String tipo, String lugarDescripcion);
}
