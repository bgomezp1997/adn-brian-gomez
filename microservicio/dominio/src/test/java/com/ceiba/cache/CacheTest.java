package com.ceiba.cache;

import java.io.IOException;

import org.junit.Test;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionCache;
import com.ceiba.modelo.util.EnumParametro;
import com.ceiba.modelo.util.EnumTipoParametro;
import com.ceiba.util.premock.MockCache;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class CacheTest {

	@Test
	public void obtainListByTipoParametroSinParametros() throws JsonParseException, JsonMappingException, IOException {
		MockCache.mockParametros(Boolean.FALSE);
		BasePrueba.assertThrows(() -> CacheUtil.obtainListByTipoParametro(EnumTipoParametro.ESPECIALIDAD), ExcepcionCache.class, "No se encontro parametro con nombre: ESPECIALIDAD");
	}
	
	@Test
	public void obtainParameterByTipoParametroAndParametroSinParametros() throws JsonParseException, JsonMappingException, IOException {
		MockCache.mockParametros(Boolean.FALSE);
		BasePrueba.assertThrows(() -> CacheUtil.obtainParameterByTipoParametroAndParametro(EnumTipoParametro.GENERAL, EnumParametro.CANTIDAD_CITAS_DIA), ExcepcionCache.class, "No se encontro parametro con nombre: CANTIDAD_CITAS_DIA");
	}

}
