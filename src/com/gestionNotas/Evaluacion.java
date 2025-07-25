package com.gestionNotas;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Representa una evaluación (Examen, Trabajo o Control)
 * programada en un curso, con fecha y puntaje máximo.
 * Guarda las calificaciones de cada estudiante inscrito.
 */
public class Evaluacion {
    private String tipo;               // Examen | Trabajo | Control
    private LocalDate fecha;
    private double puntajeMax;

    /** Mapa de notas por Inscripción (enlace Estudiante–Curso)*/
    private Map<Inscripcion, Double> calificaciones = new HashMap<>();

    /** Constructor completo */
    public Evaluacion(String tipo, LocalDate fecha, double puntajeMax) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.puntajeMax = puntajeMax;
    }

    /** ————— Getters y Setters ——————————————————————————————————————————————*/

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getPuntajeMax() {
        return puntajeMax;
    }

    public void setPuntajeMax(double puntajeMax) {
        this.puntajeMax = puntajeMax;
    }

    public Map<Inscripcion, Double> getCalificaciones() {
        return calificaciones;
    }

    /**
     * Asigna una nota a una inscripción (estudiante–curso).
     * Valida rango 0..puntajeMax.
     */
    public void asignarNota(Inscripcion inscripciones, double nota) {
        if (nota < 0 || nota > puntajeMax) {
            throw new IllegalArgumentException(
                "Nota Fuera de Rango 0–" + puntajeMax);
        }
        calificaciones.put(inscripciones, nota);
    }

    @Override
    public String toString() {
        return String.format(
            "Evaluación Tipo=%s, Fecha=%s, Máximo=%.2f, Califs=%d",
            tipo, fecha, puntajeMax, calificaciones.size()
        );
    }
}