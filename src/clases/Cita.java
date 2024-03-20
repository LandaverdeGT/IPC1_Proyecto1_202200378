package clases;
public class Cita {
    String numeroCita;
    String citaAgendada;
    String especialidad;


    public Cita(String numeroCita, String citaAgendada, String especialidad) {
        this.numeroCita = numeroCita;
        this.citaAgendada = citaAgendada;
        this.especialidad = especialidad;
    }

    public String getNumeroCita() {
        return numeroCita;
    }
    public String getCitaAgendada() {
        return citaAgendada;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}
