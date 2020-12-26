package com.ceiba.util.premock;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

import org.mockito.Mockito;

import com.ceiba.cache.CacheComponent;
import com.ceiba.modelo.dto.DtoParametro;
import com.ceiba.puerto.dao.DaoParametro;
import com.ceiba.util.builder.ParametroTestDataBuilder;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class MockCache {
	
	public static void mockParametros(boolean conDatos) throws JsonParseException, JsonMappingException, IOException {
		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);
		if (conDatos) {
			List<DtoParametro> parametros = new ParametroTestDataBuilder().conDatos().build();
			Mockito.when(daoParametro.listarPorEstado(Mockito.anyBoolean())).thenReturn(parametros);
		} else {
			List<DtoParametro> parametros = new ParametroTestDataBuilder().build();
			Mockito.when(daoParametro.listarPorEstado(Mockito.anyBoolean())).thenReturn(parametros);
		}
		CacheComponent cacheComponent = new CacheComponent(daoParametro);
		assertNotNull(cacheComponent);
	}


}
