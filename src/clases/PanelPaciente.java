package clases;

import interfaces.VistaInformacionPacienteHistorial;

import javax.swing.*;
import java.awt.*;

public class PanelPaciente extends JPanel {
    private Historial historial;
    public PanelPaciente(Historial historial){
        initComponents(historial);
        this.historial = historial;
    }

    public void initComponents(Historial historial){
        setSize(800,50);
        setBackground(new Color(255,255,153));

        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                BorderFactory.createLineBorder(new Color(255,255,153),5)
        ));
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JLabel lblNombre = new JLabel(historial.getPaciente().getNombres());
        JLabel lblHora = new JLabel(historial.getHora());
        JLabel lblFecha = new JLabel(historial.getFecha());

        lblNombre.setBounds(5,10,100,25);
        add(lblNombre);

        lblHora.setBounds(115,10,100,25);
        add(lblHora);

        lblFecha.setBounds(225,10,100,25);
        add(lblFecha);

        JButton btnVerMas = new JButton("Ver Más");
        btnVerMas.setBounds(400,10,50,25);
        add(btnVerMas);

        btnVerMas.addActionListener(e -> {
            VistaInformacionPacienteHistorial vistaInformacionPacienteHistorial = new VistaInformacionPacienteHistorial(historial);
            vistaInformacionPacienteHistorial.setVisible(true);
            vistaInformacionPacienteHistorial.setLocationRelativeTo(this);
        });

        JButton btnAtender = new JButton("Atender");
        btnAtender.setBounds(460, 10, 50,25);
        add(btnAtender);

        btnAtender.addActionListener(e -> {
            historial.setEstado("Completada");
        });

        JButton btnRechazar = new JButton("Rechazar");
        btnRechazar.setBounds(520, 10,0,25);
        add(btnRechazar);

        btnRechazar.addActionListener(e -> {
            historial.setEstado("Rechazada");
        });

    }
}
