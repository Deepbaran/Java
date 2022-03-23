CREATE DATABASE jdbctest;
USE jdbctest;

CREATE TABLE table1 (
	id INT,
    name VARCHAR(20)
);

select * from table1;

insert into table1 (id,name)
values (1,"Deep"),(2,"Baran"),(3,"Kar");
