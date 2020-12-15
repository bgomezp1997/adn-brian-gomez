package com.ceiba.usuario.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.usuario.modelo.dto.DtoParametro;
import com.ceiba.usuario.puerto.dao.DaoParametro;

@Component
public class ManejadorListarParametros {

	private final DaoParametro daoParametro;

	public ManejadorListarParametros(DaoParametro daoParametro) {
		this.daoParametro = daoParametro;
	}

	public List<DtoParametro> ejecutar() {
		return this.daoParametro.listarPorEstado(Boolean.TRUE);
	}
}
