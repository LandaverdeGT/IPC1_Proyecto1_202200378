package interfaces;

import clases.Administrador;
import clases.Doctor;
import clases.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;


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
        }
        tablaDoctores.setModel(modeloTablaDoctores);
        JScrollPane scrollPaneDoctores = new JScrollPane(tablaDoctores);
        panelDoctores.add(scrollPaneDoctores, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.LEADING));

        JButton btnCrearDoctor = new JButton("Nuevo Doctor");
        panelBotones.add(btnCrearDoctor);

        btnCrearDoctor.addActionListener(e -> {
            SwingUtilities.invokeLater(()->{
                VistatCrearDoctor vistaCrearDoctor = new VistatCrearDoctor(modeloTablaDoctores);
                vistaCrearDoctor.setVisible(true);
                vistaCrearDoctor.setLocationRelativeTo(this);
            });
        });

        JButton btnActualizarDoctor = new JButton("Actualizar Doctor");
        panelBotones.add(btnActualizarDoctor);

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

        tabbedPane.addTab("Doctores", panelDoctores);
        getContentPane().add(tabbedPane);

    }
}
