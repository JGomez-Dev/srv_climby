set schema 'core';

create table core.tb_school(
	id_school varchar not null,
	name_school varchar(50) not null,
	
	constraint pk_core_school primary key (id_school)
);
