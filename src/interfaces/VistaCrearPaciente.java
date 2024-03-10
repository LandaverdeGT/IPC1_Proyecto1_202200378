package interfaces;

import clases.Administrador;
import clases.Paciente;

import javax.swing.*;
import java.awt.*;

public class VistaCrearPaciente extends JFrame {
    int contadorCodigo = 0;
    VistaCrearPaciente(){
        initComponents();
    }

    public void initComponents(){
        setTitle("Crear Paciente");
        setSize(1200, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(null);


        JLabel lblNombrePaciente = new JLabel("Nombres:");
        lblNombrePaciente.setBounds(40,25,60,25);
        add(lblNombrePaciente);

        JTextField txtNombres = new JTextField();
        txtNombres.setBounds(140,25,400,25);
        add(txtNombres);

        JLabel lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setBounds(40,60,60,25);
        add(lblApellidos);

        JTextField txtApellidos = new JTextField();
        txtApellidos.setBounds(140,60,400,25);
        add(txtApellidos);

        JLabel lblGenero = new JLabel("Género:");
        lblGenero.setBounds(40,95,50,25);
        add(lblGenero);

        String[] rellenoCbx = {"Masculino", "Femenino"};
        JComboBox<String> cbxGenero = new JComboBox<>(rellenoCbx);
        cbxGenero.setBounds(140,95,100,25);
        add(cbxGenero);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(600,25,60,25);
        add(lblEdad);

        JTextField txtEdad = new JTextField();
        txtEdad.setBounds(700,25,400,25);
        add(txtEdad);

        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(600,60,80,25);
        add(lblContrasena);

        JTextField txtContrasena = new JTextField();
        txtContrasena.setBounds(700,60,400,25);
        add(txtContrasena);

        JButton btnAgregarPaciente = new JButton("Crear Paciente");
        btnAgregarPaciente.setBackground(Color.CYAN);
        btnAgregarPaciente.setBounds(950,200,150,30);
        add(btnAgregarPaciente);

        btnAgregarPaciente.addActionListener(e -> {
            contadorCodigo+=1;
            String digitoContador = "00"+Integer.toString(contadorCodigo);
            Administrador.agregarPacientes(new Paciente(digitoContador,txtContrasena.getText(),txtNombres.getText(),
                    txtApellidos.getText(),txtEdad.getText(),cbxGenero.getSelectedItem().toString()));
        });

        JLabel fondo = new JLabel();
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/fondo1.jpg")));
        fondo.setBounds(0,0,2000,1000);
        add(fondo);

    }
}
