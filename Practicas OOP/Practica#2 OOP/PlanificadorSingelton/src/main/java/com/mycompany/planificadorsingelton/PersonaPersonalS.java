
package com.mycompany.planificadorsingelton;

public class PersonaPersonalS extends PersonaS {
    private String vinculo;


    PersonaPersonalS (String nombre, String ubicacion, String vinculo) {
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

