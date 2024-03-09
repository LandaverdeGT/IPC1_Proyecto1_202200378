package interfaces;

import javax.swing.*;

public class VistaActualizarDoctor extends JFrame {
    VistaActualizarDoctor(){
        initComponents();
    }

    public void initComponents(){
        setTitle("Actualizar Doctor");
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


        JLabel fondo = new JLabel();
        fondo.setIcon(new javax.swing.ImageIcon("/recursos/fondo1.jpg"));
        fondo.setBounds(0,0,1200,500);
        add(fondo);
    }
}
