package com.mycompany.editorgrafico;

public class Circulo implements Figura {
    private int radio;

    public Circulo(int radio) {
        this.radio = radio;
    }

    public int getRadio() {
        return this.radio;
    }

    @Override
    public void create() {
        int diametro = this.radio * 2;
        int centro = this.radio;

        for (int i = 0; i <= diametro; i++) {
            for (int j = 0; j <= diametro; j++) {
                double distanciaCentro = Math.hypot(i - centro, j - centro);
                if (Math.abs(distanciaCentro - this.radio) < 0.5) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
