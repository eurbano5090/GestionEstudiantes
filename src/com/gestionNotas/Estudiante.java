package com.gestionNotas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Representa a un estudiante de la institución.
 * Guarda sus datos personales, las inscripciones a cursos,
 * y proporciona métodos para registrar y mostrar calificaciones.
 */
	public class Estudiante {
    private String rut;
    private String nombre;
    private String carrera;
    private LocalDate anioIngreso;

    private static final DateTimeFormatter FORMATO_FECHA =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

   
    /** Relación: las inscripciones de este estudiante */
    private List<Inscripcion> inscripciones = new ArrayList<>();

    /** Colección estática global de todos los estudiantes*/
    private static List<Estudiante> listaEstudiantes = new ArrayList<>();

    /**
     * Constructor vacío.
     */
    public Estudiante() {
    }

    /**
     * Constructor completo.
     *
     * @param rut         RUN del estudiante
     * @param nombre      Nombre completo
     * @param carrera     Carrera que cursa
     * @param anioIngreso Fecha de ingreso
     */
    public Estudiante(String rut, String nombre, String carrera, LocalDate anioIngreso) {
        this.rut = rut;
        this.nombre = nombre;
        this.carrera = carrera;
        this.anioIngreso = anioIngreso;
    }

    // ————— Getters y Setters ——————————————————————————————————

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public LocalDate getAnioIngreso() {
        return anioIngreso;
    }

    public void setAnioIngreso(LocalDate anioIngreso) {
        this.anioIngreso = anioIngreso;
    }

    /**
     * Devuelve las inscripciones (cursos + calificaciones) de este estudiante.
     */
    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    /**
     * Agrega una inscripción a este estudiante.
     *
     * @param insc Inscripción a añadir
     */
    public void agregarInscripcion(Inscripcion insc) {
        if (!inscripciones.contains(insc)) {
            inscripciones.add(insc);
        }
    }

    /**
     * Devuelve la lista global de estudiantes.
     */
    public static List<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    // ————— Métodos de negocio ——————————————————————————————————————————

    /**
     * Calcula el promedio general de este estudiante
     * promediando los promedios de cada inscripción.
     *
     * @return Promedio general (0.0 si no hay inscripciones)
     */
    public double calcularPromedioGeneral() {
        if (inscripciones.isEmpty()) {
            return 0.0;
        }
        double suma = 0.0;
        for (Inscripcion insc : inscripciones) {
            suma += insc.calcularPromedio();
        }
        return suma / inscripciones.size();
    }

    /**
     * Muestra en consola las calificaciones por curso y evaluación,
     * y al final el promedio general.
     */
    public void mostrarCalificaciones() {
        System.out.println("\n📋 Calificaciones de " + nombre + " (" + rut + "):");
        if (inscripciones.isEmpty()) {
            System.out.println("   (Sin Cursos Inscritos)");
            return;
        }

        for (Inscripcion insc : inscripciones) {
            Curso curso = insc.getCurso();
            System.out.println("Curso: " + curso.getCodigoCurso()
                               + " - " + curso.getNombre());

            if (insc.getCalificaciones().isEmpty()) {
                System.out.println("   (Sin Calificaciones Registradas)");
            } else {
                insc.getCalificaciones().forEach((eval, nota) -> {
                    System.out.printf("   %s [%s]: %.2f / %.2f%n",
                        eval.getTipo(),
                        eval.getFecha(),
                        nota,
                        eval.getPuntajeMax()
                    );
                });
                System.out.printf("   → Promedio curso: %.2f%n",
                    insc.calcularPromedio());
            }
            System.out.println();
        }

        System.out.printf(">>> Promedio general: %.2f%n",
            calcularPromedioGeneral());
    }

    /**
     * Método estático: Registra un nuevo estudiante leyendo datos por consola.
     *
     * @param sc Scanner compartido de entrada
     */
    public static void registrarEstudiante(Scanner sc) {
        System.out.println("\n--- Registrar Nuevo Estudiante ---");
        System.out.print("RUT: ");
        String rut = sc.nextLine().trim();
        System.out.print("Nombre Completo: ");
        String nombre = sc.nextLine().trim();
        System.out.print("Carrera: ");
        String carrera = sc.nextLine().trim();
        System.out.print("Año Ingreso (DD-MM-YYYY): ");
        LocalDate ingreso = LocalDate.parse(sc.nextLine().trim(), FORMATO_FECHA);


        Estudiante est = new Estudiante(rut, nombre, carrera, ingreso);
        listaEstudiantes.add(est);
        System.out.println("✅ Estudiante Registrado Exitosamente: " + est.getNombre());
    }

    @Override
    public String toString() {
        return String.format(
            "Estudiante Rut=%s, Nombre=%s, Carrera=%s, Ingreso=%s, Insc=%d",
            rut, nombre, carrera, anioIngreso,
            inscripciones.size()
        );
    }
}