create database EducAgro;
use EducAgro;
 
CREATE TABLE professor (
email VARCHAR(30),
senha VARCHAR(30),
nome VARCHAR(30),
id_professor INTEGER PRIMARY KEY not null auto_increment
);
 
CREATE TABLE voluntario (
senha VARCHAR(30),
nome VARCHAR(30),
email VARCHAR(30),
id_voluntario INTEGER PRIMARY KEY not null auto_increment
);
 
CREATE TABLE materia (
id_materia INTEGER PRIMARY KEY not null auto_increment,
nome VARCHAR(35)
);
 

CREATE TABLE aulas (
id_aula integer not null auto_increment,
fk_id_professor INTEGER,
fk_id_voluntario INTEGER,
fk_id_materia INTEGER,
primary key(id_aula),
FOREIGN KEY(fk_id_professor) REFERENCES professor (id_professor),
FOREIGN KEY(fk_id_voluntario) REFERENCES voluntario (id_voluntario),
foreign key(fk_id_materia) references materia(id_materia)
);
 
show tables;
insert into professor(nome,email,senha) values('hahaha','haha@haha','123456');

select * from professor;
use educagro;

drop table aulas;

CREATE TABLE aulas (
id_aula integer not null auto_increment,
professor varchar(30) not null,
voluntario varchar(30) not null,
materia varchar(30) not null,
primary key(id_aula)
);
insert into aulas(professor,voluntario,materia) values('Gilson','Alan','Matematica');
insert into aulas(professor,voluntario,materia) values('Alan','Taiane','Portugues');
insert into aulas(professor,voluntario,materia) values('Taiane','Renan','Alfabetizacao');
