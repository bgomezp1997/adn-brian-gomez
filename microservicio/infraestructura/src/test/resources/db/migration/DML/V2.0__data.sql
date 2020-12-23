insert into eps (nombre, nit, telefono, email) values ('test','1234','755555','eps@mail.com');
insert into paciente (nombres, apellidos, identificacion, fecha_creacion, email, estrato, id_eps) values ('test', 'test', '12345', now(), 'test@mail.com', '3', 1);
insert into paciente (nombres, apellidos, identificacion, fecha_creacion, email, estrato, id_eps) values ('test', 'test', '1234567', now(), 'test@mail.com', '3', 1);
insert into medico (nombres, apellidos, identificacion, fecha_creacion, email, especialidad, numero_tarjeta_profesional) values ('test', 'test', '12345', now(), 'test@mail.com', 'test', 'test');
insert into cita (fecha_cita, id_paciente, id_medico, precio) values (now(), 1, 1, 2000);
