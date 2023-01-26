INSERT INTO movie (title, genre, year_of_release, director)
 VALUES ('Space Jam', 'Cartoon, Comedy, Sports', 1996, 'Joe Pytka');
INSERT INTO movie (title, genre, year_of_release, director)
 VALUES ('One Piece: Red', 'Animation, Action, Shonen', 2022, 'Goro Taniguchi');
INSERT INTO movie (title, genre, year_of_release, director)
 VALUES ('Spider-Man', 'Superhero, Action', 2002, 'Sam Raimi');
 
INSERT INTO character (full_name, alias) VALUES ('Micheal Jordan',null);
INSERT INTO character (full_name, alias) VALUES ('Peter Parker', 'Spider-Man');
INSERT INTO character (full_name, alias) VALUES ('Monkey D. Luffy', 'Straw Hat');
INSERT INTO character (full_name, alias) VALUES ('Shanks',null);
INSERT INTO character (full_name, alias) VALUES ('Bugs Bunny', 'Bugs');
INSERT INTO character (full_name, alias) VALUES ('Harry Osborn', 'Green Goblin');

INSERT INTO franchise (name, description) VALUES ('One Piece', 'One Piece is a Japanese
manga series written and illustrated by Eiichiro Oda. It has been serialized in Shueishas
Weekly Shōnen Jump magazine since July 19, 1997, with the chapters collected into tankōbon volumes.');
INSERT INTO franchise (name, description) VALUES ('Marvel', 'The Marvel Cinematic
Universe (MCU) films are a series of American superhero films produced by Marvel
Studios based on characters that appear in publications by Marvel Comics.');

INSERT INTO movie_characters (movies_id, characters_id) VALUES (1,1);
INSERT INTO movie_characters (movies_id, characters_id) VALUES (3,2);
INSERT INTO movie_characters (movies_id, characters_id) VALUES (2,3);
INSERT INTO movie_characters (movies_id, characters_id) VALUES (2,4);
INSERT INTO movie_characters (movies_id, characters_id) VALUES (1,5);
INSERT INTO movie_characters (movies_id, characters_id) VALUES (3,6);