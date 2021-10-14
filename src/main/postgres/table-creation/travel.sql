set schema 'core';

create table core.tb_travel(
	id_travel varchar not null,
	id_driver varchar,
	site varchar,
	type varchar,
	available_places integer,
	departure_date_string varchar,
	departure_date timestamp,
	province varchar,
	
	constraint pk_core_travel primary key (id_travel),
	constraint fk_core_id_driver foreign key (id_driver) references tb_user(id_user),
	constraint fk_core_province foreign key (province) references tb_province(id_province)
);
