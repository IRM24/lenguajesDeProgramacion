package com.mycompany.laboratorio4ian;

import GUI.Load;
import java.util.List;
import javax.swing.JOptionPane;

public class Laboratorio4Ian {

    public static void main(String[] args) {
    GrupoPlanificaciones grupo = new GrupoPlanificaciones();
    grupo.agregarPlanificador(new Planificador());
    Planificador planificador = grupo.getPlanificador().get(0);
   
    String mensaje = "Planificador Inicialmente Vacio, Cargar Datos una vez, seleccionar que datos anadir a la agenda y luego subir y cargar el planificador";

    JOptionPane.showMessageDialog(null, mensaje);
    
    Load frmInicio = new Load();
    frmInicio.setVisible(true);
}

}
