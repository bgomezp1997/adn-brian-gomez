package com.ceiba.adaptador.repositorio;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.modelo.entidad.Eps;
import com.ceiba.puerto.repositorio.RepositorioEps;

@Repository
public class RepositorioEpsMysql implements RepositorioEps {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="eps", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="eps", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="eps", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="eps", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="eps", value="existeExcluyendoId") 
    private static String sqlExisteExcluyendoId;

    public RepositorioEpsMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Eps eps) {
        return this.customNamedParameterJdbcTemplate.crear(eps, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(String nit) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nit", nit);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Eps eps) {
        this.customNamedParameterJdbcTemplate.actualizar(eps, sqlActualizar);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String nit) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("nit", nit);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId, paramSource, Boolean.class);
    }
}
