package com.ceiba.adaptador.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.adaptador.mapper.MapeoMedico;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.modelo.dto.DtoMedico;
import com.ceiba.puerto.dao.DaoMedico;

@Component
public class DaoMedicoMysql implements DaoMedico {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="medico", value="listar")
    private static String sqlListar;

    public DaoMedicoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoMedico> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoMedico());
    }
}
