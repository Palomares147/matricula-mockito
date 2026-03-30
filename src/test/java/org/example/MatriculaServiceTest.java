package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MatriculaServiceTest {

    @Test
    public void testNoPrerequisitos() {

        ValidadorAcademico mockValidador = mock(ValidadorAcademico.class);

        when(mockValidador.aproboPrerequisitos("Juan")).thenReturn(false);

        MatriculaService service = new MatriculaService(mockValidador);

        String resultado = service.registrar("Juan", 15);

        assertEquals("No cumple prerrequisitos", resultado);
    }

    @Test
    public void testAlumnoNuevoExcedeCreditos() {

        ValidadorAcademico mockValidador = mock(ValidadorAcademico.class);

        when(mockValidador.aproboPrerequisitos("Luis")).thenReturn(true);
        when(mockValidador.hayCruceHorario("Luis")).thenReturn(false);
        when(mockValidador.hayVacantes("curso")).thenReturn(true);
        when(mockValidador.esAlumnoNuevo("Luis")).thenReturn(true);

        MatriculaService service = new MatriculaService(mockValidador);

        String resultado = service.registrar("Luis", 15);

        assertEquals("Excede límite de créditos para alumno nuevo", resultado);
    }

}
