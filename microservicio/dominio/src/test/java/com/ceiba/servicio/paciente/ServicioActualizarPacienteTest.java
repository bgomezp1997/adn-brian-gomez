package com.ceiba.servicio.paciente;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.Paciente;
import com.ceiba.puerto.repositorio.RepositorioPaciente;
import com.ceiba.servicio.testdatabuilder.PacienteTestDataBuilder;

public class ServicioActualizarPacienteTest {

    @Test
    public void validarPacienteConExistenciaTest() {
    	
        Paciente usuario = new PacienteTestDataBuilder().conId(1L).build();
        RepositorioPaciente repositorioPaciente = Mockito.mock(RepositorioPaciente.class);
        Mockito.when(repositorioPaciente.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(true);
        ServicioActualizarPaciente servicioActualizarPaciente = new ServicioActualizarPaciente(repositorioPaciente);
       
        BasePrueba.assertThrows(() -> servicioActualizarPaciente.ejecutar(usuario), ExcepcionDuplicidad.class,"El paciente ya existe en el sistema");
    }
  
}
