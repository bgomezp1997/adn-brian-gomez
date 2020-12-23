package com.ceiba.servicio.medico;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.Medico;
import com.ceiba.puerto.repositorio.RepositorioMedico;
import com.ceiba.servicio.testdatabuilder.MedicoTestDataBuilder;

public class ServicioCrearMedicoTest {

    @Test
    public void validarUsuarioExistenciaPreviaTest() {
    	
    	Medico medico = new MedicoTestDataBuilder().build();
    	RepositorioMedico repositorioMedico = Mockito.mock(RepositorioMedico.class);
        Mockito.when(repositorioMedico.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearMedico servicioCrearMedico = new ServicioCrearMedico(repositorioMedico);
        
        BasePrueba.assertThrows(() -> servicioCrearMedico.ejecutar(medico), ExcepcionDuplicidad.class, "El medico ya existe en el sistema");
    }
}
