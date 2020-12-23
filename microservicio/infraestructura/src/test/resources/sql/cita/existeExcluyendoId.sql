select count(1) 
	from cita 
where id <> :id 
	and TO_CHAR(fecha_cita, 'yyyy-MM-dd') = :fechaCita
	and id_paciente = :idPaciente
	and id_medico = :idMedico