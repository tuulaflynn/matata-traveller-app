DROP DATABASE IF EXISTS matata_traveller;
CREATE DATABASE matata_traveller;
USE matata_traveller;

CREATE TABLE city_details(
city_id INT AUTO_INCREMENT PRIMARY KEY,
city_name VARCHAR (30) NOT NULL,
city_country VARCHAR (30) NOT NULL,
city_currency VARCHAR (30) NOT NULL
);

CREATE TABLE thread_details(
thread_id INT AUTO_INCREMENT PRIMARY KEY,
thread_content TINYTEXT NOT NULL,
thread_date DATE NOT NULL,
city_id INT NOT NULL,
FOREIGN KEY (city_id) REFERENCES city_details(city_id)
);

CREATE TABLE category_details(
category_id INT AUTO_INCREMENT PRIMARY KEY,
category_name VARCHAR (30) NOT NULL);

CREATE TABLE thread_category_details(
thread_category_id INT AUTO_INCREMENT PRIMARY KEY,
thread_id INT NOT NULL,
category_id INT NOT NULL,
FOREIGN KEY (thread_id) REFERENCES thread_details(thread_id),
FOREIGN KEY (category_id) REFERENCES category_details(category_id)
);

CREATE TABLE attraction_details(
attraction_id INT AUTO_INCREMENT PRIMARY KEY,
attraction_name VARCHAR (50) NOT NULL,
attraction_description MEDIUMTEXT NOT NULL,
attraction_image VARCHAR(255) NOT NULL,
city_id INT NOT NULL,
FOREIGN KEY (city_id) REFERENCES city_details(city_id)
);
