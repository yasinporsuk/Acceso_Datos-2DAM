package accesoAdatos;

import java.util.Properties;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Reto1 {
    public static void main(String[] args) {
        // Crear un objeto Properties
        Properties properties = new Properties();

        // Agregar pares clave/valor
        properties.setProperty("usuario", "yasin");
        properties.setProperty("correo", "yasin@porsuk.com");
        properties.setProperty("edad", "20");

        // Guardar en ficheros
        saveProperties(properties);
        
        // Cargar y mostrar propiedades desde ficheros
        loadProperties();
    }

    // Método para guardar las propiedades en ficheros
    public static void saveProperties(Properties properties) {
        try (FileOutputStream fileOut = new FileOutputStream("config.properties");
             FileOutputStream xmlOut = new FileOutputStream("config.xml")) {

            // Guardar en archivo de texto
            properties.store(fileOut, "Propiedades de usuario");

            // Guardar en archivo XML
            properties.storeToXML(xmlOut, "Propiedades de usuario en XML");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar las propiedades desde los ficheros
    public static void loadProperties() {
        Properties loadedProps = new Properties();

        try (FileInputStream fileIn = new FileInputStream("config.properties");
             FileInputStream xmlIn = new FileInputStream("config.xml")) {

            // Cargar desde archivo de texto
            loadedProps.load(fileIn);
            System.out.println("Propiedades cargadas desde config.properties:");
            loadedProps.forEach((key, value) -> System.out.println(key + ": " + value));

            // Cargar desde archivo XML
            loadedProps.loadFromXML(xmlIn);
            System.out.println("Propiedades cargadas desde config.xml:");
            loadedProps.forEach((key, value) -> System.out.println(key + ": " + value));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
