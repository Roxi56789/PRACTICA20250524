public class Persona {

    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private double peso;
    private double talla;

  public Persona (){}
  public Persona (String pNombre, String pApellido, int pEdad, String pGenero, double pPeso, double pTalla){
    nombre = pNombre;
    apellido = pApellido;
    edad = pEdad;
    genero = pGenero;
    peso = pPeso;
    talla = pTalla;
  }
    public String getNombre()
    {
        return nombre;
    }

    public String getApellido()
    {
        return apellido;
    }
    public int getEdad()
    {
        return edad;
    }
    public String getGenero()
    {
        return genero;
    }
    public double getPeso()
    {
        return peso;
    }
    public double getTalla()
    {
        return talla;
    }
    public void setNombre(String pNombre)
    {
        nombre = pNombre;
    }
    public void setApellido(String pApellido)
    {
        apellido = pApellido;
    }
    public void setEdad(int pEdad)
    {
        edad = pEdad;
    }
    public void setGenero(String pGenero)
    {
        genero = pGenero;
    }
    public void setPeso(double pPeso)
    {
        peso = pPeso;
    }
    public void setTalla(double pTalla)
    {
        talla = pTalla;
    }


}
