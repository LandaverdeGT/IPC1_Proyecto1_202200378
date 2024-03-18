package interfaces;

import clases.Paciente;
import clases.Producto;
import tableModels.TableModelProductos;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Objects;

public class EliminarProductoValidacion extends JFrame{
    TableModelProductos tableModelProductos;
    EliminarProductoValidacion(List<Producto> productos, TableModelProductos tableModelProductos){
        initComponents(productos);
        this.tableModelProductos = tableModelProductos;
    }

    public void initComponents(List<Producto> productos){
        setTitle("Eliminar Producto");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(null);

        JLabel lblIconoError = new JLabel();
        lblIconoError.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/error-icon-4.png"))));
        lblIconoError.setBounds(50,78,100,100);
        add(lblIconoError);

        JLabel lblMensaje = new JLabel("Ingrese el Código del Producto");
        lblMensaje.setFont(new Font("Tahoma",Font.BOLD,15));
        lblMensaje.setBounds(175,100,300,20);
        add(lblMensaje);

        JLabel lblMensaje2 = new JLabel("que Desea Eliminar");
        lblMensaje2.setFont(new Font("Tahoma",Font.BOLD,15));
        lblMensaje2.setBounds(175,135,300,20);
        add(lblMensaje2);

        JTextField txtCodigoEliminar = new JTextField();
        txtCodigoEliminar.setBounds(140,250,230,35);
        add(txtCodigoEliminar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(Color.LIGHT_GRAY);
        btnCancelar.setBounds(130,310,100,25);
        add(btnCancelar);

        btnCancelar.addActionListener(e -> {
            this.setVisible(false);
        });

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setBackground(Color.LIGHT_GRAY);
        btnAceptar.setBounds(280,310,100,25);
        add(btnAceptar);

        btnAceptar.addActionListener(e -> {
            String codigoEiminar = txtCodigoEliminar.getText();
            boolean productoEncontrado = false;

            do {
                for (Producto producto : productos) {
                    if (codigoEiminar.equals(producto.getCodigo())) {
                        productos.remove(producto);
                        JOptionPane.showMessageDialog(this, "El Producto se ha Eliminado");
                        productoEncontrado = true;
                        tableModelProductos.actualizarTabla();
                        break;
                    }
                }
                if (!productoEncontrado){
                    JOptionPane.showMessageDialog(this,"El Producto no Existe");
                    break;
                }
            }while (!productoEncontrado);

        });

        JLabel fondo = new JLabel();
        fondo.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/fondo1.jpg"))));
        fondo.setBounds(0,0,1000,1000);
        add(fondo);

    }

}
