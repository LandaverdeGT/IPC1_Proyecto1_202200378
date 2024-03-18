package interfaces;

import clases.Administrador;
import clases.Doctor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VistaPaciente extends JFrame {
    private JTabbedPane tabbedPane;
    VistaPaciente(List<String> especialidades,List<Doctor> doctores){
        initComponents(especialidades,doctores);
    }

    public void initComponents(List<String> especialidades,List<Doctor> doctores) {
        setTitle("Paciente");
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panelSolicitarCita = new JPanel(new BorderLayout());
        JScrollPane scrollPaneSolicitar = new JScrollPane();
        tabbedPane = new JTabbedPane();

        JButton btnEditarPerfil = new JButton("Editar Perfil");
        btnEditarPerfil.setBackground(Color.GRAY);
        btnEditarPerfil.setBounds(1000, 0, 200, 25);
        panelSolicitarCita.add(btnEditarPerfil);

        JLabel lblMotivoCita = new JLabel("Motivo de la Cita:");
        lblMotivoCita.setBounds(70, 25, 100, 25);
        panelSolicitarCita.add(lblMotivoCita);

        JTextField txtMotivoCita = new JTextField();
        txtMotivoCita.setBounds(70, 60, 1000, 75);
        panelSolicitarCita.add(txtMotivoCita);

        JLabel lblEspecialidad = new JLabel("Especialidad:");
        lblEspecialidad.setBounds(85, 150, 100, 25);
        panelSolicitarCita.add(lblEspecialidad);
        DefaultComboBoxModel rellenoEspecialidades = new DefaultComboBoxModel();
        for (String especialidad : especialidades) {
            rellenoEspecialidades.addElement(especialidad);
        }
        JComboBox cbxEspecialidad = new JComboBox(rellenoEspecialidades);
        cbxEspecialidad.setBounds(190,150,150,25);
        panelSolicitarCita.add(cbxEspecialidad);

        DefaultComboBoxModel<String> doctoresFiltrados = new DefaultComboBoxModel<>();
        List<Doctor> listaDoctores = new ArrayList<>();
        cbxEspecialidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doctoresFiltrados.removeAllElements();

                String especialidadSeleccionada = cbxEspecialidad.getSelectedItem().toString();
                for (Doctor doctor : doctores){
                    if (especialidadSeleccionada.equals(doctor.getEspecialidad())){
                        doctoresFiltrados.addElement(doctor.getNombres());
                        listaDoctores.add(doctor);
                    }
                }
            }
        });

        JButton btnMostrarDoctores = new JButton("Mostrar Doctores");
        btnMostrarDoctores.setBounds(450,150,200,25);
        panelSolicitarCita.add(btnMostrarDoctores);

        btnMostrarDoctores.addActionListener(e -> {
            VistaListaDoctoresFiltrados doctoresLista = new VistaListaDoctoresFiltrados(listaDoctores);
            doctoresLista.setVisible(true);
            doctoresLista.setLocationRelativeTo(this);
        });

        JLabel lblDoctor = new JLabel("Doctor:");
        lblDoctor.setBounds(85,185,100,25);
        panelSolicitarCita.add(lblDoctor);

        JComboBox cbxDoctor = new JComboBox(doctoresFiltrados);
        cbxDoctor.setBounds(190,185,150,25);
        panelSolicitarCita.add(cbxDoctor);

        JButton btnMostarHorarios = new JButton("Mostrar Horarios");
        btnMostarHorarios.setBounds(450,185,200,25);
        panelSolicitarCita.add(btnMostarHorarios);

        btnMostarHorarios.addActionListener(e -> {
            TablaCitas tablaCitas = new TablaCitas();
            tablaCitas.setVisible(true);
            tablaCitas.setLocationRelativeTo(this);
        });

        JLabel lblTitulo = new JLabel("Horario de Citas Disponibles");
        lblTitulo.setFont(new Font("Tahoma",Font.BOLD,25));
        lblTitulo.setBounds(70,350,500,50);
        panelSolicitarCita.add(lblTitulo);

        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setBounds(75,410,50,25);
        panelSolicitarCita.add(lblFecha);

        JComboBox cbxFechas = new JComboBox();
        cbxFechas.setBounds(130,410,150,25);
        panelSolicitarCita.add(cbxFechas);

        JLabel lblHora = new JLabel("Hora:");
        lblHora.setBounds(350,410,200,25);
        panelSolicitarCita.add(lblHora);

        JComboBox cbxHora = new JComboBox();
        cbxHora.setBounds(305,410,150,25);
        panelSolicitarCita.add(cbxHora);

        JButton btnGenerarCita = new JButton("Generar Cita");
        btnGenerarCita.setBackground(Color.ORANGE);
        btnGenerarCita.setBounds(1000,600,150,50);
        panelSolicitarCita.add(btnGenerarCita);

        panelSolicitarCita.add(scrollPaneSolicitar, BorderLayout.CENTER);

        tabbedPane.addTab("Solicitar Cita", panelSolicitarCita);
        getContentPane().add(tabbedPane);

        JLabel fondo = new JLabel();
        fondo.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/fondo1.jpg"))));
        fondo.setBounds(0,0,2000,1000);
        panelSolicitarCita.add(fondo);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        JPanel panelEstadoCita = new JPanel(new BorderLayout());
        JScrollPane scrollPaneEstadoCita = new JScrollPane();

         JLabel lblHistorial = new JLabel("Historial de Citas:");
         lblHistorial.setFont(new Font("Tahoma",Font.BOLD,25));
         lblHistorial.setBounds(50,30,300,50);
         panelEstadoCita.add(lblHistorial);

         panelEstadoCita.add(scrollPaneEstadoCita,BorderLayout.CENTER);

         tabbedPane.addTab("Ver Estado Cita",panelEstadoCita);
         getContentPane().add(tabbedPane);

        JLabel fondo2 = new JLabel();
        fondo2.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/fondo1.jpg"))));
        fondo2.setBounds(0,0,2000,1000);
        panelEstadoCita.add(fondo2);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        JPanel panelFarmacia = new JPanel(new BorderLayout());
        JScrollPane scrollPaneFarmacia = new JScrollPane();

        JLabel lblProductos = new JLabel("Productos Disponibles");
        lblProductos.setFont(new Font("Tahoma", Font.BOLD,15));
        lblProductos.setBounds(25,25,800,50);
        panelFarmacia.add(lblProductos);

        panelFarmacia.add(scrollPaneFarmacia,BorderLayout.CENTER);

        tabbedPane.addTab("Farmacia", panelFarmacia);
        getContentPane().add(tabbedPane);

        JLabel fondo3 = new JLabel();
        fondo3.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/fondo1.jpg"))));
        fondo3.setBounds(0,0,2000,1000);
        panelFarmacia.add(fondo3);
    }
}
