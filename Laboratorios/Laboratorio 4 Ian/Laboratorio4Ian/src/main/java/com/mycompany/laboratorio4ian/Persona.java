
package com.mycompany.laboratorio4ian;

public abstract class Persona implements Obj {
    private String nombre;
    private String ubicacion;

    public Persona(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public void actualizarNombre(String nombre) {
        this.nombre = nombre;
    }

    public String obtenerUbicacion() {
        return ubicacion;
    }

    public void actualizarUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Ubicación: " + ubicacion;
    }
    
    @Override
    public String getObj() {
        return "Nombre: " + nombre + ", Ubicación: " + ubicacion;
    } 
}
