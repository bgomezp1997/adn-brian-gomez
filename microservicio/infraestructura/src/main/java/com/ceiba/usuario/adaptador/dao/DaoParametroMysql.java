package com.ceiba.usuario.adaptador.dao;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.adaptador.mapper.MapeoParametro;
import com.ceiba.usuario.modelo.dto.DtoParametro;
import com.ceiba.usuario.puerto.dao.DaoParametro;

@Component
public class DaoParametroMysql implements DaoParametro {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="parametro", value="listarPorEstado")
    private static String sqlListarPorEstado;

    public DaoParametroMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoParametro> listarPorEstado(Boolean estado) {
    	MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("estado", estado);
    	
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorEstado, paramSource, new MapeoParametro());
    }
}
