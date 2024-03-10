package interfaces;

import clases.Doctor;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.List;

public class EliminarDoctorValidacion extends JFrame {
    EliminarDoctorValidacion(List<Doctor> doctores){
        initComponents(doctores);
        }

    public void initComponents(List<Doctor> doctores){
        setTitle("Eliminar Doctor");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(null);

        JLabel lblIconoError = new JLabel();
        lblIconoError.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/error-icon-4.png")));
        lblIconoError.setBounds(50,78,100,100);
        add(lblIconoError);

        JLabel lblMensaje = new JLabel("Ingrese el Código del Doctor");
        lblMensaje.setFont(new Font("Tahoma",Font.BOLD,15));
        lblMensaje.setBounds(175,100,300,20);
        add(lblMensaje);

        JLabel lblMensaje2 = new JLabel("que Desea Eliminar");
        lblMensaje2.setFont(new Font("Tahoma",Font.BOLD,15));
        lblMensaje2.setBounds(175,135,300,20);
        add(lblMensaje2);

        JTextField txtCodigoEliminar = new JTextField();
        txtCodigoEliminar.setBounds(140,250,230,35);
        add(txtCodigoEliminar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(Color.LIGHT_GRAY);
        btnCancelar.setBounds(130,310,100,25);
        add(btnCancelar);

        btnCancelar.addActionListener(e -> {
            this.setVisible(false);
        });

        JButton btnAceptarEliminar = new JButton("Aceptar");
        btnAceptarEliminar.setBackground(Color.LIGHT_GRAY);
        btnAceptarEliminar.setBounds(280,310,100,25);
        add(btnAceptarEliminar);

        btnAceptarEliminar.addActionListener(e -> {
            String codigoEiminar = txtCodigoEliminar.getText();
            boolean doctorEcontrado = false;

            do {
                for (Doctor doctor : doctores) {
                    if (codigoEiminar.equals(doctor.getCodigo())) {
                        doctores.remove(doctor);
                        JOptionPane.showMessageDialog(this, "El Doctor se ha Eliminado");
                        doctorEcontrado = true;
                        break;
                    }
                }
                if (!doctorEcontrado){
                    JOptionPane.showMessageDialog(this,"El Doctor no Existe");
                    break;
                }
            }while (doctorEcontrado!=true);

        });

        JLabel fondo = new JLabel();
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/fondo1.jpg")));
        fondo.setBounds(0,0,1000,1000);
        add(fondo);

    }

}
