package interfaces;

import clases.Administrador;
import clases.Producto;
import tableModels.TableModelProductos;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class VistaCrearProducto extends JFrame {
    int contadorCodigo = 0;
    TableModelProductos tableModelProductos;
    VistaCrearProducto(TableModelProductos tableModelProductos){
        initComponents();
        this.tableModelProductos = tableModelProductos;
    }

    public void initComponents(){
        setTitle("Crear Producto");
        setSize(1200, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(null);


        JLabel lblNombreProducto = new JLabel("Nombre:*");
        lblNombreProducto.setBounds(40,25,80,25);
        add(lblNombreProducto);

        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(140,25,400,25);
        add(txtNombre);

        JLabel lblPrecio = new JLabel("Precio:*");
        lblPrecio.setBounds(40,60,80,25);
        add(lblPrecio);

        JTextField txtPrecio = new JTextField();
        txtPrecio.setBounds(140,60,400,25);
        add(txtPrecio);

        JLabel lblDescripcion = new JLabel("Descripción:*");
        lblDescripcion.setBounds(600,25,80,25);
        add(lblDescripcion);

        JTextField txtDescripcion = new JTextField();
        txtDescripcion.setBounds(700, 25,400,25);
        add(txtDescripcion);

        JLabel lblCantidad = new JLabel("Cantidad:*");
        lblCantidad.setBounds(600,60,60,25);
        add(lblCantidad);

        JTextField txtCantidad = new JTextField();
        txtCantidad.setBounds(700,60,400,25);
        add(txtCantidad);

        JLabel lblAdvertencia = new JLabel("Campos obligatorios (*)");
        lblAdvertencia.setBounds(500,400,500,25);
        add(lblAdvertencia);

        JButton btnAgregarProducto = new JButton("Crear Producto");
        btnAgregarProducto.setBackground(Color.CYAN);
        btnAgregarProducto.setBounds(950,200,150,30);
        add(btnAgregarProducto);

        btnAgregarProducto.addActionListener(e -> {
            contadorCodigo+=1;
            int precio = Integer.parseInt(txtPrecio.getText());
            int cantidad = Integer.parseInt(txtCantidad.getText());
            String digitoContador = "PRO00"+Integer.toString(contadorCodigo);
            if (txtNombre.getText().isBlank() || txtPrecio.getText().isBlank() || txtDescripcion.getText().isBlank()
            || txtCantidad.getText().isBlank()){
                JOptionPane.showMessageDialog(this,"Por favor complete los campos obligatorios",
                "EROR",JOptionPane.ERROR_MESSAGE);
            }else {
                tableModelProductos.agregarProductos(digitoContador, txtNombre.getText(), Integer.parseInt(txtPrecio.getText()), txtDescripcion.getText(), Integer.parseInt(txtCantidad.getText()));
            }
        });

        JLabel fondo = new JLabel();
        fondo.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/fondo1.jpg"))));
        fondo.setBounds(0,0,2000,1000);
        add(fondo);

    }
}
