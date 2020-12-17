package com.ceiba.puerto.dao;

import java.util.List;

import com.ceiba.modelo.dto.DtoCita;

public interface DaoCita {
	
	/**
	 * Permite listar citas
	 * 
	 * @return las citas
	 */
	List<DtoCita> listar();

}
