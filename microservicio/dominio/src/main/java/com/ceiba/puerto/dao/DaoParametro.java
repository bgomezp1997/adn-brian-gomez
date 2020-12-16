package com.ceiba.puerto.dao;

import java.util.List;

import com.ceiba.modelo.dto.DtoParametro;

public interface DaoParametro {

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoParametro> listarPorEstado(Boolean estado);
}
