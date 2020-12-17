package com.ceiba.adaptador.repositorio;

import java.time.LocalDateTime;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.modelo.entidad.Cita;
import com.ceiba.puerto.repositorio.RepositorioCita;

@Repository
public class RepositorioCitaMysql implements RepositorioCita {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="cita", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="cita", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="cita", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="cita", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="cita", value="existeExcluyendoId") 
    private static String sqlExisteExcluyendoId;

    public RepositorioCitaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Cita cita) {
        return this.customNamedParameterJdbcTemplate.crear(cita, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(LocalDateTime fechaCreacion, Long idPaciente, Long idMedico) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("fechaCreacion", fechaCreacion.toLocalDate());
        paramSource.addValue("idPaciente", idPaciente);
        paramSource.addValue("idMedico", idMedico);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Cita cita) {
        this.customNamedParameterJdbcTemplate.actualizar(cita, sqlActualizar);
    }

    @Override
    public boolean existeExcluyendoId(Long id, LocalDateTime fechaCita, Long idPaciente, Long idMedico) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("fechaCita", fechaCita.toLocalDate().toString());
        paramSource.addValue("idPaciente", idPaciente);
        paramSource.addValue("idMedico", idMedico);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId, paramSource, Boolean.class);
    }
}
