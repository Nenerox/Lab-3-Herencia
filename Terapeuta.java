public class Terapeuta extends BaseTrabajador {
    private String especialidad;
    private double duracionHoras;
    private double comision;
    private int sesionesRealizadas;

// Constructor
    public Terapeuta(int ID, String nombre, String departamento, int experiencia, double salarioBase, String especialidad, double duracion, double comision) {
        super(ID, nombre, departamento, experiencia, salarioBase);
        this.especialidad = especialidad;
        this.duracionHoras = duracion;
        this.comision = comision;
    }

    public double calculoSalario() {
        return salarioBase + (sesionesRealizadas * comision);
    }

    public void addSesionesRealizadas(int sesiones) {
        this.sesionesRealizadas += sesiones;
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