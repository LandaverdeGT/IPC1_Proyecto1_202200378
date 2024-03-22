package interfaces;

import clases.Cita;
import clases.Doctor;
import clases.Historial;
import clases.PanelPaciente;
import tableModels.TableModelCitas;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Objects;

import static clases.Administrador.doctores;
import static clases.Paciente.historiales;

public class VistaDoctor extends JFrame {
    private JTabbedPane tabbedPane;
    private Doctor doctorActual;
    private JPanel panelCitas;
    private JPanel panelGraficas;
    int contador = 0;
    VistaDoctor(Doctor doctor){
        initComponents(doctor);
    }

    public void initComponents(Doctor doctor){
        setTitle("Doctor");
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.doctorActual = doctor;

        panelCitas = new JPanel(new BorderLayout());
        JScrollPane scrollPaneCitas= new JScrollPane();
        tabbedPane = new JTabbedPane();

        JButton btnEditarPerfil = new JButton("Editar Perfil");
        btnEditarPerfil.setHorizontalAlignment(SwingConstants.RIGHT);
        add(btnEditarPerfil, BorderLayout.NORTH);

        btnEditarPerfil.addActionListener(e -> {
            VistaEditarPerfilDoctor vistaEditarPerfilDoctor = new VistaEditarPerfilDoctor(doctorActual);
            vistaEditarPerfilDoctor.setVisible(true);
            vistaEditarPerfilDoctor.setLocationRelativeTo(this);
        });

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
        panelCitas.setLayout(new BoxLayout(panelCitas, BoxLayout.Y_AXIS));
        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (tabbedPane.getSelectedIndex() == tabbedPane.indexOfTab("Citas")){
                    updatePacientesPanel();
                }
            }
        });

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
                tableModelCitas.agregarCita(no, txtHoraCita.getText(),doctorActual.getEspecialidad());
            }
        });

        JScrollPane scrollPaneAsignarHorario = new JScrollPane(tableHorarios);
        panelAsignarHorario.add(scrollPaneAsignarHorario,BorderLayout.SOUTH);
        tableHorarios.setModel(tableModelCitas);

        tabbedPane.addTab("Asignar Horario",panelAsignarHorario);
        getContentPane().add(tabbedPane);
    }
    private void updatePacientesPanel(){
        panelCitas.removeAll();
        for (Historial historial : historiales){
            PanelPaciente panelPaciente = new PanelPaciente(historial);
            panelCitas.add(panelPaciente);
            panelPaciente.add(Box.createVerticalStrut(10));
        }
        panelCitas.revalidate();
        panelCitas.repaint();
    }
}
