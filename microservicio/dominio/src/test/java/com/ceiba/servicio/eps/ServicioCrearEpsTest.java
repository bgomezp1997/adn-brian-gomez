package com.ceiba.servicio.eps;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.Eps;
import com.ceiba.puerto.repositorio.RepositorioEps;
import com.ceiba.util.builder.EpsTestDataBuilder;

public class ServicioCrearEpsTest {

    @Test
    public void validarEpsExistenciaPreviaTest() {
    	
    	Eps eps = new EpsTestDataBuilder().build();
    	RepositorioEps repositorioEps = Mockito.mock(RepositorioEps.class);
        Mockito.when(repositorioEps.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearEps servicioCrearEps = new ServicioCrearEps(repositorioEps);
        
        BasePrueba.assertThrows(() -> servicioCrearEps.ejecutar(eps), ExcepcionDuplicidad.class, "La eps ya existe en el sistema");
    }
    
    @Test
    public void ejecutarTodoValido() {
    	Eps eps = new EpsTestDataBuilder().build();
    	RepositorioEps repositorioEps = Mockito.mock(RepositorioEps.class);
        Mockito.when(repositorioEps.existe(Mockito.anyString())).thenReturn(false);
        ServicioCrearEps servicioCrearEps = new ServicioCrearEps(repositorioEps);
        servicioCrearEps.ejecutar(eps);
        
        verify(repositorioEps).crear(eps);
    }
}
