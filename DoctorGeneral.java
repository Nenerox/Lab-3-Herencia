public class DoctorGeneral extends BaseTrabajador {
    private String especialidad;
    private int capacidad;
    private double tarifaConsulta;
    private int citasAtendidas;

// Constructor
    public DoctorGeneral(int ID, String nombre, String departamento, int experiencia, double salarioBase, String especialidad, int capacidad, double tarifaConsulta) {
        super(ID, nombre, departamento, experiencia, salarioBase);
        this.especialidad = especialidad;
        this.capacidad = capacidad;
        this.tarifaConsulta = tarifaConsulta;
    }

    public double calculoSalario() {
        return salarioBase + (citasAtendidas * tarifaConsulta);
    }

    public void addCitasAtendidas(int citas) {
        this.citasAtendidas += citas;
    }

// Getters
    public String getEspecialidad() {
        return especialidad;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public double getTarifaConsulta() {
        return tarifaConsulta;
    }
    public int getCitasAtendidas() {
        return citasAtendidas;
    }
}