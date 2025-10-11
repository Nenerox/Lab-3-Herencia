public class DoctorGeneral extends BaseTrabajador {
    private String especialidad;
    private int capacidad;
    private double tarifaConsulta;
    private int citasAtendidas;

// Constructor
    public DoctorGeneral(int ID, String nombre, String departamento, int experiencia, String especialidad, int capacidad, double tarifaConsulta) {
        super(ID, nombre, departamento, experiencia);
        this.especialidad = especialidad;
        this.capacidad = capacidad;
        this.tarifaConsulta = tarifaConsulta;
    }

    @Override
    public double calculoSalario() {
        return salarioBase + (citasAtendidas * tarifaConsulta);
    }

    public void addCitasAtendidas(int citas) {
        this.citasAtendidas += citas;
    }
    
    @Override
    public String datos(int ID) {
        return "Doctor General [ID=" + ID + ", Nombre=" + nombre + ", Departamento=" + departamento + ", Experiencia=" + experiencia + " años" + "Especialidad=" + especialidad + ", Capacidad de Pacientes=" + capacidad + ", Tarifa por Consulta=" + tarifaConsulta + ", Citas Atendidas=" + citasAtendidas + ", Salario=" + calculoSalario() + "]";
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