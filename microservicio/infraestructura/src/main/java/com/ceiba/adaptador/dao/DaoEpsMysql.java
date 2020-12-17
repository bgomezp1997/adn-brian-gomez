package com.ceiba.adaptador.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.adaptador.mapper.MapeoEps;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.modelo.dto.DtoEps;
import com.ceiba.puerto.dao.DaoEps;

@Component
public class DaoEpsMysql implements DaoEps {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="eps", value="listar")
    private static String sqlListar;

    public DaoEpsMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoEps> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoEps());
    }
}
