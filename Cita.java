public class Cita {
    private String ID;
    private String paciente;
    private String medicoAsignado;
    private String fechaHora;
    private String tipoCita;
    private String estado;

// Constructor
    public Cita(String ID, String paciente, String medicoAsignado, String fechaHora, String tipoCita, String estado) {
        this.ID = ID;
        this.paciente = paciente;
        this.medicoAsignado = medicoAsignado;
        this.fechaHora = fechaHora;
        this.tipoCita = tipoCita;
        this.estado = estado;
    }

//getters 
    public String getID() {
        return ID;
    }
    public String getPaciente() {
        return paciente;
    }
    public String getMedicoAsignado() {
        return medicoAsignado;
    }
    public String getFechaHora() {
        return fechaHora;
    }
    public String getTipoCita() {
        return tipoCita;
    }
    public String getEstado() {
        return estado;
    }
}