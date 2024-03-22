package interfaces;

import clases.Administrador;
import clases.Doctor;
import clases.Paciente;
import clases.Producto;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import tableModels.TableModelPacientes;
import tableModels.TableModelProductos;
import tableModels.TableModelsDoctores;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

import static clases.Administrador.doctores;


public class VistaAdministrador extends JFrame {
    private JTabbedPane tabbedPane;
    TableModelsDoctores tableModelsDoctores = new TableModelsDoctores();
    TableModelPacientes tableModelPacientes = new TableModelPacientes();
    TableModelProductos tableModelProductos = new TableModelProductos();
    public VistaAdministrador(List<Doctor> doctores,List<Paciente> pacientes,List<Producto> productos){
        initComponents(doctores,pacientes,productos);
    }
    public void initComponents(List<Doctor> doctores, List<Paciente> pacientes, List<Producto> productos){
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

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.LEADING));

        JButton btnCrearDoctor = new JButton("Nuevo Doctor");
        panelBotones.add(btnCrearDoctor);

        btnCrearDoctor.addActionListener(e -> {
            SwingUtilities.invokeLater(()->{
                VistatCrearDoctor vistaCrearDoctor = new VistatCrearDoctor(tableModelsDoctores);
                vistaCrearDoctor.setVisible(true);
                vistaCrearDoctor.setLocationRelativeTo(this);
            });
        });

        tablaDoctores.setModel(tableModelsDoctores);
        JScrollPane scrollPaneDoctores = new JScrollPane(tablaDoctores);
        panelDoctores.add(scrollPaneDoctores, BorderLayout.CENTER);

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
            EliminarDoctorValidacion eliminarDoctorValidacion = new EliminarDoctorValidacion(doctores,tableModelsDoctores);
            eliminarDoctorValidacion.setVisible(true);
            eliminarDoctorValidacion.setLocationRelativeTo(this);
        });

        tabbedPane.addTab("Doctores", panelDoctores);
        getContentPane().add(tabbedPane);
        JPanel panelGrafica = new JPanel(new BorderLayout());
        panelDoctores.add(panelGrafica, BorderLayout.SOUTH);
        mostrarGraficaTopEspecialidades(panelGrafica, doctores);

///////////////////////////////////////////////////////////////////////////////
        JPanel panelPacientes = new JPanel(new BorderLayout());
        JTable tablaPacientes = new JTable();

        JLabel lblPacientes = new JLabel("Listado de Pacientes");
        lblPacientes.setHorizontalAlignment(SwingConstants.CENTER);
        panelPacientes.add(lblPacientes,BorderLayout.NORTH);

        JPanel panelBotonesPaciente = new JPanel(new FlowLayout(FlowLayout.LEADING));

        JButton btnCrearPaciente = new JButton("Crear Paciente");
        panelBotonesPaciente.add(btnCrearPaciente);

        btnCrearPaciente.addActionListener(e -> {
            VistaCrearPaciente vistaCrearPaciente = new VistaCrearPaciente(tableModelPacientes);
            vistaCrearPaciente.setVisible(true);
            vistaCrearPaciente.setLocationRelativeTo(this);
        });

        tablaPacientes.setModel(tableModelPacientes);
        JScrollPane scrollPanePacientes = new JScrollPane(tablaPacientes);
        panelPacientes.add(scrollPanePacientes, BorderLayout.CENTER);

        JButton btnActualizarPaciente = new JButton("Actualizar Paciente");
        panelBotonesPaciente.add(btnActualizarPaciente);

        btnActualizarPaciente.addActionListener(e -> {
            ValidacionPaciente validacionPaciente = new ValidacionPaciente();
            validacionPaciente.setVisible(true);
            validacionPaciente.setLocationRelativeTo(this);
        });

        JButton btnEliminarPaciente = new JButton("Eliminar");
        panelBotonesPaciente.add(btnEliminarPaciente);

        btnEliminarPaciente.addActionListener(e -> {
            EliminarPacienteValidacion eliminarPacienteValidacion = new EliminarPacienteValidacion(pacientes,tableModelPacientes);
            eliminarPacienteValidacion.setVisible(true);
            eliminarPacienteValidacion.setLocationRelativeTo(this);
        });

        panelPacientes.add(panelBotonesPaciente,BorderLayout.EAST);

        tabbedPane.addTab("Pacientes", panelPacientes);
        getContentPane().add(tabbedPane);
//-----------------------------------------------------------------------------------------
        JPanel panelProductos = new JPanel(new BorderLayout());
        JTable tablaProductos = new JTable();

        JLabel lblProductos = new JLabel("Listado de Productos");
        lblProductos.setHorizontalAlignment(SwingConstants.CENTER);
        panelProductos.add(lblProductos,BorderLayout.NORTH);

        JPanel panelBotonesProducto = new JPanel(new FlowLayout(FlowLayout.LEADING));

        JButton btnCrearProducto = new JButton("Crear Producto");
        panelBotonesProducto.add(btnCrearProducto);

        btnCrearProducto.addActionListener(e -> {
            VistaCrearProducto vistaCrearProducto = new VistaCrearProducto(tableModelProductos);
            vistaCrearProducto.setVisible(true);
            vistaCrearProducto.setLocationRelativeTo(this);
        });

        tablaProductos.setModel(tableModelProductos);
        JScrollPane scrollPaneProductos = new JScrollPane(tablaProductos);
        panelProductos.add(scrollPaneProductos, BorderLayout.CENTER);


        JButton btnActualizarProducto = new JButton("Actualizar Producto");
        panelBotonesProducto.add(btnActualizarProducto);

        btnActualizarProducto.addActionListener(e -> {
            ValidacionProducto validacionProducto = new ValidacionProducto();
            validacionProducto.setVisible(true);
            validacionProducto.setLocationRelativeTo(this);
        });

        JButton btnEliminarProducto = new JButton("Eliminar");
        panelBotonesProducto.add(btnEliminarProducto);

        btnEliminarProducto.addActionListener(e -> {
            EliminarProductoValidacion eliminarProductoValidacion = new EliminarProductoValidacion(productos,tableModelProductos);
            eliminarProductoValidacion.setVisible(true);
            eliminarProductoValidacion.setLocationRelativeTo(this);
        });

        panelProductos.add(panelBotonesProducto,BorderLayout.EAST);

        tabbedPane.addTab("Productos", panelProductos);
        getContentPane().add(tabbedPane);
    }
    private void mostrarGraficaTopEspecialidades(JPanel panelGrafica, List<Doctor> doctores){
        Map<String, Integer> especialidadesCount = new HashMap<>();
        for (Doctor doctor : doctores) {
            String especialidad = doctor.getEspecialidad();
            especialidadesCount.put(especialidad, especialidadesCount.getOrDefault(especialidad, 0) + 1);
        }
        List<Map.Entry<String, Integer>> topEspecialidades = especialidadesCount.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .limit(5)
                .collect(Collectors.toList());
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<String, Integer> entry : topEspecialidades) {
            dataset.addValue(entry.getValue(), "Especialidad", entry.getKey());
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Top 5 de Especialidades de Doctores",
                "Especialidades",
                "Cantidad",
                dataset
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        panelGrafica.add(chartPanel, BorderLayout.CENTER);
    }
}
