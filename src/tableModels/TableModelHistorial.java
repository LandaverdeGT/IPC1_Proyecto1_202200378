package tableModels;

import clases.Cita;
import clases.Doctor;
import clases.Historial;
import clases.Paciente;

import javax.swing.table.AbstractTableModel;

public class TableModelHistorial extends AbstractTableModel {

    private String[] columnNames = {"NO.", "Estado", "Fecha", "Hora"};
    public void agregarHistorial(int no, String estado, String fecha, String hora, Paciente paciente){
        Paciente.agregarHistorial(new Historial(no, estado, fecha, hora, paciente));
        fireTableDataChanged();
    }
    @Override
    public int getRowCount(){
        return Paciente.historiales.size();
    }
    @Override
    public int getColumnCount(){
        return columnNames.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        Historial historial = Paciente.historiales.get(rowIndex);
        switch (columnIndex){
            case 0:
                return historial.getNo();
            case 1:
                return historial.getEstado();
            case 2:
                return historial.getFecha();
            case 3:
                return historial.getHora();
            case 4:
                return  historial.getPaciente();
            default:
                return null;
        }
    }
    @Override
    public String getColumnName(int column){
        return columnNames[column];
    }
}
