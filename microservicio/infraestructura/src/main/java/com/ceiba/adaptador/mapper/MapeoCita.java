package com.ceiba.adaptador.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.modelo.dto.DtoCita;
import com.ceiba.modelo.dto.DtoEps;
import com.ceiba.modelo.dto.DtoMedico;
import com.ceiba.modelo.dto.DtoPaciente;

public class MapeoCita implements RowMapper<DtoCita>, MapperResult {

	@Override
	public DtoCita mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		Long id = resultSet.getLong("id");
		LocalDateTime fechaCita = extraerLocalDateTime(resultSet, "fecha_cita");
		Double precio = resultSet.getDouble("precio");
		return new DtoCita(id, fechaCita, mapRowPaciente(resultSet), mapRowMedico(resultSet), precio);
	}

	private DtoEps mapRowEps(ResultSet resultSet) throws SQLException {
		Long idEps = resultSet.getLong("id_eps");
		String nombreEps = resultSet.getString("nombre_eps");
		String nitEps = resultSet.getString("nit_eps");
		String telefonoEps = resultSet.getString("telefono_eps");
		String emailEps = resultSet.getString("email_eps");
		return new DtoEps(idEps, nombreEps, nitEps, telefonoEps, emailEps);
	}

	private DtoPaciente mapRowPaciente(ResultSet resultSet) throws SQLException {
		Long idPaciente = resultSet.getLong("id_paciente");
		String nombresPaciente = resultSet.getString("nombres_paciente");
		String apellidosPaciente = resultSet.getString("apellidos_paciente");
		String identificacionPaciente = resultSet.getString("identificacion_paciente");
		LocalDateTime fechaCreacionPaciente = extraerLocalDateTime(resultSet, "fecha_creacion_paciente");
		String emailPaciente = resultSet.getString("email_paciente");
		String estratoPaciente = resultSet.getString("estrato_paciente");
		return new DtoPaciente(idPaciente, nombresPaciente, apellidosPaciente, fechaCreacionPaciente,
				identificacionPaciente, emailPaciente, mapRowEps(resultSet), estratoPaciente);
	}

	private DtoMedico mapRowMedico(ResultSet resultSet) throws SQLException {
		Long idMedico = resultSet.getLong("id_medico");
		String nombresMedico = resultSet.getString("nombres_medico");
		String apellidosMedico = resultSet.getString("apellidos_medico");
		String identificacionMedico = resultSet.getString("identificacion_medico");
		LocalDateTime fechaCreacionMedico = extraerLocalDateTime(resultSet, "fecha_creacion_medico");
		String emailMedico = resultSet.getString("email_medico");
		String especialidadMedico = resultSet.getString("especialidad_medico");
		String numeroTarjetaProfesionalMedico = resultSet.getString("numero_tarjeta_profesional_medico");
		return new DtoMedico(idMedico, nombresMedico, apellidosMedico, fechaCreacionMedico, identificacionMedico,
				emailMedico, especialidadMedico, numeroTarjetaProfesionalMedico);
	}

}
