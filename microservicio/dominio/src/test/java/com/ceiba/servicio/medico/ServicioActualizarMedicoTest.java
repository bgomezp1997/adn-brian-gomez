package com.ceiba.servicio.medico;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.Medico;
import com.ceiba.puerto.repositorio.RepositorioMedico;
import com.ceiba.servicio.testdatabuilder.MedicoTestDataBuilder;

public class ServicioActualizarMedicoTest {

	@Test
	public void validarPacienteConExistenciaTest() {

		Medico medico = new MedicoTestDataBuilder().conId(1L).build();
		RepositorioMedico repositorioMedico = Mockito.mock(RepositorioMedico.class);
		Mockito.when(repositorioMedico.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(true);
		ServicioActualizarMedico servicioActualizarMedico = new ServicioActualizarMedico(repositorioMedico);

		BasePrueba.assertThrows(() -> servicioActualizarMedico.ejecutar(medico), ExcepcionDuplicidad.class, "El medico ya existe en el sistema");
	}

}
