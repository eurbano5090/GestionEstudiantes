package com.gestionNotas;

import java.time.LocalDate;

public class Evaluacion {

	private String tipo; /// Examen, Trabajo, Control
	private LocalDate fecha;
	private double puntajeMax;

	/**
	 * 
	 */
	public Evaluacion() {
		super();
	}

	/**
	 * @param tipo
	 * @param fecha
	 * @param puntajeMax
	 */
	public Evaluacion(String tipo, LocalDate fecha, double puntajeMax) {
		super();
		this.tipo = tipo;
		this.fecha = fecha;
		this.puntajeMax = puntajeMax;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the fecha
	 */
	public LocalDate getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the puntajeMax
	 */
	public double getPuntajeMax() {
		return puntajeMax;
	}

	/**
	 * @param puntajeMax the puntajeMax to set
	 */
	public void setPuntajeMax(double puntajeMax) {
		this.puntajeMax = puntajeMax;
	}

	public static void asignarEvaluaciones() {
	};

}
