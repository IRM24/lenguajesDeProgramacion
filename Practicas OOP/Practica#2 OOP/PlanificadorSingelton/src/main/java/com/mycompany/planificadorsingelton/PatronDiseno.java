package com.mycompany.planificadorsingelton;

public class PatronDiseno {

    /*
    PlanificadorS utiliza el enfoque de Lazy Initialization para crear la instancia 
    del planificador. La solicitud de instancia ocurre cuando se llama a getInstance(), y si no se ha creado una instancia previamente, 
    se crea y se devuelve esa instancia. Esta técnica retrasa la creación de la instancia hasta que sea requerida, optimizando el uso de recursos.
    Esta implementación sugiere que se crea la instancia del planificador solo cuando sea necesario.
    Lazy Singleton evita la inicialización temprana y conservar recursos.
    Siendo una aplicación de planificación donde los recursos pueden ser dinámicos y se accede a la instancia del planificador en 
    diferentes momentos del programa, el enfoque Lazy Singleton en este contexto es más eficiente.
    */
    
    
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


        PersonaS nuevoContactoPersonal = factory.crearContacto("María Fernández", "San José, Costa Rica", "personal", "Hermana");
        miPlanificador.actualizarElemento(0, nuevoContactoPersonal);

        miPlanificador.quitarElemento(eventoPersonal2);

        ActividadS nuevoEventoEmpresarial = factory.crearEvento("Conferencia de Ventas", "5/23/2022", "empresarial", "Hotel Marriott");
        miPlanificador.añadirElemento(nuevoEventoEmpresarial);


        System.out.println("Agenda Modificada");
        System.out.println(miPlanificador);
    }
}
