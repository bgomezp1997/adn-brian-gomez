insert into cita
	(fecha_cita, 
	id_paciente, 
	id_medico,
	precio) 
values 
	(:fechaCita, 
	:idPaciente, 
	:idMedico,
	:precio)