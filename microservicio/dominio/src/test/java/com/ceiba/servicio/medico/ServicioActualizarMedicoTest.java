package com.ceiba.servicio.medico;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.Medico;
import com.ceiba.puerto.repositorio.RepositorioMedico;
import com.ceiba.util.builder.MedicoTestDataBuilder;

public class ServicioActualizarMedicoTest {

	@Test
	public void validarMedicoConExistenciaTest() {

		Medico medico = new MedicoTestDataBuilder().conId(1L).build();
		RepositorioMedico repositorioMedico = Mockito.mock(RepositorioMedico.class);
		Mockito.when(repositorioMedico.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(true);
		ServicioActualizarMedico servicioActualizarMedico = new ServicioActualizarMedico(repositorioMedico);

		BasePrueba.assertThrows(() -> servicioActualizarMedico.ejecutar(medico), ExcepcionDuplicidad.class, "El medico ya existe en el sistema");
	}
	
	@Test
    public void ejecutarTodoValido() {
		Medico medico = new MedicoTestDataBuilder().conId(1L).build();
		RepositorioMedico repositorioMedico = Mockito.mock(RepositorioMedico.class);
		Mockito.when(repositorioMedico.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(false);
		ServicioActualizarMedico servicioActualizarMedico = new ServicioActualizarMedico(repositorioMedico);
		servicioActualizarMedico.ejecutar(medico);
        
        verify(repositorioMedico).actualizar(medico);
    }

}
