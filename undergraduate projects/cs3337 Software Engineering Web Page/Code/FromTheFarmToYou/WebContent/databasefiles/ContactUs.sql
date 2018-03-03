use cs3220stu76;

drop table if exists ContactUs;

create table ContactUs (
	ids		  integer AUTO_INCREMENT PRIMARY KEY,
	name      varchar(32),
    email	  varchar(32),
    comment	  varchar(2000),
    date	  date
);

insert into ContactUs values (0, "Robert Matinez","Rmartinez213@yahoo.com", "You should add more farms that feature in my area", now());

select * from ContactUs