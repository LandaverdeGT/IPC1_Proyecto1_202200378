package tableModels;

import clases.Administrador;
import clases.Paciente;

import javax.swing.table.AbstractTableModel;

public class TableModelPacientes extends AbstractTableModel {
    private String[] columnNames = {"Código", "Nombres", "Apellidos", "Edad", "Sexo"};

    public void agregarPaciente(String codigo, String contrasena, String nombres, String apellidos, String edad, String sexo){
        Administrador.agregarPacientes(new Paciente(codigo, contrasena, nombres, apellidos,edad,sexo));
        fireTableDataChanged();
    }

    @Override
    public int getRowCount(){
        return Administrador.pacientes.size();
    }
    @Override
    public int getColumnCount(){
        return columnNames.length;
    }
    @Override
    public Object getValueAt(int rowIndex,int columnIndex){
        Paciente paciente = Administrador.pacientes.get(rowIndex);
        switch (columnIndex){
            case 0:
                return paciente.getCodigo();
            case 1:
                return paciente.getNombres();
            case 2:
                return paciente.getApellidos();
            case 3:
                return paciente.getEdad();
            case 4:
                return paciente.getSexo();
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
