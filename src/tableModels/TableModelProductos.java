package tableModels;

import clases.Administrador;
import clases.Producto;

import javax.swing.table.AbstractTableModel;

public class TableModelProductos extends AbstractTableModel {
    private String[] columnNames = {"Código", "Nombre", "Precio", "Descripción", "Cantidad"};
    public void agregarProductos(String codigo, String nombre, int precio, String descripcion, int cantidad){
        Administrador.agregarProductos(new Producto(codigo,nombre,precio,descripcion,cantidad));
        fireTableDataChanged();
    }
    @Override
    public int getRowCount(){
        return Administrador.productos.size();
    }
    @Override
    public int getColumnCount(){
        return columnNames.length;
    }
    @Override
    public Object getValueAt(int rowIndex,int columnIndex){
        Producto producto = Administrador.productos.get(rowIndex);
        switch (columnIndex){
            case 0:
                return producto.getCodigo();
            case 1:
                return producto.getNombre();
            case 2:
                return producto.getPrecio();
            case 3:
                return producto.getDescripcion();
            case 4:
                return producto.getCantidad();
            default:
                return null;
        }
    }
    @Override
    public String getColumnName(int column){
        return columnNames[column];
    }
    public void actualizarTabla(){
        fireTableDataChanged();
    }

}
