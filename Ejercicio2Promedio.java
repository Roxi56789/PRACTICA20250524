import java.util.ArrayList; // Necesario para la lista dinámica
import java.util.Scanner; // Necesario para la entrada de usuario

// Clase que encapsula la colección de números y la lógica de cálculo del promedio
class CalculadoraDePromedio {
    // Atributo privado: La lista de números solo es accesible dentro de esta clase
    private ArrayList<Integer> numeros;

    // Constructor: Se llama cuando se crea un objeto CalculadoraDePromedio
    public CalculadoraDePromedio() {
        this.numeros = new ArrayList<>(); // Inicializa la lista vacía
    }

    // Método "setter" (mutador): Permite agregar un número a la lista encapsulada.
    // Esto es cómo "asignamos el estado" (los números) al objeto.
    public void setNumero(int numero) {
        this.numeros.add(numero);
    }

    // Método "getter" (accesador): Calcula y devuelve el promedio de los números.
    // Esto es cómo "obtenemos los datos de las propiedades" (el promedio calculado).
    public double getPromedio() {
        if (numeros.isEmpty()) {
            return 0.0; // Para evitar división por cero si la lista está vacía
        }
        double suma = 0;
        for (int num : numeros) {
            suma += num;
        }
        return suma / numeros.size();
    }

    // Un "getter" adicional para saber cuántos números se han ingresado.
    // Útil para controlar el bucle en el método main.
    public int getCantidadDeNumeros() {
        return numeros.size();
    }
}

public class Ejercicio2Promedio { // Nombre del archivo principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 1. Creación de objeto y asignación del estado inicial
        // Similar a: Persona obj = new Persona();
        CalculadoraDePromedio miCalculadora = new CalculadoraDePromedio();

        System.out.println("Por favor, ingresa 5  números enteros:");

        for (int i = 0; i < 5; i++) {
            int numeroIngresado;
            while (true) { // Bucle para asegurar que la entrada sea un entero válido
                System.out.print("Ingresa el número entero " + (i + 1) + ": ");
                if (scanner.hasNextInt()) { // Verifica si la próxima entrada es un entero
                    numeroIngresado = scanner.nextInt();
                    // 2. Asignación del estado usando el método setNumero
                    // Similar a: obj.setPeso(60.5);
                    miCalculadora.setNumero(numeroIngresado); 
                    break; // Salir del bucle while si la entrada es válida
                } else {
                    System.out.println("Entrada inválida. Por favor, ingresa un número entero válido.");
                    scanner.next(); // Consume la entrada inválida para evitar un bucle infinito
                }
            }
        }

        // 3. Obtener los datos de las propiedades
        // Similar a: System.out.println("Nombre: " + obj.getNombre());
        if (miCalculadora.getCantidadDeNumeros() > 0) {
            double promedioFinal = miCalculadora.getPromedio(); // Obtenemos el promedio
            System.out.printf("\nEl promedio de los números ingresados es: %.2f%n", promedioFinal);
        } else {
            System.out.println("No se ingresaron números para calcular el promedio.");
        }

        scanner.close(); // Cierra el objeto Scanner
    }
}
