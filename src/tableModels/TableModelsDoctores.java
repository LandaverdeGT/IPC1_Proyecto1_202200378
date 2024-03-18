package tableModels;

import clases.Administrador;
import clases.Doctor;

import javax.swing.table.AbstractTableModel;

public class TableModelsDoctores extends AbstractTableModel {
    private String[] columnNames = {"Código","Nombres","Apellidos","Especialidad","Género","Teléfono","Edad"};

    public void agregarDoctor(String codigo, String contrasena, String nombres, String apellidos, String especialidad, String genero, String telefono, String edad){
        Administrador.agregarDoctores(new Doctor(codigo, contrasena,nombres,apellidos,especialidad,genero,telefono,edad));
        fireTableDataChanged();
    }

    @Override
    public int getRowCount(){
        return Administrador.doctores.size();
    }
    @Override
    public int getColumnCount(){
        return columnNames.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        Doctor doctor = Administrador.doctores.get(rowIndex);
        switch (columnIndex){
            case 0:
                return doctor.getCodigo();
            case 1:
                return doctor.getNombres();
            case 2:
                return doctor.getApellidos();
            case 3:
                return doctor.getEspecialidad();
            case 4:
                return doctor.getGenero();
            case 5:
                return doctor.getTelefono();
            case 6:
                return doctor.getEdad();
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
