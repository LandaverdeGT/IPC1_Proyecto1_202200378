package interfaces;

import clases.*;
import tableModels.TableModelCitas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static clases.Doctor.citas;

public class VistaPaciente extends JFrame {
    private JTabbedPane tabbedPane;
    private JPanel panelFarmacia;
    public VistaPaciente(List<String> especialidades, List<Doctor> doctores, Paciente paciente){
        initComponents(especialidades,doctores, paciente);
    }
    public void initComponents(List<String> especialidades, List<Doctor> doctores, Paciente paciente) {
        setTitle("Paciente");
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panelSolicitarCita = new JPanel(new BorderLayout());
        JScrollPane scrollPaneSolicitar = new JScrollPane();
        tabbedPane = new JTabbedPane();

        JButton btnEditarPerfil = new JButton("Editar Perfil");
        btnEditarPerfil.setHorizontalAlignment(SwingConstants.RIGHT);
        add(btnEditarPerfil, BorderLayout.NORTH);

        btnEditarPerfil.addActionListener(e -> {
            VistaEditarPerdilPaciente vistaEditarPerdilPaciente = new VistaEditarPerdilPaciente(paciente);
            vistaEditarPerdilPaciente.setVisible(true);
            vistaEditarPerdilPaciente.setLocationRelativeTo(this);
        });

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
        cbxEspecialidad.setBounds(190, 150, 150, 25);
        panelSolicitarCita.add(cbxEspecialidad);

        DefaultComboBoxModel<String> doctoresFiltrados = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<String> horariosDoctor = new DefaultComboBoxModel<>();
        List<Doctor> listaDoctores = new ArrayList<>();
        cbxEspecialidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doctoresFiltrados.removeAllElements();
                horariosDoctor.removeAllElements();

                String especialidadSeleccionada = cbxEspecialidad.getSelectedItem().toString();
                for (Doctor doctor : doctores) {
                    if (especialidadSeleccionada.equals(doctor.getEspecialidad())) {
                        doctoresFiltrados.addElement(doctor.getNombres());
                        listaDoctores.add(doctor);
                        for (Cita cita : citas) {
                            if (especialidadSeleccionada.equals(cita.getEspecialidad())) {
                                horariosDoctor.addElement(cita.getCitaAgendada());
                            }
                        }
                    }
                }
            }
        });

        JButton btnMostrarDoctores = new JButton("Mostrar Doctores");
        btnMostrarDoctores.setBounds(450, 150, 200, 25);
        panelSolicitarCita.add(btnMostrarDoctores);

        btnMostrarDoctores.addActionListener(e -> {
            VistaListaDoctoresFiltrados doctoresLista = new VistaListaDoctoresFiltrados(cbxEspecialidad.getSelectedItem().toString(), listaDoctores);
            doctoresLista.setVisible(true);
            doctoresLista.setLocationRelativeTo(this);
        });

        JLabel lblDoctor = new JLabel("Doctor:");
        lblDoctor.setBounds(85, 185, 100, 25);
        panelSolicitarCita.add(lblDoctor);

        JComboBox cbxDoctor = new JComboBox(doctoresFiltrados);
        cbxDoctor.setBounds(190, 185, 150, 25);
        panelSolicitarCita.add(cbxDoctor);

        JButton btnMostarHorarios = new JButton("Mostrar Horarios");
        btnMostarHorarios.setBounds(450, 185, 200, 25);
        panelSolicitarCita.add(btnMostarHorarios);

        btnMostarHorarios.addActionListener(e -> {
            TableModelCitas tableModelCitas = new TableModelCitas();
            TablaCitas tablaCitas = new TablaCitas(cbxEspecialidad.getSelectedItem().toString());
            tablaCitas.setVisible(true);
            tablaCitas.setLocationRelativeTo(this);
        });

        JLabel lblTitulo = new JLabel("Horario de Citas Disponibles");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblTitulo.setBounds(70, 350, 500, 50);
        panelSolicitarCita.add(lblTitulo);

        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setBounds(75, 410, 50, 25);
        panelSolicitarCita.add(lblFecha);

        String[] llenadoFechas = {"20/03/2024", "21/03/24", "22/03/2024", "23/03/2024", "25/03/2024", "26/03/2024", "27/03/2024", "28/03/2024", "29/03/2024", "30/03/2024"};
        JComboBox cbxFechas = new JComboBox(llenadoFechas);
        cbxFechas.setBounds(130, 410, 150, 25);
        panelSolicitarCita.add(cbxFechas);

        JLabel lblHora = new JLabel("Hora:");
        lblHora.setBounds(350, 410, 200, 25);
        panelSolicitarCita.add(lblHora);

        JComboBox cbxHora = new JComboBox(horariosDoctor);
        cbxHora.setBounds(395, 410, 150, 25);
        panelSolicitarCita.add(cbxHora);

        JButton btnGenerarCita = new JButton("Generar Cita");
        btnGenerarCita.setBackground(Color.ORANGE);
        btnGenerarCita.setBounds(1000, 600, 150, 50);
        panelSolicitarCita.add(btnGenerarCita);

        panelSolicitarCita.add(scrollPaneSolicitar, BorderLayout.CENTER);

        tabbedPane.addTab("Solicitar Cita", panelSolicitarCita);
        getContentPane().add(tabbedPane);

        JLabel fondo = new JLabel();
        fondo.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/fondo1.jpg"))));
        fondo.setBounds(0, 0, 2000, 1000);
        panelSolicitarCita.add(fondo);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        JPanel panelEstadoCita = new JPanel(new BorderLayout());
        JScrollPane scrollPaneEstadoCita = new JScrollPane();

        JLabel lblHistorial = new JLabel("Historial de Citas:");
        lblHistorial.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblHistorial.setBounds(50, 30, 300, 50);
        panelEstadoCita.add(lblHistorial);

        panelEstadoCita.add(scrollPaneEstadoCita, BorderLayout.CENTER);

        tabbedPane.addTab("Ver Estado Cita", panelEstadoCita);
        getContentPane().add(tabbedPane);

        JLabel fondo2 = new JLabel();
        fondo2.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/fondo1.jpg"))));
        fondo2.setBounds(0, 0, 2000, 1000);
        panelEstadoCita.add(fondo2);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        panelFarmacia = new JPanel(new BorderLayout());
        JScrollPane scrollPaneFarmacia = new JScrollPane();

        JLabel lblProductos = new JLabel("Productos Disponibles");
        lblProductos.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblProductos.setBounds(25, 25, 800, 50);
        panelFarmacia.add(lblProductos);

        panelFarmacia.add(scrollPaneFarmacia, BorderLayout.CENTER);

        tabbedPane.addTab("Farmacia", panelFarmacia);
        getContentPane().add(tabbedPane);


    }

    public void actualizarFarmacia(Producto producto){
        JPanel panelProducto = new JPanel();
        panelProducto.setLayout(new BoxLayout(panelProducto, BoxLayout.Y_AXIS));
        panelProducto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelProducto.setPreferredSize(new Dimension(300,100));

        JLabel lblNombre = new JLabel("Nombre:" + producto.getNombre());
        JLabel lblDescripcion = new JLabel("Descripción:" + producto.getDescripcion());
        JLabel lblPrecio = new JLabel("Precio: Q." + producto.getPrecio());

        panelProducto.add(lblNombre);
        panelProducto.add(lblDescripcion);
        panelProducto.add(lblPrecio);
        panelFarmacia.add(panelProducto);
        panelFarmacia.revalidate();
        panelFarmacia.repaint();
    }
}
