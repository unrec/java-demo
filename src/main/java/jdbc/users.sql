CREATE SCHEMA jdbc_test;

CREATE TABLE users (
user_id int(10) NOT NULL,
user_name varchar(45) NOT NULL,
rating int(10) DEFAULT NULL,
PRIMARY KEY (user_id));

INSERT INTO users (user_id, user_name, rating) VALUES ('1', 'Andrei', '35');
INSERT INTO users (user_id, user_name, rating) VALUES ('2', 'Lena', '50');
INSERT INTO users (user_id, user_name, rating) VALUES ('3', 'Anton', '92');
INSERT INTO users (user_id, user_name, rating) VALUES ('4', 'Tanya', '75');