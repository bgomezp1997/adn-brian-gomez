package com.ceiba;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.ceiba.infraestructura.cache.ObjCacheManager;
import com.ceiba.usuario.consulta.ManejadorListarParametros;
import com.ceiba.usuario.modelo.dto.DtoParametro;

@ComponentScan({"com.ceiba"})
@SpringBootApplication
public class Application {
	
	@Autowired
	private ManejadorListarParametros manejadorListarParametros;
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @PostConstruct
	public void createCache() {
		List<DtoParametro> listParametros = manejadorListarParametros.ejecutar();
		if(!listParametros.isEmpty()) {
			ObjCacheManager configuracionCache = new ObjCacheManager();
			listParametros.forEach(lp -> {
				configuracionCache.putInCache(lp.getNombre().getIndicative(), lp.getValor());
			});
		}
	}
    
}
