package com.mycompany.editorgrafico;

import java.util.ArrayList;
import java.util.List;

public class Hoja {
    private List<Figura> objetos;

    public Hoja() {
        this.objetos = new ArrayList<>();
    }

    public void anadir(Figura objeto) {
        this.objetos.add(objeto);
    }

    public void imprimirHoja() {
        for (Figura objeto : objetos) {
            objeto.create();
        }
    }
}
