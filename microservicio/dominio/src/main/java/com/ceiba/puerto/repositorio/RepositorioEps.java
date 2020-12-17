package com.ceiba.puerto.repositorio;

import com.ceiba.modelo.entidad.Eps;

public interface RepositorioEps {

	/**
	 * Permite crear una eps
	 * 
	 * @param eps
	 * @return el id generado
	 */
	Long crear(Eps eps);

	/**
	 * Permite actualizar una eps
	 * 
	 * @param eps
	 */
	void actualizar(Eps eps);

	/**
	 * Permite eliminar una eps
	 * 
	 * @param id
	 */
	void eliminar(Long id);

	/**
	 * Permite validar si existe una eps con un nit
	 * 
	 * @param nit
	 * @return si existe o no
	 */
	boolean existe(String nit);

	/**
	 * Permite validar si existe una eps con un nit excluyendo un id
	 * 
	 * @param nit
	 * @return si existe o no
	 */
	boolean existeExcluyendoId(Long id, String nit);

}
