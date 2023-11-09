package com.mycompany.planificadorsingelton;

public class PatronDiseno {

    
    
    public static void main(String[] args) {
        PlanificadorS miPlanificador = PlanificadorS.getInstance();
        Factory factory = new FactoryBuild();

        PersonaS contactoEmpresarial1 = factory.crearContacto("Alejandro Perez", "San Jose, Costa Rica", "empresarial", "Gerente de Proyecto");
        PersonaS contactoEmpresarial2 = factory.crearContacto("Carolina Solis", "Heredia, Costa Rica", "empresarial", "Líder de Equipo");
        PersonaS contactoPersonal1 = factory.crearContacto("Luisa Soto", "Cartago, Costa Rica", "personal", "Mejor Amiga");
        PersonaS contactoPersonal2 = factory.crearContacto("Carlos Vargas", "Alajuela, Costa Rica", "personal", "Primo");
        ActividadS eventoEmpresarial1 = factory.crearEvento("Presentación de Producto", "8/30/2020", "empresarial", "Centro de Convenciones");
        ActividadS eventoEmpresarial2 = factory.crearEvento("Reunión de Equipo", "2/5/2022", "empresarial", "Sala de Conferencias");
        ActividadS eventoPersonal1 = factory.crearEvento("Cumpleaños de Ana", "7/2/2020", "personal", "Casa de Ana");
        ActividadS eventoPersonal2 = factory.crearEvento("Cena con Amigos", "7/5/2022", "personal", "Restaurante Italiano");

        miPlanificador.añadirElemento(contactoEmpresarial1);
        miPlanificador.añadirElemento(contactoPersonal2);
        miPlanificador.añadirElemento(eventoEmpresarial1);
        miPlanificador.añadirElemento(eventoPersonal1);

        System.out.println("Agenda");
        System.out.println(miPlanificador);

        // Modificar elementos
        PersonaS nuevoContactoPersonal = factory.crearContacto("María Fernández", "San José, Costa Rica", "personal", "Hermana");
        miPlanificador.actualizarElemento(0, nuevoContactoPersonal);

        miPlanificador.quitarElemento(eventoPersonal2);

        ActividadS nuevoEventoEmpresarial = factory.crearEvento("Conferencia de Ventas", "5/23/2022", "empresarial", "Hotel Marriott");
        miPlanificador.añadirElemento(nuevoEventoEmpresarial);

        // Mostrar el planificador modificado
        System.out.println("Agenda Modificada");
        System.out.println(miPlanificador);
    }
}
