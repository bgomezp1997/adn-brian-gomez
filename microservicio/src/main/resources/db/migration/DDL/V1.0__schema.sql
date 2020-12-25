create table eps (
 id int not null auto_increment,
 nombre varchar(70) not null,
 nit varchar(20) not null,
 telefono varchar(20) not null,
 email varchar(50) not null,
 primary key (id)
);

create table usuario (
 id int not null auto_increment,
 username varchar(20) not null,
 password varchar(100) not null,
 primary key (id)
);

create table paciente (
 id int not null auto_increment,
 nombres varchar(50) not null,
 apellidos varchar(50) not null,
 identificacion varchar(15) not null,
 fecha_creacion datetime not null,
 email varchar(60) not null,
 id_eps int not null,
 estrato varchar(5) not null,
 primary key (id),
 foreign key (id_eps) references eps (id)
);

create table medico (
 id int not null auto_increment,
 nombres varchar(50) not null,
 apellidos varchar(50) not null,
 identificacion varchar(15) not null,
 fecha_creacion datetime not null,
 email varchar(60) not null,
 especialidad varchar(80) not null,
 numero_tarjeta_profesional varchar(80) not null,
 primary key (id)
);

create table cita (
 id int not null auto_increment,
 fecha_cita datetime not null,
 id_paciente int not null,
 id_medico int not null,
 primary key (id),
 precio double not null,
 foreign key (id_paciente) references paciente (id),
 foreign key (id_medico ) references medico (id)
);

create table parametro (
 id int not null auto_increment,
 nombre varchar(100) not null,
 valor varchar(100) not null,
 estado boolean not null,
 tipo varchar(50) not null,
 primary key (id)
);



