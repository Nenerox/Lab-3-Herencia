public class BaseTrabajador {
// Atributos comunes para todos los trabajadores
    protected int ID;
    protected String nombre;
    protected String departamento;
    protected int experiencia;
    protected double salarioBase;

// Constructor
    public BaseTrabajador(int ID, String nombre, String departamento, int experiencia, double salarioBase) {
        this.ID = ID;
        this.nombre = nombre;
        this.departamento = departamento;
        this.experiencia = experiencia;
        this.salarioBase = salarioBase;
    }

//getters
    public int getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public double getSalarioBase() {
        return salarioBase;
    }
}
