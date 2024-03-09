package interfaces;

import clases.Administrador;
import clases.Main;

import javax.swing.*;

public class InterfazLogin extends JFrame {
    Administrador admin = Main.admin;

    public InterfazLogin(){
        initComponents();
    }

    public void initComponents(){
        setTitle("Login");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);


        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(250,90,50,25);
        add(lblCodigo);

        JTextField txtCodigo = new JTextField();
        txtCodigo.setBounds(350,90,300,25);
        add(txtCodigo);

        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(250,150,100,25);
        add(lblContrasena);

        JPasswordField txtContrasena = new JPasswordField();
        txtContrasena.setBounds(350,150,300,25);
        add(txtContrasena);

        JButton btnLogin = new JButton("Iniciar Sesión");
        btnLogin.setBounds(430, 250, 150, 25);
        add(btnLogin);

        btnLogin.addActionListener(e -> {
            String codigo = txtCodigo.getText();
            String contrasena = new String(txtContrasena.getPassword());

            if (admin.autenticar(codigo, contrasena)){
                //JOptionPane.showMessageDialog(this,"Inicio de Sesión Correcto");
                SwingUtilities.invokeLater(() -> {
                    VistaAdministrador vistaAdministrador = new VistaAdministrador(Administrador.doctores);
                    vistaAdministrador.setVisible(true);
                });
            }else{
                JOptionPane.showMessageDialog(this, "Inicio de Sesión Fallido");
            }
        });

        JLabel logoUsac = new JLabel();
        logoUsac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/R.png")));
        logoUsac.setBounds(10,50,200,200);
        add(logoUsac);

        JLabel fondo = new JLabel();
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/fondo1.jpg")));
        fondo.setBounds(0,0,2000,1000);
        add(fondo);



    }
}
