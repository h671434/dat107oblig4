drop schema if exists dat108 cascade;
create schema dat108;

set search_path to dat108;


create table atendee(
    mobil CHARACTER (8) PRIMARY KEY,
	hash CHARACTER (64) NOT NULL,
	salt CHARACTER (32) NOT NULL,
	fornavn VARCHAR (40),
	etternavn VARCHAR (40),
	kjonn VARCHAR (6)
  );

