package com.ceiba.puerto.dao;

import java.util.List;

import com.ceiba.modelo.dto.DtoMedico;

public interface DaoMedico {

	/**
	 * Permite listar medicos
	 * 
	 * @return los medicos
	 */
	List<DtoMedico> listar();

}
