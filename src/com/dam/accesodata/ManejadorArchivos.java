package com.dam.accesodata;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class ManejadorArchivos {
    private static final String ARCHIVO = "resources/notas_estudiantes.txt";
    private static final List<Estudiante> estudiantes = new ArrayList<>();

    public void cargarBaseDatos(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO));
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                estudiantes.add(new Estudiante(partes[0],Double.parseDouble(partes[1])));
            }
        }catch (IOException e){
            System.out.println("Error al cargar la base de datos: "+e.getMessage());
        }

    }
    public void añadirEstudiante(Estudiante estudiante) {
// TODO: Implementar la lógica para añadir un estudiante al archivo
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(ARCHIVO),true);
            writer.println(estudiante.toString());
            estudiantes.add(estudiante);
            writer.close();
        }catch (IOException e){
            e.getMessage();
        }
    }
    public void mostrarEstudiantes() {
// TODO: Implementar la lógica para mostrar todos los estudiantes del archivo
        int indice = 0;
        for (Estudiante estudiante : estudiantes) {
            System.out.println(indice+"- "+estudiante.toString());
            indice++;
        }
    }
    public void buscarEstudiante(String nombre) {
// TODO: Implementar la lógica para buscar un estudiante en el archivo
        List<Estudiante> estudiantesConNombre = new ArrayList<>();
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNombre().equalsIgnoreCase(nombre)){
                estudiantesConNombre.add(estudiante);
            }
        }
        if (estudiantesConNombre.isEmpty()){
            System.out.println("No hay ningún estudiante de nombre: "+nombre);
        }else {
            int indice = 0;
            for (Estudiante estudiante : estudiantesConNombre) {
                System.out.println(indice+"- "+estudiante.toString());
                indice++;
            }
        }
    }
    public void calcularMedia() {
// TODO: Implementar la lógica para calcular la nota media de todos los estudiantes
        double contador = 0;
        for (Estudiante estudiante : estudiantes){
            contador+=estudiante.getNota();
        }
        if (estudiantes.isEmpty()){
            System.out.println("No hay ningún estudiante");
        }else{
            System.out.println("La nota media es: "+contador/estudiantes.size());
            System.out.println("De "+estudiantes.size()+" estudiantes");
        }
    }
    private List<Estudiante> leerEstudiantes() {
// TODO: Implementar la lógica para leer todos los estudiantes del archivo
        return estudiantes;
    }
}
