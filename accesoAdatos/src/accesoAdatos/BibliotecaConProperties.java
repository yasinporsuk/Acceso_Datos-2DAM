package accesoAdatos;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class BibliotecaConProperties {
    public static void main(String[] args) {
        // Crear una colección de libros
        ArrayList<Libro> libros = new ArrayList<>();
        libros.add(new Libro("1984", "George Orwell", "978-0451524935"));
        libros.add(new Libro("Cien Años de Soledad", "Gabriel García Márquez", "978-0060883287"));
        libros.add(new Libro("El Quijote", "Miguel de Cervantes", "978-8491050480"));

        // Guardar los libros en un archivo usando Properties
        guardarLibrosConProperties(libros);

        // Recuperar los libros desde el archivo
        ArrayList<Libro> librosRecuperados = cargarLibrosConProperties();
        System.out.println("Libros recuperados:");
        librosRecuperados.forEach(System.out::println);
    }

    // Método para guardar la colección de libros en un archivo usando Properties
    public static void guardarLibrosConProperties(ArrayList<Libro> libros) {
        Properties properties = new Properties();

        // Iterar por la lista de libros
        for (int i = 0; i < libros.size(); i++) {
            Libro libro = libros.get(i);
            // Guardar cada atributo del libro usando un prefijo para identificar el libro por su índice
            properties.setProperty("libro." + i + ".titulo", libro.getTitulo());
            properties.setProperty("libro." + i + ".autor", libro.getAutor());
            properties.setProperty("libro." + i + ".isbn", libro.getIsbn());
        }

        try (FileOutputStream out = new FileOutputStream("libros.properties")) {
            // Guardar las propiedades en un archivo de texto
            properties.store(out, "Colección de libros");
            System.out.println("Libros guardados en libros.properties.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar la colección de libros desde un archivo usando Properties
    public static ArrayList<Libro> cargarLibrosConProperties() {
        Properties properties = new Properties();
        ArrayList<Libro> libros = new ArrayList<>();

        try (FileInputStream in = new FileInputStream("libros.properties")) {
            // Cargar las propiedades desde el archivo
            properties.load(in);
            int i = 0;

            // Reconstruir cada libro mientras existan propiedades para libros
            while (properties.containsKey("libro." + i + ".titulo")) {
                String titulo = properties.getProperty("libro." + i + ".titulo");
                String autor = properties.getProperty("libro." + i + ".autor");
                String isbn = properties.getProperty("libro." + i + ".isbn");

                // Crear un nuevo libro y añadirlo a la lista
                libros.add(new Libro(titulo, autor, isbn));
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return libros;
    }
}
