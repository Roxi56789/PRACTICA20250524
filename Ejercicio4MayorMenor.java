import java.util.ArrayList;   // Necesario para la lista dinámica en EstadisticasNumericas
import java.util.Collections; // Necesario para Collections.max y Collections.min en EstadisticasNumericas
import java.util.Scanner;     // Necesario para la entrada de usuario en el main

// CLASE ENCAPSULADA (EstadisticasNumericas) - Esta parte debe estar en el mismo archivo
class EstadisticasNumericas {
    // Atributo privado: La lista de números solo es accesible desde dentro de esta clase
    private ArrayList<Double> numeros; // Usamos Double para permitir números con decimales

    // Constructor: Se llama cuando se crea un objeto EstadisticasNumericas
    public EstadisticasNumericas() {
        this.numeros = new ArrayList<>(); // Inicializa la lista vacía
    }

    // Método "setter": Permite agregar un número a la lista encapsulada.
    // Esto es cómo tu 'main' "asigna el estado" (los números) al objeto.
    public void setNumero(double numero) {
        this.numeros.add(numero);
    }

    // Método "getter": Devuelve el mayor valor de los números ingresados.
    // Esto es cómo tu 'main' "obtiene los datos" sobre el mayor valor.
    public double getMayorValor() {
        if (numeros.isEmpty()) {
            // Manejo de error si no hay números.
            // Para este ejercicio, asumimos que se ingresarán números,
            // pero es buena práctica tener esta verificación.
            // Puedes lanzar una excepción si prefieres un manejo de error más estricto.
            System.err.println("Advertencia: No hay números en la lista para determinar el mayor valor. Devolviendo 0.0.");
            return 0.0; // O Double.NaN, Double.MIN_VALUE, etc.
        }
        return Collections.max(numeros); // Utiliza el método max de la clase Collections
    }

    // Método "getter": Devuelve el menor valor de los números ingresados.
    // Esto es cómo tu 'main' "obtiene los datos" sobre el menor valor.
    public double getMenorValor() {
        if (numeros.isEmpty()) {
            // Manejo de error si no hay números.
            System.err.println("Advertencia: No hay números en la lista para determinar el menor valor. Devolviendo 0.0.");
            return 0.0; // O Double.NaN, Double.MAX_VALUE, etc.
        }
        return Collections.min(numeros); // Utiliza el método min de la clase Collections
    }

    // Getter para saber cuántos números se han procesado en total
    public int getCantidadTotalNumeros() {
        return numeros.size();
    }
}

// CLASE PRINCIPAL (Ejercicio4MayorMenor)
public class Ejercicio4MayorMenor { // Nombre del archivo principal

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Aquí no declaramos ArrayList<Double> numeros;
        // En su lugar, creamos una instancia de nuestra clase encapsulada:
        EstadisticasNumericas miEstadisticas = new EstadisticasNumericas(); // Creación del objeto

        System.out.println("Por favor, ingresa 5 números cualquiera (enteros o decimales):");

        for (int i = 0; i < 5; i++) {
            double numeroIngresado;
            while (true) {
                System.out.print("Ingresa el número " + (i + 1) + ": ");
                if (scanner.hasNextDouble()) { // Verifica si la próxima entrada es un número (entero o decimal)
                    numeroIngresado = scanner.nextDouble();
                    // Usamos el método setNumero() de nuestra clase encapsulada para "asignar" el número
                    miEstadisticas.setNumero(numeroIngresado); // Asignación del estado
                    break;
                } else {
                    System.out.println("Entrada inválida. Por favor, ingresa un número válido.");
                    scanner.next(); // Consumir la entrada inválida
                }
            }
        }

        System.out.println("\n--- Mayor y Menor Valor ---");
        // Solo intentamos obtener el mayor y menor si realmente se ingresaron números
        if (miEstadisticas.getCantidadTotalNumeros() > 0) {
            // Usamos los métodos getter de nuestra clase encapsulada para "obtener" los resultados
            System.out.println("El mayor valor ingresado es: " + miEstadisticas.getMayorValor()); // Obtener datos
            System.out.println("El menor valor ingresado es: " + miEstadisticas.getMenorValor()); // Obtener datos
        } else {
            System.out.println("No se ingresaron números para determinar el mayor y el menor.");
        }

        scanner.close();
    }
}