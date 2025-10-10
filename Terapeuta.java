public class Terapeuta extends BaseTrabajador {
    private String especialidad;
    private double duracionHoras;
    private double comision = 500; // Comision fija por sesion
    private int sesionesRealizadas;

// Constructor
    public Terapeuta(int ID, String nombre, String departamento, int experiencia, String especialidad, double duracion) {
        super(ID, nombre, departamento, experiencia);
        this.especialidad = especialidad;
        this.duracionHoras = duracion;
    }

    public double calculoSalario() {
        return salarioBase + (sesionesRealizadas * comision);
    }

    public void addSesionesRealizadas(int sesiones) {
        this.sesionesRealizadas += sesiones;
    }
    @Override
    public String datos(String ID) {
        return "Terapeuta [ID=" + ID + ", Nombre=" + nombre + ", Departamento=" + departamento + ", Experiencia=" + experiencia + " años" + ", Especialidad=" + especialidad + ", Duración Promedio de Sesión (horas)=" + duracionHoras + ", Comisión por Sesión=" + comision + ", Sesiones Realizadas=" + sesionesRealizadas + ", Salario=" + calculoSalario() + "]";
    }

// Getters
    public String getEspecialidad() {
        return especialidad;
    }
    public double getDuracionHoras() {
        return duracionHoras;
    }
    public double getComision() {
        return comision;
    }
    public int getSesionesRealizadas() {
        return sesionesRealizadas;
    }
}