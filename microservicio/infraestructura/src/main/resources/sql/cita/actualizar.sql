update cita set
	fecha_cita = :fechaCita,
	id_paciente = :idPaciente,
	id_medico = :idMedico,
	precio = :precio
where id = :id