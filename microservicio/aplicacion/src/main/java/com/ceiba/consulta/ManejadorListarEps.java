package com.ceiba.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.dto.DtoEps;
import com.ceiba.puerto.dao.DaoEps;

@Component
public class ManejadorListarEps {

	private final DaoEps daoEps;

	public ManejadorListarEps(DaoEps daoEps) {
		this.daoEps = daoEps;
	}

	public List<DtoEps> ejecutar() {
		return this.daoEps.listar();
	}
}
