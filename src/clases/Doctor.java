package clases;

import java.util.ArrayList;
import java.util.List;

public class Doctor extends Usuario{
    private String nombres;
    private String apellidos;
    private String especialidad;
    private String genero;
    private String telefono;
    private String edad;

    public static List<Cita> citas;
    public Doctor(String codigo, String contrasena, String nombres, String apellidos, String especialidad, String genero, String telefono, String edad) {
        super(codigo, contrasena);
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.especialidad = especialidad;
        this.genero = genero;
        this.telefono = telefono;
        this.edad = edad;
        citas = new ArrayList<>();
    }

    public static void agregarCita(Cita cita){
        citas.add(cita);
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
}
