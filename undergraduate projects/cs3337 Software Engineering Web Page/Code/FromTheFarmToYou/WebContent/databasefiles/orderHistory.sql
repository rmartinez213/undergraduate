use cs3220stu63;


SET time_zone = "+00:00";

/*Encrypt password*/ 
/* Add review table*/
DROP TABLE IF EXISTS orderhistory;

CREATE TABLE orderhistory (

	
	id			integer auto_increment key,
    first_name	varchar(32),
    last_name	varchar(32),
    farm_num	integer, 
    eggsbought	integer,
    totalprice	float,
    Date		date

)