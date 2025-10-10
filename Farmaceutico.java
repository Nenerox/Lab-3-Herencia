public class Farmaceutico extends BaseTrabajador {
    private String licenciaFarmacia;
    private int limite;
    private int numeroDespachos;
    private int comision = 400;

// Constructor
    public Farmaceutico(int ID, String nombre, String departamento, int experiencia, String licenciaFarmacia, int limite) {
        super(ID, nombre, departamento, experiencia);
        this.licenciaFarmacia = licenciaFarmacia;
        this.limite = limite;
    }

    public double calculoSalario() {
        return salarioBase + (numeroDespachos * comision);
    }

    public void addNumeroDespachos(int despachos) {
        this.numeroDespachos += despachos;
    }

    @Override
    public String datos(String ID) {
        return "Farmaceutico [ID=" + ID + ", Nombre=" + nombre + ", Departamento=" + departamento + ", Experiencia=" + experiencia + " años" + ", Licencia de Farmacia=" + licenciaFarmacia + ", Límite de despachos por dia=" + limite + ", Número de Despachos Realizados=" + numeroDespachos + ", Comisión por Despacho=" + comision + ", Salario Total=" + calculoSalario() + "]";
    }

// Getters
    public String getLicenciaFarmacia() {
        return licenciaFarmacia;
    }
    public int getLimite() {
        return limite;
    }
    public int getNumeroDespachos() {
        return numeroDespachos;
    }
    public double getComision() {
        return comision;
    }

}