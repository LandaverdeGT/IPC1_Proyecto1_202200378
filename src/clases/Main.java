package clases;

import interfaces.InterfazLogin;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static Administrador admin = new Administrador("1", "12", "admin");

    public static void main(String[] args) {

        Administrador.agregarDoctores(new Doctor("01","1234","Kevin", "Catun","Card","M", "502","32"));
        Administrador.agregarPacientes(new Paciente("2022","1234","Juan Daniel","Carranza López",
                "34","Masculino"));
        SwingUtilities.invokeLater(() ->{
            InterfazLogin interfazIniciarSesion = new InterfazLogin();
            interfazIniciarSesion.setVisible(true);
        });
    }
}