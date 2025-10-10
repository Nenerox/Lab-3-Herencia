public class Enfermero extends BaseTrabajador {
    private int NivelCerficacion;
    private boolean nocturno;
    private double bono;

// Constructor
    public Enfermero(int ID, String nombre, String departamento, int experiencia, double salarioBase, int NivelCerficacion, boolean nocturno, double bono) {
        super(ID, nombre, departamento, experiencia, salarioBase);
        this.NivelCerficacion = NivelCerficacion;
        this.nocturno = nocturno;
        this.bono = bono;
    }

    public double calculoSalario() {
        if (nocturno) {
            return salarioBase + bono;
        } else {
            return salarioBase;
        }
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