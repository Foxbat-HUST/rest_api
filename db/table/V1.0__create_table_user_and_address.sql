CREATE TABLE users(
id int PRIMARY KEY NOT NULL,
name varchar(30),
age int,
email varchar(30),
created_at datetime DEFAULT CURRENT_TIMESTAMP,
updated_at datetime ON UPDATE CURRENT_TIMESTAMP);


CREATE TABLE address(
id int PRIMARY KEY NOT NULL,
user_id int NOT NULL,
zipcode varchar(7),
address varchar(50),
created_at datetime DEFAULT CURRENT_TIMESTAMP,
deleted_at datetime ON UPDATE CURRENT_TIMESTAMP);
