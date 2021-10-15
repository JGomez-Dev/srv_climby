set schema 'core';

create sequence sc_school as integer;

create table core.tb_school(
	id_school integer not null default nextval('core.sc_school'),
	name_school varchar(50) not null,
	
	constraint pk_core_school primary key (id_school)
);

alter sequence sc_school owned by tb_school.id_school;