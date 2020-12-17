select count(1) 
	from cita 
where id <> :id 
	and DATE_FORMAT(fecha_cita, "%Y-%m-%d") = :fechaCreacion
	and id_paciente = :idPaciente
	and id_medico = :idMedico