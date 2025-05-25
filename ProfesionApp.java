public class ProfesionApp {
public static void main(String[] args) {
        // Crear objetos
        Doctor doc = new Doctor("Ana", 2000.0, 3);
        Ingeniero ing = new Ingeniero("Carlos", 2500.0);

        // Mostrar sueldos
        doc.mostrarDatos();
        System.out.println("Sueldo total del doctor: $" + doc.calcularSueldo());

        System.out.println();

        ing.mostrarDatos();
        System.out.println("Sueldo total del ingeniero: $" + ing.calcularSueldo());
    }
}

// Interface llamada Profesion
interface Profesion {
    double calcularSueldo(); // método abstracto por defecto
}

// Clase Doctor que implementa la interface
class Doctor implements Profesion {
    private String nombre;
    private double sueldoBase;
    private int guardias;

    public Doctor(String nombre, double sueldoBase, int guardias) {
        this.nombre = nombre;
        this.sueldoBase = sueldoBase;
        this.guardias = guardias;
    }

    public void mostrarDatos() {
        System.out.println("Doctor: " + nombre);
        System.out.println("Guardias realizadas: " + guardias);
    }

    @Override
    public double calcularSueldo() {
        double pagoPorGuardia = 100.0;
        return sueldoBase + (guardias * pagoPorGuardia);
    }
}

// Clase Ingeniero que implementa la interface
class Ingeniero implements Profesion {
    private String nombre;
    private double sueldoBase;

    public Ingeniero(String nombre, double sueldoBase) {
        this.nombre = nombre;
        this.sueldoBase = sueldoBase;
    }

    public void mostrarDatos() {
        System.out.println("Ingeniero: " + nombre);
    }

    @Override
    public double calcularSueldo() {
        return sueldoBase;
    }
}
