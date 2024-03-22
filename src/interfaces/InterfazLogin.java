package interfaces;

import clases.Administrador;
import clases.Doctor;
import clases.Main;
import clases.Paciente;
import tableModels.TableModelPacientes;

import javax.swing.*;
import java.util.Objects;

import static clases.Administrador.*;

public class InterfazLogin extends JFrame {
    Administrador admin = Main.admin;
    private TableModelPacientes tableModelPacientes;
 boolean doctorEncontrado = false;
    public InterfazLogin(){
        initComponents();
        this.tableModelPacientes = new TableModelPacientes();
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

        JButton btnRegistrarse = new JButton("Registrate");
        btnRegistrarse.setBounds(350,250,100,25);
        add(btnRegistrarse);

        btnRegistrarse.addActionListener(e -> {
            VistaNuevoPaciente vistaNuevoPaciente = new VistaNuevoPaciente(tableModelPacientes);
            vistaNuevoPaciente.setVisible(true);
            vistaNuevoPaciente.setLocationRelativeTo(this);
        });


        JButton btnLogin = new JButton("Iniciar Sesión");
        btnLogin.setBounds(500, 250, 150, 25);
        add(btnLogin);

        btnLogin.addActionListener(e -> {
            String codigo = txtCodigo.getText();
            String contrasena = new String(txtContrasena.getPassword());
            for (Doctor doctor : doctores){
                if (doctor.getCodigo().equals(txtCodigo.getText()) && doctor.getContrasena().equals(txtContrasena.getPassword().toString())){
                   doctorEncontrado=true;
                }else{
                    doctorEncontrado=false;
                }
            }

            if (admin.autenticar(codigo, contrasena)){
                SwingUtilities.invokeLater(() -> {
                    VistaAdministrador vistaAdministrador = new VistaAdministrador(doctores,Administrador.pacientes, Administrador.productos);
                    vistaAdministrador.setVisible(true);
                });
            }else if (admin.autenticarDoctor(codigo,contrasena)){
                SwingUtilities.invokeLater(()->{
                    for (Doctor doctor : doctores){
                        if (codigo.equals(doctor.getCodigo()) && contrasena.equals(doctor.getContrasena())){
                            VistaDoctor vistaDoctor = new VistaDoctor(doctor);
                            vistaDoctor.setVisible(true);
                            vistaDoctor.setLocationRelativeTo(this);
                        }
                    }
                });
            } else if (admin.autenticarPaciente(codigo,contrasena)) {
                SwingUtilities.invokeLater(()->{
                    for (Paciente paciente : pacientes){
                        if (codigo.equals(paciente.getCodigo()) && contrasena.equals(paciente.getContrasena())){
                            VistaPaciente vistaPaciente = new VistaPaciente(especialidades,doctores,paciente,productos);
                            vistaPaciente.setVisible(true);
                            vistaPaciente.setLocationRelativeTo(this);
                        }
                    }
                });
            } else{
                JOptionPane.showMessageDialog(this, "Inicio de Sesión Fallido");
            }
        });

        JLabel logoUsac = new JLabel();
        logoUsac.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/R.png"))));
        logoUsac.setBounds(10,50,200,200);
        add(logoUsac);

        JLabel fondo = new JLabel();
        fondo.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/fondo1.jpg"))));
        fondo.setBounds(0,0,2000,1000);
        add(fondo);
    }
}
