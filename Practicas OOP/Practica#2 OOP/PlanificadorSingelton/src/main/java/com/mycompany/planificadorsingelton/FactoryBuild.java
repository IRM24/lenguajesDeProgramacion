package com.mycompany.planificadorsingelton;

public class FactoryBuild extends Factory {
    @Override
    public PersonaS crearContacto(String nombre, String direccion, String tipo, String puestoRelacion) {
        if (tipo.equalsIgnoreCase("empresarial")) {
            return new PersonaDeNegociosS(nombre, direccion, puestoRelacion);
        } else if (tipo.equalsIgnoreCase("personal")) {
            return new PersonaPersonalS(nombre, direccion, puestoRelacion);
        }
        return null;
    }

    @Override
    public ActividadS crearEvento(String nombre, String fecha, String tipo, String lugarDescripcion) {
        if (tipo.equalsIgnoreCase("empresarial")) {
            return new ActividadEmpresarialS(nombre, fecha, lugarDescripcion);
        } else if (tipo.equalsIgnoreCase("personal")) {
            return new ActividadPersonalS(nombre, fecha, lugarDescripcion);
        }
        return null;
    }
}
