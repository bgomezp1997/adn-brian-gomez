package com.ceiba.puerto.dao;

import java.util.List;

import com.ceiba.modelo.dto.DtoPaciente;

public interface DaoPaciente {

	/**
	 * Permite listar pacientes
	 * 
	 * @return los pacientes
	 */
	List<DtoPaciente> listar();
}
