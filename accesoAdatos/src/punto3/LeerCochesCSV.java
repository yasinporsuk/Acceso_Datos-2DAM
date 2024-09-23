package punto3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeerCochesCSV {
    public static void main(String[] args) {
        ArrayList<Coche> cochesRecuperados = cargarCochesDesdeCSV("coches.csv");
        System.out.println("Coches recuperados:");
        for (Coche coche : cochesRecuperados) {
            System.out.println(coche);
        }
    }

    public static ArrayList<Coche> cargarCochesDesdeCSV(String nombreArchivo) {
        ArrayList<Coche> coches = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            // Leer la primera línea (cabecera)
            String linea = reader.readLine();

            // Leer las siguientes líneas (datos)
            while ((linea = reader.readLine()) != null) {
                // Separar los valores por coma
                String[] datos = linea.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

                // Si el modelo estaba entre comillas, removemos las comillas
                String marca = datos[0];
                String modelo = datos[1].replaceAll("\"", "");
                int anio = Integer.parseInt(datos[2]);

                coches.add(new Coche(marca, modelo, anio));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return coches;
    }
}

