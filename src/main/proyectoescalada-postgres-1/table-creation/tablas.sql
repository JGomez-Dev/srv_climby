--CREACION TABLAS
set schema 'core';

create sequence sc_position as integer;

create table core.tb_position(
	id_position  integer not null default nextval('core.sc_position'),
	name_position varchar(50) not null,
	
	constraint pk_core_position primary key (id_position)
);
alter sequence sc_position owned by tb_position.id_position;

create sequence sc_province as integer;

create table core.tb_province(
	id_province  integer not null default nextval('core.sc_province'),
	name_province varchar(50) not null,
	
	constraint pk_core_province primary key (id_province)
);

alter sequence sc_province owned by tb_province.id_province;


create sequence sc_user as integer;

create table core.tb_user(
	id_user  integer not null default nextval('core.sc_user'),
	full_name varchar,
	experience integer,
	id_position integer,
	phone varchar(9),
	email varchar,
	score numeric(18,11),
	outputs integer,
	user_photo varchar,
	
	constraint pk_core_user primary key (id_user),
	constraint fk_core_id_posicion foreign key (id_position) references tb_position(id_position),
	constraint chk_phone check (phone not like '%[^0-9]%')
	
);

alter sequence sc_user owned by tb_user.id_user;


create sequence sc_travel as integer;

create table core.tb_travel(
	id_travel integer not null default nextval('core.sc_travel'),
	id_driver integer,
	site varchar,
	type varchar,
	available_places integer,
	departure_date timestamp,
	province integer,
	
	constraint pk_core_travel primary key (id_travel),
	constraint fk_core_id_driver foreign key (id_driver) references tb_user(id_user),
	constraint fk_core_province foreign key (province) references tb_province(id_province)
);

alter sequence sc_travel owned by tb_travel.id_travel;
	
create sequence sc_status as integer;

create table core.tb_status(
	id_status integer not null default nextval('core.sc_status'),
	status_reservation boolean,
	status_valuation boolean,
	
	constraint pk_core_status primary key (id_status)
);

alter sequence sc_status owned by tb_status.id_status;
	

create sequence sc_reservation as integer;

 create table core.tb_reservation(
	id_reservation integer not null default nextval('core.sc_reservation'),
	id_user integer,
	id_travel integer,
	id_status integer,
	date_reservation timestamp,
	
	constraint pk_core_reservation primary key (id_reservation),
	constraint fk_core_id_user foreign key (id_user) references tb_user(id_user),
	constraint fk_core_id_travel foreign key (id_travel) references tb_travel(id_travel),
	constraint fk_core_id_status foreign key (id_status) references tb_status(id_status)
	);
 	
	alter sequence sc_reservation owned by tb_reservation.id_reservation;

--create sequence sc_school as integer;

create table core.tb_school(
	id_school varchar, --not null default nextval('core.sc_school'),
	name_school varchar(50) not null,
	
	constraint pk_core_school primary key (id_school)
);

--alter sequence sc_school owned by tb_school.id_school;



--CARGADE DATOS
INSERT INTO tb_province(name_province)
VALUES
	('Albacete'),
	('Alicante/Alacant'),
	('Almería'),
	('Araba/Álava'),
	('Asturias'),
	('Ávila'),
	('Badajoz'),
	('Balears, Illes'),
	('Barcelona'),
	('Bizkaia'),
	('Burgos'),
	('Cáceres'),
	('Cádiz'),
	('Cantabria'),
	('Castellón/Castelló'),
	('Ceuta'),
	('Ciudad Real'),
	('Córdoba'),
	('Coruña, A'),
	('Cuenca'),
	('Gipuzkoa'),
	('Girona'),
	('Granada'),
	('Guadalajara'),
	('Huelva'),
	('Huesca'),
	('Jaén'),
	('León'),
	('Lugo'),
	('Lleida'),
	('Madrid'),
	('Málaga'),
	('Melilla'),
	('Murcia'),
	('Navarra'),
	('Ourense'),
	('Palencia'),
	('Palmas, Las'),
	('Pontevedra'),
	('Rioja, La'),
	('Salamanca'),
	('Santa Cruz de Tenerife'),
	('Segovia'),
	('Sevilla'),
	('Soria'),
	('Tarragona'),
	('Teruel'),
	('Toledo'),
	('Valencia/València'),
	('Valladolid'),
	('Zamora'),
	('Zaragoza');
	
INSERT INTO tb_status
VALUES
	('1',true,true),
	('2',true,false),
	('3',false,false),
	('4',false,true);

	