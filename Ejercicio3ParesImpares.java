import java.util.ArrayList; // Necesario para la lista dinámica
import java.util.Scanner; // Necesario para la entrada de usuario

// CLASE ENCAPSULADA (AnalizadorNumeros.java) - ¡Esta parte debe estar en el mismo archivo!
class AnalizadorNumeros {
    // Atributos privados: Los datos internos solo son accesibles desde dentro de esta clase
    private ArrayList<Integer> numeros;
    private int cantidadPares;
    private int cantidadImpares;

    // Constructor: Se llama cuando se crea un objeto AnalizadorNumeros
    public AnalizadorNumeros() {
        this.numeros = new ArrayList<>(); // Inicializa la lista vacía
        this.cantidadPares = 0;           // Inicializa el contador de pares
        this.cantidadImpares = 0;         // Inicializa el contador de impares
    }

    // Método "setter" (mutador): Permite agregar un número y actualiza los contadores.
    // Esto es cómo tu 'main' "asigna el estado" (los números) al objeto AnalizadorNumeros.
    public void setNumero(int numero) {
        this.numeros.add(numero); // Añade el número a la lista interna
        if (numero % 2 == 0) {
            this.cantidadPares++;   // Incrementa pares si es par
        } else {
            this.cantidadImpares++; // Incrementa impares si es impar
        }
    }

    // Método "getter" (accesador): Devuelve la cantidad de números pares contados.
    // Esto es cómo tu 'main' "obtiene los datos" sobre los números pares.
    public int getCantidadPares() {
        return cantidadPares;
    }

    // Método "getter" (accesador): Devuelve la cantidad de números impares contados.
    // Esto es cómo tu 'main' "obtiene los datos" sobre los números impares.
    public int getCantidadImpares() {
        return cantidadImpares;
    }

    // Un "getter" adicional para saber cuántos números se han procesado en total
    public int getCantidadTotalNumeros() {
        return numeros.size();
    }
}

// CLASE PRINCIPAL (Ejercicio3ParesImpares.java)
public class Ejercicio3ParesImpares { // Nombre del archivo principal

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Aquí no declaramos ArrayList<Integer> numeros;
        // En su lugar, creamos una instancia de nuestra clase encapsulada:
        AnalizadorNumeros miAnalizador = new AnalizadorNumeros(); // Creación del objeto

        System.out.println("Por favor, ingresa 5 números enteros:");

        for (int i = 0; i < 5; i++) {
            int numeroIngresado;
            while (true) {
                System.out.print("Ingresa el número entero " + (i + 1) + ": ");
                if (scanner.hasNextInt()) {
                    numeroIngresado = scanner.nextInt();
                    // Usamos el método setNumero() de nuestra clase encapsulada para "asignar" el número
                    miAnalizador.setNumero(numeroIngresado); // Asignación del estado
                    break;
                } else {
                    System.out.println("Entrada inválida. Por favor, ingresa un número entero válido.");
                    scanner.next(); // Consumir la entrada inválida
                }
            }
        }

        System.out.println("\n--- Conteo de Números Pares e Impares ---");
        // Usamos los métodos getter de nuestra clase encapsulada para "obtener" los resultados
        System.out.println("Cantidad de números pares: " + miAnalizador.getCantidadPares()); // Obtener datos
        System.out.println("Cantidad de números impares: " + miAnalizador.getCantidadImpares()); // Obtener datos

        scanner.close();
    }
}