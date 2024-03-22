package interfaces;

import clases.*;
import tableModels.TableModelCitas;
import tableModels.TableModelHistorial;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static clases.Administrador.productos;
import static clases.Doctor.citas;

public class VistaPaciente extends JFrame {
    private JTabbedPane tabbedPane;
    private JPanel panelFarmacia;
    int contadorVeces = 0;
    boolean limite = false;
    TableModelHistorial tableModelHistorial = new TableModelHistorial();
    public VistaPaciente(List<String> especialidades, List<Doctor> doctores, Paciente paciente, List<Producto> productos){
        initComponents(especialidades,doctores, paciente, productos);
    }
    public void initComponents(List<String> especialidades, List<Doctor> doctores, Paciente paciente, List<Producto> productos) {
        setTitle("Paciente");
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        final int[] cont = {0};

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

        btnGenerarCita.addActionListener(e -> {
            contadorVeces = contadorVeces+1;
            if (!limite){
                tableModelHistorial.agregarHistorial(contadorVeces,"Pendiente", cbxFechas.getSelectedItem().toString(), cbxHora.getSelectedItem().toString(), paciente);
                JOptionPane.showMessageDialog(this,"Cita Creada con Éxito");
                limite = true;
            }else{
                JOptionPane.showMessageDialog(this,"Ya ha creado una cita, no puede crear más", "EROR", JOptionPane.ERROR_MESSAGE);
            }

        });

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

        JLabel lblHistorial = new JLabel("Historial de Citas");
        lblHistorial.setHorizontalAlignment(SwingConstants.CENTER);
        panelEstadoCita.add(lblHistorial, BorderLayout.NORTH);

        JTable tablaHistorial = new JTable();
        tablaHistorial.setModel(tableModelHistorial);
        JScrollPane scrollPanelTablaHistorial = new JScrollPane(tablaHistorial);
        panelEstadoCita.add(scrollPanelTablaHistorial, BorderLayout.CENTER);

        tabbedPane.addTab("Ver Estado Cita", panelEstadoCita);
        getContentPane().add(tabbedPane);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        panelFarmacia = new JPanel();
        panelFarmacia.setLayout(new BoxLayout(panelFarmacia, BoxLayout.Y_AXIS));

        JScrollPane scrollPaneFarmacia = new JScrollPane();

        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (tabbedPane.getSelectedIndex() == tabbedPane.indexOfTab("Farmacia")){
                    updateProductosPanel();
                }
            }
        });
        panelFarmacia.add(scrollPaneFarmacia, BorderLayout.CENTER);

        tabbedPane.addTab("Farmacia", panelFarmacia);
        getContentPane().add(tabbedPane);

        JLabel fondo3 = new JLabel();
        fondo3.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/fondo1.jpg"))));
        fondo3.setBounds(0, 0, 2000, 1000);
        panelFarmacia.add(fondo3);
    }
    private void updateProductosPanel() {
        panelFarmacia.removeAll();
        JLabel lblProductos = new JLabel("¡Nuestros Productos Disponibles, Visítanos para comprarlos!");
        lblProductos.setFont(new Font("Tahoma", Font.BOLD, 25));
        panelFarmacia.add(lblProductos);
        panelFarmacia.add(Box.createVerticalStrut(10)); // Espacio entre el título y los productos

        for (Producto producto : productos) {
            PanelProducto panelProducto = new PanelProducto(producto);
            panelFarmacia.add(panelProducto);
            panelFarmacia.add(Box.createVerticalStrut(10)); // Espacio entre productos
        }

        panelFarmacia.revalidate();
        panelFarmacia.repaint();
    }
}
