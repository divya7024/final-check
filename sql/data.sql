-- Include table data insertion, updation, deletion and select scripts
---------------------------------------------------------------------------------------------------
-- Adding Movies in Movie List Table--
----------------------------------------------------------------------------------------------------

INSERT INTO movie_list

VALUES

			(1, 'Avatar', 278796508, 'Yes', '2017-03-15','Science Fiction', 'Yes'),
					
			(2, 'The Avengers', 151812988, 'Yes', '2017-12-23','Romance', 'Yes'),
					
			(3, 'Titanic', 218746394, 'Yes', '2017-08-21','Comedy', 'Yes'),
					
			(4, 'Jurassic World', 1671713208, 'No', '2017-07-02','Adventure', 'Yes'),
					
			(5, 'Avengers:End Game', 275076034, 'Yes', '2022-11-02','Thriller', 'Yes');
					

------------------------------------------------------------------------------------------------------
-- Display Movie List --
-------------------------------------------------------------------------------------------------------

SELECT 

mv_id AS Id ,

mv_title AS Title,

mv_box_office AS Box_Office,

mv_active AS Active,

mv_date_of_launch AS Date_Of_Launch,

mv_genre As Genre,

mv_has_teaser AS Has_Teaser

FROM movie_list;


------------------------------------------------------------------------------------------------------
-- Edit Movie List --
------------------------------------------------------------------------------------------------------


UPDATE movie_list

SET mv_title='Bahubali',mv_box_office=500,mv_active='No',mv_date_of_launch='2018-03-12',mv_genre='Historic',mv_has_teaser='No'

WHERE mv_id=1;


---------------------------------------------------------------------------------------------------------
-- Display Updated Movie List --
---------------------------------------------------------------------------------------------------------


SELECT 

mv_id AS Id ,

mv_title AS Title,

mv_box_office AS Box_Office,

mv_active AS Active,

mv_date_of_launch AS Date_Of_Launch,

mv_genre As Genre,

mv_has_teaser AS Has_Teaser

 FROM movie_list;



---------------------------------------------------------------------------------------------------------
-- User Table --
---------------------------------------------------------------------------------------------------------

INSERT INTO user(us_id,us_name)

VALUES

(1,'Divya'),(2,'Sneha');



SELECT 

us_id AS Id,

us_name As User

FROM user;


---------------------------------------------------------------------------------------------------------
-- Movie List Customer --
---------------------------------------------------------------------------------------------------------

SELECT mv_title,mv_has_teaser,mv_box_office,mv_genre

FROM movie_list

WHERE mv_active='Yes' AND mv_date_of_launch<=current_date();


--------------------------------------------------------------------------------------------------------
-- Add To Favorites --
--------------------------------------------------------------------------------------------------------

INSERT INTO favorites(fv_us_id,fv_pr_id)

VALUES

(1,1),(1,3);


---------------------------------------------------------------------------------------------------------
-- View Favorites --
---------------------------------------------------------------------------------------------------------

SELECT mv_title,mv_has_teaser,mv_box_office

FROM movie_list

INNER JOIN favorites

ON fv_pr_id=mv_id

WHERE fv_us_id=1;


SELECT
 
fv_id As Id,

fv_us_id AS User_id,

fv_pr_id AS Price

FROM favorites;



-----------------------------------------------------------------------------------------------------------
-- Number of favorites --
-----------------------------------------------------------------------------------------------------------

SELECT count(mv_box_office) as Number_of_favorites

FROM movie_list

INNER JOIN favorites
 
ON fv_pr_id=mv_id

WHERE fv_us_id=1;



-----------------------------------------------------------------------------------------------------------
-- Display Favorites---
-----------------------------------------------------------------------------------------------------------

SELECT
 
fv_id As Id,

fv_us_id AS User_id,

fv_pr_id AS Price

FROM favorites;



-----------------------------------------------------------------------------------------------------------
-- Delete Favorite --
-----------------------------------------------------------------------------------------------------------

DELETE FROM favorites 

WHERE fv_us_id=1 AND fv_pr_id=3;


-----------------------------------------------------------------------------------------------------------
--  Display Favorite After Deleting
-----------------------------------------------------------------------------------------------------------

SELECT mv_title,mv_has_teaser,mv_box_office

FROM movie_list

INNER JOIN favorites 

ON fv_pr_id=mv_id

WHERE fv_us_id=1;


----------------------------------------------------------------------------------------------------------
-- No of Favorites
----------------------------------------------------------------------------------------------------------

SELECT count(mv_box_office) as Number_of_Favorites from movie_list

INNER JOIN favorites
 
ON fv_pr_id=mv_id

WHERE fv_us_id=1;



-----------------------------------------------------------------------------------------------------------
-- Favorites --
-----------------------------------------------------------------------------------------------------------

SELECT
 
fv_id As Id,

fv_us_id AS User_id,

fv_pr_id AS Price

FROM favorites;
















