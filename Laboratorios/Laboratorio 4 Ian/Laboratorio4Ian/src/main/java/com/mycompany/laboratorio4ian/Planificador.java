package com.mycompany.laboratorio4ian;

import java.util.List;
import java.util.LinkedList;

public class Planificador {
    private final List<Object> elementos;

    public Planificador() {
        elementos = new LinkedList<>();
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

