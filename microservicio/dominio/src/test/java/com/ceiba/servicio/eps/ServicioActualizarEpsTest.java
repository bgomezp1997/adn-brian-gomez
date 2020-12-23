package com.ceiba.servicio.eps;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.Eps;
import com.ceiba.puerto.repositorio.RepositorioEps;
import com.ceiba.servicio.testdatabuilder.EpsTestDataBuilder;

public class ServicioActualizarEpsTest {

    @Test
    public void validarPacienteConExistenciaTest() {
    	
        Eps eps = new EpsTestDataBuilder().conId(1L).build();
        RepositorioEps repositorioEps = Mockito.mock(RepositorioEps.class);
        Mockito.when(repositorioEps.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(true);
        ServicioActualizarEps servicioActualizarEps = new ServicioActualizarEps(repositorioEps);
       
        BasePrueba.assertThrows(() -> servicioActualizarEps.ejecutar(eps), ExcepcionDuplicidad.class,"La eps ya existe en el sistema");
    }
  
}
