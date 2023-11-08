package com.mycompany.ejercicio1oop;

public class Ejercicio1OOP {

    public static void main(String[] args) {

        Planificador miPlanificador = new Planificador();
        Planificador otroPlanificador = new Planificador();

        PersonaDeNegocios contactoEmpresarial1 = new PersonaDeNegocios("Alejandro Perez", "San Jose, Costa Rica", "Gerente de Proyecto");
        PersonaDeNegocios contactoEmpresarial2 = new PersonaDeNegocios("Carolina Solis", "Heredia, Costa Rica", "Líder de Equipo");

        PersonaPersonal contactoPersonal1 = new PersonaPersonal("Luisa Soto", "Cartago, Costa Rica", "Mejor Amiga");
        PersonaPersonal contactoPersonal2 = new PersonaPersonal("Carlos Vargas", "Alajuela, Costa Rica", "Primo");

        ActividadEmpresarial eventoEmpresarial1 = new ActividadEmpresarial("Presentación de Producto", "8/30/2020", "Centro de Convenciones");
        ActividadEmpresarial eventoEmpresarial2 = new ActividadEmpresarial("Reunión de Equipo", "2/5/2022", "Sala de Conferencias");

        ActividadPersonal eventoPersonal1 = new ActividadPersonal("Cumpleaños de Ana", "7/2/2020", "Casa de Ana");
        ActividadPersonal eventoPersonal2 = new ActividadPersonal("Cena con Amigos", "7/5/2022", "Restaurante Italiano");

        miPlanificador.añadirElemento(contactoEmpresarial1);
        miPlanificador.añadirElemento(contactoPersonal2);
        miPlanificador.añadirElemento(eventoEmpresarial1);
        miPlanificador.añadirElemento(eventoPersonal1);

        otroPlanificador.añadirElemento(contactoEmpresarial2);
        otroPlanificador.añadirElemento(contactoPersonal1);
        otroPlanificador.añadirElemento(eventoPersonal2);
        otroPlanificador.añadirElemento(eventoEmpresarial2);

        System.out.println("Mi Planificador:");
        System.out.println(miPlanificador);

        System.out.println("Otro Planificador:");
        System.out.println(otroPlanificador);

        PersonaPersonal nuevoContactoPersonal = new PersonaPersonal("María Fernández", "San José, Costa Rica", "Hermana");
        miPlanificador.actualizarElemento(0, nuevoContactoPersonal);

        otroPlanificador.quitarElemento(eventoPersonal2);

        ActividadEmpresarial nuevoEventoEmpresarial = new ActividadEmpresarial("Conferencia de Ventas", "5/23/2022", "Hotel Marriott");
        miPlanificador.añadirElemento(nuevoEventoEmpresarial);

        System.out.println("Mi Planificador Mod:");
        System.out.println(miPlanificador);

        System.out.println("Otro Planificador Mod:");
        System.out.println(otroPlanificador);
    }
}
