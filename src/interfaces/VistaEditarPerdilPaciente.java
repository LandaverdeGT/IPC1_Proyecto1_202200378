package interfaces;

import clases.Paciente;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class VistaEditarPerdilPaciente extends JFrame {
    private Paciente pacienteActual;
    VistaEditarPerdilPaciente(Paciente paciente){
        initComponents(paciente);
    }
    public void initComponents(Paciente paciente){
        setTitle("Editar Perfil");
        setSize(1200, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pacienteActual = paciente;
        setLayout(null);

        JLabel lblNombres = new JLabel("Nombres: *");
        lblNombres.setBounds(50,50,80,25);
        add(lblNombres);

        JTextField txtNombres = new JTextField();
        txtNombres.setBounds(150,50,300,25);
        add(txtNombres);

        JLabel lblApellidos = new JLabel("Apellidos: *");
        lblApellidos.setBounds(50, 85, 80,25);
        add(lblApellidos);

        JTextField txtApellidos = new JTextField();
        txtApellidos.setBounds(150,85,300,25);
        add(txtApellidos);

        JLabel lblContrasena = new JLabel("Contraseña: *");
        lblContrasena.setBounds(50,120,300,25);
        add(lblContrasena);

        JTextField txtContrasena = new JTextField();
        txtContrasena.setBounds(150,120,300,25);
        add(txtContrasena);

        JLabel lblEdad = new JLabel("Edad: *");
        lblEdad.setBounds(50,155,300,25);
        add(lblEdad);

        JTextField txtEdad = new JTextField();
        txtEdad.setBounds(150,155,300,25);
        add(txtEdad);

        JButton btnActualizarPerfilPaciente = new JButton("Actualizar");
        btnActualizarPerfilPaciente.setBackground(Color.CYAN);
        btnActualizarPerfilPaciente.setBounds(1000,300,100,50);
        add(btnActualizarPerfilPaciente);

        btnActualizarPerfilPaciente.addActionListener(e -> {
            if (txtNombres.getText().isBlank() || txtApellidos.getText().isBlank() || txtContrasena.getText().isBlank() || txtEdad.getText().isBlank()){
                JOptionPane.showMessageDialog(this,"Por favor complete todos los campos de texto","ERROR",JOptionPane.ERROR_MESSAGE);
            }else {
                pacienteActual.setNombres(txtNombres.getText());
                pacienteActual.setApellidos(txtApellidos.getText());
                pacienteActual.setContrasena(txtContrasena.getText());
                pacienteActual.setEdad(txtEdad.getText());
                JOptionPane.showMessageDialog(this, "Se ha actualizado la información");
            }
        });

        JLabel advertencia = new JLabel("Campos Obligatorios (*)");
        advertencia.setBounds(550,400,100,25);

        JLabel fondo = new JLabel();
        fondo.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/fondo1.jpg"))));
        fondo.setBounds(0,0,2000,1000);
        add(fondo);
    }
}
