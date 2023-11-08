
package com.mycompany.planificadorsingelton;

import java.util.LinkedList;
import java.util.List;

public class PlanificadorS {
   private static PlanificadorS instance;
    private final List<Object> elementos;

    private PlanificadorS() {
        elementos = new LinkedList<>();
    }

    public static PlanificadorS getInstance() {
        if (instance == null) {
            instance = new PlanificadorS();
        }
        return instance;
    }
    public void añadirElemento(Object elemento) {
        elementos.add(elemento);
    }

    public void quitarElemento(Object elemento) {
        elementos.remove(elemento);
    }

    public void actualizarElemento(int posicion, Object nuevoElemento) {
        elementos.set(posicion, nuevoElemento);
    }
    
    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        for (Object objeto : elementos) {
            resultado.append(objeto).append("\n");
        }
        return resultado.toString();
    }
}
