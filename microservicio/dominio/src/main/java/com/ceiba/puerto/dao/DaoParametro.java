package com.ceiba.puerto.dao;

import java.util.List;

import com.ceiba.modelo.dto.DtoParametro;
import com.ceiba.modelo.util.EnumTipoParametro;

public interface DaoParametro {

	/**
	 * Permite listar parametros
	 * 
	 * @return los parametros
	 */
	List<DtoParametro> listarPorEstado(Boolean estado);
	
	/**
	 * Permite listar un conjunto de parametros por su tipo
	 * 
	 * @param estado
	 * @param enumParametro
	 * @return los parametros
	 */
	List<DtoParametro> listarPorEstadoYTipo(Boolean estado, EnumTipoParametro enumTipoParametro);
}
