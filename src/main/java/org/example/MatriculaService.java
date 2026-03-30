package org.example;

public class MatriculaService {

    private ValidadorAcademico validador;

    public MatriculaService(ValidadorAcademico validador) {
        this.validador = validador;
    }

    public String registrar(String estudiante, int creditos) {

        if (!validador.aproboPrerequisitos(estudiante)) {
            return "No cumple prerrequisitos";
        }

        if (validador.hayCruceHorario(estudiante)) {
            return "Horario cruzado";
        }

        if (!validador.hayVacantes("curso")) {
            return "No hay vacantes";
        }

        if (validador.esAlumnoNuevo(estudiante) && creditos > 12) {
            return "Excede límite de créditos para alumno nuevo";
        }

        if (creditos > 20) {
            return "Excede máximo de créditos";
        }

        double costo = creditos * 100;

        if (validador.tieneBeca(estudiante)) {
            costo = costo * 0.5;
        }

        return "Matrícula registrada. Costo: " + costo;
    }
}
