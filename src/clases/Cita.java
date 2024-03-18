package clases;

public class Cita {
    String numeroCita;
    String citaAgendada;


    public Cita(String numeroCita, String citaAgendada) {
        this.numeroCita = numeroCita;
        this.citaAgendada = citaAgendada;
    }

    public String getNumeroCita() {
        return numeroCita;
    }
    public String getCitaAgendada() {
        return citaAgendada;
    }

}
