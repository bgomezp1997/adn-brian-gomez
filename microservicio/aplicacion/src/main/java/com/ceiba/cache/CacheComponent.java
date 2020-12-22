package com.ceiba.cache;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import com.ceiba.consulta.parametro.ManejadorListarParametros;
import com.ceiba.modelo.dto.DtoParametro;
import com.ceiba.modelo.util.EnumTipoParametro;

@Component
@DependsOn("flyway")
public class CacheComponent {

	private final ManejadorListarParametros manejadorListarParametros;

	public CacheComponent(ManejadorListarParametros manejadorListarParametros) {
		this.manejadorListarParametros = manejadorListarParametros;
		createCache();
	}

	private void createCache() {
		List<DtoParametro> listParametros = manejadorListarParametros.ejecutar();
		if (!listParametros.isEmpty()) {
			List<DtoParametro> listaFestivos = new ArrayList<>();
			List<DtoParametro> listaGenerales = new ArrayList<>();
			listParametros.forEach(lp -> {
				if (lp.getTipo().equals(EnumTipoParametro.GENERAL))
					listaGenerales.add(lp);
				else
					listaFestivos.add(lp);
			});
			ObjCacheManager configuracionCache = new ObjCacheManager();
			configuracionCache.putInCache(EnumTipoParametro.GENERAL.getIndicative(), listaGenerales);
			configuracionCache.putInCache(EnumTipoParametro.FESTIVO.getIndicative(), listaFestivos);
		}
	}

}
