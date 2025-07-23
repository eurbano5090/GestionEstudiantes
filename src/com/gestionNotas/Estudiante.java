package com.gestionNotas;

import java.time.LocalDate;
import java.util.ArrayList;

public class Estudiante {

	  private String nombre;
	  private String rut;
	  private String carrera;
	  private LocalDate añoIngreso;
	  
	  private double promedio; 
	
      ArrayList<Double> evaluaciones = new ArrayList<>();
      static ArrayList<Estudiante> estudiantes = new ArrayList<>();
	
    /**
	 * 
	 */
	public Estudiante() {
		super();
	}



	/**
	 * @param nombre
	 * @param rut
	 * @param carrera
	 * @param añoIngreso
	 * @param promedio
	 * @param notas
	 */
	public Estudiante(String nombre, String rut, String carrera, LocalDate añoIngreso,
			ArrayList<Double> evaluaciones) {
		super();
		this.nombre = nombre;
		this.rut = rut;
		this.carrera = carrera;
		this.añoIngreso = añoIngreso;
		this.evaluaciones = evaluaciones;
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
	 * @return the carrera
	 */
	public String getCarrera() {
		return carrera;
	}



	/**
	 * @param carrera the carrera to set
	 */
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}



	/**
	 * @return the añoIngreso
	 */
	public LocalDate getAñoIngreso() {
		return añoIngreso;
	}



	/**
	 * @param añoIngreso the añoIngreso to set
	 */
	public void setAñoIngreso(LocalDate añoIngreso) {
		this.añoIngreso = añoIngreso;
	}



	/**
	 * @return the promedio
	 */
	public double getPromedio() {
		return promedio;
	}



	/**
	 * @param promedio the promedio to set
	 */
	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}



	/**
	 * @return the notas
	 */
	public ArrayList<Double> getEvaluaciones() {
		return evaluaciones;
	}



	/**
	 * @param notas the notas to set
	 */
	public void setEvaluaciones(ArrayList<Double> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}



	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Estudiante: ").append(nombre).append("\n");
        sb.append("Notas: ");
        if (evaluaciones != null && evaluaciones.size() > 0) {
            for (int i = 0; i < evaluaciones.size(); i++) {
                sb.append(String.format("%.2f", evaluaciones.get(i)));
                if (i < evaluaciones.size() - 1) sb.append(", ");
            }
        } else {
            sb.append("No hay notas registradas");
        }
        sb.append("\nPromedio: ").append(String.format("%.2f", promedio));
        return sb.toString();
    }
    
	public static void calcularPromedio() {
	    for (Estudiante estud : estudiantes) {
	        if (estud == null) continue;

	        ArrayList<Double> notas = estud.getEvaluaciones();
	        double suma = 0;

	        for (double nota : notas) {
	            suma += nota;
	        }

	        double promedio = (notas.size() > 0) ? suma / notas.size() : 0;

	        estud.setPromedio(promedio);
	        System.out.println(estud.toString());
	    }
	}
  
}
