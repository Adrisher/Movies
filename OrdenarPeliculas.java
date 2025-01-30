import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


class Movies {
    private String titulo;
    private int anioLanzamiento;
    private String genero;

  
    public Movies(String titulo, int anioLanzamiento, String genero) {
        this.titulo = titulo;
        this.anioLanzamiento = anioLanzamiento;
        this.genero = genero;
    }

    
    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    // Método para mostrar los datos de la película
    @Override
    public String toString() {
        return anioLanzamiento + " - " + titulo + " (" + genero + ")";
    }
}

// Clase principal
public class OrdenarPeliculas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Movies> listaPeliculas = solicitarPeliculas(scanner);
        
        
        System.out.println("\nSeleccione el orden de las películas:");
        System.out.println("1. Ascendente (del más antiguo al más reciente)");
        System.out.println("2. Descendente (del más reciente al más antiguo)");
        System.out.print("Opción: ");
        int opcionOrden = scanner.nextInt();

        
        ordenarPeliculas(listaPeliculas, opcionOrden);
        
      
        mostrarPeliculasOrdenadas(listaPeliculas);
        
        scanner.close();
    }

    // Método para solicitar películas al usuario
    private static List<Movies> solicitarPeliculas(Scanner scanner) {
        List<Movies> listaPeliculas = new ArrayList<>();
        int cantidad = 0;

        // Validar la cantidad ingresada
        while (true) {
            try {
                System.out.print("Ingrese la cantidad de películas a registrar: ");
                cantidad = Integer.parseInt(scanner.nextLine());
                if (cantidad > 0) break;
                System.out.println("⚠️ Ingrese un número válido mayor que 0.");
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Entrada inválida. Ingrese un número entero.");
            }
        }

    // Entrada de datos
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\nPelícula #" + (i + 1));

            System.out.print("Título: ");
            String titulo = scanner.nextLine();

            int anio = 0;
            while (true) {
                try {
                    System.out.print("Año de lanzamiento: ");
                    anio = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Ingrese un año válido.");
                }
            }

            System.out.print("Género: ");
            String genero = scanner.nextLine();

            listaPeliculas.add(new Movies(titulo, anio, genero));
        }
        return listaPeliculas;
    }

    // Método para ordenar películas
    private static void ordenarPeliculas(List<Movies> listaPeliculas, int opcionOrden) {
        if (opcionOrden == 2) {
            
            listaPeliculas.sort(Comparator.comparing(Movies::getAnioLanzamiento).reversed());
        } else {
            
            listaPeliculas.sort(Comparator.comparing(Movies::getAnioLanzamiento));
        }
    }

    // Método para mostrar las películas ordenadas
    private static void mostrarPeliculasOrdenadas(List<Movies> listaPeliculas) {
        System.out.println("\n Lista de películas ordenadas:");
        for (Movies p : listaPeliculas) {
            System.out.println(p);
        }
    }
}


/*
 Ingrese la cantidad de películas a registrar: 3

Película #1
Título: Interstellar
Año de lanzamiento: 2014
Género: Ciencia Ficción

Película #2
Título: ¿Conoces a Joe Black?
Año de lanzamiento: 1997
Género: Romance

Película #3
Título: Rapidos y Furiosos
Año de lanzamiento: 2010
Género: Ciencia Ficción

Seleccione el orden de las películas:
1. Ascendente (del más antiguo al más reciente)
2. Descendente (del más reciente al más antiguo)
Opción: 2

Lista de películas ordenadas:
2014 - Interstellar (Ciencia Ficción)
2010 - Inception (Ciencia Ficción)
1997 - Titanic (Romance)
 
 
 */