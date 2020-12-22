select count(1) 
	from cita 
where DATE_FORMAT(fecha_cita, "%Y-%m-%d") = :fechaCita
	and id_paciente = :idPaciente
	and id_medico = :idMedico