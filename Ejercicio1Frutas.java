// Ejercicio1Frutas.java
import java.util.Scanner;
import java.util.ArrayList; // ArrayList es más flexible que un array fijo

public class Ejercicio1Frutas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> frutas = new ArrayList<>();

        System.out.println("Por favor, ingresa 10 nombres de frutas:");

        for (int i = 0; i < 10; i++) {
            String fruta;
            while (true) {
                System.out.print("Ingresa la fruta número " + (i + 1) + ": ");
                fruta = scanner.nextLine().trim();

                if (!fruta.isEmpty()) {
                    frutas.add(fruta);
                    break;
                } else {
                    System.out.println("El nombre de la fruta no puede estar vacío. Por favor, inténtalo de nuevo.");
                }
            }
        }

        System.out.println("\n--- Frutas en orden inverso ---");
        for (int i = frutas.size() - 1; i >= 0; i--) {
            System.out.println(frutas.get(i));
        }

        scanner.close();
    }
}
