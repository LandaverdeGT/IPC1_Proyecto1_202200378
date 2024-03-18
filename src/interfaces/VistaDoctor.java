package interfaces;

import clases.Cita;
import clases.Doctor;
import tableModels.TableModelCitas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Objects;

public class VistaDoctor extends JFrame {
    private JTabbedPane tabbedPane;
    int contador = 0;
    VistaDoctor(){
        initComponents();
    }

    public void initComponents(){
        setTitle("Doctor");
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panelCitas = new JPanel(new BorderLayout());
        JScrollPane scrollPaneCitas= new JScrollPane();
        tabbedPane = new JTabbedPane();

        JLabel lblEncabezadoNombre = new JLabel("Nombre Paciente");
        lblEncabezadoNombre.setBounds(15,15,100,25);
        panelCitas.add(lblEncabezadoNombre);

        JLabel lblHora = new JLabel("Hora Cita");
        lblHora.setBounds(250,15,100,25);
        panelCitas.add(lblHora);

        JLabel lblFecha = new JLabel("Fecha Cita");
        lblFecha.setBounds(485,15,100,25);
        panelCitas.add(lblFecha);

        JLabel lblAcciones = new JLabel("Acciones");
        lblAcciones.setBounds(900,15,100,25);
        panelCitas.add(lblAcciones);

        panelCitas.add(scrollPaneCitas, BorderLayout.CENTER);

        tabbedPane.addTab("Citas", panelCitas);
        getContentPane().add(tabbedPane);

        JPanel panelAsignarHorario = new JPanel(new BorderLayout());
        JTable tableHorarios = new JTable();

        JLabel lblHorario = new JLabel("Horario");
        lblHorario.setFont(new Font("Tahoma", Font.BOLD,30));
        lblHorario.setBounds(25,25,300,50);
        panelAsignarHorario.add(lblHorario);

        JLabel lblHorarioCitas = new JLabel("Horario Citas:");
        lblHorarioCitas.setBounds(25,85,300,25);
        panelAsignarHorario.add(lblHorarioCitas);

        JTextField txtHoraCita = new JTextField();
        txtHoraCita.setBounds(375,85,200,25);
        panelAsignarHorario.add(txtHoraCita);

        JButton btnAsignar = new JButton("Asignar");
        btnAsignar.setBounds(600,85,150,25);
        panelAsignarHorario.add(btnAsignar);

        JLabel lblMiHorarioDisponible = new JLabel("Mi Horario Disponible para citas:");
        lblMiHorarioDisponible.setHorizontalAlignment(SwingConstants.CENTER);
        lblMiHorarioDisponible.setBounds(500,110,500,25);
        panelAsignarHorario.add(lblMiHorarioDisponible);
        TableModelCitas tableModelCitas = new TableModelCitas();

        btnAsignar.addActionListener(e -> {
            contador=contador+1;
            String no = "00"+Integer.toString(contador);
            if (txtHoraCita.getText().isBlank()){
                JOptionPane.showMessageDialog(this,"Ingrese una hora","ERROR",JOptionPane.ERROR_MESSAGE);
            }else {
                tableModelCitas.agregarCita(no, txtHoraCita.getText());
            }
        });

        JScrollPane scrollPaneAsignarHorario = new JScrollPane(tableHorarios);
        panelAsignarHorario.add(scrollPaneAsignarHorario,BorderLayout.SOUTH);
        tableHorarios.setModel(tableModelCitas);

        tabbedPane.addTab("Asignar Horario",panelAsignarHorario);
        getContentPane().add(tabbedPane);

    }
}
