set schema 'core';

--create sequence sc_reservation as integer;

create table core.tb_reservation(
	id_reservation varchar,-- not null default nextval('core.sc_reservation'),
	id_user varchar not null,
	id_travel varchar not null,
	id_status varchar not null,
	date_reservation timestamp not null,
	
	constraint pk_core_reservation primary key (id_reservation),
	constraint fk_core_id_user foreign key (id_user) references tb_user(id_user),
	constraint fk_core_id_travel foreign key (id_travel) references tb_travel(id_travel),
	constraint fk_core_id_status foreign key (id_status) references tb_status(id_status)
	);
	
	--alter sequence sc_reservation owned by tb_reservation.id_reservation;
