create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table parametro (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 valor varchar(100) not null,
 estado boolean not null,
 primary key (id)
);

insert into parametro(nombre, valor, estado) values('VALOR_CITA', 150000, 1);

