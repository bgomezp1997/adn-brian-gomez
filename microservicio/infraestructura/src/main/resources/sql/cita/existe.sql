select count(1) 
	from cita 
where DATE_FORMAT(fecha_cita, "%Y-%m-%d") = :fecha
	and id_paciente = :idPaciente
	and id_medico = :idMedico