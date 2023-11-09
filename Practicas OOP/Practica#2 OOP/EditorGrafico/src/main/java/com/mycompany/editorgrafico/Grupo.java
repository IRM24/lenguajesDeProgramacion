package com.mycompany.editorgrafico;

import java.util.ArrayList;
import java.util.List;

class Grupo implements Figura {
    private List<Figura> objetos;

    public Grupo() {
        this.objetos = new ArrayList<>();
    }

    public void anadir(Figura objeto) {
        this.objetos.add(objeto);
    }

    @Override
    public void create() {
        for (Figura objeto : this.objetos) {
            objeto.create();
        }
    }
}
