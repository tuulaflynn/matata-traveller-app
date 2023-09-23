-- insert data in the city_details table
INSERT INTO city_details(city_name, city_country, city_img, city_currency) VALUES
("Paris", "France" ,"img", "EURO"),
("London", "United Kingdom", "img", "GBP"),
("New York City", "United States", "img", "USD"),
("Tokyo", "Japan", "img", "JPY"),
("Sydney", "Australia", "img", "AUD"),
("Rome", "Italy", "img","EURO"),
("Rio de Janeiro", "Brazil","img", "BRL"),
("Shanghai", "China","img", "CNY"),
("Amsterdam", "Netherlands", "img","EURO"),
("Berlin", "Germany", "img","EURO"),
("Moscow", "Russia","img","RUB"),
("Istanbul", "Turkey", "img", "TRY"),
("Barcelona", "Spain", "img","EURO"),
("Mumbai", "India", "img", "INR"),
("Buenos Aires", "Argentina", "img", "ARS"),
("Toronto", "Canada","img","CAD"),
("Cape Town", "South Africa","img","ZAR"),
("Bangkok", "Thailand","img", "THB");

-- insert data in the attraction_details table
INSERT INTO attraction_details (attraction_name, attraction_description,attraction_image, attraction_opening_times, city_id) VALUES
("Eiffel Tower", "Iconic iron lattice tower offering breathtaking views of Paris.", "Eiffel Tower img" , "opening ttimes details", 1),
("Notre-Dame Cathedral ", "Gothic masterpiece known for its stunning architecture and history.", "img" , "opening ttimes details",1),
("Louvre Museum", "World-famous art museum housing the Mona Lisa and countless other treasures.", "img" , "opening ttimes details",1),
("Big Ben and the Houses of Parliament", "Iconic clock tower and seat of the UK government." , "img" , "opening ttimes details",2),
("The British Museum ", "Renowned museum with a vast collection of art and historical artifacts." , "img" , "opening ttimes details",2),
("Buckingham Palace", "The official residence of the British monarch and a symbol of British royalty." , "img" , "opening ttimes details",2),
("Statue of Liberty","Iconic symbol of freedom and a must-visit landmark."  , "img" , "opening ttimes details", 3),
("Times Square", "Bright, bustling commercial hub famous for its theaters and billboards."  , "img" , "opening ttimes details", 3),
("Central Park", "Enormous urban park offering green spaces, lakes, and various recreational activities."  , "img" , "opening ttimes details", 3),
("Disneyland and DisneySea", "Popular theme parks offering a magical experience." , "img" , "opening times details", 4),
("Tokyo Skytree", "Tallest tower in Japan, providing panoramic views of the city."  , "img" , "opening times details", 4),
("Tsukiji Outer Market", "A bustling seafood and street food market offering delicious culinary delights."  , "img" , "opening times details", 4),
("Sydney Opera House", "World-famous performing arts venue with a distinctive sail-like design."  , "img" , "opening times details", 5),
("Sydney Harbour Bridge", "Iconic steel bridge offering the opportunity to climb for breathtaking views."  , "img" , "opening times details", 5),
("Bondi Beach", " Famous coastal destination known for its stunning beach and vibrant atmosphere."  , "img" , "opening times details", 5),
("Colosseum", " Ancient Roman amphitheater known for its historical significance."  , "img" , "opening times details", 6),
("Vatican City", "Independent city-state housing St. Peter's Basilica and the Sistine Chapel."  , "img" , "opening times details", 6),
("Trevi Fountain", "Baroque fountain where visitors can toss a coin to make a wish."  , "img" , "opening times details", 6),
("Christ the Redeemer", " Iconic statue atop Corcovado mountain with panoramic city views."  , "img" , "opening times details", 7),
("Copacabana Beach", " World-famous urban beach known for its lively atmosphere.."  , "img" , "opening times details", 7),
("Sugarloaf Mountain", " Granite peak offering stunning views of Rio and the surrounding bay."  , "img" , "opening times details", 7),
("The Bund", " Famous waterfront area with colonial-era architecture and skyline views."  , "img" , "opening times details", 8),
("Oriental Pearl Tower", " Iconic TV tower known for its unique design and observation decks."  , "img" , "opening times details", 8),
("Yu Garden", " Classical Chinese garden with historic buildings and serene surroundings."  , "img" , "opening times details", 8),
("Anne Frank House", "Historic museum in the former hiding place of Anne Frank during WWII."  , "img" , "opening times details", 9),
("Van Gogh Museum", "Art museum dedicated to the works of Vincent van Gogh."  , "img" , "opening times details", 9),
("Rijksmuseum", " National museum housing a vast collection of Dutch Golden Age paintings."  , "img" , "opening times details", 9),
("Brandenburg Gate", "Iconic neoclassical gate that symbolizes German unity."  , "img" , "opening times details", 10),
("Berlin Wall Memorial", " Historic site commemorating the division of the city during the Cold War."  , "img" , "opening times details", 10),
("Museum Island", "Cultural complex with several world-class museums and historic architecture."  , "img" , "opening times details", 10),
("Red Square", "Historic city square known for landmarks like the Kremlin and St. Basil's Cathedral."  , "img" , "opening times details", 11),
("The Kremlin", "Historic fortress complex housing government buildings and cathedrals."  , "img" , "opening times details", 11),
("Bolshoi Theatre", " Renowned venue for opera and ballet performances."  , "img" , "opening times details", 11),
("Hagia Sophia"," Historic architectural marvel with a rich history as a church and mosque."  , "img" , "opening times details", 12),
("Topkapi Palace","Former residence of Ottoman sultans, now a museum with exquisite treasures."  , "img" , "opening times details", 12),
("Grand Bazaar","One of the world's oldest and largest covered markets offering diverse shopping."  , "img" , "opening times details", 12)
;

-- Create categories
INSERT INTO category_details (category_id ,category_name) VALUES
    (1, 'food'),
    (2, 'transport'),
    (3, 'hotel'),
    (4, 'restaurant'),
    (5, 'excursion'),
    (6, 'adventure');
    
-- Create threads
INSERT INTO thread_details(thread_content, thread_date, city_id) VALUES
    ('Visited the Sophia Mosque today. Such a spiritually enriching experience!', "2014-02-01", 12),
    ('Took a ride on the historic tram, exploring the city with vintage vibes.', "2014-06-11", 6),
    ('Staying at the luxurious Grand Hotel during my trip. What a fantastic choice!', "2014-06-30", 4),
    ('Enjoyed a delightful dinner at the Italian restaurant downtown. The pasta was incredible.', "2014-07-04", 2),
    ('Went on a guided tour to explore ancient ruins. History comes alive!', "2014-07-04", 5),
    ('Sunset views from my hotel room are breathtaking. Feeling blessed.', "2022-09-14", 5),
    ('Exploring the local cuisine. Street food is the way to go!', "2022-09-26", 3),
    ('Took a scenic hike to the mountain peak. Spectacular views all around.', "2022-10-03", 7),
    ('Navigating the city using public transport. Easy and convenient!', "2022-12-02", 2),
    ('Dining at a rooftop restaurant tonight. City lights and good food - perfect combination.', "2022-12-17", 1),
    ('Visited a historic cathedral today. Incredible architecture!', "2023-03-27", 2),
    ('Took a boat ride along the river. Relaxing and scenic!',"2023-04-07", 5),
    ('Checked into a cozy boutique hotel. Loving the ambiance!', "2023-01-05", 4),
    ('Tried some street food specialties. Spicy and delicious!', "2023-06-01", 4),
    ('Explored ancient temples on a guided tour. Fascinating history!', "2023-09-14", 18);

-- Create thread-category associations
INSERT INTO thread_category_details (thread_id, category_id) VALUES
	(1, 5),
	(2, 2),
	(2, 6),
	(3, 3),
	(4, 1),
	(5, 5),
	(6, 3),
	(7, 1),
	(7, 6),
	(8, 5),
	(9, 2),
	(10, 4),
	(11, 5),
	(12, 2),
	(13, 3),
	(14, 1),
	(15, 5);



-- insert data in the city_thread table
-- INSERT INTO city_thread (thread_id, city_id) VALUES
-- (1,1),
-- (2,2),
-- (3,3),
-- (4,4),
-- (5,5),
-- (6,6),
-- (7,7),
-- (8,8),
-- (9,9),
-- (10,10),
-- (11,11),
-- (12,12),
-- (13,13),
-- (14,14),
-- (15,15),
-- (1,3),
-- (2,4),
-- (3,5),
-- (4,3),
-- (5,1),
-- (6,4),
-- (7,3),
-- (8,1),
-- (9,3),
-- (10,1),
-- (11,1),
-- (12,1),
-- (13,1),
-- (14,1),
-- (15,1);

SELECT * FROM city_details;
SELECT * FROM attraction_details;
SELECT * FROM category_details;
SELECT * FROM thread_details;
SELECT * FROM thread_category_details;
SELECT * FROM city_thread;

SHOW TABLES;