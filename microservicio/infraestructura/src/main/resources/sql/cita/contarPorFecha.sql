select count(*)
	from cita
where str_to_date(fecha_cita, "%Y-%m-%d") = :fechaCita