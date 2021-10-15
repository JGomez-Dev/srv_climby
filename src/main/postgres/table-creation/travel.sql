set schema 'core';

create sequence sc_travel as integer;

create table core.tb_travel(
	id_travel integer not null default nextval('core.sc_travel'),
	id_driver integer,
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

	alter sequence sc_travel owned by tb_travel.id_travel;
