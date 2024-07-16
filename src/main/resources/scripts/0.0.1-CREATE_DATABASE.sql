CREATE SCHEMA IF NOT EXISTS treatment;

DROP TABLE IF EXISTS treatment.treatment;

CREATE SEQUENCE treatment.treatment_sequence
    INCREMENT BY 50
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
	CACHE 1
	NO CYCLE;

CREATE TABLE treatment.treatment
(
    id             int8           NOT NULL,
    uuid           uuid           NOT NULL,
    "name"         varchar(255)   NOT NULL,
    description    varchar(255)   NOT NULL,
    value          numeric(19, 2) NOT NULL,
    type           varchar(255)   NOT NULL,
    creation_date  timestamp      NOT NULL,
    last_update    timestamp      NOT NULL,

    CONSTRAINT treatment_pkey PRIMARY KEY (id)
);