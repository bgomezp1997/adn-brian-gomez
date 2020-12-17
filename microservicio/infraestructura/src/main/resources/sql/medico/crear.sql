insert into medico
	(nombres, 
	apellidos, 
	identificacion, 
	fecha_creacion, 
	email, 
	especialidad, 
	numero_tarjeta_profesional) 
values 
	(:nombres, 
	:apellidos, 
	:identificacion, 
	:fechaCreacion, 
	:email, 
	:especialidad, 
	:numeroTarjetaProfesional)