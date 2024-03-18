package interfaces;

import clases.Doctor;
import clases.Paciente;

import javax.swing.*;
import java.awt.*;

import static clases.Administrador.doctores;
import static clases.Administrador.pacientes;

public class VistaActualizarPaciente extends JFrame {
    VistaActualizarPaciente(String codigoBuscado){
        initComponents(codigoBuscado);
    }

    public void initComponents(String codigoBuscado){
        setTitle("Actualizar Paciente");
        setSize(1200, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(null);

        JLabel lblNombrePaciente = new JLabel("Nombres:*");
        lblNombrePaciente.setBounds(40,15,80,25);
        add(lblNombrePaciente);

        JTextField txtNombres = new JTextField();
        txtNombres.setBounds(140,15,400,25);
        add(txtNombres);

        JLabel lblApellidos = new JLabel("Apellidos:*");
        lblApellidos.setBounds(40,50,80,25);
        add(lblApellidos);

        JTextField txtApellidos = new JTextField();
        txtApellidos.setBounds(140,50,400,25);
        add(txtApellidos);

        JLabel lblEdad = new JLabel("Edad:*");
        lblEdad.setBounds(600,15,80,25);
        add(lblEdad);

        JTextField txtEdad = new JTextField();
        txtEdad.setBounds(700,15,400,25);
        add(txtEdad);

        JLabel lblContrasena = new JLabel("Contraseña:*");
        lblContrasena.setBounds(600,50,100,25);
        add(lblContrasena);

        JTextField txtContrasena = new JTextField();
        txtContrasena.setBounds(700,50,400,25);
        add(txtContrasena);

        JLabel lblAdvertencia = new JLabel("Campos Obligatorios (*)");
        lblAdvertencia.setBounds(600,400,500,25);
        add(lblAdvertencia);

        JButton btnActualizarPaciente = new JButton("Actualizar Datos");
        btnActualizarPaciente.setBackground(Color.LIGHT_GRAY);
        btnActualizarPaciente.setBounds(950,180,150,50);
        add(btnActualizarPaciente);

        btnActualizarPaciente.addActionListener(e -> {
            boolean pacienteEncontrado = false;
            do{
                if (txtNombres.getText().isBlank() || txtApellidos.getText().isBlank() || txtEdad.getText().isBlank()
                || txtContrasena.getText().isBlank()){
                    JOptionPane.showMessageDialog(this,"Por favor llene todos los campos obligatorios (*)");
                }else {
                    for (Paciente paciente : pacientes) {
                        if (paciente.getCodigo().equals(codigoBuscado)) {
                            paciente.setNombres(txtNombres.getText());
                            paciente.setApellidos(txtApellidos.getText());
                            paciente.setEdad(txtEdad.getText());
                            paciente.setContrasena(txtContrasena.getText());
                            pacienteEncontrado = true;
                            JOptionPane.showMessageDialog(this, "El Paciente se ha Actualizado");
                            break;
                        }
                    }
                    if (!pacienteEncontrado) {
                        JOptionPane.showMessageDialog(this, "El Paciente no Existe");
                        break;
                    }
                }
            }while (pacienteEncontrado!=true);
        });

        JLabel fondo1 = new JLabel();
        fondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/fondo1.jpg")));
        fondo1.setBounds(0,0,1200,500);
        add(fondo1);
    }
}
