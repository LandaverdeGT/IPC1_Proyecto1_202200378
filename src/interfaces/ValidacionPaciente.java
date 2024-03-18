package interfaces;

import clases.Paciente;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import static clases.Administrador.pacientes;

public class ValidacionPaciente extends JFrame {
    ValidacionPaciente(){
        initComponents();
    }

    public void initComponents(){
        setTitle("Validación");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(null);

        JLabel lblIcono = new JLabel();
        lblIcono.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/advertencia.png"))));
        lblIcono.setBounds(50,78,100,100);
        add(lblIcono);

        JLabel lblMensaje = new JLabel("Ingrese el Código del Paciente que");
        lblMensaje.setFont(new Font("Tahoma",Font.BOLD,15));
        lblMensaje.setBounds(175,100,300,20);
        add(lblMensaje);

        JLabel lblMensaje2 = new JLabel("Desea Actualizar sus Datos");
        lblMensaje2.setFont(new Font("Tahoma",Font.BOLD,15));
        lblMensaje2.setBounds(175,135,300,20);
        add(lblMensaje2);

        JTextField txtCodigoNuevoPaciente = new JTextField();
        txtCodigoNuevoPaciente.setBounds(140,250,230,35);
        add(txtCodigoNuevoPaciente);

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
            String codigoBuscado = txtCodigoNuevoPaciente.getText();
            boolean pacienteEncontrado = false;
            do {
                for (Paciente paciente : pacientes) {
                    if (codigoBuscado.equals(paciente.getCodigo())) {
                        VistaActualizarPaciente vistaActualizarPaciente = new VistaActualizarPaciente(codigoBuscado);
                        vistaActualizarPaciente.setVisible(true);
                        setLocationRelativeTo(null);
                        this.setVisible(false);
                        pacienteEncontrado = true;
                        break;
                    }
                }
                if (!pacienteEncontrado){
                    JOptionPane.showMessageDialog(this,"El Paciente No Existe");
                    break;
                }
            }while (!pacienteEncontrado);

        });


        JLabel fondo = new JLabel();
        fondo.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/fondo1.jpg"))));
        fondo.setBounds(0,0,1000,1000);
        add(fondo);
    }
}
