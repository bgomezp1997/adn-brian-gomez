package com.ceiba.usuario.puerto.dao;

import java.util.List;

import com.ceiba.usuario.modelo.dto.DtoParametro;

public interface DaoParametro {

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoParametro> listarPorEstado(Boolean estado);
}
