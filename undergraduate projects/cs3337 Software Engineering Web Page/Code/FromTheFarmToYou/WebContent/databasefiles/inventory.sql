use cs3220stu63;


SET time_zone = "+00:00";

/*Encrypt password*/ 
/* Add review table*/
DROP TABLE IF EXISTS inventory;

CREATE TABLE inventory (

	id			integer auto_increment key,
    farm_num	integer,
    name		varchar(32),
    description TEXT,
    price		FLOAT,
    quantity	integer,
    totalPrice	FLOAT
	/*ADD IMAGE HERE if time*/
);

/*Egg 1*/
INSERT INTO inventory values(1, 1, "White Eggs", "The best of it's kind is the original white egg that can be eaten with many other dishes. We are known for these eggs!", 2.99, 6, null);
INSERT INTO inventory values(2, 1, "Brown Eggs", "The brown eggs have been cleaned after the hens have produced them. They are nice and firm too!", 2.99, 5, null);
INSERT INTO inventory values(3, 1, "Omega Eggs", "The best of it's kind is the Omega egg. This egg features many more vitamins and minerals than all the other eggs!", 2.99, 3, null);
INSERT INTO inventory values(4, 1, "Caged Free Eggs", "Even though all of our hens are caged free, these are the real eggs that are produced while the hens are outside.", 2.99, 2, null);

/*Egg 2 */
INSERT INTO inventory values(5, 2, "Brown Eggs", "Our brown eggs are the most favored amongst our customers and recommend them to you!", 0.99, 10, null);
INSERT INTO inventory values(6, 2, "White Eggs", "The white eggs has been our original from the start of this farm and our hens know it.", 2.99, 10, null);
INSERT INTO inventory values(7, 2, "Omega Eggs", "Amongst the most nutritionist eggs that we have and contain 39% less Arachidonic Acid.", 2.99, 10, null);


SELECT * FROM inventory;
