package com.ceiba.servicio.medico;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.modelo.entidad.Medico;
import com.ceiba.puerto.repositorio.RepositorioMedico;
import com.ceiba.util.builder.MedicoTestDataBuilder;

public class ServicioEliminarMedicoTest {
	
	@Test
    public void ejecutarTodoValido() {
		Medico medico = new MedicoTestDataBuilder().conId(1L).build();
		
		RepositorioMedico repositorioMedico = Mockito.spy(RepositorioMedico.class);
		Mockito.doNothing().when(repositorioMedico).eliminar(Mockito.anyLong());
		ServicioEliminarMedico servicioEliminarMedico = new ServicioEliminarMedico(repositorioMedico);
		servicioEliminarMedico.ejecutar(medico.getId());
        
        verify(repositorioMedico).eliminar(medico.getId());
    }

}
