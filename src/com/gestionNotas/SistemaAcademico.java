package com.gestionNotas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class SistemaAcademico {

  final Scanner sc;

   public SistemaAcademico(Scanner sc) {
    this.sc = sc;
  }

   private static final DateTimeFormatter FORMATO_FECHA =
           DateTimeFormatter.ofPattern("dd/MM/yyyy");
   
  /** Carga un set inicial de datos de prueba */
  public void cargarDatosPrueba() {
    // Estudiantes
    Estudiante e1 = new Estudiante("12345678-1", "Ana Pérez", "Ingeniería", LocalDate.parse("01/03/2021", FORMATO_FECHA));
    Estudiante e2 = new Estudiante("12345678-2", "Luis Ramírez", "Psicología", LocalDate.parse("15/04/2023",FORMATO_FECHA));
    Estudiante.getListaEstudiantes().addAll(Arrays.asList(e1, e2));

    // Docente
    Docente d1 = new Docente("33333333-3", "María Gómez", "Matemáticas");
    Docente.getListaDocentes().add(d1);

    // Cursos
    Curso c1 = new Curso("MAT101", "Matemáticas I", 4);
    Curso c2 = new Curso("PSI201", "Introducción a la Psicología", 3);
    Curso.getListaCursos().addAll(Arrays.asList(c1, c2));
    c1.setDocente(d1);
    c2.setDocente(d1);

    // Evaluaciones
    Evaluacion ev1 = new Evaluacion("Parcial", LocalDate.parse("16/04/2024",FORMATO_FECHA), 60);
    Evaluacion ev2 = new Evaluacion("Trabajo", LocalDate.parse("14/09/2024",FORMATO_FECHA), 40);
    c1.agregarEvaluacion(ev1);
    c1.agregarEvaluacion(ev2);
    c2.agregarEvaluacion(new Evaluacion("Control", LocalDate.parse("05/05/2025",FORMATO_FECHA),100));

    // Inscripciones
    Inscripcion i1 = new Inscripcion(e1, c1);
    Inscripcion i2 = new Inscripcion(e2, c1);
    Inscripcion i3 = new Inscripcion(e1, c2);
    e1.agregarInscripcion(i1);
    e1.agregarInscripcion(i3);
    e2.agregarInscripcion(i2);
    c1.getInscripciones().addAll(Arrays.asList(i1, i2));
    c2.getInscripciones().add(i3);

    // Notas de ejemplo
    i1.asignarCalificacion(ev1,45);
    i1.asignarCalificacion(ev2,35);
    i2.asignarCalificacion(ev1,50);
    i3.asignarCalificacion(c2.getEvaluaciones().get(0),85);

    System.out.println("⚙️ Datos de Prueba Cargados: 2 Estudiantes, 1 Docente, 2 Cursos");
  }

  // ——— Operaciones sobre Estudiantes ——————————————————————

  public void registrarEstudiante() {
    Estudiante.registrarEstudiante(sc);
  }

  public void verCalificaciones() {
    System.out.print("RUT del Estudiante: ");
    String rut = sc.nextLine().trim();
    Optional<Estudiante> opt = Estudiante.getListaEstudiantes().stream()
      .filter(e -> e.getRut().equals(rut))
      .findFirst();
    opt.ifPresentOrElse(
      Estudiante::mostrarCalificaciones,
      () -> System.out.println("❌ Estudiante no Encontrado.")
    );
  }

  public void listarEstudiantes() {
    Estudiante.getListaEstudiantes().forEach(System.out::println);
  }

  // ——— Operaciones sobre Docentes ——————————————————————

  public void registrarDocente() {
    Docente.registrarDocente(sc);
  }

  public void listarDocentes() {
    Docente.getListaDocentes().forEach(System.out::println);
  }

  // ——— Operaciones sobre Cursos ———————————————————————

  public void registrarCurso() {
    Curso.registrarCurso(sc);
  }

  public void inscribirEstudianteEnCurso() {
    System.out.print("RUT estudiante: ");
    String rut = sc.nextLine().trim();
    System.out.print("Código Curso: ");
    String cod = sc.nextLine().trim();

    Optional<Estudiante> optE = Estudiante.getListaEstudiantes().stream()
      .filter(e -> e.getRut().equals(rut)).findFirst();
    Optional<Curso>      optC = Curso.getListaCursos().stream()
      .filter(c -> c.getCodigoCurso().equals(cod)).findFirst();

    if (optE.isPresent() && optC.isPresent()) {
      optC.get().inscribirEstudiante(optE.get());
    } else {
      System.out.println("❌ Estudiante o Curso no Encontrado.");
    }
  }

  public void listarCursos() {
    Curso.getListaCursos().forEach(System.out::println);
  }

  public void listarEstudiantesPorCurso() {
    System.out.print("Código Curso: ");
    String cod = sc.nextLine().trim();
    Curso.getListaCursos().stream()
      .filter(c -> c.getCodigoCurso().equals(cod))
      .findFirst()
      .ifPresentOrElse(
        curso -> curso.getInscripciones()
                       .forEach(ins -> System.out.println(" • " + ins.getEstudiante().getNombre())),
        () -> System.out.println("❌ Curso no Encontrado.")
      );
  }

  // ——— Operaciones sobre Evaluaciones y Notas ——————————————————

  public void crearEvaluacion() {
    System.out.print("Tipo: ");
    String tipo = sc.nextLine().trim();
    System.out.print("Fecha (DD/MM/YYYY): ");
    LocalDate fecha = LocalDate.parse(sc.nextLine().trim(), 
    	    FORMATO_FECHA);

    System.out.print("Puntaje Máximo: ");
    double max = Double.parseDouble(sc.nextLine().trim());

    Evaluacion ev = new Evaluacion(tipo, fecha, max);
    System.out.print("Código Curso: ");
    String cod = sc.nextLine().trim();

    Curso.getListaCursos().stream()
      .filter(c -> c.getCodigoCurso().equals(cod))
      .findFirst()
      .ifPresentOrElse(
        c -> {
          c.agregarEvaluacion(ev);
          System.out.println("✅ Evaluación Creada.");
        },
        () -> System.out.println("❌ Curso no Encontrado.")
      );
  }

  public void asignarCalificacion() {
      System.out.println("\n✏️ Asignar Nota a Estudiante");
      List<Inscripcion> inscripciones = Inscripcion.getListaInscripciones();
      if (inscripciones.isEmpty()) {
          System.out.println("❌ No hay Inscripciones Registradas.");
          return;
      }
      for (int i = 0; i < inscripciones.size(); i++) {
          Inscripcion insc = inscripciones.get(i);
          System.out.printf("%d) %s - %s%n",
              i + 1,
              insc.getEstudiante().getNombre(),
              insc.getCurso().getCodigoCurso()
          );
      }
      System.out.print("Seleccione Inscripción (número): ");
      int idxInsc = Integer.parseInt(sc.nextLine().trim()) - 1;
      if (idxInsc < 0 || idxInsc >= inscripciones.size()) {
          System.out.println("❌ Selección Inválida.");
          return;
      }
      Inscripcion insc = inscripciones.get(idxInsc);
      List<Evaluacion> evs = insc.getCurso().getEvaluaciones();
      if (evs.isEmpty()) {
          System.out.println("❌ El curso no tiene Evaluaciones.");
          return;
      }
      for (int j = 0; j < evs.size(); j++) {
          Evaluacion e = evs.get(j);
          System.out.printf("%d) %s [%s] (Máx: %.2f)%n",
              j + 1, e.getTipo(), e.getFecha(), e.getPuntajeMax());
      }
      System.out.print("Seleccione Evaluación (número): ");
      int idxEv = Integer.parseInt(sc.nextLine().trim()) - 1;
      if (idxEv < 0 || idxEv >= evs.size()) {
          System.out.println("❌ Selección Inválida.");
          return;
      }
      Evaluacion seleccion = evs.get(idxEv);
      System.out.print("Ingrese nota Obtenida: ");
      double nota = Double.parseDouble(sc.nextLine().trim());
      try {
          insc.asignarCalificacion(seleccion, nota);
          System.out.println("✅ Nota Registrada correctamente.");
      } catch (IllegalArgumentException iae) {
          System.out.println("❌ " + iae.getMessage());
      }
  }

  public void verPromediosPorCurso() {
    Curso.getListaCursos().forEach(c ->
      System.out.printf(
        "• %s → %.2f%n",
        c.getCodigoCurso(),
        c.calcularPromedioCurso()
      )
    );
  }

  // ——— Reportes —————————————————————————————————————————

  public void mostrarCursosPorPromedio() {
      System.out.println("\n📈 Cursos con Mejores Promedios:");
      Curso.getListaCursos().stream()
          .sorted((c1, c2) -> Double.compare(
              c2.calcularPromedioCurso(),
              c1.calcularPromedioCurso())
          )
          .limit(5)
          .forEach(c ->
              System.out.printf("• %s → %.2f%n",
                  c.getCodigoCurso(),
                  c.calcularPromedioCurso())
          );
  }

  public void mostrarDocentesPorCarga() {
      System.out.println("\n👨‍🏫 Docentes con Mayor Carga Académica:");
      Docente.getListaDocentes().stream()
          .sorted((d1, d2) -> Integer.compare(
              d2.getCursos().size(),
              d1.getCursos().size())
          )
          .limit(5)
          .forEach(doc ->
              System.out.printf("• %s → %d curso(s)%n",
                  doc.getNombre(),
                  doc.getCursos().size())
          );
  }
  
   public void verPromedioGeneralEstudiante() {
	   System.out.print("Ingrese RUT del Estudiante: ");
       String rut3 = sc.nextLine().trim();
       Estudiante.getListaEstudiantes().stream()
           .filter(e -> e.getRut().equals(rut3))
           .findFirst()
           .ifPresentOrElse(
               e -> System.out.printf(
                   "📘 Promedio General de %s: %.2f%n",
                   e.getNombre(), e.calcularPromedioGeneral()),
               () -> System.out.println("❌ Estudiante no Encontrado.")
           );
  }

  public void buscarEstudiantePorRut() {
	  System.out.print("Ingrese RUT del Estudiante: ");
      String rut4 = sc.nextLine().trim();
      Estudiante.getListaEstudiantes().stream()
          .filter(e -> e.getRut().equals(rut4))
          .findFirst()
          .ifPresentOrElse(
              System.out::println,
              () -> System.out.println("❌ Estudiante no Encontrado.")
          );
  }
}