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

