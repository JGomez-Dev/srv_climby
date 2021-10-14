set schema 'core';

create table core.tb_status(
	id_status varchar not null,
	status_reservation boolean,
	status_valuation boolean,
	
	constraint pk_core_status primary key (id_status)
);
