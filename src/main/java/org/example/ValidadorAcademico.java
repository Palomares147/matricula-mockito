package org.example;

public interface ValidadorAcademico {
    boolean aproboPrerequisitos(String estudiante);
    boolean hayCruceHorario(String estudiante);
    boolean hayVacantes(String curso);
    boolean esAlumnoNuevo(String estudiante);
    boolean tieneBeca(String estudiante);
}
