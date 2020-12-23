package com.ceiba.adaptador.dao;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.ceiba.adaptador.mapper.MapeoParametro;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.modelo.dto.DtoParametro;
import com.ceiba.modelo.util.EnumTipoParametro;
import com.ceiba.puerto.dao.DaoParametro;

@Component
public class DaoParametroMysql implements DaoParametro {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="parametro", value="listarPorEstado")
    private static String sqlListarPorEstado;
    
    @SqlStatement(namespace="parametro", value="listarPorEstadoYTipo.sql")
    private static String sqlListarPorEstadoYTipo;

    public DaoParametroMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoParametro> listarPorEstado(Boolean estado) {
    	MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("estado", estado);
    	
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorEstado, paramSource, new MapeoParametro());
    }

	@Override
	public List<DtoParametro> listarPorEstadoYTipo(Boolean estado, EnumTipoParametro enumTipoParametro) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("estado", estado);
        paramSource.addValue("tipo", enumTipoParametro.toString());
    	
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorEstadoYTipo, paramSource, new MapeoParametro());
	}
}
