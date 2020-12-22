package com.ceiba.consulta.eps;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.dto.DtoEps;
import com.ceiba.puerto.dao.DaoEps;

@Component
public class ManejadorObtenerEps {
	
	private final DaoEps daoEps;

	public ManejadorObtenerEps(DaoEps daoEps) {
		this.daoEps = daoEps;
	}
	
	public DtoEps ejecutar(Long id) {
		return this.daoEps.obtener(id);
	}

}
