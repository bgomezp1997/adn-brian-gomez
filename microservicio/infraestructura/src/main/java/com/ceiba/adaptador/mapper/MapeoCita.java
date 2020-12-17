package com.ceiba.adaptador.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.modelo.dto.DtoCita;

public class MapeoCita implements RowMapper<DtoCita>, MapperResult {

    @Override
    public DtoCita mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        LocalDateTime fechaCita = extraerLocalDateTime(resultSet, "fecha_cita");
        Long idPaciente = resultSet.getLong("id_paciente");
        Long idMedico = resultSet.getLong("id_medico");
        
        return new DtoCita(id, fechaCita, idPaciente, idMedico);
    }

}
