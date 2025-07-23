package com.gestionNotas;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;





public class GestionNotas {
	
	static Scanner scan= new Scanner(System.in);
	private static final int MAX_ESTUDIANTES = 30;
	static ArrayList<Estudiante> estudiantes = new ArrayList<>();
	private static int contador = 0;

    
	public static void agregarEstudiantes() {
	  DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	  ArrayList<Double> evaluaciones = new ArrayList<>();
		  if (contador >= MAX_ESTUDIANTES) {
	            System.out.println("🚫 Límite de estudiantes alcanzado.");
	            return;
	        }
	  System.out.println("Ingrese nombre del Estudiante");
	  String nombre= scan.nextLine().trim();
	  System.out.println("Ingrese evaluaciones del estudiante");
	 
      for (int i = 0; i < 5; i++) {
          System.out.print("  Evaluaciones " + (i + 1) + ": ");
          evaluaciones.add(Double.parseDouble(scan.nextLine().trim()));
      }
      System.out.println("Ingrese rut  del Estudiante");
	  String rut= scan.nextLine().trim();
	  
	  System.out.println("Ingrese carrera del Estudiante");
	  String carrera= scan.nextLine().trim();
	  System.out.print("Ingrese fecha de ingreso (dd-MM-yyyy): ");
	  String fechaStr = scan.nextLine().trim();
	  
	  

	  LocalDate añoIngreso = LocalDate.parse(fechaStr, formato);
      estudiantes.add(new Estudiante(nombre, rut, carrera,  añoIngreso, evaluaciones));
      System.out.println("✅ Estudiante agregado correctamente. Total: " + contador);
	};
	
	
	public static void listarEstudiantes() {
		  if (contador == 0) {
	            System.out.println("📭 No hay estudiantes registrados.");
	            return;
	        }
	        System.out.println("📋 Lista de estudiantes:");
	        System.out.println("======================");
	        for (int i = 0; i < contador; i++) {
	            System.out.println((i + 1) + ". " + estudiantes.get(i));
	            System.out.println("----------------------");
	        }
		
	};
	


	  
	public static void listarAprobados() {
		   if (contador == 0) {
	            System.out.println("No hay estudiantes registrados.");
	            return;
	        }
	        System.out.printf("🏅 Estudiantes con promedio >= %.2f:%n", 4.0);
	        boolean hay = false;
	        for (Estudiante est :estudiantes) {
	        	if (est.getPromedio() >= 4.0) {
	                System.out.printf("%s → %.2f%n", est.getNombre(),est.getPromedio());
	                hay = true;
	            }
	            System.out.println("----------------------");
	        }
	     
	        if (!hay) {
	            System.out.println("Ninguno.");
	        }
	};
}
