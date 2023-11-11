package com.mycompany.laboratorio4ian;

import java.util.ArrayList;
import java.util.List;

public class GrupoPlanificaciones {
    private static List<Planificador> planificador = new ArrayList<>();

    public GrupoPlanificaciones() {
    }

    public static List<Planificador> getPlanificador() {
        return planificador;
    }
    

    public void agregarPlanificador(Planificador plan) {
        planificador.add(plan);
    }

}
