package interfaces;

import clases.Administrador;
import clases.Doctor;
import tableModels.TableModelsDoctores;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VistatCrearDoctor extends JFrame {
    int contadorCodigo = 0;
    TableModelsDoctores tableModelsDoctores;

    VistatCrearDoctor(TableModelsDoctores tableModelsDoctores){
        initComponents();
        this.tableModelsDoctores = tableModelsDoctores;
    }

    public void initComponents(){
        setTitle("Crear Doctor");
        setSize(1200, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(null);


        JLabel lblNombreDoctor = new JLabel("Nombres:*");
        lblNombreDoctor.setBounds(40,25,80,25);
        add(lblNombreDoctor);

        JTextField txtNombres = new JTextField();
        txtNombres.setBounds(140,25,400,25);
        add(txtNombres);

        JLabel lblApellidos = new JLabel("Apellidos:*");
        lblApellidos.setBounds(40,60,80,25);
        add(lblApellidos);

        JTextField txtApellidos = new JTextField();
        txtApellidos.setBounds(140,60,400,25);
        add(txtApellidos);

        JLabel lblEspecialidad = new JLabel("Especialidad:*");
        lblEspecialidad.setBounds(40,95,100,25);
        add(lblEspecialidad);

        JTextField txtEspecialidad = new JTextField();
        txtEspecialidad.setBounds(140,95,400,25);
        add(txtEspecialidad);

        JLabel lblGenero = new JLabel("Género:*");
        lblGenero.setBounds(40,130,60,25);
        add(lblGenero);

        String[] rellenoCbx = {"Masculino", "Femenino"};
        JComboBox<String> cbxGenero = new JComboBox<>(rellenoCbx);
        cbxGenero.setBounds(140,130,100,25);
        add(cbxGenero);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(600,25,60,25);
        add(lblTelefono);

        JTextField txtTelefono = new JTextField();
        txtTelefono.setBounds(700, 25,400,25);
        add(txtTelefono);

        JLabel lblEdad = new JLabel("Edad:*");
        lblEdad.setBounds(600,60,80,25);
        add(lblEdad);

        JTextField txtEdad = new JTextField();
        txtEdad.setBounds(700,60,400,25);
        add(txtEdad);

        JLabel lblContrasena = new JLabel("Contraseña:*");
        lblContrasena.setBounds(600,95,100,25);
        add(lblContrasena);

        JTextField txtContrasena = new JTextField();
        txtContrasena.setBounds(700,95,400,25);
        add(txtContrasena);

        JLabel lblAdvertencia = new JLabel("Campos Obligatorios (*)");
        lblAdvertencia.setBounds(500,400,500,25);
        add(lblAdvertencia);

        JButton btnAgregarDoctor = new JButton("Crear Doctor");
        btnAgregarDoctor.setBackground(Color.CYAN);
        btnAgregarDoctor.setBounds(950,200,150,30);
        add(btnAgregarDoctor);

        btnAgregarDoctor.addActionListener(e -> {
            contadorCodigo+=1;
            String digitoContador = "DOC00"+Integer.toString(contadorCodigo);
            if (digitoContador.isBlank() || txtContrasena.getText().isBlank() || txtNombres.getText().isBlank()
            || txtApellidos.getText().isBlank() || txtEspecialidad.getText().isBlank() || cbxGenero.getSelectedItem().toString().isBlank()
            || txtEdad.getText().isBlank()){
                JOptionPane.showMessageDialog(this,"Llene todos los campos obligatorios","Error",JOptionPane.ERROR_MESSAGE);
            }else {
                tableModelsDoctores.agregarDoctor(digitoContador, txtContrasena.getText(), txtNombres.getText(), txtApellidos.getText(),
                        txtEspecialidad.getText(), cbxGenero.getSelectedItem().toString(), txtTelefono.getText(), txtEdad.getText());
            }
        });

        JLabel fondo = new JLabel();
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/fondo1.jpg")));
        fondo.setBounds(0,0,2000,1000);
        add(fondo);

    }
}
