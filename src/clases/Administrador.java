package clases;

import java.util.ArrayList;
import java.util.List;

public class Administrador extends Usuario{
    private String nombre;
    public static List<Doctor> doctores = new ArrayList<>();
    public Administrador(String nombreUsuario, String contrasena, String nombre) {
        super(nombreUsuario, contrasena);
        this.nombre = nombre;
    }
    public static void agregarDoctores(Doctor doctor) {
        doctores.add(doctor);
    }
}
