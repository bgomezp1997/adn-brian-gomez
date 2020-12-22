select count(*)
	from cita
where DATE_FORMAT(fecha_cita, "%Y-%m-%d") = :fechaCita