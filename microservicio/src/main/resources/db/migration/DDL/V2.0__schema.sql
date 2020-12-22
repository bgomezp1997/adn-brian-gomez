alter table parametro add tipo varchar(50);
update parametro set tipo = 'GENERAL' where nombre in ('VALOR_CITA', 'CANTIDAD_CITAS_DIA');

insert into parametro(nombre, valor, estado, tipo) values('NAVIDAD', '2020-12-25', 1, 'FESTIVO');
insert into parametro(nombre, valor, estado, tipo) values('ANO_NUEVO', '2021-01-01', 1, 'FESTIVO');