package com.mycompany.sistemabiblioteca;

import static com.mycompany.sistemabiblioteca.Libro.mostrarEstadoLibros;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SistemaBiblioteca {

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(101, "Juan Pérez", "San José, Costa Rica");
        Cliente cliente2 = new Cliente(102, "Ana Sánchez", "Heredia, Costa Rica");
        Cliente cliente3 = new Cliente(103, "Luis Rodríguez", "Cartago, Costa Rica");
        
        Libro libro1 = new Libro(201, "La Aventura del Saber", "María González");
        Libro libro2 = new Libro(202, "El Secreto de la Montaña", "Carlos López");
        Libro libro3 = new Libro(203, "Viaje al Pasado", "Isabel Torres");
        Libro libro4 = new Libro(204, "Luces en la Oscuridad", "Luisa Martínez");
        Libro libro5 = new Libro(205, "El Misterio del Tiempo", "Andrés García");
        Libro libro6 = new Libro(206, "La Llave del Conocimiento", "Elena Vargas");
        Libro libro7 = new Libro(207, "Aventuras en la Selva", "Diego Rojas");

        LinkedList<Cliente> clientes = new LinkedList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        
        LinkedList<Libro> libros = new LinkedList<>();
        libros.add(libro1);
        libros.add(libro2);
        //libros add(libro3);
        libros.add(libro4);
        libros.add(libro5);
        libros.add(libro6);
        libros.add(libro7);
        
        
        System.out.println("Ejemplos de tomar prestado y devolver libros");
        cliente1.tomarPrestado(libro3);
        cliente2.tomarPrestado(libro7);
        cliente2.tomarPrestado(libro4);
        cliente3.tomarPrestado(libro5);
        cliente3.tomarPrestado(libro6);
        cliente3.tomarPrestado(libro2);
        cliente3.tomarPrestado(libro1);
  
        cliente1.devolver(libro3);
        cliente2.devolver(libro7);
            
        
        System.out.println("\nEstado de los libros en la biblioteca:");
        mostrarEstadoLibros(libros);

        List<Cliente> clientesConNombresLargos = filtrarClientesConNombreLargo(clientes, 10);

        System.out.println("Clientes con nombres largos (10 caracteres o más):");
        for (Cliente cliente : clientesConNombresLargos) {
        System.out.println(cliente.getNombre());
        }
    }

    public static List<Cliente> filtrarClientesConNombreLargo(LinkedList<Cliente> clientes, int longitudMinima) {
    return clientes.stream().filter(c -> c.getNombre().length() >= longitudMinima).collect(Collectors.toList());
}

}
