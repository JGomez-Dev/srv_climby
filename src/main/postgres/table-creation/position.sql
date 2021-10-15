set schema 'core';

create sequence sc_position as integer;

create table core.tb_position(
	id_position  integer not null default nextval('core.sc_position'),
	name_position varchar(50) not null,
	
	constraint pk_core_position primary key (id_position)
);
alter sequence sc_position owned by tb_position.id_position;