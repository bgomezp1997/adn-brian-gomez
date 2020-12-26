package com.ceiba.cache;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import com.ceiba.dominio.cache.ObjCacheManager;
import com.ceiba.modelo.dto.DtoParametro;
import com.ceiba.modelo.util.EnumTipoParametro;
import com.ceiba.puerto.dao.DaoParametro;

@Component
@DependsOn("flyway")
public class CacheComponent {

	private final DaoParametro daoParametro;

	public CacheComponent(DaoParametro daoParametro) {
		this.daoParametro = daoParametro;
		createCache();
	}

	private void createCache() {
		List<DtoParametro> listParametros = daoParametro.listarPorEstado(Boolean.TRUE);
		if (!listParametros.isEmpty()) {
			List<DtoParametro> listaFestivos = new ArrayList<>();
			List<DtoParametro> listaGenerales = new ArrayList<>();
			List<DtoParametro> listaEspecialidades = new ArrayList<>();
			listParametros.forEach(lp -> {
				if (lp.getTipo().equals(EnumTipoParametro.GENERAL))
					listaGenerales.add(lp);
				else if(lp.getTipo().equals(EnumTipoParametro.ESPECIALIDAD))
					listaEspecialidades.add(lp);
				else
					listaFestivos.add(lp);
			});
			ObjCacheManager configuracionCache = new ObjCacheManager();
			configuracionCache.putInCache(EnumTipoParametro.GENERAL.getIndicative(), listaGenerales);
			configuracionCache.putInCache(EnumTipoParametro.FESTIVO.getIndicative(), listaFestivos);
			configuracionCache.putInCache(EnumTipoParametro.ESPECIALIDAD.getIndicative(), listaEspecialidades);
		}
	}

}
