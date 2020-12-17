update medico set 
	nombres = :nombres,
	apellidos = :apellidos,
	identificacion = :identificacion,
	fecha_creacion = :fechaCreacion,
	email = :email,
	especialidad = :especialidad,
	numero_tarjeta_profesional  = :numeroTarjetaProfesional
where id = :id