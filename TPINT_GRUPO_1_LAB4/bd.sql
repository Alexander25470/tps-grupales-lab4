CREATE DATABASE TpIntegradorLab4;
use TpIntegradorLab4;

CREATE TABLE MATERIAS(
	id int primary key,
    nombre varchar(100) not null
);

CREATE TABLE NACIONALIDADES
(
    id int primary key,
    Nombre varchar(100) not null
);

CREATE TABLE PROVINCIAS
(
    id int primary key,
    Nombre varchar(100) not null
);

CREATE TABLE LOCALIDADES
(
    id int primary key,
    Nombre varchar(100) not null
);

CREATE TABLE DOCENTES(
	legajo int primary key AUTO_INCREMENT,
    dni varchar(12) unique,
    nombreApellido varchar(100) not null,
    fechaNac date not null,
    ID_Nacionalidad int,
    ID_Localidad int,
    direccion varchar(200) not null,
    email varchar(200) not null,
    telefono varchar(200) not null,
    estado BIT default 1,
    foreign key (ID_Nacionalidad) references NACIONALIDADES(id),
    foreign key (ID_Localidad) references LOCALIDADES(id)
);

CREATE TABLE ALUMNOS(
	legajo int primary key AUTO_INCREMENT,
    dni varchar(12) unique,
    nombreApellido varchar(100) not null,
    fechaNac date not null,
    ID_Nacionalidad int,
    ID_Provincia int,
    direccion varchar(200) not null,
    email varchar(200) not null,
    telefono varchar(200) not null,
    estado BIT default 1,
    foreign key (ID_Nacionalidad) references NACIONALIDADES(id),
    foreign key (ID_Provincia) references PROVINCIAS(id)
);


CREATE TABLE CURSOS(
	id int primary key AUTO_INCREMENT,
    ID_Materia int,
    legajo int,
    semestre int not null,
    anio int not null,
	foreign key (ID_Materia) references Materias(id),
    foreign key (legajo) references DOCENTES(legajo)
);

CREATE TABLE NOTAS(
	legajo int,
    ID_Curso int,
    parcial1 float,
    parcial2 float,
    recuperatorio1 float,
    recuperatorio2 float,
    estado varchar(50),
    foreign key (legajo) references ALUMNOS(legajo),
    foreign key (ID_Curso) references CURSOS(id)
);

CREATE TABLE USUARIOS(
    id int primary key AUTO_INCREMENT,
	legajo_docente int,
    nombre varchar(50),
    contrasenia varchar(50),
    administrador bool  
);


insert into NACIONALIDADES 
(id,nombre)
VALUES('1','Argentina'),('2','Uruguar'),('3','Brasil'),
('4','Chile'),('5','Bolivia'),('6','Colombia'),('7','España');

insert into PROVINCIAS
(id,nombre)
VALUES('1','Provincia'),('2','Santa Fe'),('3','Cordoba'),
('4','Chaco'),('5','Misiones'),('6','Santa Cruz'),('7','Entre Rios');

insert into LOCALIDADES 
(id,nombre)
VALUES('1','Tigre'),('2','San Isidro'),('3','Malvinas Argentinas'),
('4','Moron'),('5','La Matanza'),('6','Garin'),('7','La Plata');







