CREATE SEQUENCE IF NOT EXISTS medicine_id_sequence START WITH 1 INCREMENT BY 1;
create table medicine
(
    id int4 NOT NULL DEFAULT nextval('medicine_id_sequence'::regclass),
    name varchar(300) not null,
    weight int not null,
    code varchar(100) not null,
    image text not null,
    CONSTRAINT medicine_pk PRIMARY KEY (id)
);
create unique index medicine_code_uindex
	on medicine (code);