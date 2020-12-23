package com.ceiba.servicio.paciente;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.Paciente;
import com.ceiba.puerto.repositorio.RepositorioPaciente;
import com.ceiba.servicio.testdatabuilder.PacienteTestDataBuilder;

public class ServicioCrearPacienteTest {

    @Test
    public void validarUsuarioExistenciaPreviaTest() {
     
        Paciente usuario = new PacienteTestDataBuilder().build();
        RepositorioPaciente repositorioPaciente = Mockito.mock(RepositorioPaciente.class);
        Mockito.when(repositorioPaciente.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearPaciente servicioCrearPaciente = new ServicioCrearPaciente(repositorioPaciente);
       
        BasePrueba.assertThrows(() -> servicioCrearPaciente.ejecutar(usuario), ExcepcionDuplicidad.class, "El paciente ya existe en el sistema");
    }
}
