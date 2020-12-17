package com.ceiba.puerto.dao;

import java.util.List;

import com.ceiba.modelo.dto.DtoParametro;

public interface DaoParametro {

	/**
	 * Permite listar parametros
	 * 
	 * @return los parametros
	 */
	List<DtoParametro> listarPorEstado(Boolean estado);
}
