package interfaces;

import clases.Cita;
import clases.Doctor;
import tableModels.TableModelCitas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TablaCitas extends JFrame {
    TablaCitas(String doctoSeleccionado){
        initComponents(doctoSeleccionado);
    }
    public void initComponents(String doctorSeleccionado){
        setTitle("Listado De Citas");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTable tablaCitas = new JTable();

        JLabel lblListadoCitas = new JLabel("Listado de Citas");
        lblListadoCitas.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblListadoCitas, BorderLayout.NORTH);

        DefaultTableModel modeloTablaCitas = new DefaultTableModel();
        modeloTablaCitas.addColumn("NO.");
        modeloTablaCitas.addColumn("Hora");

        for (Cita cita : Doctor.citas){
            if (doctorSeleccionado.equals(cita.getEspecialidad())){
                modeloTablaCitas.addRow(new Object[]{cita.getNumeroCita(),cita.getCitaAgendada()});
            }
        }
        tablaCitas.setModel(modeloTablaCitas);
        JScrollPane scrollPaneDoctoresFiltrados = new JScrollPane(tablaCitas);
        add(scrollPaneDoctoresFiltrados, BorderLayout.CENTER);
    }
}
