package com.ceiba.puerto.repositorio;

import com.ceiba.modelo.entidad.Paciente;

public interface RepositorioPaciente {
	
    /**
     * Permite crear un paciente
     * @param paciente
     * @return el id generado
     */
    Long crear(Paciente paciente);

    /**
     * Permite actualizar un paciente
     * @param paciente
     */
    void actualizar(Paciente paciente);

    /**
     * Permite eliminar un paciente
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un paciente con un identificacion
     * @param identificacion
     * @return si existe o no
     */
    boolean existe(String identificacion);

    /**
     * Permite validar si existe un paciente con un identificacion excluyendo un id
     * @param identificacion
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id, String identificacion);

}
