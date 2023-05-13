/*
* Assistência Tech Underground
* Autores: Alessandro, Pedro, Nicolas.
*/

create database assistencia;
use assistencia;

create table usuario(
	id int primary key auto_increment,
    usuario varchar(50) not null,
    login varchar(20) not null unique,
    senha varchar(250) not null,
    perfil varchar(50) not null
);

create table clientes (
	idFor int primary key auto_increment,
    cep varchar(10) not null,
    endereço varchar(50) not null,
    numero varchar(6) not null,
    complemento varchar(20),
    bairro varchar(50) not null,
    cidade varchar(50) not null,
    uf char(3) not null,
    nomeContato varchar(30) not null,
    fone varchar(15) not null,
    whatsapp varchar(15),
    email varchar (50) not null,
    obs varchar(250),
    razao varchar(50),
    fantasia varchar(50),
    cnpj varchar(50),
    inscricao varchar(50),
    cpf varchar(11) not null
);

insert into usuario (usuario,login,senha,perfil)
values('Administrador','admin',md5('admin'),'Administrador');

create table servico (
idOs int primary key auto_increment,
idCliente int not null,
foreign key(idCliente) references clientes(idFor),
equipamento varchar(50) not null,
acessorio varchar(50),
IMEI varchar(50) not null,
defeito varchar(50) not null,
diagnostico varchar(50),
tecnico varchar(50),
statusreparo char(50) not null,
valor varchar(10),
sinal varchar(10),
receber varchar(10),
datacad timestamp default current_timestamp,
foto longblob
);