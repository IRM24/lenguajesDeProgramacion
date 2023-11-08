package com.mycompany.ejercicio1oop;

public class PersonaPersonal extends Persona {
    private String vinculo;

    public PersonaPersonal(String nombre, String ubicacion, String vinculo) {
        super(nombre, ubicacion);
        this.vinculo = vinculo;
    }

    public String obtenerVinculo() {
        return vinculo;
    }

    public void actualizarVinculo(String vinculo) {
        this.vinculo = vinculo;
    }

    @Override
    public String toString() {
        return super.toString() + ", Vínculo: " + vinculo;
    }
}