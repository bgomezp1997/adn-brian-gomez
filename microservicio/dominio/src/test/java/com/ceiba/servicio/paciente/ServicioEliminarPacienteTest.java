package com.ceiba.servicio.paciente;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.modelo.entidad.Paciente;
import com.ceiba.puerto.repositorio.RepositorioPaciente;
import com.ceiba.util.builder.PacienteTestDataBuilder;

public class ServicioEliminarPacienteTest {
	
	@Test
    public void ejecutarTodoValido() {
		Paciente paciente = new PacienteTestDataBuilder().conId(1L).build();
		
		RepositorioPaciente repositorioPaciente = Mockito.spy(RepositorioPaciente.class);
		Mockito.doNothing().when(repositorioPaciente).eliminar(Mockito.anyLong());
		ServicioEliminarPaciente servicioEliminarPaciente = new ServicioEliminarPaciente(repositorioPaciente);
		servicioEliminarPaciente.ejecutar(paciente.getId());
        
        verify(repositorioPaciente).eliminar(paciente.getId());
    }

}
