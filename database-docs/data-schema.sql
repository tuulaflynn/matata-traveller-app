DROP DATABASE IF EXISTS matata_traveler;
CREATE DATABASE matata_traveler;
USE matata_traveler;

CREATE TABLE city_details(
city_id INT AUTO_INCREMENT PRIMARY KEY,
city_name VARCHAR (30) NOT NULL,
city_country VARCHAR (30) NOT NULL,
city_img VARCHAR (255),
city_currency VARCHAR (30)
);

CREATE TABLE thread_details(
thread_id INT AUTO_INCREMENT PRIMARY KEY,
thread_content TINYTEXT,
thread_date DATE,
city_id INT,
FOREIGN KEY (city_id) REFERENCES city_details(city_id)
);

CREATE TABLE category_details(
category_id INT AUTO_INCREMENT PRIMARY KEY,
category_name VARCHAR (30)); 

CREATE TABLE thread_category_details(
thread_category_id INT AUTO_INCREMENT PRIMARY KEY,
thread_id INT,
category_id INT,
FOREIGN KEY (thread_id) REFERENCES thread_details(thread_id),
FOREIGN KEY (category_id) REFERENCES category_details(category_id)
);

CREATE TABLE attraction_details(
attraction_id INT AUTO_INCREMENT PRIMARY KEY,
attraction_name VARCHAR (50),
attraction_description TINYTEXT,
attraction_image VARCHAR(255),
attraction_opening_times VARCHAR (255),
city_id INT,
FOREIGN KEY (city_id) REFERENCES city_details(city_id)
);


-- CREATE TABLE city_thread(
-- city_thread_id INT AUTO_INCREMENT PRIMARY KEY,
-- thread_id INT,
-- city_id INT,
-- FOREIGN KEY (thread_id) REFERENCES thread_details(thread_id),
-- FOREIGN KEY (city_id) REFERENCES city_details(city_id)
-- );


