use cs3220stu63;


SET time_zone = "+00:00";

/*Encrypt password*/
DROP TABLE IF EXISTS users;

CREATE TABLE users(
	
    id			integer auto_increment primary key,
    first_name	varchar(32),
    last_name	varchar(32),
    username	varchar(32),
    email		varchar(64),
    password	varchar(64),
    /*address	TEXT,*/
    status		varchar(64),
    farm_num	integer



);

INSERT INTO users (first_name, last_name, username, email, password, status) values("Miguel", "Cayetano", "r3lek", "mcayeta3@mail.com", "abcd1234", "Admin");
INSERT INTO users (first_name, last_name, username, email, password, status, farm_num) values("Jon", "Snow", "jonSnow", "test@mail.com", "abcd", "Farmer", 1);
INSERT INTO users (first_name, last_name, username, email, password, status, farm_num) values("farmer2", "farm2", "farmTwo", "farm2@mail.com", "abcd", "Farmer", 2);
INSERT INTO users (first_name, last_name, username, email, password, status) values("Bill", "who", "billWho", "only52@mail.com", "abcd", "Customer");



SELECT * FROM users;


