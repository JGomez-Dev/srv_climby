set schema 'core';

create table core.tb_position(
	id_position varchar not null,
	name_position varchar(50) not null,
	
	constraint pk_core_position primary key (id_position)
);
