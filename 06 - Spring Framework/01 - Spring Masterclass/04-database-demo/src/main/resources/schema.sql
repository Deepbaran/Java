-- We do not need to create the table manually as 
-- Spring Boot Auto configuration will trigger the Schema update
-- The Schema update is a fetaure of Hibernate
-- SO, when using JPA, no need to CREATE a Table explicitly as a table for each @Entity will be created automatically.
-- Just use INSERT data into them

--create table person
--(
--   id integer not null,
--   name varchar(255) not null,
--   location varchar(255),
--   birth_date timestamp,
--   primary key(id)
--);


INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) 
VALUES(10001,  'Ranga', 'Hyderabad',sysdate());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) 
VALUES(10002,  'James', 'New York',sysdate());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) 
VALUES(10003,  'Pieter', 'Amsterdam',sysdate());