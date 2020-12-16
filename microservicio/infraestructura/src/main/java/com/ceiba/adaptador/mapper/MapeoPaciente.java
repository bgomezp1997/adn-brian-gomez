package com.ceiba.adaptador.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.modelo.dto.DtoPaciente;

public class MapeoPaciente implements RowMapper<DtoPaciente>, MapperResult {

    @Override
    public DtoPaciente mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombres = resultSet.getString("nombres");
        String apellidos = resultSet.getString("apellidos");
        String identificacion = resultSet.getString("identificacion");
        LocalDateTime fechaCreacion = extraerLocalDateTime(resultSet, "fecha_creacion");
        String email = resultSet.getString("email");
        String estrato = resultSet.getString("estrato");
        Long idEps = resultSet.getLong("id_eps");
        
        return new DtoPaciente(id, nombres, apellidos, fechaCreacion, identificacion, email, idEps, estrato);
    }

}
