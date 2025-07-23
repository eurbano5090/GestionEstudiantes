package com.gestionNotas;

public class Curso {
	
	private String codigoCurso;
	private String nombre;
	private int numeroCreditos;
	private String docenteAsignado;
	/**
	 * 
	 */
	public Curso() {
		super();
	}
	/**
	 * @param codigo
	 * @param nombre
	 * @param numeroCreditos
	 * @param docenteAsignado
	 */
	public Curso(String codigoCurso, String nombre, int numeroCreditos, String docenteAsignado) {
		super();
		this.codigoCurso = codigoCurso;
		this.nombre = nombre;
		this.numeroCreditos = numeroCreditos;
		this.docenteAsignado = docenteAsignado;
	}
	/**
	 * @return the codigo
	 */
	public String getCodigoCurso() {
		return codigoCurso;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
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
	 * @return the numeroCreditos
	 */
	public int getNumeroCreditos() {
		return numeroCreditos;
	}
	/**
	 * @param numeroCreditos the numeroCreditos to set
	 */
	public void setNumeroCreditos(int numeroCreditos) {
		this.numeroCreditos = numeroCreditos;
	}
	/**
	 * @return the docenteAsignado
	 */
	public String getDocenteAsignado() {
		return docenteAsignado;
	}
	/**
	 * @param docenteAsignado the docenteAsignado to set
	 */
	public void setDocenteAsignado(String docenteAsignado) {
		this.docenteAsignado = docenteAsignado;
	}
	
	

}
