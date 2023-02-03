CREATE SEQUENCE IF NOT EXISTS drones_id_sequence START WITH 1 INCREMENT BY 1;
CREATE TABLE drones (
                        id int4 NOT NULL DEFAULT nextval('drones_id_sequence'::regclass),
                        serial varchar(100) not null,
                        model varchar(30) not null,
                        weight_limit int not null,
                        battery int not null,
                        state varchar(30) not null,
                        CONSTRAINT drones_pk PRIMARY KEY (id)
);
create unique index drones_serial_uindex
	on drones (serial);
