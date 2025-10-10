public class Cirujano extends BaseTrabajador {
    private String tipoCirugia;
    private String Disponibilidad;
    private double  bono;
    private int horasCirugia;
    private double tarifaHora;

// Constructor
    public Cirujano(int ID, String nombre, String departamento, int experiencia, double salarioBase, String tipoCirugia, String Disponibilidad, double bono, int horasCirugia, double tarifaHora) {
        super(ID, nombre, departamento, experiencia, salarioBase);
        this.tipoCirugia = tipoCirugia;
        this.Disponibilidad = Disponibilidad;
        this.bono = bono;
        this.horasCirugia = horasCirugia;
        this.tarifaHora = tarifaHora;
    }


    public double calculoSalario() {
        return salarioBase + bono + (horasCirugia * tarifaHora);
    }
    
    public void addHorasCirugia(int horas) {
        this.horasCirugia += horas;
    }

// Getters
    public String getTipoCirugia() {
        return tipoCirugia;
    }
    public String getDisponibilidad() {
        return Disponibilidad;
    }
    public double getBono() {
        return bono;
    }
    public int getHorasCirugia() {
        return horasCirugia;
    }
    public double getTarifaHora() {
        return tarifaHora;
    }
 
}