select count(1) 
	from cita 
where str_to_date(fecha_cita, "%Y-%m-%d") = :fecha
	and id_paciente = :idPaciente
	and id_medico = :idMedico