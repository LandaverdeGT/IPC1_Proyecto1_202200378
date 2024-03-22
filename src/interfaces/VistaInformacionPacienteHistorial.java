package interfaces;

import clases.Historial;
import tableModels.TableModelHistorial;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VistaInformacionPacienteHistorial extends JFrame {
    public VistaInformacionPacienteHistorial(Historial historial){
        initComponents(historial);
    }
    public void initComponents(Historial historial){
        setTitle("Mayor Información Paciente");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panelVerMasInfo = new JPanel(new BorderLayout());
        JTable tablaVerMasInfo = new JTable();

        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("NO.");
        defaultTableModel.addColumn("Paciente");
        defaultTableModel.addColumn("Fecha");
        defaultTableModel.addColumn("Hora");

        defaultTableModel.addRow(new Object[]{historial.getNo(), historial.getPaciente().getNombres()+historial.getPaciente().getApellidos(), historial.getFecha(), historial.getHora()});

        tablaVerMasInfo.setModel(defaultTableModel);
        JScrollPane scrollPane = new JScrollPane(tablaVerMasInfo);
        panelVerMasInfo.add(scrollPane, BorderLayout.CENTER);
        add(panelVerMasInfo);
    }
}
