package com.ceiba.servicio;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.Paciente;
import com.ceiba.puerto.repositorio.RepositorioPaciente;
import com.ceiba.servicio.paciente.ServicioCrearPaciente;
import com.ceiba.servicio.testdatabuilder.PacienteTestDataBuilder;

public class ServicioCrearPacienteTest {

    @Test
    public void validarUsuarioExistenciaPreviaTest() {
        // arrange
        Paciente usuario = new PacienteTestDataBuilder().build();
        RepositorioPaciente repositorioUsuario = Mockito.mock(RepositorioPaciente.class);
        Mockito.when(repositorioUsuario.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearPaciente servicioCrearUsuario = new ServicioCrearPaciente(repositorioUsuario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearUsuario.ejecutar(usuario), ExcepcionDuplicidad.class, "El paciente ya existe en el sistema");
    }
}
