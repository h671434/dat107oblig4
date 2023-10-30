DROP SCHEMA IF EXISTS dat108oblig4 CASCADE;
CREATE SCHEMA dat108oblig4;
SET search_path TO dat108oblig4;

CREATE TABLE participant (
	phone CHAR(8) PRIMARY KEY,
	hash CHAR(64) NOT NULL,
	salt CHAR(32) NOT NULL,
	firstname VARCHAR(40),
 	lastname VARCHAR(40),
 	gender VARCHAR(6)
);
