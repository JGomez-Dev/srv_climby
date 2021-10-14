set schema 'core';

create table core.tb_user(
	id_user varchar not null,
	full_name varchar,
	experience integer,
	id_position varchar,
	phone varchar,
	email varchar,
	score numeric(18,11),
	outputs integer,
	user_photo varchar,
	
	
	constraint pk_core_user primary key (id_user),
	constraint fk_core_id_posicion foreign key (id_position) references tb_position(id_position)
);
