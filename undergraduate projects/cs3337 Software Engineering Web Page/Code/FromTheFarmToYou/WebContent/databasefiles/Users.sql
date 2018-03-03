use cs3220stu76;


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
    status		varchar(64)



);

INSERT INTO users (first_name, last_name, username, email, password, status) values("Miguel", "Cayetano", "r3lek", "mcayeta3@mail.com", "abcd1234", "Admin");
INSERT INTO users (first_name, last_name, username, email, password, status) values("Jon", "Snow", "jonSnow", "test@mail.com", "abcd1234", "Farmer");
INSERT INTO users (first_name, last_name, username, email, password, status) values("Bill", "Cosby", "billWho", "only52@mail.com", "123", "Customer");



SELECT * FROM users;
