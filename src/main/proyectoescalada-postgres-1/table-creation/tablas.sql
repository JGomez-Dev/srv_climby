--CREACION TABLAS
set schema 'core';

create sequence sc_position as integer;

create table core.tb_position(
	id_position  integer not null default nextval('core.sc_position'),
	name_position varchar(50) not null,
	
	constraint pk_core_position primary key (id_position)
);
alter sequence sc_position owned by tb_position.id_position;

create table core.tb_province(
	id_province  varchar not null,
	name_province varchar(50) not null,
	
	constraint pk_core_province primary key (id_province)
);


create sequence sc_user as integer;

create table core.tb_user(
	id_user  integer not null default nextval('core.sc_user'),
	full_name varchar,
	experience integer,
	id_position integer,
	phone varchar,
	email varchar,
	score numeric(18,11),
	outputs integer,
	user_photo varchar,
	
	constraint pk_core_user primary key (id_user),
	constraint fk_core_id_posicion foreign key (id_position) references tb_position(id_position)
	
);

alter sequence sc_user owned by tb_user.id_user;


--create sequence sc_travel as integer;
-- 
-- create table core.tb_travel(
-- 	id_travel varchar, -- integer not null default nextval('core.sc_travel'),
-- 	id_driver varchar,
-- 	site varchar,
-- 	type varchar,
-- 	available_places integer,
-- 	departure_date timestamp,
-- 	province varchar,
-- 	
-- 	constraint pk_core_travel primary key (id_travel),
-- 	constraint fk_core_id_driver foreign key (id_driver) references tb_user(id_user),
-- 	constraint fk_core_province foreign key (province) references tb_province(id_province)
-- );

	--alter sequence sc_travel owned by tb_travel.id_travel;
	
--create sequence sc_status as integer;

create table core.tb_status(
	id_status varchar ,--integer not null default nextval('core.sc_status'),
	status_reservation boolean,
	status_valuation boolean,
	
	constraint pk_core_status primary key (id_status)
);

	--alter sequence sc_status owned by tb_status.id_status;
	

--create sequence sc_reservation as integer;

-- create table core.tb_reservation(
-- 	id_reservation varchar,-- not null default nextval('core.sc_reservation'),
-- 	id_user varchar not null,
-- 	id_travel varchar not null,
-- 	id_status varchar not null,
-- 	date_reservation timestamp not null,
-- 	
-- 	constraint pk_core_reservation primary key (id_reservation),
-- 	constraint fk_core_id_user foreign key (id_user) references tb_user(id_user),
-- 	constraint fk_core_id_travel foreign key (id_travel) references tb_travel(id_travel),
-- 	constraint fk_core_id_status foreign key (id_status) references tb_status(id_status)
-- 	);
	
	--alter sequence sc_reservation owned by tb_reservation.id_reservation;

--create sequence sc_school as integer;

create table core.tb_school(
	id_school varchar, --not null default nextval('core.sc_school'),
	name_school varchar(50) not null,
	
	constraint pk_core_school primary key (id_school)
);

--alter sequence sc_school owned by tb_school.id_school;


--CARGADE DATOS
INSERT INTO tb_province
VALUES
	('2','Albacete'),
	('3','Alicante/Alacant'),
	('4','Almería'),
	('1','Araba/Álava'),
	('33','Asturias'),
	('5','Ávila'),
	('6','Badajoz'),
	('7','Balears, Illes'),
	('8','Barcelona'),
	('48','Bizkaia'),
	('9','Burgos'),
	('10','Cáceres'),
	('11','Cádiz'),
	('39','Cantabria'),
	('12','Castellón/Castelló'),
	('51','Ceuta'),
	('13','Ciudad Real'),
	('14','Córdoba'),
	('15','Coruña, A'),
	('16','Cuenca'),
	('20','Gipuzkoa'),
	('17','Girona'),
	('18','Granada'),
	('19','Guadalajara'),
	('21','Huelva'),
	('22','Huesca'),
	('23','Jaén'),
	('24','León'),
	('27','Lugo'),
	('25','Lleida'),
	('28','Madrid'),
	('29','Málaga'),
	('52','Melilla'),
	('30','Murcia'),
	('31','Navarra'),
	('32','Ourense'),
	('34','Palencia'),
	('35','Palmas, Las'),
	('36','Pontevedra'),
	('26','Rioja, La'),
	('37','Salamanca'),
	('38','Santa Cruz de Tenerife'),
	('40','Segovia'),
	('41','Sevilla'),
	('42','Soria'),
	('43','Tarragona'),
	('44','Teruel'),
	('45','Toledo'),
	('46','Valencia/València'),
	('47','Valladolid'),
	('49','Zamora'),
	('50','Zaragoza');
	
INSERT INTO tb_status
VALUES
	('1',true,true),
	('2',true,false),
	('3',false,false),
	('4',false,true);

	