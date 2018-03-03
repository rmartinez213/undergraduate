/*use cs3220stu63;
SELECT * FROM guestbook;
*/

use cs3220stu63;


SET time_zone = "+00:00";

/*Encrypt password*/ 
/* Add review table*/
DROP TABLE IF EXISTS farmerInfo;

CREATE TABLE farmerInfo(
	
    /* When deciding if they can edit, check if status from user table is FArmer, and check from farmerInfo if farmNum equals 1  */
    
    id				integer auto_increment key,
    h1_header		varchar(255),
    service_text	TEXT,
    first_h4		TEXT,
    arranging_text	TEXT,
    second_h4		TEXT,
    arranging2_text	TEXT,
    third_h4		TEXT,
    arranging3_text	TEXT,
    fourth_h4		TEXt,
    arranging4_text	TEXT
    
    
/*    
    email		varchar(640),
    password	varchar(640),
    status		varchar(640)
*/
);

insert into farmerInfo values (1, 
			"Welcome to, The Dixon Farm", 
            
            " Since 1994, we've been a local farm. We expanded our farm by buying multiple acres of land where we have sought to expand our animal inventory and start selling to local communities.
        	We guarantee the freshness of our products as they are grown locally. We enjoy satisfying our customers with only the best farm grown hens that are caged free and with the best
        	nutrition. Order your eggs online today and enjoy the best tasting non-GMO eggs out there! ",
            
            "Natural Environment", 
            
            "Our farm is located in a natural environment that takes great care of our live stock. By this we mean that our land has provided
                         some of the most beneficial environment by giving our animals water and some of the best food source. ",
                         
			"Open 24/7",
            
            "That's right! We are open 24/7 so that means you can order your eggs any time of the day, any day of the week, in any month.
						We want all our customers to enjoy all the eggs that they want at any given time, so as long as transportation services are 
						available, then the egg will be delivered to you! ",
                         
			"Fast Delivery",
            
            "Like many other farmers, we want to ensure our customers get their eggs as soon as possible, so that they can enjoy
                         the freshness of our eggs. There are many things we want our customers to enjoy, so we want them to enjoy the eggs as
                         fast as possible!",
                         
            "Satisfied Customers",
            
            "We enjoy seeing our farmers satisfied, that's why we deliver the best experience for our user, so that they
                         can return and buy more of our eggs. Don't believe us? Scroll down to the bottom of the page to see what our
                         customers are saying!"
            
            );

/*For farm 2 */
insert into farmerInfo values (2, 
			"Welcome to,The Hesperia Family Farm", 
            
            " We are family farm dedicated to providing the best eggs around! Like I said, we are family farm that has been around for generations
            and we know what our customers love! We stay committed to delivering the best quality eggs and delivering the freshness straight to your door.
            We care about our live stock, just as much as we care about our customers and their satisfaction. Since 1887 we have dedicated the best services
            and we plan on expanding our egg shipments to other locals in different areas!",
            
            "Caged Free Hens", 
            
            "We love our hens too! We provide the best shelter and care for animals so that they can lay the best eggs just for you! Not only do
                         we care for our business, but we care for our live stock and that's why we keep them caged-free so that they can stay fit and produce
                         the best eggs in town! ",
                         
			"100% Natural Eggs",
            
            "The eggs are here and they are more natural than ever before! The hens are raised in the best environment and are not kept in cages.
                         The eggs have not been modified or don't contain any enzymes. These are real eggs that are GMO-free. Give them a try!",
                         
			"Large Variety Feeds",
            
            "We have many live stock animals and we provide the best food and exercise especially for our hens. We take great care of our hens by providing them
                         with daily meals throughout the day and plenty of water. We provide only the best meals for our live stock so we ensure they are getting the best
                         nutrition.",
                         
            "Flash Delivery",
            
            "We have been hard at work to gather resources to deliver your eggs safely to your home. Get your eggs delivered to you within hours,
                         as long as you order before 10am. Upon confirmation we will send the eggs directly to your home! Why wait? Order yours right now and
                         get them delivered to your home within hours!"
            
            );



select * from farmerInfo;