public class PersonalApp {

    public static void main(String[] args) {
        // Crear un objeto de tipo Empleado
        Empleado emp = new Empleado("Luis Torres", 25, 1500.0);

        // Llamar a los métodos
        emp.registrar();
        System.out.println("Sueldo: $" + emp.calcularSueldo());
    }
}

// Clase abstracta
abstract class Personal {
    private String nombre;
    private int edad;

    // Constructor
    public Personal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    // Métodos abstractos
    public abstract void registrar();
    public abstract double calcularSueldo();
}

// Clase que hereda de Personal
class Empleado extends Personal {
    private double salarioBase;

    // Constructor
    public Empleado(String nombre, int edad, double salarioBase) {
        super(nombre, edad);
        this.salarioBase = salarioBase;
    }

    // Implementación de registrar
    public void registrar() {
        System.out.println("Empleado registrado:");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Edad: " + getEdad());
    }

    // Implementación de calcularSueldo
    public double calcularSueldo() {
        return salarioBase;
    }
}
