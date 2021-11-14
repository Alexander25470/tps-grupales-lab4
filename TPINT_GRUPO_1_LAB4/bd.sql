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

CREATE TABLE ESTADOSALUMNO(
	ID int primary key,
    descripcion varchar(50)
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
    estado int,
    foreign key (legajo) references ALUMNOS(legajo),
    foreign key (ID_Curso) references CURSOS(id),
	foreign key (estado) references ESTADOSALUMNO(ID)
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
VALUES('1','Argentina'),('2','Uruguay'),('3','Brasil'),
('4','Chile'),('5','Bolivia'),('6','Colombia'),('7','España');

insert into PROVINCIAS
(id,nombre)
VALUES('1','Jujuy'),('2','Santa Fe'),('3','Cordoba'),
('4','Chaco'),('5','Misiones'),('6','Santa Cruz'),('7','Entre Rios');

insert into LOCALIDADES 
(id,nombre)
VALUES('1','Tigre'),('2','San Isidro'),('3','Malvinas Argentinas'),
('4','Moron'),('5','La Matanza'),('6','Garin'),('7','La Plata');

insert into MATERIAS
(id,nombre)
VALUES(1,'Matematica'),('2','Programacion'),('3','Ingles'),
(4,'Laboratorio'),('5','Legislacion'),('6','Metodologia de sistemas');

insert into docentes
(dni,nombreApellido,fechaNac,ID_Nacionalidad,ID_Localidad,direccion,email,telefono,estado)
VALUES('33859632','Maria Perez','1992/10/02','1','3','Av.Libertador 1050','maria@gmail.com','1169325452',1),
('30506231','Ernesto Fernandez','1990/08/10','5','5','8 de Octubre 3058','ErnestoFe@hotmail.com','1178321052',1);

insert into alumnos
(dni,nombreApellido,fechaNac,ID_Nacionalidad,ID_Provincia,direccion,email,telefono,estado)
VALUES('42456321','Lautaro Farias','2000/01/15','2','3','San Martin 1595','lautaro@gmail.com','1178412136',1),
('40963215','Estela Ricartez','1998/05/15','5','4','Juramento 5050','ricartez@outlook.com','1112457896',1);

insert into estadosalumno
(id,descripcion)
VALUES (1,'regular'),(2,'libre');	

insert into cursos
(ID_Materia,legajo,semestre,anio)
VALUES('1','1','1',2021),
('2','2','1',2021);

insert into NOTAS 
(legajo,ID_Curso,parcial1,parcial2,recuperatorio1,recuperatorio2,estado)
VALUES(1,1,10,8,null,null,1),
(2,2,5,5,7,8,1);

insert into USUARIOS
(legajo_docente,nombre,contrasenia,administrador)
VALUES(1,'MariaUser','mariaadmin',0),
(null,'Admin1','administradorincognito',1);



