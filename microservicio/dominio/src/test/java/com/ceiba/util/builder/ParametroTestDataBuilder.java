package com.ceiba.util.builder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ceiba.modelo.dto.DtoParametro;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ParametroTestDataBuilder {
	
	private static final String PARAMETROS_JSON =
			"[{ \"id\": 30, \"nombre\": \"CORNEOLOGO\", \"tipo\": \"ESPECIALIDAD\", \"valor\": \"190000\", \"estado\": true }, "
			+ "{ \"id\": 31, \"nombre\": \"RETINOLOGO\", \"tipo\": \"ESPECIALIDAD\", \"valor\": \"150000\", \"estado\": true }, "
			+ "{ \"id\": 32, \"nombre\": \"GLAUCOMATOLOGO\", \"tipo\": \"ESPECIALIDAD\", \"valor\": \"210000\", \"estado\": true }, "
			+ "{ \"id\": 33, \"nombre\": \"OCULOPLASTICO\", \"tipo\": \"ESPECIALIDAD\", \"valor\": \"230000\", \"estado\": true }, "
			+ "{ \"id\": 34, \"nombre\": \"NO\", \"tipo\": \"ESPECIALIDAD\", \"valor\": \"130000\", \"estado\": true }, "
			+ "{ \"id\": 24, \"nombre\": \"CANTIDAD_CITAS_DIA\", \"tipo\": \"GENERAL\", \"valor\": \"5\", \"estado\": true }, "
			+ "{ \"id\": 25, \"nombre\": \"DSCTO_ESTRATO_BAJO\", \"tipo\": \"GENERAL\", \"valor\": \"35\", \"estado\": true }, "
			+ "{ \"id\": 26, \"nombre\": \"DSCTO_ESTRATO_MEDIO\", \"tipo\": \"GENERAL\", \"valor\": \"20\", \"estado\": true }, "
			+ "{ \"id\": 27, \"nombre\": \"DSCTO_ESTRATO_ALTO\", \"tipo\": \"GENERAL\", \"valor\": \"10\", \"estado\": true }, "
			+ "{ \"id\": 28, \"nombre\": \"NAVIDAD\", \"tipo\": \"FESTIVO\", \"valor\": \"2020-12-25\", \"estado\": true }, "
			+ "{ \"id\": 29, \"nombre\": \"ANO_NUEVO\", \"tipo\": \"FESTIVO\", \"valor\": \"2021-01-01\", \"estado\": true }]";
	
	private List<DtoParametro> parametros;
	
	public ParametroTestDataBuilder() {
		this.parametros = new ArrayList<>();
	}
	
	public ParametroTestDataBuilder conDatos() throws JsonParseException, JsonMappingException, IOException {
		this.parametros = new ObjectMapper().readValue(PARAMETROS_JSON, new TypeReference<List<DtoParametro>>(){});
		return this;
	}
	
	public List<DtoParametro> build() {
		return this.parametros;
	}

}
