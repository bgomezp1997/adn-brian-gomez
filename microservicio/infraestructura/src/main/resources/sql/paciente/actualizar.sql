update paciente
set nombres = :nombres,
	apellidos = :apellidos,
	identificacion = :identificacion,
	fecha_creacion = :fechaCreacion,
	email = :email,
	estrato = :estrato,
	id_eps = :idEps
where id = :id