CREATE TABLE public.place_categories (
	category_id int8 NOT NULL PRIMARY KEY,
	category_image_url varchar(255) NULL,
	category_name varchar(255) NULL,
	category_secondary_image_url varchar(255) NULL
);

CREATE TABLE public.point_of_interest (
	place_id int8 NOT NULL PRIMARY KEy,
	category_id int8 NULL,
	category_name varchar(255) NULL,
	geo_hash varchar(255) NULL,
	place_city varchar(255) NULL,
	place_description varchar(255) NULL,
	place_image_url varchar(255) NULL,
	place_lat float8 NULL,
	place_long float8 NULL,
	place_name varchar(255) NULL,
	place_rating float4 NULL
);



INSERT INTO public.place_categories (category_id,category_image_url,category_name,category_secondary_image_url) VALUES
	 (1,'https://i.ibb.co/HzKG343/Top-view-table-full-of-food-Sharing-dinner-with-friends.jpg','Restaurant','https://i.ibb.co/tCY7WQq/restaurants.png'),
	 (2,'https://i.ibb.co/rydknC6/Coffee-Shops.jpg','Coffee Shops','https://i.ibb.co/2s37d74/coffee.png'),
	 (3,'https://i.ibb.co/vhkg5tb/Shopping.jpg','Shopping','https://i.ibb.co/ysDP8cs/shopping.png'),
	 (4,'https://i.ibb.co/Tm2HGgk/pubs.jpg','Pubs','https://i.ibb.co/Q9VbhgW/pubs.png'),
	 (5,'https://i.ibb.co/mGS1QhN/bars.jpg','Bars','https://i.ibb.co/DVmC7zZ/bars.png'),
	 (6,'https://i.ibb.co/cNNNhsd/hairsalon.jpg','Hair Salons','https://i.ibb.co/VLLGD70/hair.png');

INSERT INTO public.point_of_interest (place_id,category_id,category_name,geo_hash,place_city,place_description,place_image_url,place_lat,place_long,place_name,place_rating) VALUES
     	 (1,1,'Restaurant','tewf7','Washim','Best place','https://i.ibb.co/rbmNQfd/restaurent-1.png',20.104549,77.132677,'Raddison Blu',4.4),
     	 (2,1,'Restaurant','tewf7','Washim','Best place','https://i.ibb.co/xLRwbfW/restaurent-2.png',20.10471,77.132935,'Ovenstory Pizza',3.7),
     	 (3,1,'Restaurant','tgb0r','Nagpur','Best place','https://i.ibb.co/CKmzxDv/restaurent-3.png',21.1441,79.0882,'Subway',2.7),
     	 (4,1,'Restaurant','tgb0p','Nagpur','Best place','https://i.ibb.co/nLDLJrH/restaurent-4.png',21.1341,79.0782,'BBQ',3.2);