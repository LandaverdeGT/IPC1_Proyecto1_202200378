package clases;

import tableModels.TableModelsDoctores;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Administrador extends Usuario{
    private String nombre;
    public static List<Doctor> doctores;
    public static List<Paciente> pacientes;
    public static List<Producto> productos;
    public static List<String> especialidades;

    public Administrador(String nombreUsuario, String contrasena, String nombre) {
        super(nombreUsuario, contrasena);
        this.nombre = nombre;
        doctores = new ArrayList<>();
        productos = new ArrayList<>();
        pacientes = new ArrayList<>();
        especialidades = new ArrayList<>();
    }
    public static void agregarDoctores(Doctor doctor) {
        doctores.add(doctor);
        especialidades.add(doctor.getEspecialidad());
        JOptionPane.showMessageDialog(null,"El Doctor se ha agregado");
    }
    public static void agregarPacientes(Paciente paciente){
        pacientes.add(paciente);
        JOptionPane.showMessageDialog(null,"El Paciente se ha agregado");
    }
    public static void agregarProductos(Producto producto){
        productos.add(producto);
        JOptionPane.showMessageDialog(null,"El Producto se ha agregado");
    }


    public boolean autenticarDoctor(String codigo, String contrasena) {
        for (Doctor doctor : doctores) {
            if (doctor.getCodigo().equals(codigo) && doctor.getContrasena().equals(contrasena)) {
                return true;
            }
        }
        return false;
    }
    public boolean autenticarPaciente(String codigo, String contrasena){
        for (Paciente paciente : pacientes){
            if (paciente.getCodigo().equals(codigo) && paciente.getContrasena().equals(contrasena)){
                return true;
            }
        }
        return false;
    }
}
