package clases;

import javax.swing.*;
import java.awt.*;

public class PanelProducto extends JPanel {
    private Producto producto;
    public PanelProducto(Producto producto){
        initComponents(producto);
        this.producto = producto;
    }

    public void initComponents(Producto producto){
        setSize(200,100);
        setBackground(new Color(255,255,153));

        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                BorderFactory.createLineBorder(new Color(255,255,153),5)
        ));
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JLabel lblNombre = new JLabel("Nombre:"+producto.getNombre());
        JLabel lblDescripcion = new JLabel("Descripción:"+producto.getDescripcion());
        JLabel lblPrecio = new JLabel("Precio: Q."+producto.getPrecio()+".00");

        lblNombre.setBounds(10,10,100,25);
        add(lblNombre);

        lblDescripcion.setBounds(10,45,100,25);
        add(lblDescripcion);

        lblPrecio.setBounds(10,80,100,25);
        add(lblPrecio);
    }
}
