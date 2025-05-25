import java.util.Scanner; // Necesario para la entrada de usuario

// CLASE ENCAPSULADA (OperacionesMatrices)
// Esta clase debe estar en el mismo archivo que Ejercicio7SumaMatrices.java
// para que el compilador la encuentre.
class OperacionesMatrices {
    // Atributos privados: Las dos matrices y sus dimensiones
    private double[][] matriz1;
    private double[][] matriz2;
    private int filas;
    private int columnas;

    // Constructor: Inicializa las matrices con las dimensiones dadas
    public OperacionesMatrices(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.matriz1 = new double[filas][columnas];
        this.matriz2 = new double[filas][columnas];
    }

    // Método "setter": Permite establecer un valor en la primera matriz.
    public void setValorMatriz1(int fila, int columna, double valor) {
        if (fila >= 0 && fila < this.filas && columna >= 0 && columna < this.columnas) {
            this.matriz1[fila][columna] = valor;
        } else {
            System.err.println("Error: Intento de establecer valor en Matriz 1 en posición inválida [" + (fila + 1) + "][" + (columna + 1) + "].");
        }
    }

    // Método "setter": Permite establecer un valor en la segunda matriz.
    public void setValorMatriz2(int fila, int columna, double valor) {
        if (fila >= 0 && fila < this.filas && columna >= 0 && columna < this.columnas) {
            this.matriz2[fila][columna] = valor;
        } else {
            System.err.println("Error: Intento de establecer valor en Matriz 2 en posición inválida [" + (fila + 1) + "][" + (columna + 1) + "].");
        }
    }

    // Método "getter": Devuelve la primera matriz original.
    public double[][] getMatriz1() {
        return this.matriz1;
    }

    // Método "getter": Devuelve la segunda matriz original.
    public double[][] getMatriz2() {
        return this.matriz2;
    }

    // Método "getter": Calcula y devuelve la matriz resultante de la suma.
    public double[][] getMatrizSuma() {
        double[][] matrizSuma = new double[this.filas][this.columnas];

        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++) {
                matrizSuma[i][j] = this.matriz1[i][j] + this.matriz2[i][j];
            }
        }
        return matrizSuma;
    }

    // Método auxiliar para imprimir cualquier matriz
    public void imprimirMatriz(double[][] matriz, String titulo) {
        System.out.println("\n--- " + titulo + " ---");
        // Verificar si la matriz está vacía para evitar errores de índice
        if (matriz.length == 0 || (matriz.length > 0 && matriz[0].length == 0)) { // Mejorado para matrices con 0 columnas
            System.out.println("Matriz vacía.");
            return;
        }
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

// CLASE PRINCIPAL (Ejercicio7SumaMatrices)
public class Ejercicio7SumaMatrices { // Nombre del archivo principal

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Dimensiones de las matrices para este ejercicio (ej. 2x2)
        int numFilas = 2;
        int numColumnas = 2;

        // 1. Creación de objeto y asignación del estado inicial
        OperacionesMatrices misMatrices = new OperacionesMatrices(numFilas, numColumnas);

        // --- Ingreso de valores para la Primera Matriz ---
        System.out.println("Por favor, ingresa " + (numFilas * numColumnas) + " valores numéricos para la PRIMERA matriz (" + numFilas + "x" + numColumnas + "):");
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                double valorIngresado;
                while (true) {
                    System.out.print("Matriz 1 - Ingresa el valor para [" + (i + 1) + "][" + (j + 1) + "]: ");
                    if (scanner.hasNextDouble()) {
                        valorIngresado = scanner.nextDouble();
                        // 2. Asignación del estado a la primera matriz usando el setter específico
                        misMatrices.setValorMatriz1(i, j, valorIngresado); 
                        break;
                    } else {
                        System.out.println("Entrada inválida. Por favor, ingresa un valor numérico válido.");
                        scanner.next(); // Consumir la entrada inválida
                    }
                }
            }
        }

        // --- Ingreso de valores para la Segunda Matriz ---
        System.out.println("\nPor favor, ingresa " + (numFilas * numColumnas) + " valores numéricos para la SEGUNDA matriz (" + numFilas + "x" + numColumnas + "):");
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                double valorIngresado;
                while (true) {
                    System.out.print("Matriz 2 - Ingresa el valor para [" + (i + 1) + "][" + (j + 1) + "]: ");
                    if (scanner.hasNextDouble()) {
                        valorIngresado = scanner.nextDouble();
                        // 2. Asignación del estado a la segunda matriz usando el setter específico
                        misMatrices.setValorMatriz2(i, j, valorIngresado); 
                        break;
                    } else {
                        System.out.println("Entrada inválida. Por favor, ingresa un valor numérico válido.");
                        scanner.next(); // Consumir la entrada inválida
                    }
                }
            }
        }
        scanner.nextLine(); // Importante: Consumir el salto de línea pendiente después de nextDouble()
                            // Esto evita que lea una cadena vacía en la siguiente llamada a nextLine() si hubiera una.

        // 3. Obtener los datos de las propiedades y mostrarlos
        double[][] matrizA = misMatrices.getMatriz1();
        double[][] matrizB = misMatrices.getMatriz2();
        double[][] matrizResultante = misMatrices.getMatrizSuma();

        // Usamos el método auxiliar de la clase encapsulada para imprimir
        misMatrices.imprimirMatriz(matrizA, "Matriz 1");
        misMatrices.imprimirMatriz(matrizB, "Matriz 2");
        misMatrices.imprimirMatriz(matrizResultante, "Matriz Resultante (Suma)");

        scanner.close(); // Cierra el objeto Scanner
    }
}