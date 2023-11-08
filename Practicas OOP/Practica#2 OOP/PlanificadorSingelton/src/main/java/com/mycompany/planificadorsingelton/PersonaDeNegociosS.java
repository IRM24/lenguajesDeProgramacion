package com.mycompany.planificadorsingelton;

public class PersonaDeNegociosS extends PersonaS {
    private String cargo;

    PersonaDeNegociosS(String nombre, String ubicacion, String cargo) {
        super(nombre, ubicacion);
        this.cargo = cargo;
    }

    public String obtenerCargo() {
        return cargo;
    }

    public void actualizarCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return super.toString() + ", Cargo: " + cargo;
    } 
}
