package com.ceiba.puerto.repositorio;

import com.ceiba.modelo.entidad.Medico;

public interface RepositorioMedico {

	/**
	 * Permite crear un medico
	 * 
	 * @param medico
	 * @return el id generado
	 */
	Long crear(Medico medico);

	/**
	 * Permite actualizar un medico
	 * 
	 * @param medico
	 */
	void actualizar(Medico medico);

	/**
	 * Permite eliminar un medico
	 * 
	 * @param id
	 */
	void eliminar(Long id);

	/**
	 * Permite validar si existe un medico con una identificacion
	 * 
	 * @param identificacion
	 * @return si existe o no
	 */
	boolean existe(String identificacion);

	/**
	 * Permite validar si existe un medico con una identificacion excluyendo un id
	 * 
	 * @param identificacion
	 * @return si existe o no
	 */
	boolean existeExcluyendoId(Long id, String identificacion);

}
