package com.mycompany.editorgrafico;

import java.util.LinkedList;
import java.util.List;

public class Documento {
    private List<Hoja> hojas;

    public Documento() {
        this.hojas = new LinkedList<>(); // Cambio aquí
    }

    public void anadir(Hoja hoja) {
        this.hojas.add(hoja);
    }

    public void imprimirDocumento() {
        for (Hoja hoja : hojas) {
            hoja.imprimirHoja();
        }
    }
}

