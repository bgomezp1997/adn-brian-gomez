package com.ceiba.cache;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.ceiba.infraestructura.cache.ObjCacheManager;
import com.ceiba.usuario.consulta.ManejadorListarParametros;
import com.ceiba.usuario.modelo.dto.DtoParametro;

@Configuration
@DependsOn("flyway")
public class CacheComponent {
	
	private final ManejadorListarParametros manejadorListarParametros;
	
	public CacheComponent(ManejadorListarParametros manejadorListarParametros) {
		this.manejadorListarParametros = manejadorListarParametros;
	}
	
	@PostConstruct
	public void createCache() {
		List<DtoParametro> listParametros = manejadorListarParametros.ejecutar();
		if (!listParametros.isEmpty()) {
			ObjCacheManager configuracionCache = new ObjCacheManager();
			listParametros.forEach(lp -> {
				configuracionCache.putInCache(lp.getNombre().getIndicative(), lp.getValor());
			});
		}
	}

}
