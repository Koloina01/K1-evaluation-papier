CREATE DATABASE garage;

\c garage;

create user garage_db_manager password '012345';


GRANT CONNECT ON DATABASE garage TO "garage_db_manager" ;
GRANT CREATE ON SCHEMA public TO "garage_db_manager";
GRANT SELECT,INSERT,UPDATE,DELETE ON ALL TABLES IN SCHEMA public TO "garage_db_manager";