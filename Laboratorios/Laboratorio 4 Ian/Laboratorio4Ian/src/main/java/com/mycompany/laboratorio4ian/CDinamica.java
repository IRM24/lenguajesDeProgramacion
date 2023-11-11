package com.mycompany.laboratorio4ian;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CDinamica {

    public static List<String> ClaseHeredaName(String packageName, Class<?> superClase) throws ClassNotFoundException, URISyntaxException {
        List<String> nombresElementos = new ArrayList<>();
        String path = packageName.replace('.', '/');
        URL resource = getDato(path);

        if (resource != null) {
            File directory = getPath(resource);
            if (directory != null) {
                nombresElementos.addAll(ClaseName(directory, packageName, superClase));
            }
        }

        return nombresElementos;
    }

    private static URL getDato(String path) {
        return Thread.currentThread().getContextClassLoader().getResource(path);
    }

    private static File getPath(URL resource) throws URISyntaxException {
        File directory = new File(resource.toURI());
        if (directory.exists() && directory.isDirectory()) {
            return directory;
        }
        return null;
    }

    private static List<String> ClaseName(File directory, String packageName, Class<?> superClase) throws ClassNotFoundException {
        List<String> nombresClases = new ArrayList<>();
        for (File file : directory.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".class")) {
                String className = file.getName().replace(".class", "");
                nombresClases.addAll(addSuperHeredada(packageName, className, superClase));
            }
        }
        return nombresClases;
    }

    private static List<String> addSuperHeredada(String packageName, String className, Class<?> superClase) throws ClassNotFoundException {
        List<String> nombres = new ArrayList<>();
        Class<?> clazz = Class.forName(packageName + "." + className);
        if (superClase.isAssignableFrom(clazz) && !superClase.equals(clazz)) {
            nombres.add(className);
        }
        return nombres;
    }

    public static List<String> ClasNamePckg(String packageName) throws URISyntaxException {
        String path = packageName.replace('.', '/');
        URL resource = Thread.currentThread().getContextClassLoader().getResource(path);
        List<String> nombresClases = new ArrayList<>();

        if (resource != null) {
            File directory = new File(resource.toURI());
            if (directory.exists() && directory.isDirectory()) {
                for (File file : directory.listFiles()) {
                    if (file.isFile() && file.getName().endsWith(".class")) {
                        String className = file.getName().replace(".class", "");
                        nombresClases.add(className);
                    }
                }
            }
        }

        return nombresClases;
    }
}