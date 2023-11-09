package com.mycompany.editorgrafico;

public class Elipse implements Figura {
    private int semiejeMayor;
    private int semiejeMenor;

    public Elipse(int semiejeMayor, int semiejeMenor) {
        this.semiejeMayor = semiejeMayor;
        this.semiejeMenor = semiejeMenor;
    }

    public int getSemiejeMayor() {
        return this.semiejeMayor;
    }

    public int getSemiejeMenor() {
        return this.semiejeMenor;
    }

    @Override
    public void create() {
        int altura = semiejeMayor * 2;
        int anchura = semiejeMenor * 2;
        int centroAltura = semiejeMayor;
        int centroAnchura = semiejeMenor;

        for (int i = 0; i <= altura; i++) {
            for (int j = 0; j <= anchura; j++) {
                double distanciaCentro = Math.pow((i - centroAltura) * 1.0 / semiejeMayor, 2)
                                       + Math.pow((j - centroAnchura) * 1.0 / semiejeMenor, 2);

                if (distanciaCentro <= 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}

