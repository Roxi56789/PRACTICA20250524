import java.util.ArrayList;   // Necesario para la clase encapsulada
import java.util.Arrays;      // Necesario para Arrays.copyOf en la clase encapsulada
import java.util.Scanner;     // Necesario para la entrada de usuario en el main

// CLASE ENCAPSULADA (GestorMatrizArticulos)
class GestorMatrizArticulos {
    // Atributo privado: La matriz de artículos.
    private String[][] articulos;
    private int filas;
    private int columnas;

    // Constructor: Inicializa la matriz con las dimensiones dadas
    public GestorMatrizArticulos(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.articulos = new String[filas][columnas];
    }

    // Método "setter": Permite establecer un artículo en una posición específica de la matriz.
    public void setArticulo(int fila, int columna, String articulo) {
        if (fila >= 0 && fila < this.filas && columna >= 0 && columna < this.columnas) {
            if (articulo != null && !articulo.trim().isEmpty()) {
                this.articulos[fila][columna] = articulo.trim();
            } else {
                System.err.println("Advertencia: El artículo en [" + (fila + 1) + "][" + (columna + 1) + "] no puede estar vacío. Se omitirá.");
            }
        } else {
            System.err.println("Error: Intento de establecer artículo en posición inválida [" + (fila + 1) + "][" + (columna + 1) + "].");
        }
    }

    // Método "getter": Devuelve la matriz completa con sus filas invertidas.
    public String[][] getMatrizFilasInvertidas() {
        String[][] matrizInvertida = new String[this.filas][this.columnas];

        // Copia las filas en orden inverso a la nueva matriz
        for (int i = 0; i < this.filas; i++) {
            matrizInvertida[i] = Arrays.copyOf(this.articulos[this.filas - 1 - i], this.columnas);
        }
        return matrizInvertida;
    }

    // Getters para las dimensiones (aunque no se usan en el main que me diste, son buenas prácticas)
    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }
}

// CLASE PRINCIPAL (Ejercicio5ArticulosInvertidos)
public class Ejercicio5ArticulosInvertidos { // Nombre del archivo principal

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Dimensiones de la matriz para este ejercicio
        int numFilas = 3;
        int numColumnas = 3;

        // 1. Creación de objeto y asignación del estado inicial
        GestorMatrizArticulos miGestor = new GestorMatrizArticulos(numFilas, numColumnas);

        // CORRECCIÓN DEL ERROR AQUÍ: Usando concatenación de cadenas en Java, no f-string de Python
        System.out.println("Por favor, ingresa " + (numFilas * numColumnas) + " nombres de artículos para una matriz de " + numFilas + "x" + numColumnas + ":");

        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                String articuloIngresado;
                while (true) {
                    System.out.print("Ingresa el artículo para la posición [" + (i + 1) + "][" + (j + 1) + "]: ");
                    articuloIngresado = scanner.nextLine(); // Leer toda la línea

                    if (!articuloIngresado.trim().isEmpty()) {
                        // 2. Asignación del estado usando el método setArticulo
                        miGestor.setArticulo(i, j, articuloIngresado); 
                        break; // Salir del bucle while si la entrada es válida
                    } else {
                        System.out.println("El nombre del artículo no puede estar vacío. Por favor, inténtalo de nuevo.");
                    }
                }
            }
        }

        System.out.println("\n--- Contenido de la Matriz con Filas Invertidas ---");
        // 3. Obtener los datos de las propiedades
        String[][] matrizInvertida = miGestor.getMatrizFilasInvertidas(); // Obtenemos la matriz invertida

        // Imprimir la matriz invertida
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                System.out.print(matrizInvertida[i][j] + "\t"); // Usamos \t para tabulación
            }
            System.out.println(); // Salto de línea al final de cada fila
        }

        scanner.close(); // Cierra el objeto Scanner
    }
}