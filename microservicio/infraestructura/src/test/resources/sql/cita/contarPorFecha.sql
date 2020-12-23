select count(*)
	from cita
where TO_CHAR(fecha_cita, 'yyyy-MM-dd') = :fechaCita