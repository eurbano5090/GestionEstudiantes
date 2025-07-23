package com.gestionNotas;

import java.util.Scanner;


public class Menu {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
      
        while (!salir) {
            System.out.println("\n--- MENÚ DE GESTIÓN DE TAREAS ---");
            System.out.println("1 ▪ Agregar estudiante");
            System.out.println("2 ▪ Calcular y mostrar promedio");
            System.out.println("3 ▪ Mostrar todos los estudiantes.");
            System.out.println("4 ▪ Mostrar estudiantes aprobados.");
            System.out.println("5 ▪ Salir.");
          
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1": GestionNotas.agregarEstudiantes(); break;
                case "2": Estudiante.calcularPromedio(); break;
                case "3": GestionNotas.listarEstudiantes(); break;
                case "4": GestionNotas.listarAprobados(); break;
                case "5": salir = true; break;
                default: System.out.println("❌ Opción inválida.");
            }
        }

        System.out.println("👋 ¡Programa finalizado!");
        scanner.close();
    }

	}

