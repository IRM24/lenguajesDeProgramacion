
package com.mycompany.planificadorsingelton;

    public class PersonaS {
    private String nombre;
    private String ubicacion;

    PersonaS(String nombre, String ubicacion) {
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
}

