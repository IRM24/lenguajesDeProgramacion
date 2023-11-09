package com.mycompany.editorgrafico;

class Texto implements Figura {
    private String Texto;

    public Texto(String Texto) {
        this.Texto = Texto;
    }

    public String getTexto() {
        return Texto;
    }

    public void setContenido(String Texto) {
        this.Texto = Texto;
    }

    @Override
    public void create() {
        System.out.println(this.Texto);
    }
}
