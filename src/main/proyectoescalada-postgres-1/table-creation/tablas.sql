
CREATE SCHEMA IF NOT exists public ;

--CREACION TABLAS
set schema 'public';

--create sequence sc_position as integer;

--create table core.tb_position(
	--id_position  integer not null default nextval('core.sc_position'),
	--name_position varchar(50) not null,
	
	--constraint pk_core_position primary key (id_position)
--);
--alter sequence sc_position owned by tb_position.id_position;

--create sequence sc_province as integer;

create table public.tb_climbing_type(
	climbing_type varchar(50) not null,
	constraint pk_core_climbingtype primary key (climbing_type)
);


create table public.tb_province(
	name_province varchar(50) not null,
	number_travels int,
	constraint pk_core_province primary key (name_province)
);

--alter sequence sc_province owned by tb_province.id_province;


--create sequence sc_school as integer;

create table public.tb_school(
	name_school varchar(50) not null,
	constraint pk_core_school primary key (name_school)
);

--alter sequence sc_school owned by tb_school.id_school;

create sequence sc_user as integer;

create table public.tb_user(
	id_user  integer not null default nextval('public.sc_user'),
	full_name varchar,
	experience varchar,
	phone varchar(9),
	email varchar,
	score numeric(18,11),
	outputs integer,
	user_photo varchar,
	ratings integer DEFAULT 0,
	token varchar (300),
	registration_date timestamp,
	
	
	constraint pk_core_user primary key (id_user),
	constraint chk_phone check (phone not like '%[^0-9]%')
	
);

alter sequence sc_user owned by tb_user.id_user;


create sequence sc_travel as integer;

create table public.tb_travel(
	id_travel integer not null default nextval('public.sc_travel'),
	id_driver integer,
	school varchar,
	type varchar,
	available_places integer,
	departure_date timestamp,
	province varchar,
	
	constraint pk_core_travel primary key (id_travel),
	constraint fk_core_id_driver foreign key (id_driver) references tb_user(id_user),
	constraint fk_core_province foreign key (province) references tb_province(name_province),
	constraint fk_core_school foreign key (school) references tb_school(name_school),
	constraint fk_core_type foreign key (type) references tb_climbing_type(climbing_type)
);

alter sequence sc_travel owned by tb_travel.id_travel;






create sequence sc_message as integer;

create table public.tb_message(
	id_message integer not null default nextval('public.sc_message'),
	text_message varchar(300),
	read Boolean DEFAULT false,
	
	constraint pk_core_message primary key (id_message)
);

alter sequence sc_message owned by tb_message.id_message;	
--create sequence sc_status as integer;

--create table core.tb_status(
--	id_status integer not null default nextval('core.sc_status'),
--	status_reservation boolean,
--	status_valuation boolean,
	
--	constraint pk_core_status primary key (id_status)
--);

--alter sequence sc_status owned by tb_status.id_status;
	

create sequence sc_reservation as integer;

 create table public.tb_reservation(
	id_reservation integer not null default nextval('public.sc_reservation'),
	id_user integer,
	id_travel integer,
	date_reservation timestamp,
	reservation_status Boolean,
	id_message integer,
	valuation_status Boolean,
	
	constraint pk_core_reservation primary key (id_reservation),
	constraint fk_core_id_user foreign key (id_user) references tb_user(id_user),
	constraint fk_core_id_travel foreign key (id_travel) references tb_travel(id_travel),
	constraint fk_core_id_message foreign key (id_message) references tb_message(id_message)
	);
 	
	alter sequence sc_reservation owned by tb_reservation.id_reservation;


--CARGADE DATOS
INSERT INTO tb_province(name_province)
VALUES
	('Elige tu provincia'),
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
	
	
INSERT INTO tb_user(full_name,experience,phone,email,score,outputs,user_photo,registration_date, ratings)
VALUES 
('Eduardo Gomez','Experimentado','691234453','edu21061991@gmail.com',2,0,'https://1.bp.blogspot.com/-wDSq0sy-Lro/YQqbRZ3HboI/AAAAAAAAGKs/uV4K5FhUOsAdn9U2YpmnmyzgqJ_MUYOQgCLcBGAsYHQ/s634/Screenshot_20210804-144347_1.png','2000-01-01 01:01:01',4),
('Pepito Perez','Principiante','685771234','javiergf1991@gmail.com',3,0,'https://media.cdnandroid.com/item_images/1068635/imagen-girly-wallpapers-profil-pics-for-girls-0big.jpg','2000-01-01 01:01:01',5),
('Juanito Fernandez','Principiante','685333928','javiergf1991@gmail.com',2,0,'https://media.cdnandroid.com/item_images/1068635/imagen-girly-wallpapers-profil-pics-for-girls-0big.jpg','2000-01-01 01:01:01',1),
('Lucas Garcia','Intermedio','644331928','javiergf1991@gmail.com',2.1,0,'https://media.cdnandroid.com/item_images/1068635/imagen-girly-wallpapers-profil-pics-for-girls-0big.jpg','2000-01-01 01:01:01',5),
('Marcos Lopez','Principiante','643475928','javiergf1991@gmail.com',3,0,'https://media.cdnandroid.com/item_images/1068635/imagen-girly-wallpapers-profil-pics-for-girls-0big.jpg','2000-01-01 01:01:01',3),
('Daniel Aran','Intermedio','685776568','javiergf1991@gmail.com',2,0,'https://media.cdnandroid.com/item_images/1068635/imagen-girly-wallpapers-profil-pics-for-girls-0big.jpg','2000-01-01 01:01:01',2),
('Sergio Garraf','Experimentado','685776668','javiergf1991@gmail.com',2,0,'https://media.cdnandroid.com/item_images/1068635/imagen-girly-wallpapers-profil-pics-for-girls-0big.jpg','2000-01-01 01:01:01',3),
('Isabel Noguera','Principiante','685779928','javiergf1991@gmail.com',3,0,'https://media.cdnandroid.com/item_images/1068635/imagen-girly-wallpapers-profil-pics-for-girls-0big.jpg','2000-01-01 01:01:01',5),
('Maria Delito','Intermedio','685770928','javiergf1991@gmail.com',1.5,0,'https://media.cdnandroid.com/item_images/1068635/imagen-girly-wallpapers-profil-pics-for-girls-0big.jpg','2000-01-01 01:01:01',1),
('Conchi Galan','Experimentado','685771111','javiergf1991@gmail.com',3,0,'https://media.cdnandroid.com/item_images/1068635/imagen-girly-wallpapers-profil-pics-for-girls-0big.jpg','2000-01-01 01:01:01',2),
('Lolito Priorat','Principiante','622775928','lolito@gmail',2.8,0,'https://cdn.autobild.es/sites/navi.axelspringer.es/public/styles/1200/public/media/image/2016/09/569465-whatsapp-que-tus-contactos-ponen-rana-perfil.jpg?itok=tpvHWpeZ','2000-01-01 01:01:01',4);

INSERT INTO tb_school
VALUES 
('Albarracin'),
('Rodellar'),
('Chulilla'),
('Sella'),
('Arbolí'),
('El Vellón'),
('Alcañiz'),
('Mula'),
('La Pedriza');


INSERT INTO tb_climbing_type
VALUES ('Selecciona el tipo de Escalada'),
		('Boulder'),
		('Deportiva'),
		('Rocódromo'),
		('Clásica');
	
INSERT INTO tb_travel(id_driver,school,type,available_places,departure_date,province)
VALUES 
(11,'Sella','Clásica',1,'2023-11-27 01:01:01.000','Madrid'),
(1,'Albarracin','Deportiva',2,'2021-11-27 01:01:01.000','Toledo'),
(2,'Chulilla','Boulder',3,'2022-11-27 01:01:01.000','Cádiz'),
(10,'Mula','Rocódromo',2,'2022-11-27 01:01:01.000','Melilla'),
(1,'Sella','Clásica',1,'2020-11-27 01:01:01.000','Murcia'),
(2,'La Pedriza','Rocódromo',4,'2023-11-27 01:01:01.000','Ourense'),
(9,'Alcañiz','Clásica',1,'2020-11-27 01:01:01.000','Asturias'),
(8,'El Vellón','Deportiva',3,'2021-11-27 01:01:01.000','Cuenca'),
(3,'Albarracin','Rocódromo',1,'2021-11-27 01:01:01.000','Pontevedra'),
(8,'Rodellar','Boulder',2,'2022-11-27 01:01:01.000','Girona'),
(2,'Albarracin','Rocódromo',1,'2023-11-27 01:01:01.000','Tarragona'),
(1,'Arbolí','Boulder',4,'2022-11-27 01:01:01.000','Teruel');
--INSERT INTO tb_status
--VALUES
--	('1',true,true),
--	('2',true,false),
--	('3',false,false),
--	('4',false,true);

INSERT INTO tb_reservation(id_user, id_travel, date_reservation, reservation_status,id_message, valuation_status)
VALUES
(2, 1, '2000-01-01 01:01:01', true,1,false),
(4, 2, '2000-01-01 01:01:01', false,2,false),
(5, 2, '2000-01-01 01:01:01', false,3,true),
(6, 2, '2000-01-01 01:01:01', true,4,false),
(5, 3, '2000-01-01 01:01:01', true,5,false),
(7, 4, '2000-01-01 01:01:01', false,6,false),
(1, 5, '2000-01-01 01:01:01', true,7,true),
(9, 5, '2000-01-01 01:01:01', false,8,false),
(3, 6, '2000-01-01 01:01:01', true,9,false),
(4, 7, '2000-01-01 01:01:01', false,10,true),
(4, 8, '2000-01-01 01:01:01', false,11,true),
(1, 9, '2000-01-01 01:01:01', true,12,false);


INSERT INTO tb_message(text_message, read)
VALUES
('Mensaje numero 1 ', false),
('Mensaje numero 2 ', true),
('Mensaje numero 3 ', false),
('Mensaje numero 4 ', false),
('Mensaje numero 5 ', true),
('Mensaje numero 6 ', true),
('Mensaje numero 7 ', true),
('Mensaje numero 8 ', false),
('Mensaje numero 9 ', true),
('Mensaje numero 10 ', true),
('Mensaje numero 11 ', false),
('Mensaje numero 12 ', true);

	