set schema 'core';

--create sequence sc_status as integer;

create table core.tb_status(
	id_status varchar ,--integer not null default nextval('core.sc_status'),
	status_reservation boolean,
	status_valuation boolean,
	
	constraint pk_core_status primary key (id_status)
);

	--alter sequence sc_status owned by tb_status.id_status;
