package com.gestionNotas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Une un Estudiante con un Curso, y almacena
 * para ese par las notas de todas las evaluaciones.
 */
public class Inscripcion {
    private Estudiante estudiante;
    private Curso curso;

    /** Mapa evaluación → nota obtenida*/
    private Map<Evaluacion, Double> calificaciones = new HashMap<>();

    /** Lista global de inscripciones*/
    private static List<Inscripcion> listaInscripciones = new ArrayList<>();

    /** Constructor que liga estudiante y curso */
    public Inscripcion(Estudiante estudiante, Curso curso) {
        this.estudiante = estudiante;
        this.curso = curso;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public Map<Evaluacion, Double> getCalificaciones() {
        return calificaciones;
    }

    /**
     * Asigna la nota de una evaluación para este estudiante.
     * @param evaluacion Evaluación planificada en el curso
     * @param nota       Valor obtenido (0..puntajeMax)
     */
    public void asignarCalificacion(Evaluacion evaluacion, double nota) {
        if (!curso.getEvaluaciones().contains(evaluacion)) {
            System.out.println("❌ La Evaluación no pertenece a este Curso.");
            return;
        }
        double max = evaluacion.getPuntajeMax();
        if (nota < 0 || nota > max) {
            System.out.printf("❌ Nota inválida. Debe estar entre 0 y %.2f%n", max);
            return;
        }
        calificaciones.put(evaluacion, nota);
        /** También registra en la propia Evaluacion para reportes generales */
        evaluacion.asignarNota(this, nota);
    }

    /**
     * Calcula el promedio de las calificaciones en este curso.
     * @return promedio (0 si no hay notas)
     */
    public double calcularPromedio() {
        if (calificaciones.isEmpty()) return 0.0;
        double suma = 0;
        for (double n : calificaciones.values()) {
            suma += n;
        }
        return suma / calificaciones.size();
    }

    /**
     * Registra una nueva inscripción leyendo datos por consola:
     * 1) Elige estudiante de lista
     * 2) Elige curso de lista
     * 3) Crea Inscripcion y la añade a student & curso
     */
    public static void registrarInscripcion(Scanner sc) {
        System.out.println("\n--- Inscribir Estudiante en Curso ---");
        // 1) Mostrar lista de estudiantes
        Estudiante.getListaEstudiantes().forEach(e ->
            System.out.println(" • " + e.getRut() + " - " + e.getNombre())
        );
        System.out.print("RUT Estudiante: ");
        String rut = sc.nextLine().trim();
        Estudiante est = Estudiante.getListaEstudiantes().stream()
            .filter(e -> e.getRut().equals(rut))
            .findFirst()
            .orElse(null);
        if (est == null) {
            System.out.println("❌ Estudiante no Encontrado.");
            return;
        }

        // 2) Mostrar lista de cursos
        Curso.getListaCursos().forEach(c ->
            System.out.println(" • " + c.getCodigoCurso() + " - " + c.getNombre())
        );
        System.out.print("Código Curso: ");
        String cod = sc.nextLine().trim();
        Curso cur = Curso.getListaCursos().stream()
            .filter(c -> c.getCodigoCurso().equals(cod))
            .findFirst()
            .orElse(null);
        if (cur == null) {
            System.out.println("❌ Curso no Encontrado.");
            return;
        }

        // 3) Crear y almacenar
        cur.inscribirEstudiante(est);
        listaInscripciones.add(new Inscripcion(est, cur));
    }

    /** Devuelve la lista global de inscripciones */
    public static List<Inscripcion> getListaInscripciones() {
        return listaInscripciones;
    }

    @Override
    public String toString() {
        return String.format(
            "Inscripción Estudiante=%s, Curso=%s, Promedio=%.2f",
            estudiante.getNombre(),
            curso.getCodigoCurso(),
            calcularPromedio()
        );
    }
}