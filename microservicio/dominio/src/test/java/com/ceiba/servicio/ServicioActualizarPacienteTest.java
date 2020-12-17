package com.ceiba.servicio;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.Paciente;
import com.ceiba.puerto.repositorio.RepositorioPaciente;
import com.ceiba.servicio.paciente.ServicioActualizarPaciente;
import com.ceiba.servicio.testdatabuilder.PacienteTestDataBuilder;

public class ServicioActualizarPacienteTest {

    @Test
    public void validarUsuarioExistenciaPreviaTest() {
        // arrange
        Paciente usuario = new PacienteTestDataBuilder().conId(1L).build();
        RepositorioPaciente repositorioUsuario = Mockito.mock(RepositorioPaciente.class);
        Mockito.when(repositorioUsuario.existeExcluyendoId(Mockito.anyLong(),Mockito.anyString())).thenReturn(true);
        ServicioActualizarPaciente servicioActualizarUsuario = new ServicioActualizarPaciente(repositorioUsuario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarUsuario.ejecutar(usuario), ExcepcionDuplicidad.class,"El paciente ya existe en el sistema");
    }
}
