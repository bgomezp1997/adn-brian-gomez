package com.ceiba.servicio.eps;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.modelo.entidad.Eps;
import com.ceiba.puerto.repositorio.RepositorioEps;
import com.ceiba.util.builder.EpsTestDataBuilder;

public class ServicioEliminarEpsTest {
	
	@Test
    public void ejecutarTodoValido() {
		Eps eps = new EpsTestDataBuilder().conId(1L).build();
		
		RepositorioEps repositorioEps = Mockito.spy(RepositorioEps.class);
		Mockito.doNothing().when(repositorioEps).eliminar(Mockito.anyLong());
		ServicioEliminarEps servicioEliminarPaciente = new ServicioEliminarEps(repositorioEps);
		servicioEliminarPaciente.ejecutar(eps.getId());
        
        verify(repositorioEps).eliminar(eps.getId());
    }

}
