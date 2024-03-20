package interfaces;

import clases.Doctor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.Objects;

public class VistaListaDoctoresFiltrados extends JFrame {
    VistaListaDoctoresFiltrados(String especialidadSeleccionada,List<Doctor> listaDoctores){
        initComponents(especialidadSeleccionada,listaDoctores);
    }

    public void initComponents(String especialidadSeleccionada,List<Doctor> listaDoctores){
        setTitle("Listado De Doctores");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTable tablaDoctoresFiltrados = new JTable();

        JLabel lblListadoDoctores = new JLabel("Listado de Doctores");
        lblListadoDoctores.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblListadoDoctores,BorderLayout.NORTH);

        DefaultTableModel modeloTablaDoctores = new DefaultTableModel();
        modeloTablaDoctores.addColumn("Código");
        modeloTablaDoctores.addColumn("Nombres");
        modeloTablaDoctores.addColumn("Apellidos");
        modeloTablaDoctores.addColumn("Especialidad");
        modeloTablaDoctores.addColumn("Género");
        modeloTablaDoctores.addColumn("Teléfono");
        modeloTablaDoctores.addColumn("Edad");

        for (Doctor doctor : listaDoctores){
            if (especialidadSeleccionada.equals(doctor.getEspecialidad())){
                modeloTablaDoctores.addRow(new Object[]{doctor.getCodigo(), doctor.getNombres(), doctor.getApellidos(), doctor.getEspecialidad(),
                        doctor.getGenero(), doctor.getTelefono(), doctor.getEdad()});
            }
        }
        tablaDoctoresFiltrados.setModel(modeloTablaDoctores);
        JScrollPane scrollPaneDoctoresFiltrados = new JScrollPane(tablaDoctoresFiltrados);
        add(scrollPaneDoctoresFiltrados, BorderLayout.CENTER);

    }
}
