package com.ceiba.cache;

import java.util.ArrayList;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.consulta.ManejadorListarParametros;

public class CacheTest {
	
	@Test
	public void cargarCache() {
		ManejadorListarParametros manejadorListarParametros = Mockito.mock(ManejadorListarParametros.class);
		Mockito.when(manejadorListarParametros.ejecutar()).thenReturn(new ArrayList<>());
		CacheComponent cacheComponent = new CacheComponent(manejadorListarParametros);
		cacheComponent.createCache();
	}

}
