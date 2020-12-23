package com.ceiba.puerto.repositorio;

import java.time.LocalDateTime;

import com.ceiba.modelo.entidad.Cita;

public interface RepositorioCita {
	
	/**
	 * Permite crear una cita
	 * 
	 * @param cita
	 * @return el id generado
	 */
	Long crear(Cita cita);

	/**
	 * Permite actualizar una cita
	 * 
	 * @param cita
	 */
	void actualizar(Cita cita);

	/**
	 * Permite eliminar una cita
	 * 
	 * @param id
	 */
	void eliminar(Long id);
	
	/**
	 * Permite validar si existe una cita con la fecha de creacion, paciente y medico relacionados
	 * 
	 * @param fechaCreacion
	 * @param idPaciente
	 * @param idMedico
	 * @return si existe o no
	 */
	boolean existe(LocalDateTime fechaCita, Long idPaciente, Long idMedico);
	
	/**
	 * Permite validar si existe una cita con la fecha de creacion, paciente y medico relacionados
	 * 
	 * @param id
	 * @param fechaCreacion
	 * @param idPaciente
	 * @param idMedico
	 * @return si existe o no
	 */
	boolean existeExcluyendoId(Long id, LocalDateTime fechaCita, Long idPaciente, Long idMedico);
	
	/**
	 * Permite contar cuantas citas existen por dia
	 * 
	 * @param fechaCreacion
	 * @return cantidad de citas por dia
	 */
	Integer contarCitasPorDia(LocalDateTime fechaCita);

}
