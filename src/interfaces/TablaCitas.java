package interfaces;

import clases.Cita;
import clases.Doctor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TablaCitas extends JFrame {
    TablaCitas(){
        initComponents();
    }
    public void initComponents(){
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
            modeloTablaCitas.addRow(new Object[]{cita.getNumeroCita(),cita.getCitaAgendada()});
        }
        tablaCitas.setModel(modeloTablaCitas);
        JScrollPane scrollPaneDoctoresFiltrados = new JScrollPane(tablaCitas);
        add(scrollPaneDoctoresFiltrados, BorderLayout.CENTER);
    }
}
