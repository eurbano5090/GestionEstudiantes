package com.gestionNotas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Representa a un docente que puede dictar múltiples cursos.
 */
public class Docente {
    private String rut;
    private String nombre;
    private String especializacion;

    /** Relación de los Cursos que dicta un docente */
    private List<Curso> cursos = new ArrayList<>();

    /** Lista Global de Docentes */
    private static List<Docente> listaDocentes = new ArrayList<>();

    /** Constructor completo */
    public Docente(String rut, String nombre, String especializacion) {
        this.rut = rut;
        this.nombre = nombre;
        this.especializacion = especializacion;
    }

    /** ————— Getters y Setters ——————————————————————————————————————————————*/

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

    public String getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    /**
     * Agrega un curso al listado de cursos que dicta el docente.
     */
    public void agregarCurso(Curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
            curso.setDocente(this);
        }
    }

    /** Devuelve la lista global de docentes */
    public static List<Docente> getListaDocentes() {
        return listaDocentes;
    }

    /**————— Métodos y Utilitarios ——————————————————————————————————————————————*/

    /**
     * Lee datos por consola, crea el docente y lo agrega a la lista global.
     */
    public static void registrarDocente(Scanner sc) {
        System.out.println("\n--- Registrar Nuevo Docente ---");
        System.out.print("RUT: ");
        String rut = sc.nextLine().trim();
        System.out.print("Nombre Completo: ");
        String nombre = sc.nextLine().trim();
        System.out.print("Especialización: ");
        String esp = sc.nextLine().trim();

        Docente d = new Docente(rut, nombre, esp);
        listaDocentes.add(d);
        System.out.println("✅ Docente Registrado Exitosamente: " + d.getNombre());
    }

    @Override
    public String toString() {
        return String.format(
            "Docente Rut=%s, Nombre=%s, Especialidad=%s, Carga Cursos=%d",
            rut, nombre, especializacion, cursos.size()
        );
    }
}