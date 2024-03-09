package interfaces;

import javax.swing.*;

public class ValidacionDoctor extends JFrame {
    ValidacionDoctor(){
        initComponents();
    }

    public void initComponents(){
        setTitle("Validación");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(null);

        JLabel lblIcono = new JLabel();
        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/advertencia.png")));
        lblIcono.setBounds(25,10,100,100);
        add(lblIcono);



        JLabel fondo = new JLabel();
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/fondo1.jpg")));
        fondo.setBounds(0,0,1000,1000);
        add(fondo);
    }
}
