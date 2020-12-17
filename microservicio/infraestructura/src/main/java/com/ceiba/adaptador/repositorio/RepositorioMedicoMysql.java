package com.ceiba.adaptador.repositorio;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.modelo.entidad.Medico;
import com.ceiba.puerto.repositorio.RepositorioMedico;

@Repository
public class RepositorioMedicoMysql implements RepositorioMedico {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="medico", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="medico", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="medico", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="medico", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="medico", value="existeExcluyendoId") 
    private static String sqlExisteExcluyendoId;

    public RepositorioMedicoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Medico medico) {
        return this.customNamedParameterJdbcTemplate.crear(medico, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(String identificacion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("identificacion", identificacion);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Medico medico) {
        this.customNamedParameterJdbcTemplate.actualizar(medico, sqlActualizar);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String identificacion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("identificacion", identificacion);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId, paramSource, Boolean.class);
    }
}
