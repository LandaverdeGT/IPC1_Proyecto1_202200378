package interfaces;

import clases.Doctor;

import javax.swing.*;
import java.awt.*;

import static clases.Administrador.doctores;


public class ValidacionDoctor extends JFrame {
    ValidacionDoctor(){
        initComponents();
    }

    public void initComponents(){
        setTitle("Validación");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(null);

        JLabel lblIcono = new JLabel();
        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/advertencia.png")));
        lblIcono.setBounds(50,78,100,100);
        add(lblIcono);

        JLabel lblMensaje = new JLabel("Ingrese el Código del Doctor que");
        lblMensaje.setFont(new Font("Tahoma",Font.BOLD,15));
        lblMensaje.setBounds(175,100,300,20);
        add(lblMensaje);

        JLabel lblMensaje2 = new JLabel("Desea Actualizar sus Datos");
        lblMensaje2.setFont(new Font("Tahoma",Font.BOLD,15));
        lblMensaje2.setBounds(175,135,300,20);
        add(lblMensaje2);

        JTextField txtCodigoNuevoDoctor = new JTextField();
        txtCodigoNuevoDoctor.setBounds(140,250,230,35);
        add(txtCodigoNuevoDoctor);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(Color.LIGHT_GRAY);
        btnCancelar.setBounds(130,310,100,25);
        add(btnCancelar);

        btnCancelar.addActionListener(e -> {
            this.setVisible(false);
        });

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setBackground(Color.LIGHT_GRAY);
        btnAceptar.setBounds(280,310,100,25);
        add(btnAceptar);

        btnAceptar.addActionListener(e -> {
            String codigoBuscado = txtCodigoNuevoDoctor.getText();
            boolean doctorEncontrado = false;
            do {
                for (Doctor doctor : doctores) {
                    if (codigoBuscado.equals(doctor.getCodigo())) {
                        VistaActualizarDoctor vistaActualizarDoctor = new VistaActualizarDoctor(codigoBuscado);
                        vistaActualizarDoctor.setVisible(true);
                        setLocationRelativeTo(null);
                        this.setVisible(false);
                        doctorEncontrado = true;
                        break;
                    }else{
                        doctorEncontrado=false;
                    }
                }
                if (!doctorEncontrado){
                    JOptionPane.showMessageDialog(this,"El Doctor No Existe");
                    break;
                }
            }while (doctorEncontrado!=true);

        });


        JLabel fondo = new JLabel();
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/fondo1.jpg")));
        fondo.setBounds(0,0,1000,1000);
        add(fondo);
    }
}
