CREATE TABLE fight (
	id serial PRIMARY KEY,
	human_health INTEGER NOT null,
	human_attack INTEGER not null,
	computer_health INTEGER not null,
	computer_attack INTEGER not NULL
);

CREATE SEQUENCE fight_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

GRANT USAGE, SELECT ON SEQUENCE fight_seq TO battlesimulator;
GRANT ALL PRIVILEGES ON TABLE fight TO battlesimulator;
