package com.gestionNotas;

import java.util.Scanner;

public class MenuAcademico {

	
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    SistemaAcademico sistema = new SistemaAcademico(sc);

    // 1) Cargo datos de prueba
    sistema.cargarDatosPrueba();

    // 2) Bucle principal
    boolean salir = false;
    while (!salir) {
      System.out.println("\n🎓 BIENVENIDA(O) A MENÚ PRINCIPAL BOOTCLASS");
      System.out.println("1️. 👩‍🎓 Gestión de Estudiantes");
      System.out.println("2️. 👨‍🏫 Gestión de Docentes");
      System.out.println("3️. 📚 Gestión de Cursos");
      System.out.println("4️. 📝 Evaluaciones y Notas");
      System.out.println("5️. 📊 Consultas y Reportes");
      System.out.println("6️. 🛑 Salir");
      System.out.print("👉 Ingrese su Opción: ");

      String op = sc.nextLine().trim();
      switch (op) {
        case "1" -> menuEstudiantes(sistema);
        case "2" -> menuDocentes(sistema);
        case "3" -> menuCursos(sistema);
        case "4" -> menuEvaluaciones(sistema);
        case "5" -> menuReportes(sistema);
        case "6" -> salir = true;
        default  -> System.out.println("❌ Opción Inválida");
      }
    }

    System.out.println("👋 ¡Hasta pronto! Muchas Gracias por Utilizar BootClass");
    sc.close();
  }

  private static void menuEstudiantes(SistemaAcademico sys) {
    boolean volver = false;
    while (!volver) {
      System.out.println("\n📂 Gestión de Estudiantes");
      System.out.println("1. ➕ Registrar estudiante");
      System.out.println("2. 🧾 Listar estudiantes");
      System.out.println("3. 👀 Ver calificaciones");
      System.out.println("4. 🔙 Volver al Menú Principal");
      System.out.print("👉 Ingrese su Opción: ");

      switch (sys.sc.nextLine().trim()) {
        case "1" -> sys.registrarEstudiante();
        case "2" -> sys.listarEstudiantes();
        case "3" -> sys.verCalificaciones();
        case "4" -> volver = true;
        default  -> System.out.println("❌ Opción Inválida");
      }
    }
  }

  private static void menuDocentes(SistemaAcademico sys) {
    boolean volver = false;
    while (!volver) {
      System.out.println("\n📂 Gestión de Docentes");
      System.out.println("1. ➕ Registrar docente");
      System.out.println("2. 🧾 Listar docentes");
      System.out.println("3. 🔙 Volver al Menú Principal");
      System.out.print("👉 Ingrese su Opción: ");

      switch (sys.sc.nextLine().trim()) {
        case "1" -> sys.registrarDocente();
        case "2" -> sys.listarDocentes();
        case "3" -> volver = true;
        default  -> System.out.println("❌ Opción Inválida");
      }
    }
  }

  private static void menuCursos(SistemaAcademico sys) {
    boolean volver = false;
    while (!volver) {
      System.out.println("\n📂 Gestión de Cursos");
      System.out.println("1. ➕ Registrar curso");
      System.out.println("2. 🧾 Listar cursos");
      System.out.println("3. 👥 Listar estudiantes por curso");
      System.out.println("4. 🔗 Inscribir Estudiante a un Curso");
      System.out.println("5. 🔙 Volver al Menú Principal");
      System.out.print("👉 Ingrese su Opción: ");

      switch (sys.sc.nextLine().trim()) {
        case "1" -> sys.registrarCurso();
        case "2" -> sys.listarCursos();
        case "3" -> sys.listarEstudiantesPorCurso();
        case "4" -> sys.inscribirEstudianteEnCurso();
        case "5" -> volver = true;
        default  -> System.out.println("❌ Opción Inválida");
      }
    }
  }

  private static void menuEvaluaciones(SistemaAcademico sys) {
    boolean volver = false;
    while (!volver) {
      System.out.println("\n📂 Evaluaciones y Notas");
      System.out.println("1. 📝 Crear Evaluación");
      System.out.println("2. ✏️ Asignar Nota");
      System.out.println("3. 📘 Ver promedios por Curso");
      System.out.println("4. 🔙 Volver al Menú Principal");
      System.out.print("👉 Ingrese su Opción: ");

      switch (sys.sc.nextLine().trim()) {
        case "1" -> sys.crearEvaluacion();
        case "2" -> sys.asignarCalificacion();
        case "3" -> sys.verPromediosPorCurso();
        case "4" -> volver = true;
        default  -> System.out.println("❌ Opción Inválida");
      }
    }
  }

  private static void menuReportes(SistemaAcademico sys) {
    boolean volver = false;
    while (!volver) {
      System.out.println("\n📂 Consultas y Reportes");
      System.out.println("1. 📈 Cursos con Mejores Promedios");
      System.out.println("2. 👨‍🏫 Docentes con Mayor Carga Académica");
      System.out.println("3. 🧮 Promedio General de Estudiante");
      System.out.println("4. 🔍 Buscar Estudiante por RUT");
      System.out.println("5. 🔙 Volver");
      System.out.print("👉 Ingrese su Opción: ");

      switch (sys.sc.nextLine().trim()) {
        case "1" -> sys.mostrarCursosPorPromedio();
        case "2" -> sys.mostrarDocentesPorCarga();
        case "3" -> sys.verPromedioGeneralEstudiante();
        case "4" -> sys.buscarEstudiantePorRut();
        case "5" -> volver = true;
        default  -> System.out.println("❌ Opción inválida");
      }
    }
  }
}