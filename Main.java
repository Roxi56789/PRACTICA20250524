public class Main {
public static void main(String[] args) {
        // Creo objetos de cada clase derivada
        Automovil auto = new Automovil("Toyota", "Corolla");
        Barco barco = new Barco("Yamaha", "WaveRunner");
        Avion avion = new Avion("Boeing", "747");

        // Llamo al método moverse de cada uno (polimorfismo)
        auto.moverse();
        barco.moverse();
        avion.moverse();
    }
}

// Clase principal Vehiculo con encapsulamiento
class Vehiculo {
    private String marca;
    private String modelo;

    // Constructor
    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    // Getters y setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    // Método que será sobrescrito en clases hijas
    public void moverse() {
        System.out.println("El vehículo se está moviendo");
    }
}

// Clase Automovil que hereda de Vehiculo y sobrescribe moverse()
class Automovil extends Vehiculo {
    public Automovil(String marca, String modelo) {
        super(marca, modelo);
    }

    @Override
    public void moverse() {
        System.out.println("El automóvil " + getMarca() + " " + getModelo() + " está circulando por la carretera");
    }
}

// Clase Barco que hereda de Vehiculo y sobrescribe moverse()
class Barco extends Vehiculo {
    public Barco(String marca, String modelo) {
        super(marca, modelo);
    }

    @Override
    public void moverse() {
        System.out.println("El barco " + getMarca() + " " + getModelo() + " está navegando por el agua");
    }
}

// Clase Avion que hereda de Vehiculo y sobrescribe moverse()
class Avion extends Vehiculo {
    public Avion(String marca, String modelo) {
        super(marca, modelo);
    }

    @Override
    public void moverse() {
        System.out.println("El avión " + getMarca() + " " + getModelo() + " está volando en el cielo");
    }
}
