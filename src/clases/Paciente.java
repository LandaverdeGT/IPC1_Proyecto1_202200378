package clases;

import java.util.ArrayList;
import java.util.List;

public class Paciente extends Usuario{

    private String nombres;
    private String apellidos;
    private String edad;
    private String sexo;
    public static List<Historial> historiales;

    public Paciente(String codigo, String contrasena, String nombres, String apellidos, String edad, String sexo) {
        super(codigo, contrasena);
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.sexo = sexo;
        historiales = new ArrayList<>();
    }

    public static void agregarHistorial(Historial historial){
        historiales.add(historial);
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
