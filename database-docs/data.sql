-- insert data in the city_details table
INSERT INTO city_details(city_name, city_country, city_img, city_currency) VALUES
("Paris", "France" ,"img", "EURO"),
("London", "United Kingdom", "img", "GBP"),
("New York City", "United States", "img", "USD"),
("Tokyo", "Japan", "img", "JPY"),
("Sydney", "Australia", "img", "AUD");

/*
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
("Bangkok", "Thailand","img", "THB") */


-- insert data in the attraction_details table
INSERT INTO attraction_details (attraction_name, attraction_description,attraction_image, city_id) VALUES
("Eiffel Tower", "The Eiffel Tower is arguably the most iconic symbol of Paris and a global landmark. Designed by Gustave Eiffel, it stands 324 meters tall and offers breathtaking views of the city from its observation decks. Visitors can ascend the tower via elevators or climb the stairs for a unique perspective of Paris.", "https://images.unsplash.com/photo-1511739001486-6bfe10ce785f?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=3087&q=80", 1),
("Notre-Dame Cathedral ", "Notre-Dame Cathedral is a masterpiece of French Gothic architecture and a symbol of Paris. Visitors can admire its stunning facade, intricate stained glass windows, and the opportunity to climb to the top for panoramic views of the city. It's also famous for Victor Hugo's novel, 'The Hunchback of Notre-Dame'.", "https://images.unsplash.com/photo-1598875793464-d8cc825c32f7?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8bm90cmUlMjBkYW1lfGVufDB8fDB8fHww&auto=format&fit=crop&w=800&q=60" ,1),
("Louvre Museum", "The Eiffel Tower is arguably the most iconic symbol of Paris and a global landmark. Designed by Gustave Eiffel, it stands 324 meters tall and offers breathtaking views of the city from its observation decks. Visitors can ascend the tower via elevators or climb the stairs for a unique perspective of Paris.", "https://images.unsplash.com/photo-1541264161754-445bbdd7de52?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OHx8bG91dnJlJTIwbXVzZXVtfGVufDB8fDB8fHww&auto=format&fit=crop&w=800&q=60",1),
("Arc de Triomphe", " The Arc de Triomphe is a monumental arch situated at the western end of the Champs-Élysées. It honors those who fought and died for France in the French Revolutionary and Napoleonic Wars. Visitors can ascend to the top for another fantastic vantage point of Paris and its grand boulevards.", "", 1),

("Big Ben and the Houses of Parliament", " Adjacent to the Houses of Parliament is the famous Big Ben clock tower, officially renamed the Elizabeth Tower in honor of Queen Elizabeth II. Visitors can admire the impressive architecture and take in the iconic view along the River Thames." , "https://images.unsplash.com/photo-1645193289160-31b15aeebf2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2845&q=80",2),
("London Bridge", "London Bridge is an iconic and historic structure that spans the River Thames in the heart of London. Although often confused with its more famous neighbor, Tower Bridge, London Bridge has its own significance. The current bridge is a modern construction, but it has a rich history dating back centuries, with various versions of the bridge standing in its place over time. While it may lack the ornate architecture of some other London landmarks, its historical and cultural importance, along with its strategic location, make it a symbol of London's enduring heritage." , "https://images.unsplash.com/photo-1533929736458-ca588d08c8be?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2970&q=80",2),
("Buckingham Palace", "Buckingham Palace serves as the official residence and administrative headquarters of the British monarch. While the palace itself is impressive, one of the main attractions is the Changing of the Guard ceremony that takes place in front of the palace. It's a colorful and ceremonial display of the British military and a must-see for visitors." , "https://images.unsplash.com/photo-1621591046606-f0e855b7c209?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=3087&q=80" ,2),
("National Gallery", "The National Gallery in London is a celebrated art museum located in Trafalgar Square. Visitors can explore masterpieces by renowned artists such as Leonardo da Vinci, Vincent van Gogh, Claude Monet, and J.M.W. Turner. The gallery's impressive collection spans various art movements and styles, including Renaissance, Baroque, Impressionism, and Post-Impressionism. Its neoclassical architecture and central location make it a cultural hub in the heart of London, attracting art enthusiasts and tourists alike to admire the timeless beauty of its artworks.", "https://images.unsplash.com/photo-1601316774005-63420603f0a5?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2960&q=80",2)

("Statue of Liberty","The Statue of Liberty is an enduring symbol of freedom and democracy. Given as a gift from France to the United States in 1886, Lady Liberty stands on Liberty Island in New York Harbor. Visitors can take a ferry to the island and explore the statue's pedestal and crown for panoramic views of the city."  , "https://images.unsplash.com/photo-1588384153148-ebd739ac430c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OHx8c3RhdHVlJTIwb2YlMjBsaWJlcnR5fGVufDB8fDB8fHww&auto=format&fit=crop&w=800&q=60" ,  3),
("Times Square", "Times Square, often referred to as 'The Crossroads of the World', is a bustling commercial and entertainment hub in the heart of Manhattan. Known for its iconic digital billboards, Broadway theaters, and vibrant atmosphere, it's a must-visit destination day or night."  , "https://images.unsplash.com/photo-1586615398870-38fd272d4701?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjF8fHRpbWVzJTIwc3F1YXJlfGVufDB8fDB8fHww&auto=format&fit=crop&w=800&q=60" , 3),
("Central Park", "Central Park is a sprawling urban oasis in the midst of Manhattan. This vast green space offers a serene escape from the city's hustle and bustle. Visitors can enjoy leisurely strolls, boating on the lake, picnics, and attractions like the Central Park Zoo and Strawberry Fields, a tribute to John Lennon."  , "https://images.unsplash.com/photo-1631729779674-1f369e1116b4?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8Y2VudHJhbCUyMHBhcmt8ZW58MHx8MHx8fDA%3D&auto=format&fit=crop&w=800&q=60" ,3),
("The Metropolitan Museum of Art","The Met, as it's commonly known, is one of the world's largest and most prestigious art museums. It houses an extensive collection of art spanning various cultures and time periods. From ancient Egyptian artifacts to European masterpieces, the museum offers a journey through human creativity and history.","https://images.unsplash.com/photo-1665399320904-51baf9adac8e?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=3087&q=80",3),

("Disneyland and DisneySea", "Popular theme parks offering a magical experience." , "img" ,  4),
("Tokyo Skytree", "Tallest tower in Japan, providing panoramic views of the city."  , "img" , 4),
("Tsukiji Outer Market", "A bustling seafood and street food market offering delicious culinary delights."  , "img" , 4),

("Sydney Opera House", "World-famous performing arts venue with a distinctive sail-like design."  , "img" , 5),
("Sydney Harbour Bridge", "Iconic steel bridge offering the opportunity to climb for breathtaking views."  , "img" , 5),
("Bondi Beach", " Famous coastal destination known for its stunning beach and vibrant atmosphere."  , "img" , 5);

/*
("Colosseum", " Ancient Roman amphitheater known for its historical significance."  , "img" , 6),
("Vatican City", "Independent city-state housing St. Peter's Basilica and the Sistine Chapel."  , "img" , 6),
("Trevi Fountain", "Baroque fountain where visitors can toss a coin to make a wish."  , "img" , 6),
("Christ the Redeemer", " Iconic statue atop Corcovado mountain with panoramic city views."  , "img" , 7),
("Copacabana Beach", " World-famous urban beach known for its lively atmosphere.."  , "img" , 7),
("Sugarloaf Mountain", " Granite peak offering stunning views of Rio and the surrounding bay."  , "img" , 7),
("The Bund", " Famous waterfront area with colonial-era architecture and skyline views."  , "img" , 8),
("Oriental Pearl Tower", " Iconic TV tower known for its unique design and observation decks."  , "img" , 8),
("Yu Garden", " Classical Chinese garden with historic buildings and serene surroundings."  , "img" , 8),
("Anne Frank House", "Historic museum in the former hiding place of Anne Frank during WWII."  , "img" , 9),
("Van Gogh Museum", "Art museum dedicated to the works of Vincent van Gogh."  , "img" , 9),
("Rijksmuseum", " National museum housing a vast collection of Dutch Golden Age paintings."  , "img" , 9),
("Brandenburg Gate", "Iconic neoclassical gate that symbolizes German unity."  , "img" , 10),
("Berlin Wall Memorial", " Historic site commemorating the division of the city during the Cold War."  , "img" , 10),
("Museum Island", "Cultural complex with several world-class museums and historic architecture."  , "img" , 10),
("Red Square", "Historic city square known for landmarks like the Kremlin and St. Basil's Cathedral."  , "img" , 11),
("The Kremlin", "Historic fortress complex housing government buildings and cathedrals."  , "img" ,  11),
("Bolshoi Theatre", " Renowned venue for opera and ballet performances."  , "img" ,  11),
("Hagia Sophia"," Historic architectural marvel with a rich history as a church and mosque."  , "img" , 12),
("Topkapi Palace","Former residence of Ottoman sultans, now a museum with exquisite treasures."  , "img" , 12),
("Grand Bazaar","One of the world's oldest and largest covered markets offering diverse shopping."  , "img" , 12) */


-- insert data in category_details
INSERT INTO category_details (category_id ,category_name) VALUES
    (1, 'food'),
    (2, 'transport'),
    (3, 'hotel'),
    (4, 'restaurant'),
    (5, 'excursion'),
    (6, 'adventure');
    
-- insert data into threads_details
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