package com.ceiba.adaptador.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.modelo.dto.DtoEps;
import com.ceiba.modelo.dto.DtoPaciente;

public class MapeoPaciente implements RowMapper<DtoPaciente>, MapperResult {

    @Override
    public DtoPaciente mapRow(ResultSet resultSet, int rowNum) throws SQLException {
    	Long idPaciente = resultSet.getLong("id_paciente");
		String nombresPaciente = resultSet.getString("nombres_paciente");
		String apellidosPaciente = resultSet.getString("apellidos_paciente");
		String identificacionPaciente = resultSet.getString("identificacion_paciente");
		LocalDateTime fechaCreacionPaciente = extraerLocalDateTime(resultSet, "fecha_creacion_paciente");
		String emailPaciente = resultSet.getString("email_paciente");
		String estratoPaciente = resultSet.getString("estrato_paciente");
        return new DtoPaciente(idPaciente, nombresPaciente, apellidosPaciente, fechaCreacionPaciente, identificacionPaciente, emailPaciente, mapRowEps(resultSet), estratoPaciente);
    }
    
    private DtoEps mapRowEps(ResultSet resultSet) throws SQLException {
		Long idEps = resultSet.getLong("id_eps");
		String nombreEps = resultSet.getString("nombre_eps");
		String nitEps = resultSet.getString("nit_eps");
		String telefonoEps = resultSet.getString("telefono_eps");
		String emailEps = resultSet.getString("email_eps");
		return new DtoEps(idEps, nombreEps, nitEps, telefonoEps, emailEps);
	}

}
