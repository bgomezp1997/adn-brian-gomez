package com.ceiba.servicio.cita;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.modelo.entidad.Cita;
import com.ceiba.puerto.repositorio.RepositorioCita;
import com.ceiba.util.builder.CitaTestDataBuilder;

public class ServicioEliminarCitaTest {
	
	@Test
    public void ejecutarTodoValido() {
		Cita cita = new CitaTestDataBuilder().conId(1L).build();
		
		RepositorioCita repositorioCita = Mockito.spy(RepositorioCita.class);
		Mockito.doNothing().when(repositorioCita).eliminar(Mockito.anyLong());
		ServicioEliminarCita servicioEliminarCita = new ServicioEliminarCita(repositorioCita);
		servicioEliminarCita.ejecutar(cita.getId());
        
        verify(repositorioCita).eliminar(cita.getId());
    }

}
