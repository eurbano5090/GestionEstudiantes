package com.gestionNotas;

public class Inscripcion {

	private int idInscripcion;
	private String rutEstudiante;
	private int codigoCurso;
	private String nombreDocente;
	
	
	
	/**
	 * 
	 */
	public Inscripcion() {
		super();
	}



	/**
	 * @param idInscripcion
	 * @param rutEstudiante
	 * @param codigoCurso
	 * @param nombreDocente
	 */
	public Inscripcion(int idInscripcion, String rutEstudiante, int codigoCurso, String nombreDocente) {
		super();
		this.idInscripcion = idInscripcion;
		this.rutEstudiante = rutEstudiante;
		this.codigoCurso = codigoCurso;
		this.nombreDocente = nombreDocente;
	}



	/**
	 * @return the idInscripcion
	 */
	public int getIdInscripcion() {
		return idInscripcion;
	}



	/**
	 * @param idInscripcion the idInscripcion to set
	 */
	public void setIdInscripcion(int idInscripcion) {
		this.idInscripcion = idInscripcion;
	}



	/**
	 * @return the rutEstudiante
	 */
	public String getRutEstudiante() {
		return rutEstudiante;
	}



	/**
	 * @param rutEstudiante the rutEstudiante to set
	 */
	public void setRutEstudiante(String rutEstudiante) {
		this.rutEstudiante = rutEstudiante;
	}



	/**
	 * @return the codigoCurso
	 */
	public int getCodigoCurso() {
		return codigoCurso;
	}



	/**
	 * @param codigoCurso the codigoCurso to set
	 */
	public void setCodigoCurso(int codigoCurso) {
		this.codigoCurso = codigoCurso;
	}



	/**
	 * @return the nombreDocente
	 */
	public String getNombreDocente() {
		return nombreDocente;
	}



	/**
	 * @param nombreDocente the nombreDocente to set
	 */
	public void setNombreDocente(String nombreDocente) {
		this.nombreDocente = nombreDocente;
	}



	public static void asociarEstudianteCurso() {};
}
