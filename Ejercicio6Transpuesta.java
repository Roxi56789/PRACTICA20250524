import java.util.Scanner; // Necesario para la entrada de usuario

// CLASE ENCAPSULADA (OperacionesMatriz)
// Esta clase NO DEBE ESTAR EN UN ARCHIVO SEPARADO para evitar el error si no se compilan juntos.
// Debe estar DENTRO del mismo archivo que Ejercicio6Transpuesta.java.
class OperacionesMatriz {
    // Atributos privados: La matriz original y sus dimensiones
    private double[][] matrizOriginal;
    private int filas;
    private int columnas;

    // Constructor: Inicializa la matriz con las dimensiones dadas
    public OperacionesMatriz(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.matrizOriginal = new double[filas][columnas];
    }

    // Método "setter": Permite establecer un valor en una posición específica de la matriz.
    public void setValor(int fila, int columna, double valor) {
        // Validar que la posición esté dentro de los límites de la matriz
        if (fila >= 0 && fila < this.filas && columna >= 0 && columna < this.columnas) {
            this.matrizOriginal[fila][columna] = valor;
        } else {
            System.err.println("Error: Intento de establecer valor en posición inválida [" + (fila + 1) + "][" + (columna + 1) + "].");
        }
    }

    // Método "getter": Devuelve la matriz original.
    public double[][] getMatrizOriginal() {
        // Devolvemos la referencia directa para este ejercicio.
        return this.matrizOriginal;
    }

    // Método "getter": Calcula y devuelve la matriz transpuesta.
    public double[][] getMatrizTranspuesta() {
        double[][] matrizTranspuesta = new double[this.columnas][this.filas]; // Dimensiones invertidas

        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++) {
                matrizTranspuesta[j][i] = this.matrizOriginal[i][j]; // Intercambio de filas por columnas
            }
        }
        return matrizTranspuesta;
    }

    // Método auxiliar para imprimir cualquier matriz (útil para original y transpuesta)
    public void imprimirMatriz(double[][] matriz, String titulo) {
        System.out.println("\n--- " + titulo + " ---");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + "\t"); // Usamos \t para tabulación
            }
            System.out.println(); // Salto de línea al final de cada fila
        }
    }

    // Getters para las dimensiones (aunque no se usan directamente en el main que me diste para este ejercicio, son buenas prácticas)
    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }
}

// CLASE PRINCIPAL (Ejercicio6Transpuesta)
public class Ejercicio6Transpuesta { // Nombre del archivo principal

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Dimensiones de la matriz para este ejercicio (ej. 3x3)
        int numFilas = 3;
        int numColumnas = 3;

        // 1. Creación de objeto y asignación del estado inicial
        OperacionesMatriz miMatriz = new OperacionesMatriz(numFilas, numColumnas);

        System.out.println("Por favor, ingresa " + (numFilas * numColumnas) + " valores numéricos para una matriz de " + numFilas + "x" + numColumnas + ":");

        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                double valorIngresado;
                while (true) {
                    System.out.print("Ingresa el valor para la posición [" + (i + 1) + "][" + (j + 1) + "]: ");
                    if (scanner.hasNextDouble()) {
                        valorIngresado = scanner.nextDouble();
                        // 2. Asignación del estado usando el método setValor
                        miMatriz.setValor(i, j, valorIngresado); 
                        break; // Salir del bucle while si la entrada es válida
                    } else {
                        System.out.println("Entrada inválida. Por favor, ingresa un valor numérico válido.");
                        scanner.next(); // Consumir la entrada inválida
                    }
                }
            }
        }

        // 3. Obtener los datos de las propiedades y mostrarlos
        double[][] original = miMatriz.getMatrizOriginal();
        double[][] transpuesta = miMatriz.getMatrizTranspuesta();

        // Usamos el método auxiliar de la clase encapsulada para imprimir
        miMatriz.imprimirMatriz(original, "Matriz Original");
        miMatriz.imprimirMatriz(transpuesta, "Matriz Transpuesta");

        scanner.close(); // Cierra el objeto Scanner
    }
}