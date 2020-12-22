package com.ceiba.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ceiba.dominio.excepcion.ExcepcionCache;
import com.ceiba.modelo.dto.DtoParametro;
import com.ceiba.modelo.util.EnumParametro;
import com.ceiba.modelo.util.EnumTipoParametro;

public class CacheUtil {

	private static final String NO_SE_ENCONTRO_PARAMETRO = "No se encontro parametro con nombre: %s";
	private static final String NO_SE_ENCONTRO_LISTA_DE_PARAMETRO = "No se encontro parametro con nombre: %s";

	private CacheUtil() {
	}

	public static String obtainParameterByTipoParametroAndParametro(EnumTipoParametro enumTipoParametro, EnumParametro enumParametro) {
		ObjCacheManager objCacheManager = new ObjCacheManager();
		Optional<DtoParametro> optParametro = (CacheUtil
				.setItems(objCacheManager.retrieveFromCache(enumTipoParametro.getIndicative())))
				.stream()
				.filter(p -> p.getNombre().equals(enumParametro))
				.findFirst();
		if(optParametro.isPresent())
			return optParametro.get().getValor();
		throw new ExcepcionCache(String.format(NO_SE_ENCONTRO_PARAMETRO, enumParametro.toString()));
	}
	
	public static List<DtoParametro> obtainListByTipoParametro(EnumTipoParametro enumTipoParametro) {
		ObjCacheManager objCacheManager = new ObjCacheManager();
		List<DtoParametro> listDtoParametro = setItems(objCacheManager.retrieveFromCache(enumTipoParametro.getIndicative()));
		if(!listDtoParametro.isEmpty())
			return listDtoParametro;
		throw new ExcepcionCache(String.format(NO_SE_ENCONTRO_LISTA_DE_PARAMETRO, enumTipoParametro.toString()));
	}

	private static List<DtoParametro> setItems(Object object) {
		List<DtoParametro> result = new ArrayList<>();
		if (object instanceof List) {
			for (int i = 0; i < ((List<?>) object).size(); i++) {
				Object item = ((List<?>) object).get(i);
				if (item instanceof DtoParametro) {
					result.add((DtoParametro) item);
				}
			}
		}
		return result;
	}

}
