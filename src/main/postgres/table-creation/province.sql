set schema 'core';

create table core.tb_province(
	id_province varchar not null,
	name_province varchar(50) not null,
	
	constraint pk_core_province primary key (id_province)
);
