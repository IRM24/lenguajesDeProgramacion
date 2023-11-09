package com.mycompany.editorgrafico;

public class Cuadrado implements Figura {
    private int lado;

    public Cuadrado(int lado) {
        this.lado = lado;
    }

    public int getLado() {
        return this.lado;
    }

    @Override
    public void create() {
        for (int i = 0; i < lado; i++) {
            for (int j = 0; j < lado; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

