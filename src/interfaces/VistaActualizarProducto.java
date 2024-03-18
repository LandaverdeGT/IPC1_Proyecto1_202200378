package interfaces;

import clases.Paciente;
import clases.Producto;

import javax.swing.*;
import java.awt.*;

import static clases.Administrador.pacientes;
import static clases.Administrador.productos;

public class VistaActualizarProducto extends JFrame {
    VistaActualizarProducto(String codigoBuscado){
        initComponents(codigoBuscado);
    }

    public void initComponents(String codigoBuscado){
        setTitle("Actualizar Producto");
        setSize(1200, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(null);

        JLabel lblNombreProducto = new JLabel("Nombre");
        lblNombreProducto.setBounds(40,15,60,25);
        add(lblNombreProducto);

        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(140,15,400,25);
        add(txtNombre);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setBounds(40,50,60,25);
        add(lblPrecio);

        JTextField txtPrecio = new JTextField();
        txtPrecio.setBounds(140,50,400,25);
        add(txtPrecio);

        JLabel lblDescripcion = new JLabel("Descripción:");
        lblDescripcion.setBounds(600,15,100,25);
        add(lblDescripcion);

        JTextField txtDescripcion = new JTextField();
        txtDescripcion.setBounds(700,15,400,25);
        add(txtDescripcion);

        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setBounds(600,50,80,25);
        add(lblCantidad);

        JTextField txtCantidad = new JTextField();
        txtCantidad.setBounds(700,50,400,25);
        add(txtCantidad);

        JButton btnActualizarProducto = new JButton("Actualizar Datos");
        btnActualizarProducto.setBackground(Color.LIGHT_GRAY);
        btnActualizarProducto.setBounds(950,180,150,50);
        add(btnActualizarProducto);

        btnActualizarProducto.addActionListener(e -> {
            boolean productoEncontrado = false;
            do{
                for (Producto producto : productos){
                    if (producto.getCodigo().equals(codigoBuscado)){
                        producto.setNombre(txtNombre.getText());
                        producto.setPrecio(Integer.parseInt(txtPrecio.getText()));
                        producto.setDescripcion(txtDescripcion.getText());
                        producto.setCantidad(Integer.parseInt(txtCantidad.getText()));
                        productoEncontrado = true;
                        JOptionPane.showMessageDialog(this,"El Producto se ha Actualizado");
                        break;
                    }
                }
                if (!productoEncontrado){
                    JOptionPane.showMessageDialog(this,"El Producto no Existe");
                    break;
                }
            }while (productoEncontrado!=true);
        });

        JLabel fondo1 = new JLabel();
        fondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/fondo1.jpg")));
        fondo1.setBounds(0,0,1200,500);
        add(fondo1);
    }
}
