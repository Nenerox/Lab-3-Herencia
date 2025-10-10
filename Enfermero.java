public class Enfermero extends BaseTrabajador {
    private int NivelCerficacion;
    private boolean nocturno;
    private double bono = 300;

// Constructor
    public Enfermero(int ID, String nombre, String departamento, int experiencia, int NivelCerficacion, boolean nocturno) {
        super(ID, nombre, departamento, experiencia);
        this.NivelCerficacion = NivelCerficacion;
        this.nocturno = nocturno;
    }

    public double calculoSalario() {
        if (nocturno) {
            return salarioBase + bono;
        } else {
            return salarioBase;
        }
    }
    @Override
    public String datos(String ID) {
        return "Enfermero [ID=" + ID + ", Nombre=" + nombre + ", Departamento=" + departamento + ", Experiencia=" + experiencia + " años" + ", Nivel de Certificación=" + this.NivelCerficacion + ", Turno Nocturno=" + this.nocturno + ", Salario Total=" + calculoSalario() + "]";
    }

// Getters
    public int getNivelCerficacion() {
        return NivelCerficacion;
    }
    public boolean isNocturno() {
        return nocturno;
    }
    public double getBono() {
        return bono;
    }
}