public class Enfermero extends BaseTrabajador {
    private String NivelCerficacion;
    private boolean nocturno;
    private double bono = 300;

// Constructor
    public Enfermero(int ID, String nombre, String departamento, int experiencia, String NivelCerficacion, boolean nocturno) {
        super(ID, nombre, departamento, experiencia);
        this.NivelCerficacion = NivelCerficacion;
        this.nocturno = nocturno;
    }
    
    @Override
    public double calculoSalario() {
        if (nocturno) {
            return salarioBase + bono;
        } else {
            return salarioBase;
        }
    }
    @Override
    public String datos(int ID) {
        return "Enfermero [ID=" + ID + ", Nombre=" + nombre + ", Departamento=" + departamento + ", Experiencia=" + experiencia + " años" + ", Nivel de Certificación=" + this.NivelCerficacion + ", Turno Nocturno=" + this.nocturno + ", Salario Total=" + calculoSalario() + "]";
    }

// Getters
    public String getNivelCerficacion() {
        return NivelCerficacion;
    }
    public boolean isNocturno() {
        return nocturno;
    }
    public double getBono() {
        return bono;
    }
}