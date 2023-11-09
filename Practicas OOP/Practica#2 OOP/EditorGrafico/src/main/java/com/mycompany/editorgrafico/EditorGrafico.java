package com.mycompany.editorgrafico;

public class EditorGrafico {

    public static void main(String[] args) {
        Documento documento = new Documento();
        
        Hoja hoja1 = new Hoja();
        Hoja hoja2 = new Hoja();
        
        Circulo circulo1 = new Circulo(5);
        Circulo circulo2 = new Circulo(9);
        Elipse elipse1 = new Elipse(6,4);
        Elipse elipse2 = new Elipse(5,3);
        Cuadrado cuadrado1 = new Cuadrado(4);
        Cuadrado cuadrado2 = new Cuadrado(6);
        Texto texto1 = new Texto("Siguiriguidum");
        
        Grupo grupo1 = new Grupo();
        grupo1.anadir(circulo1);
        grupo1.anadir(elipse1);
        grupo1.anadir(cuadrado1);
        hoja1.anadir(grupo1);
        
        Grupo grupo2 = new Grupo();
        grupo2.anadir(circulo2);
        grupo2.anadir(elipse2);
        grupo2.anadir(cuadrado2);
        hoja2.anadir(grupo2);
        
        documento.anadir(hoja1);
        documento.anadir(hoja2);

        documento.imprimirDocumento();

    }
    }

