import java.time.*;
import java.util.*;
public class Controlador {
    private ArrayList<BaseTrabajador> trabajadores = new ArrayList<>();
    private ArrayList<Cita> citas = new ArrayList<>();
    int contadorID = 1;
    int contadorCita = 1;

//Metodos para crear trabajadores
    public void CrearDoctorGeneral(String nombre, int experiencia, String especialidad, int capacidad, double tarifaConsulta) {
        BaseTrabajador doctor = new DoctorGeneral(contadorID, nombre, "Doctores Generales", experiencia, especialidad, capacidad, tarifaConsulta);
        contadorID++;
        trabajadores.add(doctor);
    }
    public void CrearEnfermero(String nombre, int experiencia, String NivelCerficacion, boolean nocturno) {
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
    
//Metodos de operaciones del manager
    public void BuscarDisponibles(String especialidad, LocalDateTime inicio, LocalDateTime fin){
        for (BaseTrabajador trabajador : trabajadores) {
            for (Cita cita : citas) {
                if (trabajador instanceof DoctorGeneral && ((DoctorGeneral) trabajador).getEspecialidad().equals(especialidad) && cita.getFechaHora().isBefore(inicio) && cita.getFechaHora().isAfter(fin)) {
                    System.out.println(trabajador.datos(trabajador.getID()));
                } else if (trabajador instanceof Terapeuta && ((Terapeuta) trabajador).getEspecialidad().equals(especialidad) && cita.getFechaHora().isBefore(inicio) && cita.getFechaHora().isAfter(fin)) {
                    System.out.println(trabajador.datos(trabajador.getID()));
                }  
            }
        }
    }

    public void reporteDepartamento(String departamentoFiltro) {
        double total = 0.0;
        for (BaseTrabajador t : trabajadores) {
            if (t.getDepartamento().equalsIgnoreCase(departamentoFiltro)) {
                double salario = t.calculoSalario();
                total += salario;
                System.out.println("- " + t.getNombre() + " Salario: $" + salario);
            }
        }
        System.out.println("Total en salarios para el departamento de " + departamentoFiltro + ": $" + total);
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

    public void reporteEficiencia(){
        for (BaseTrabajador t : trabajadores) {
            int citasAsignadas = 0;
            int citasRealizadas = 0;
            for (Cita c : citas) {
                if (c.getMedicoAsignado().equalsIgnoreCase(t.getNombre()) && c.getEstado().equals("COMPLETADA")) {
                    citasRealizadas++;
                } 
                if (c.getMedicoAsignado().equalsIgnoreCase(t.getNombre()) && !c.getEstado().equals("CANCELADA")) {
                    citasAsignadas++;
                }
            }
            if (citasAsignadas == 0) {
                System.out.println("- " + t.getNombre() + " No tiene citas asignadas.");
            } else {
                double eficiencia = (citasRealizadas / citasAsignadas) * 100;
                System.out.printf("- " + t.getNombre() + " Total de citas asignadas: " + citasAsignadas + " Total de citas realizadas: "+ citasRealizadas + " Eficiencia del: "+ eficiencia + "%");
            }
        }
    }

    public void mostrarTrabajadores(){
        for (Object elem : trabajadores) {
            BaseTrabajador p = (BaseTrabajador) elem;
            System.out.println(p.datos(p.getID()));
        }
    }

    public void reporteCitas(String estadoFiltro, String medicoFiltro) {
        for (Cita c : citas) {
            boolean coincideEstado = (estadoFiltro == null) || c.getEstado().equalsIgnoreCase(estadoFiltro);
            boolean coincideMedico = (medicoFiltro == null) || c.getMedicoAsignado().equalsIgnoreCase(medicoFiltro);
            if (coincideEstado && coincideMedico) {
                System.out.println(c.Datos());
            }
        }
    }

    public void analisisFinanciero(){
        double Doctores = 0.0;
        double Enfermeros = 0.0;
        double Farmaceuticos = 0.0;
        double Terapeutas = 0.0;
        double total = 0.0;

        for (BaseTrabajador t : trabajadores) {
            if (t.getDepartamento().equalsIgnoreCase("Doctores Generales")) {
                double salario = t.calculoSalario();
                Doctores += salario;
                total += salario;
            } else if (t.getDepartamento().equalsIgnoreCase("Enfermeros")) {
                double salario = t.calculoSalario();
                Enfermeros += salario;
                total += salario;
            } else if (t.getDepartamento().equalsIgnoreCase("Farmaceuticos")) {
                double salario = t.calculoSalario();
                Farmaceuticos += salario;
                total += salario;
            } else if (t.getDepartamento().equalsIgnoreCase("Terapeutas")) {
                double salario = t.calculoSalario();
                Terapeutas += salario;
                total += salario;
            }
        }
        System.out.println("Total en salarios en el departamento de Doctores Generales: $" + total);
        System.out.println("Total en salarios en el departamento de Enfermeros: $" + total);
        System.out.println("Total en salarios en el departamento de Farmaceuticos: $" + total);
        System.out.println("Total en salarios en el departamento de Terapeutas: $" + total);
        System.out.println("Total en salarios en el hospital: $" + total);
    }

    public void HitorialCita(int idCita) {
        for (Cita c : citas) {
            if (c.getID() == idCita) {
                c.mostrarHistorial();
            }
        }
    }


//Metodos para citas
    public void crearCita(String paciente, String medicoAsignado, LocalDateTime fechaHora, String tipoCita) {
        Cita cita = new Cita(contadorCita, paciente, medicoAsignado, fechaHora, tipoCita, "CONFIRMADA");
        contadorCita++;
        citas.add(cita);
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
                // Si ya pasó la hora, se marca como COMPLETADA y se agrega a las citas atendidas del doctor
                c.setEstado("COMPLETADA");
                for (BaseTrabajador t : trabajadores) {
                    if (t.getNombre().equals(c.getMedicoAsignado())) {
                        if (t instanceof DoctorGeneral) {
                            ((DoctorGeneral) t).addCitasAtendidas(1);
                        } else if (t instanceof Terapeuta) {
                            ((Terapeuta) t).addSesionesRealizadas(1);
                        } else if (t instanceof Farmaceutico) {
                            ((Farmaceutico) t).addNumeroDespachos(1);
                        }
                    }
                }
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