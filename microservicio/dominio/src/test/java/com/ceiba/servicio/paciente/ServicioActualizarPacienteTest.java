package com.ceiba.servicio.paciente;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.Paciente;
import com.ceiba.puerto.repositorio.RepositorioPaciente;
import com.ceiba.util.builder.PacienteTestDataBuilder;

public class ServicioActualizarPacienteTest {

    @Test
    public void validarPacienteConExistenciaTest() {
    	
        Paciente paciente = new PacienteTestDataBuilder().conId(1L).build();
        RepositorioPaciente repositorioPaciente = Mockito.mock(RepositorioPaciente.class);
        Mockito.when(repositorioPaciente.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(true);
        ServicioActualizarPaciente servicioActualizarPaciente = new ServicioActualizarPaciente(repositorioPaciente);
       
        BasePrueba.assertThrows(() -> servicioActualizarPaciente.ejecutar(paciente), ExcepcionDuplicidad.class,"El paciente ya existe en el sistema");
    }
    
    @Test
    public void ejecutarTodoValido() {
    	 Paciente paciente = new PacienteTestDataBuilder().conId(1L).build();
         RepositorioPaciente repositorioPaciente = Mockito.mock(RepositorioPaciente.class);
         Mockito.when(repositorioPaciente.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(false);
         ServicioActualizarPaciente servicioActualizarPaciente = new ServicioActualizarPaciente(repositorioPaciente);
         servicioActualizarPaciente.ejecutar(paciente);
        
        verify(repositorioPaciente).actualizar(paciente);
    }
  
}
