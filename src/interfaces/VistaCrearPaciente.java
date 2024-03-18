package interfaces;

import clases.Administrador;
import clases.Paciente;
import tableModels.TableModelPacientes;

import javax.swing.*;
import java.awt.*;

public class VistaCrearPaciente extends JFrame {
    TableModelPacientes tableModelPacientes;
    int contadorCodigoP = 0;
    VistaCrearPaciente(TableModelPacientes tableModelPacientes){

        initComponents();
        this.tableModelPacientes = tableModelPacientes;
    }

    public void initComponents(){
        setTitle("Crear Paciente");
        setSize(1200, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(null);

        JLabel lblNombrePaciente = new JLabel("Nombres:*");
        lblNombrePaciente.setBounds(40,25,80,25);
        add(lblNombrePaciente);

        JTextField txtNombres = new JTextField();
        txtNombres.setBounds(140,25,400,25);
        add(txtNombres);

        JLabel lblApellidos = new JLabel("Apellidos:*");
        lblApellidos.setBounds(40,60,80,25);
        add(lblApellidos);

        JTextField txtApellidos = new JTextField();
        txtApellidos.setBounds(140,60,400,25);
        add(txtApellidos);

        JLabel lblGenero = new JLabel("Género:*");
        lblGenero.setBounds(40,95,60,25);
        add(lblGenero);

        String[] rellenoCbx = {"Masculino", "Femenino"};
        JComboBox<String> cbxGenero = new JComboBox<>(rellenoCbx);
        cbxGenero.setBounds(140,95,100,25);
        add(cbxGenero);

        JLabel lblEdad = new JLabel("Edad:*");
        lblEdad.setBounds(600,25,60,25);
        add(lblEdad);

        JTextField txtEdad = new JTextField();
        txtEdad.setBounds(700,25,400,25);
        add(txtEdad);

        JLabel lblContrasena = new JLabel("Contraseña:*");
        lblContrasena.setBounds(600,60,100,25);
        add(lblContrasena);

        JTextField txtContrasena = new JTextField();
        txtContrasena.setBounds(700,60,400,25);
        add(txtContrasena);

        JLabel lblAdvertencia = new JLabel("Campos obligatorios (*)");
        lblAdvertencia.setBounds(500,400,500,25);
        add(lblAdvertencia);

        JButton btnAgregarPaciente = new JButton("Crear Paciente");
        btnAgregarPaciente.setBackground(Color.CYAN);
        btnAgregarPaciente.setBounds(950,200,150,30);
        add(btnAgregarPaciente);

        btnAgregarPaciente.addActionListener(e -> {
            contadorCodigoP+=1;
            String digitoContador = "PAC00"+Integer.toString(contadorCodigoP);
            if (digitoContador.isBlank() || txtNombres.getText().isBlank() || txtApellidos.getText().isBlank() || txtEdad.getText().isBlank()
            || txtContrasena.getText().isBlank()){
                JOptionPane.showMessageDialog(this,"Por favor complete los campos obligatorios","Error",JOptionPane.ERROR_MESSAGE);
            }else {
                tableModelPacientes.agregarPaciente(digitoContador, txtContrasena.getText(), txtNombres.getText(), txtApellidos.getText(),
                        txtEdad.getText(), cbxGenero.getSelectedItem().toString());
            }
        });

        JLabel fondo = new JLabel();
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/fondo1.jpg")));
        fondo.setBounds(0,0,2000,1000);
        add(fondo);

    }
}
