public class EjemploEncapsulamiento {
    public static void main(String[] args)
    {
        //creación de objeto y asignación del estado inicial
        Persona obj = new Persona();
        obj.setGenero("Masculino");
        obj.setNombre("Cayetano");
        obj.setPeso(60.5);
        obj.setTalla(1.5);
        obj.setApellido("Angulo");
        obj.setEdad(60);

        //obtener los datos de las propiedades
        System.out.println("Nombre: " + obj.getNombre());
        System.out.println("Apellido: " + obj.getApellido());
        System.out.println("Edad: " + obj.getEdad());
        System.out.println("Género: " + obj.getGenero());
        System.out.println("Peso: " + obj.getPeso());
        System.out.println("Estatura: " + obj.getTalla());
    }
}