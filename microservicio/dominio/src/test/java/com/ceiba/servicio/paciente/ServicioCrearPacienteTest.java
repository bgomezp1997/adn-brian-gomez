package com.ceiba.servicio.paciente;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.Paciente;
import com.ceiba.puerto.repositorio.RepositorioPaciente;
import com.ceiba.util.builder.PacienteTestDataBuilder;

public class ServicioCrearPacienteTest {

    @Test
    public void validarPacienteExistenciaPreviaTest() {
     
        Paciente paciente = new PacienteTestDataBuilder().build();
        RepositorioPaciente repositorioPaciente = Mockito.mock(RepositorioPaciente.class);
        Mockito.when(repositorioPaciente.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearPaciente servicioCrearPaciente = new ServicioCrearPaciente(repositorioPaciente);
       
        BasePrueba.assertThrows(() -> servicioCrearPaciente.ejecutar(paciente), ExcepcionDuplicidad.class, "El paciente ya existe en el sistema");
    }
    
    @Test
    public void ejecutarTodoValido() {
    	Paciente paciente = new PacienteTestDataBuilder().build();
        RepositorioPaciente repositorioPaciente = Mockito.mock(RepositorioPaciente.class);
        Mockito.when(repositorioPaciente.existe(Mockito.anyString())).thenReturn(false);
        ServicioCrearPaciente servicioCrearPaciente = new ServicioCrearPaciente(repositorioPaciente);
        servicioCrearPaciente.ejecutar(paciente);
        
        verify(repositorioPaciente).crear(paciente);
    }
}
