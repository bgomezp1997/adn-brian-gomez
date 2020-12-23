select count(1) 
	from cita 
where TO_CHAR(fecha_cita, 'yyyy-MM-dd') = :fecha
	and id_paciente = :idPaciente
	and id_medico = :idMedico