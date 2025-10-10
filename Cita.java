import java.time.*;
import java.util.*;
public class Cita {
    private ArrayList<String> historial = new ArrayList<>();
    private int ID;
    private String paciente;
    private String medicoAsignado;
    private LocalDateTime fechaHora;
    private String tipoCita;
    private String estado;

// Constructor
    public Cita(int ID, String paciente, String medicoAsignado, LocalDateTime fechaHora, String tipoCita, String estado) {
        this.ID = ID;
        this.paciente = paciente;
        this.medicoAsignado = medicoAsignado;
        this.fechaHora = fechaHora;
        this.tipoCita = tipoCita;
        this.estado = estado;
        historial.add(LocalDateTime.now() + "- Cita creada con estado: " + estado + " para el paciente: " + paciente + " con el medico: " + medicoAsignado + " en la fecha y hora: " + fechaHora);
    }

    public void setEstado(String estado) {
        this.estado = estado;
        historial.add(LocalDateTime.now() + "- Cita actualizada a estado: " + estado);
    }
    public void setfechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
        historial.add(LocalDateTime.now() + "- Cita reagendada a: " + fechaHora);
    }
    public void setMedicoAsignado(String medicoAsignado) {
        this.medicoAsignado = medicoAsignado;
        historial.add(LocalDateTime.now() + "- Medico asignado cambiado a: " + medicoAsignado);
    }
    public void mostrarHistorial() {
        for (String h : historial) {
            System.out.println(h);
        }
    }

//getters 
    public int getID() {
        return ID;
    }
    public String getPaciente() {
        return paciente;
    }
    public String getMedicoAsignado() {
        return medicoAsignado;
    }
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
    public String getTipoCita() {
        return tipoCita;
    }
    public String getEstado() {
        return estado;
    }
}