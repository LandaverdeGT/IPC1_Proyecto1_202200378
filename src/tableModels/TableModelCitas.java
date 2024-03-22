package tableModels;

import clases.Cita;
import clases.Doctor;

import javax.swing.table.AbstractTableModel;

public class TableModelCitas extends AbstractTableModel {

    private String[] columnNames = {"NO.", "Hora de Cita"};
    public void agregarCita(String numeroCita, String hora, String especialidad) {
        Doctor.agregarCita(new Cita(numeroCita, hora, especialidad));
        fireTableDataChanged();
    }

    @Override
    public int getRowCount(){
        return Doctor.citas.size();
    }
    @Override
    public int getColumnCount(){
        return columnNames.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        Cita cita = Doctor.citas.get(rowIndex);
        switch (columnIndex){
            case 0:
                return cita.getNumeroCita();
            case 1:
                return cita.getCitaAgendada();
            case 2:
                return cita.getEspecialidad();
            default:
                return null;
        }
    }
    @Override
    public String getColumnName(int column){
        return columnNames[column];
    }
}
