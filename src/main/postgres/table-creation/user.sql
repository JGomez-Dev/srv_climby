set schema 'core';

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