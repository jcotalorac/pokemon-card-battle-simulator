CREATE TABLE fight (
	id serial PRIMARY KEY,
	health_human INTEGER NOT NULL
);

CREATE SEQUENCE fight_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
