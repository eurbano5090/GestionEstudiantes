package com.gestionNotas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Representa un curso con código, créditos y su docente asignado.
 * Un curso tiene múltiples inscripciones (estudiantes + calificaciones)
 * y múltiples evaluaciones (Examen, Trabajo, Control).
 */
public class Curso {
    private String codigoCurso;
    private String nombre;
    private int numeroCreditos;

    /** Relación con Docente (Composición) */
    private Docente docente;
    
    /** Relación: las inscripciones de estudiantes a este curso*/
    private List<Inscripcion> inscripciones = new ArrayList<>();
    
    /** Relación: las evaluaciones programadas en este curso*/
    private List<Evaluacion> evaluaciones = new ArrayList<>();

    /** Lista global de cursos*/
    private static List<Curso> listaCursos = new ArrayList<>();

    /** Constructor completo */
    public Curso(String codigoCurso, String nombre, int numeroCreditos) {
        this.codigoCurso = codigoCurso;
        this.nombre = nombre;
        this.numeroCreditos = numeroCreditos;
    }

    /** ————— Getters y Setters ——————————————————————————————————————————————*/

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroCreditos() {
        return numeroCreditos;
    }

    public void setNumeroCreditos(int numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }

    public Docente getDocente() {
        return docente;
    }

    /**
     * Asigna (o reasigna) un docente a este curso.
     */
    public void setDocente(Docente docente) {
        this.docente = docente;
        if (!docente.getCursos().contains(this)) {
            docente.agregarCurso(this);
        }
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public List<Evaluacion> getEvaluaciones() {
        return evaluaciones;
    }

    /**
     * Inscribe un estudiante a este curso, creando la Inscripción
     * y agregándola tanto a curso como a estudiante.
     */
    public void inscribirEstudiante(Estudiante est) {
    	/** Evita duplicar inscripción*/
        for (Inscripcion insc : inscripciones) {
            if (insc.getEstudiante().equals(est)) {
                System.out.println("❌ El estudiante ya está Inscrito.");
                return;
            }
        }
        Inscripcion insc = new Inscripcion(est, this);
        inscripciones.add(insc);
        est.agregarInscripcion(insc);
        System.out.println("✅ Estudiante Inscrito al Curso " + codigoCurso);
    }


    /**
     * Agrega una nueva evaluación al curso.
     */
    public void agregarEvaluacion(Evaluacion ev) {
        evaluaciones.add(ev);
    }

    /**
     * Calcula el promedio del curso: promedio de cada inscripción.
     */
    public double calcularPromedioCurso() {
        if (inscripciones.isEmpty()) return 0.0;
        double suma = 0;
        for (Inscripcion insc : inscripciones) {
            suma += insc.calcularPromedio();
        }
        return suma / inscripciones.size();
    }

    /** Devuelve la lista global de cursos */
    public static List<Curso> getListaCursos() {
        return listaCursos;
    }

    /**
     * Método estático que crea un curso leyendo de consola
     * y lo agrega a listaCursos.
     */
    public static void registrarCurso(Scanner sc) {
        System.out.println("\n--- Registrar Nuevo Curso ---");
        System.out.print("Código Curso: ");
        String codigo = sc.nextLine().trim();
        System.out.print("Nombre Curso: ");
        String nombre = sc.nextLine().trim();
        System.out.print("N° Créditos: ");
        int creds = Integer.parseInt(sc.nextLine().trim());

        Curso c = new Curso(codigo, nombre, creds);
        listaCursos.add(c);
        System.out.println("✅ Curso Registrado Exitosamente: " + c.getCodigoCurso());
    }
   

    @Override
    public String toString() {
        String doc = (docente == null)
            ? "Sin asignar"
            : docente.getNombre();
        return String.format(
            "Curso Código=%s, Nombre=%s, Créditos=%d, Docente=%s, Insc=%d, Eval=%d",
            codigoCurso, nombre, numeroCreditos,
            doc, inscripciones.size(), evaluaciones.size()
        );
    }
}