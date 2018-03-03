use cs3220stu76;

drop table if exists Review;

create table Review (
	ids		  integer AUTO_INCREMENT PRIMARY KEY,
	name      varchar(32),
    farm	  varchar(32),
    comment	  varchar(2000),
    date	  date
);

insert into Review values (0, "Robert Matinez", "Dixon", "The dixon farm was perhaps my favorite farm, especially the low price that the eggs have", now());

select * from Review