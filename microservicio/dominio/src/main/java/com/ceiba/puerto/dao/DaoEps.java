package com.ceiba.puerto.dao;

import java.util.List;

import com.ceiba.modelo.dto.DtoEps;

public interface DaoEps {
	
	/**
	 * Permite listar eps
	 * 
	 * @return las eps
	 */
	List<DtoEps> listar();
	
	/**
	 * Permite obtener una eps por su id
	 * 
	 * @param id
	 * @return la eps
	 */
	DtoEps obtener(Long id);

}
