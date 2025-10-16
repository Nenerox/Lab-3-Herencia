import java.time.*;
import java.util.*;
public class main {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        
        System.out.println("bienvenido al sistema de gestión del hospital");
        while (opcion != 6) {
        controlador.actualizarEstadosCitas(); // Actualizar estados de citas al inicio de cada ciclo
        System.out.println("Seleccione una opcion: \n 1. Agregar trabajador \n 2. Agregar cita \n 3. Reagendar cita \n 4. Cancelar cita \n 5. Operaciones de manager \n 6. Salir");
        opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        switch (opcion) {
            case 1:
                System.out.println("Seleccione el tipo de trabajador a agregar: \n 1. Doctor General \n 2. Enfermero/a \n 3. Farmaceutico/a \n 4. Terapeuta \n 5. Volver");
                int tipoTrabajador = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                switch (tipoTrabajador) {
                    case 1:
                        System.out.println("Ingrese el nombre del doctor:");
                        String nombre = scanner.nextLine();
                        System.out.println("Ingrese la especialidad del doctor:");
                        String especialidad = scanner.nextLine();
                        System.out.println("Ingrese los años de experiencia del doctor:");
                        int experiencia = scanner.nextInt();
                        System.out.println("Ingrese la capacidad de pacientes del doctor:");
                        int capacidad = scanner.nextInt();
                        System.out.println("Ingrese la tarifa de consulta del doctor:");
                        double tarifaConsulta = scanner.nextDouble();

                        System.out.println(controlador.CrearDoctorGeneral(nombre, experiencia, especialidad, capacidad, tarifaConsulta));
                        break;
                    case 2:
                        System.out.println("Ingrese el nombre del enfermero:");
                        nombre = scanner.nextLine();
                        System.out.println("Ingrese los años de experiencia del enfermero:");
                        experiencia = scanner.nextInt();
                        System.out.println("Ingrese el nivel de certificación del enfermero:");
                        String NivelCerficacion = scanner.nextLine();
                        System.out.println("¿El enfermero trabaja en turno nocturno? (true/false):");
                        boolean nocturno = scanner.nextBoolean();

                        System.out.println(controlador.CrearEnfermero(nombre, experiencia, NivelCerficacion, nocturno));
                        break;
                    case 3:
                        System.out.println("Ingrese el nombre del farmacéutico:");
                        nombre = scanner.nextLine();
                        System.out.println("Ingrese los años de experiencia del farmacéutico:");
                        experiencia = scanner.nextInt();
                        System.out.println("Ingrese la licencia de farmacia del farmacéutico:");
                        String licenciaFarmacia = scanner.nextLine();
                        System.out.println("Ingrese el límite de prescripciones del farmacéutico:");
                        int limite = scanner.nextInt();

                        System.out.println(controlador.CrearFarmaceutico(nombre, experiencia, licenciaFarmacia, limite));
                        break;
                    case 4:
                        System.out.println("Ingrese el nombre del terapeuta:");
                        nombre = scanner.nextLine();
                        System.out.println("Ingrese los años de experiencia del terapeuta:");
                        experiencia = scanner.nextInt();
                        System.out.println("Ingrese la especialidad del terapeuta:");
                        especialidad = scanner.nextLine();
                        System.out.println("Ingrese la duración de la sesión del terapeuta (en horas):");
                        int duracion = scanner.nextInt();

                        System.out.println(controlador.CrearTerapeuta(nombre, experiencia, especialidad, duracion));
                        break;
                    case 5:
                        System.out.println("Volviendo al menú principal.");
                        break;
                    default:
                        System.out.println("Opcion no válida. Volviendo al menú principal.");
                }
                break;
            case 2:
                System.out.println("Ingrese el nombre del paciente:");
                String paciente = scanner.nextLine();
                System.out.println("Ingrese el nombre del médico asignado:");
                String medicoAsignado = scanner.nextLine();
                System.out.println("Ingrese la fecha y hora de la cita (formato: YYYY-MM-DD HH:MM):");
                LocalDateTime fechaHora = LocalDateTime.parse(scanner.nextLine().replace(" ", "T"));
                System.out.println("Ingrese el tipo de cita (Consulta, Seguimiento, Urgencia):");
                String tipoCita = scanner.nextLine();

                System.out.println(controlador.crearCita(paciente, medicoAsignado, fechaHora, tipoCita));
                break;
            case 3:
                System.out.println("Ingrese el ID de la cita a reagendar:");
                int ID = scanner.nextInt();
                System.out.println("1. Reagendar tiempo de cita \n 2. Reasignar medico");
                int opcionReagendar = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                System.out.println("Ingrese la nueva fecha y hora de la cita (formato: YYYY-MM-DD HH:MM):");
                LocalDateTime nuevaFecha = LocalDateTime.parse(scanner.nextLine().replace(" ", "T"));

                System.out.println(controlador.reagendarCita(ID, nuevaFecha));

                if (opcionReagendar == 2) {
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.println("Ingrese el nombre del nuevo médico:");
                    String nuevoMedico = scanner.nextLine();
                    System.out.println(controlador.reasignarMedico(ID, nuevoMedico));
                    break;
                }
                break;
            case 4:
                System.out.println("Ingrese el ID de la cita a cancelar:");
                ID = scanner.nextInt();
                System.out.println(controlador.CancelarCita(ID));
            case 5:
                controlador.actualizarEstadosCitas();
                System.out.println("Seleccione una opcion de manager: \n 1. Buscar personal disponible \n 2. Reporte de Nómina por departamento \n 3. Reagendamiento automatico \n 4. Eficiencia del personal \n 5. Mostrar todos los trabajadores \n 6. Reporte de citas \n 7. Analisis Financiero \n 8. Historial de Citas \n 9. Volver al menú principal");
                int opcionManager = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                switch (opcionManager) {
                    case 1:
                        System.out.println("Ingrese la especialidad a filtrar:");
                        String especialidad = scanner.nextLine();
                        System.out.println("Ingrese la fecha y hora inicial del filtro (formato: YYYY-MM-DD HH:MM):");
                        LocalDateTime inicio = LocalDateTime.parse(scanner.nextLine().replace(" ", "T"));
                        System.out.println("Ingrese la fecha y hora limite del filtro (formato: YYYY-MM-DD HH:MM):");
                        LocalDateTime fin = LocalDateTime.parse(scanner.nextLine().replace(" ", "T"));
                        ArrayList<String> disponibles = controlador.BuscarDisponibles(especialidad, inicio, fin);
                        if (disponibles.isEmpty()) {
                            System.out.println("No se encontró personal disponible con la especialidad " + especialidad + " en el rango de tiempo especificado.");
                        } else {
                            System.out.println("Personal disponible: ");
                            for (String t : disponibles) {
                                System.out.println(t);
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Ingrese el departamento a filtrar (Doctor General, Enfermero, Farmaceutico, Terapeuta):");
                        String departamentoFiltro = scanner.nextLine();
                        ArrayList<String> reporteNomina = controlador.reporteDepartamento(departamentoFiltro);
                        for (String reporte : reporteNomina) {
                            System.out.println(reporte);
                        }
                        break;
                    case 3:
                        System.out.println("Ingrese el ID de la cita a reagendar automáticamente:");
                        ID = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea
                        System.out.println(controlador.ReagendarCitaAutomaticamente(ID));
                        break;
                    case 4:
                        ArrayList<String> eficiencia = controlador.reporteEficiencia();
                        for (String reporte : eficiencia) {
                            System.out.println(reporte);
                        }
                        break;
                    case 5:
                        ArrayList<String> todosTrabajadores = controlador.mostrarTrabajadores();
                        for (String trabajador : todosTrabajadores) {
                            System.out.println(trabajador);
                        }
                        break;
                    case 6:
                        System.out.println("Ingrese el estado de la cita a filtrar (PROGRAMADA, CONFIRMADA, EN_PROGRESO, COMPLETADA, CANCELADA, REAGENDADA o deje en blanco para omitir):");
                        String estadoFiltro = scanner.nextLine();
                        System.out.println("Ingrese el nombre del médico a filtrar (o deje en blanco para omitir):");
                        String medicoFiltro = scanner.nextLine();
                        ArrayList<String> reporteCitas = controlador.reporteCitas(estadoFiltro, medicoFiltro);
                        for (String reporte : reporteCitas) {
                            System.out.println(reporte);
                        }
                        break;
                    case 7:
                        System.out.println(controlador.analisisFinanciero());
                        System.out.println("Enter para continuar");
                        scanner.nextLine(); // Esperar a que el usuario presione Enter
                        break;
                    case 8:
                        System.out.println("Ingrese el ID de la cita para ver el historial de cambios:");
                        ID = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea
                        ArrayList<String> historial = controlador.HitorialCita(ID);
                        if (historial.isEmpty()) {
                            System.out.println("No se encontró una cita con ID " + ID);
                        } else {
                            System.out.println("Historial de la cita ID " + ID + ":");
                            for (String evento : historial) {
                                System.out.println(evento);
                            }
                        }
                        break;
                    case 9:
                        System.out.println("Volviendo al menú principal.");
                        break;
                    default:
                        System.out.println("Opcion no válida. Volviendo al menú principal.");
                }
                break;
            case 6:
                System.out.println("Saliendo del sistema.");
                break;
            default:
                System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }
}
