CREATE USER battlesimulator WITH PASSWORD 'replaceWithPassword';
CREATE DATABASE battlesimdb;
GRANT ALL PRIVILEGES ON DATABASE battlesimdb TO battlesimulator;
ALTER DATABASE battlesimdb OWNER TO battlesimulator;
GRANT ALL PRIVILEGES ON SCHEMA public TO battlesimulator;
