import java.time.*;
import java.util.*;
public class Controlador {
    private ArrayList<BaseTrabajador> trabajadores = new ArrayList<>();
    private ArrayList<Cita> citas = new ArrayList<>();
    int contadorID = 1;
    int contadorCita = 1;

//Metodos de trabajadores
    public void CrearDoctorGeneral(String nombre, int experiencia, String especialidad, int capacidad, double tarifaConsulta) {
        BaseTrabajador doctor = new DoctorGeneral(contadorID, nombre, "Doctores Generales", experiencia, especialidad, capacidad, tarifaConsulta);
        contadorID++;
        trabajadores.add(doctor);
    }
    public void CrearEnfermero(String nombre, int experiencia, int NivelCerficacion, boolean nocturno) {
        BaseTrabajador enfermero = new Enfermero(contadorID, nombre, "Enfermeros", experiencia, NivelCerficacion, nocturno);
        contadorID++;
        trabajadores.add(enfermero);
    }
    public void CrearFarmaceutico(String nombre, int experiencia, String licenciaFarmacia, int limite) {
        BaseTrabajador farmaceutico = new Farmaceutico(contadorID, nombre, "Farmaceuticos", experiencia, licenciaFarmacia, limite);
        contadorID++;
        trabajadores.add(farmaceutico);
    }
    public void CrearTerapeuta(String nombre, int experiencia, String especialidad, double duracion) {
        BaseTrabajador terapeuta = new Terapeuta(contadorID, nombre, "Terapeutas", experiencia, especialidad, duracion);
        contadorID++;
        trabajadores.add(terapeuta);
    }

    public void mostrarTrabajadores(){
        for (Object elem : trabajadores) {
            BaseTrabajador p = (BaseTrabajador) elem;
            System.out.println(p.datos(String.valueOf(p.getID())));
        }
    }


//Metodos para citas
    public void crearCita(String paciente, String medicoAsignado, LocalDateTime fechaHora, String tipoCita) {
        Cita cita = new Cita(contadorCita, paciente, medicoAsignado, fechaHora, tipoCita, "CONFIRMADA");
        contadorCita++;
        citas.add(cita);
    }
    public void HitorialCita(int idCita) {
        for (Cita c : citas) {
            if (c.getID() == idCita) {
                c.mostrarHistorial();
            }
        }
    }

    public String ReagendarCitaAutomaticamente(int idCita) {
        for (Cita c : citas) {
            if (c.getID() == idCita) {
                for (int i = 0; i < 3; i++) {
                    for (Cita otra : citas) {
                        if (otra.getID() != c.getID() && otra.getMedicoAsignado().equals(c.getMedicoAsignado()) && otra.getFechaHora().isEqual(c.getFechaHora()) && !otra.getEstado().equals("CANCELADA")) {
                            c.setEstado("REAGENDADA");
                            c.setfechaHora(otra.getFechaHora().plusHours(1)); // Reagendar a la siguiente hora
                        }
                    }
                }
                return "Reagendada con exito a: " + c.getFechaHora();
            }
        }
        return "Cita no encontrada.";
    }

    public String reagendarCita(int idCita, LocalDateTime nuevaFecha) {
        for (Cita c : citas) {
            if (c.getID() == idCita) {
                for (Cita otra : citas) {
                        if (otra.getID() != c.getID() && otra.getMedicoAsignado().equals(c.getMedicoAsignado()) && otra.getFechaHora().isEqual(nuevaFecha) && !otra.getEstado().equals("CANCELADA")) {
                            return "Fecha no disponible, intente otra fecha.";
                    }
                }
                c.setfechaHora(nuevaFecha);
                c.setEstado("REAGENDADA");
                return "Reagendada con exito a: " + nuevaFecha;
            }
        }
        return "Cita no encontrada.";
    }

    public String reasignarMedico(int idCita, String nuevoMedico) {
        for (Cita c : citas) {
            if (c.getID() == idCita) {
                for (Cita otra : citas) {
                        if (otra.getID() != c.getID() && otra.getMedicoAsignado().equals(nuevoMedico) && otra.getFechaHora().isEqual(c.getFechaHora()) && !otra.getEstado().equals("CANCELADA")) {
                            return "Fecha no disponible, intente otra fecha o medico.";
                    }
                }
                c.setMedicoAsignado(nuevoMedico);
                c.setEstado("REAGENDADA");
                return "medico reasignado con exito a: " + nuevoMedico;
            }
        }
        return "Cita no encontrada.";
    }

    public void revisarEstadosCitas() {
        LocalDateTime ahora = LocalDateTime.now();
        Duration duracionCita = Duration.ofHours(1); // Duración maxima de 1 hora

        for (Cita c : citas) {
            LocalDateTime inicio = c.getFechaHora();
            LocalDateTime fin = inicio.plus(duracionCita);

            if (ahora.isAfter(fin)) {
                // Si ya pasó la hora, se marca como COMPLETADA
                c.setEstado("COMPLETADA");
            } else if (inicio.isBefore(ahora) && ahora.isBefore(fin)) {
                // Si estamos dentro del rango de la cita
                c.setEstado("EN_PROGRESO");
            } else if (ahora.isBefore(inicio) && c.getEstado().equals("CONFIRMADA")) {
                c.setEstado("PROGRAMADA");
            }
        }
    }

        public void CancelarCita(int idCita) {
        for (Cita c : citas) {
            if (c.getID() == idCita) {
                c.setEstado("CANCELADA");
            }
        }
    }
}