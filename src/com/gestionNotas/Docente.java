package com.gestionNotas;

public class Docente {

	private String rut;
	private String nombre;
	private String especializacion;
	/**
	 * 
	 */
	public Docente() {
		super();
	}
	/**
	 * @param rut
	 * @param nombre
	 * @param especializacion
	 */
	public Docente(String rut, String nombre, String especializacion) {
		super();
		this.rut = rut;
		this.nombre = nombre;
		this.especializacion = especializacion;
	}
	/**
	 * @return the rut
	 */
	public String getRut() {
		return rut;
	}
	/**
	 * @param rut the rut to set
	 */
	public void setRut(String rut) {
		this.rut = rut;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the especializacion
	 */
	public String getEspecializacion() {
		return especializacion;
	}
	/**
	 * @param especializacion the especializacion to set
	 */
	public void setEspecializacion(String especializacion) {
		this.especializacion = especializacion;
	}
	
	public static void asociarDocenteCurso() {};
}
