package interfaces;

import clases.Doctor;
import clases.Paciente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

import static clases.Administrador.pacientes;


public class VistaAdministrador extends JFrame {
    private JTabbedPane tabbedPane;
    public VistaAdministrador(List<Doctor> doctores){
        initComponents(doctores);
    }


    public void initComponents(List<Doctor> doctores){
        setTitle("Administrador");
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        tabbedPane = new JTabbedPane();
        JPanel panelDoctores = new JPanel(new BorderLayout());
        JTable tablaDoctores = new JTable();

        JLabel lblDoctores = new JLabel("Listado de Doctores");
        lblDoctores.setHorizontalAlignment(SwingConstants.CENTER);
        panelDoctores.add(lblDoctores,BorderLayout.NORTH);


        DefaultTableModel modeloTablaDoctores = new DefaultTableModel();
        modeloTablaDoctores.addColumn("Código");
        modeloTablaDoctores.addColumn("Nombres");
        modeloTablaDoctores.addColumn("Apellidos");
        modeloTablaDoctores.addColumn("Especialidad");
        modeloTablaDoctores.addColumn("Género");
        modeloTablaDoctores.addColumn("Teléfono");
        modeloTablaDoctores.addColumn("Edad");

        for (Doctor doctor : doctores){
                modeloTablaDoctores.addRow(new Object[]{doctor.getCodigo(), doctor.getNombres(), doctor.getApellidos(), doctor.getEspecialidad(),
                        doctor.getGenero(), doctor.getTelefono(), doctor.getEdad()});
                modeloTablaDoctores.fireTableDataChanged();
        }
        tablaDoctores.setModel(modeloTablaDoctores);
        JScrollPane scrollPaneDoctores = new JScrollPane(tablaDoctores);
        panelDoctores.add(scrollPaneDoctores, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.LEADING));

        JButton btnCrearDoctor = new JButton("Nuevo Doctor");
        panelBotones.add(btnCrearDoctor);

        btnCrearDoctor.addActionListener(e -> {
            SwingUtilities.invokeLater(()->{
                VistatCrearDoctor vistaCrearDoctor = new VistatCrearDoctor();
                vistaCrearDoctor.setVisible(true);
                vistaCrearDoctor.setLocationRelativeTo(this);
            });
        });

        JButton btnActualizarDoctor = new JButton("Actualizar Doctor");
        panelBotones.add(btnActualizarDoctor);

        int seleccion = tablaDoctores.getSelectedRow();

        btnActualizarDoctor.addActionListener(e -> {
            SwingUtilities.invokeLater(()->{
                ValidacionDoctor validacionDoctor = new ValidacionDoctor();
                validacionDoctor.setVisible(true);
                validacionDoctor.setLocationRelativeTo(this);
            });
        });

        JButton btnEliminarDoctor = new JButton("Eliminar Doctor");
        panelBotones.add(btnEliminarDoctor);
        panelDoctores.add(panelBotones,BorderLayout.EAST);

        btnEliminarDoctor.addActionListener(e -> {
            EliminarDoctorValidacion eliminarDoctorValidacion = new EliminarDoctorValidacion(doctores);
            eliminarDoctorValidacion.setVisible(true);
            eliminarDoctorValidacion.setLocationRelativeTo(this);
        });

        tabbedPane.addTab("Doctores", panelDoctores);
        getContentPane().add(tabbedPane);


        JPanel panelPacientes = new JPanel(new BorderLayout());
        JTable tablaPacientes = new JTable();

        JLabel lblPacientes = new JLabel("Listado de Pacientes");
        lblPacientes.setHorizontalAlignment(SwingConstants.CENTER);
        panelPacientes.add(lblPacientes,BorderLayout.NORTH);


        DefaultTableModel modeloTablaPacientes = new DefaultTableModel();
        modeloTablaPacientes.addColumn("Código");
        modeloTablaPacientes.addColumn("Nombres");
        modeloTablaPacientes.addColumn("Apellidos");
        modeloTablaPacientes.addColumn("Edad");
        modeloTablaPacientes.addColumn("Género");

        for (Paciente paciente : pacientes){
            modeloTablaPacientes.addRow(new Object[]{paciente.getCodigo(),paciente.getNombres(),paciente.getApellidos(),
            paciente.getEdad(),paciente.getSexo()});
            modeloTablaPacientes.fireTableDataChanged();
        }

        tablaPacientes.setModel(modeloTablaPacientes);
        JScrollPane scrollPanePacientes = new JScrollPane(tablaPacientes);
        panelPacientes.add(scrollPanePacientes, BorderLayout.CENTER);

        JPanel panelBotonesPaciente = new JPanel(new FlowLayout(FlowLayout.LEADING));

        JButton btnCrearPaciente = new JButton("Crear Paciente");
        panelBotonesPaciente.add(btnCrearPaciente);

        btnCrearPaciente.addActionListener(e -> {
            VistaCrearPaciente vistaCrearPaciente = new VistaCrearPaciente();
            vistaCrearPaciente.setVisible(true);
            vistaCrearPaciente.setLocationRelativeTo(this);
        });

        JButton btnActualizarPaciente = new JButton("Actualizar Paciente");
        panelBotonesPaciente.add(btnActualizarPaciente);

        JButton btnEliminarPaciente = new JButton("Eliminar");
        panelBotonesPaciente.add(btnEliminarPaciente);

        panelPacientes.add(panelBotonesPaciente,BorderLayout.EAST);

        tabbedPane.addTab("Pacientes", panelPacientes);
        getContentPane().add(tabbedPane);

    }
}
