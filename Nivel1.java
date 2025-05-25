import java.util.Scanner;

public class Nivel1 {

    public int puntaje;
    private String respuesta;
    private final String[] animales;
    private final Scanner ent;

    public Nivel1() {
        puntaje = 0;
        ent = new Scanner(System.in);
        animales = new String[2];
        animales[0] = "Perro";
        animales[1] = "Gato";
    }

    private void puntajePerro()
     {
        if(respuesta.equals(animales[0]))
        {
            System.out.println("Correcto! Haz ganado 10 puntos");
            puntaje+= 10;
            
        }
        else
        {
            System.out.println("Incorrecto! La respuesta correcta es: " + animales[1]);
            System.out.println("Haz perdido 5 puntos");
            puntaje-= 5;

        }
    }
        public void imprimePreguntas(){
        {
            System.out.println("¿Es un animal que ladra y come troquetas?");
            respuesta = ent.nextLine();
            puntajePerro();
            
        }

    }
}
