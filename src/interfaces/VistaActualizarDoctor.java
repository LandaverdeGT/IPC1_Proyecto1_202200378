package interfaces;

import clases.Doctor;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

import static clases.Administrador.doctores;

public class VistaActualizarDoctor extends JFrame {
    VistaActualizarDoctor(String codigoBuscado){
        initComponents(codigoBuscado);
    }

    public void initComponents(String codigoBuscado){
        setTitle("Actualizar Doctor");
        setSize(1200, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(null);

        JLabel lblCodigo = new JLabel("Código:*");
        lblCodigo.setBounds(40,15,80,25);
        add(lblCodigo);

        JTextField txtCodigo = new JTextField();
        txtCodigo.setBounds(140,15,250,25);
        add(txtCodigo);


        JLabel lblNombreDoctor = new JLabel("Nombres:*");
        lblNombreDoctor.setBounds(40,50,80,25);
        add(lblNombreDoctor);

        JTextField txtNombres = new JTextField();
        txtNombres.setBounds(140,50,400,25);
        add(txtNombres);

        JLabel lblApellidos = new JLabel("Apellidos:*");
        lblApellidos.setBounds(40,85,80,25);
        add(lblApellidos);

        JTextField txtApellidos = new JTextField();
        txtApellidos.setBounds(140,85,400,25);
        add(txtApellidos);

        JLabel lblEspecialidad = new JLabel("Especialidad:*");
        lblEspecialidad.setBounds(40,120,100,25);
        add(lblEspecialidad);

        JTextField txtEspecialidad = new JTextField();
        txtEspecialidad.setBounds(140,120,400,25);
        add(txtEspecialidad);

        JLabel lblGenero = new JLabel("Género:*");
        lblGenero.setBounds(40,155,60,25);
        add(lblGenero);

        String[] rellenoCombo = {"Masculino", "Femenino"};
        JComboBox cbxGenero = new JComboBox(rellenoCombo);
        cbxGenero.setBounds(140,155,100,25);
        add(cbxGenero);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(600,50,60,25);
        add(lblTelefono);

        JTextField txtTelefono = new JTextField();
        txtTelefono.setBounds(700, 50,400,25);
        add(txtTelefono);

        JLabel lblEdad = new JLabel("Edad:*");
        lblEdad.setBounds(600,85,60,25);
        add(lblEdad);

        JTextField txtEdad = new JTextField();
        txtEdad.setBounds(700,85,400,25);
        add(txtEdad);

        JLabel lblContrasena = new JLabel("Contraseña:*");
        lblContrasena.setBounds(600,120,100,25);
        add(lblContrasena);

        JTextField txtContrasena = new JTextField();
        txtContrasena.setBounds(700,120,400,25);
        add(txtContrasena);

        JLabel lblAdvertencia = new JLabel("Campos obligatorios (*)");
        lblAdvertencia.setBounds(600,400,500,25);
        add(lblAdvertencia);

        JButton btnActualizarDoctor = new JButton("Actualizar Datos");
        btnActualizarDoctor.setBackground(Color.LIGHT_GRAY);
        btnActualizarDoctor.setBounds(950,180,150,50);
        add(btnActualizarDoctor);

        btnActualizarDoctor.addActionListener(e -> {
            boolean doctorEncontrado = false;
            do{
                if (txtCodigo.getText().isBlank() || txtContrasena.getText().isBlank() || txtNombres.getText().isBlank()
                || txtApellidos.getText().isBlank() || txtEspecialidad.getText().isBlank() || cbxGenero.getSelectedItem().toString().isBlank()
                || txtEdad.getText().isBlank()){
                    JOptionPane.showMessageDialog(this,"Por favor complete todos los campos obligatorios");
                    break;
                }else {

                    for (Doctor doctor : doctores) {
                        if (doctor.getCodigo().equals(codigoBuscado)) {
                            doctor.setNombres(txtNombres.getText());
                            doctor.setApellidos(txtApellidos.getText());
                            doctor.setEspecialidad(txtEspecialidad.getText());
                            doctor.setGenero(Objects.requireNonNull(cbxGenero.getSelectedItem()).toString());
                            doctor.setTelefono(txtTelefono.getText());
                            doctor.setEdad(txtEdad.getText());
                            doctor.setCodigo(txtCodigo.getText());
                            doctor.setContrasena(txtContrasena.getText());
                            doctorEncontrado = true;
                            JOptionPane.showMessageDialog(this, "El Doctor se ha Actualizado");
                            break;
                        }

                    }
                    if (!doctorEncontrado) {
                        JOptionPane.showMessageDialog(this, "El Doctor no Existe");
                        break;
                    }
                }
            }while (!doctorEncontrado);
        });

        JLabel fondo1 = new JLabel();
        fondo1.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/fondo1.jpg"))));
        fondo1.setBounds(0,0,1200,500);
        add(fondo1);
    }
}
