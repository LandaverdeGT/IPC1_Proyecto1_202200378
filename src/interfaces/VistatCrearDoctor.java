package interfaces;

import clases.Administrador;
import clases.Doctor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VistatCrearDoctor extends JFrame {
    int contadorCodigo = 0;
    VistatCrearDoctor(DefaultTableModel modeloTablaDoctores){
        initComponents(modeloTablaDoctores);
    }

    public void initComponents(DefaultTableModel modeloTablaDoctores){
        setTitle("Crear Doctor");
        setSize(1200, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(null);


        JLabel lblNombreDoctor = new JLabel("Nombres:");
        lblNombreDoctor.setBounds(40,25,60,25);
        add(lblNombreDoctor);

        JTextField txtNombres = new JTextField();
        txtNombres.setBounds(140,25,400,25);
        add(txtNombres);

        JLabel lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setBounds(40,60,60,25);
        add(lblApellidos);

        JTextField txtApellidos = new JTextField();
        txtApellidos.setBounds(140,60,400,25);
        add(txtApellidos);

        JLabel lblEspecialidad = new JLabel("Especialidad:");
        lblEspecialidad.setBounds(40,95,80,25);
        add(lblEspecialidad);

        JTextField txtEspecialidad = new JTextField();
        txtEspecialidad.setBounds(140,95,400,25);
        add(txtEspecialidad);

        JLabel lblGenero = new JLabel("Género:");
        lblGenero.setBounds(40,130,50,25);
        add(lblGenero);

        String[] rellenoCbx = {"Masculino", "Femenino"};
        JComboBox<String> cbxGenero = new JComboBox<>(rellenoCbx);
        cbxGenero.setBounds(140,130,80,25);
        add(cbxGenero);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(600,25,60,25);
        add(lblTelefono);

        JTextField txtTelefono = new JTextField();
        txtTelefono.setBounds(700, 25,400,25);
        add(txtTelefono);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(600,60,60,25);
        add(lblEdad);

        JTextField txtEdad = new JTextField();
        txtEdad.setBounds(700,60,400,25);
        add(txtEdad);

        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(600,95,80,25);
        add(lblContrasena);

        JTextField txtContrasena = new JTextField();
        txtContrasena.setBounds(700,95,400,25);
        add(txtContrasena);

        JButton btnAgregarDoctor = new JButton("Crear Doctor");
        btnAgregarDoctor.setBackground(Color.CYAN);
        btnAgregarDoctor.setBounds(950,200,150,30);
        add(btnAgregarDoctor);

        btnAgregarDoctor.addActionListener(e -> {
            contadorCodigo+=1;
            String digitoContador = "00"+Integer.toString(contadorCodigo);
            Administrador.agregarDoctores(new Doctor(digitoContador,txtContrasena.getText(),txtNombres.getText(), txtApellidos.getText(),
                    txtEspecialidad.getText(),cbxGenero.getSelectedItem().toString(),txtTelefono.getText(),txtEdad.getText()));
            modeloTablaDoctores.fireTableDataChanged();
        });
        JLabel fondo = new JLabel();
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/fondo1.jpg")));
        fondo.setBounds(0,0,2000,1000);
        add(fondo);

    }
}
