package com.ceiba.adaptador.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.modelo.dto.DtoMedico;

public class MapeoMedico implements RowMapper<DtoMedico>, MapperResult {

    @Override
    public DtoMedico mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombres = resultSet.getString("nombres");
        String apellidos = resultSet.getString("apellidos");
        String identificacion = resultSet.getString("identificacion");
        LocalDateTime fechaCreacion = extraerLocalDateTime(resultSet, "fecha_creacion");
        String email = resultSet.getString("email");
        String especialidad = resultSet.getString("especialidad");
        String numeroTarjetaProfesional = resultSet.getString("numero_tarjeta_profesional");
        
        return new DtoMedico(id, nombres, apellidos, fechaCreacion, identificacion, email, especialidad, numeroTarjetaProfesional);
    }

}
