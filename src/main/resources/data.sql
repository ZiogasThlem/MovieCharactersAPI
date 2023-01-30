INSERT INTO movie (title, genre, year_of_release, director)
 VALUES ('Space Jam', 'Cartoon, Comedy, Sports', 1996, 'Joe Pytka');
INSERT INTO movie (title, genre, year_of_release, director)
 VALUES ('One Piece: Red', 'Animation, Action, Shonen', 2022, 'Goro Taniguchi');
INSERT INTO movie (title, genre, year_of_release, director)
 VALUES ('Spider-Man', 'Superhero, Action', 2002, 'Sam Raimi');
INSERT INTO movie (title, genre, year_of_release, director)
VALUES ('Scarface', 'Gangster, Thriller, Drama', 1982, 'Brian De Palma');
INSERT INTO movie (title, genre, year_of_release, director)
VALUES ('The Dark Knight', 'Superhero, Crime, Action', 2008, 'Christopher Nolan');


INSERT INTO character (full_name, alias, gender) VALUES ('Micheal Jordan','Male');
INSERT INTO character (full_name, alias, gender) VALUES ('Peter Parker', 'Spider-Man','Male');
INSERT INTO character (full_name, alias, gender) VALUES ('Monkey D. Luffy', 'Straw Hat','Male');
INSERT INTO character (full_name, alias, gender) VALUES ('Shanks',null,'Male');
INSERT INTO character (full_name, alias, gender) VALUES ('Bugs Bunny', 'Bugs','Male');
INSERT INTO character (full_name, alias, gender) VALUES ('Harry Osborn', 'Green Goblin','Male');
INSERT INTO character (full_name, alias, gender) VALUES ('Tony Montana', 'Scarface','Male');
INSERT INTO character (full_name, alias, gender) VALUES ('Bruce Wayne', 'Batman','Male');
INSERT INTO character (full_name, alias, gender) VALUES ('Alfred Pennywise', null,'Male');
INSERT INTO character (full_name, alias, gender) VALUES ('Manny Ray', null,'Male');
INSERT INTO character (full_name, alias, gender) VALUES ('Jennifer Lopez', 'JLo','Female');


INSERT INTO franchise (name, description) VALUES ('One Piece', 'One Piece is a Japanese
manga series written and illustrated by Eiichiro Oda. It has been serialized in Shueishas
Weekly Shōnen Jump magazine since July 19, 1997, with the chapters collected into tankōbon volumes.');
INSERT INTO franchise (name, description) VALUES ('Marvel', 'The Marvel Cinematic
Universe (MCU) films are a series of American superhero films produced by Marvel
Studios based on characters that appear in publications by Marvel Comics.');
INSERT INTO franchise (name, description) VALUES ('DCEU', 'The DC Extended Universe (DCEU) is an American
media franchise and shared universe centered on a series of superhero films and television series produced
by DC Studios. It is based on characters that appear in American comic books published by DC Comics.');


INSERT INTO movie_characters (movies_id, characters_id) VALUES (1,1);
INSERT INTO movie_characters (movies_id, characters_id) VALUES (3,2);
INSERT INTO movie_characters (movies_id, characters_id) VALUES (2,3);
INSERT INTO movie_characters (movies_id, characters_id) VALUES (2,4);
INSERT INTO movie_characters (movies_id, characters_id) VALUES (1,5);
INSERT INTO movie_characters (movies_id, characters_id) VALUES (3,6);
INSERT INTO movie_characters (movies_id, characters_id) VALUES (4,7);
INSERT INTO movie_characters (movies_id, characters_id) VALUES (5,8);
INSERT INTO movie_characters (movies_id, characters_id) VALUES (5,9);
INSERT INTO movie_characters (movies_id, characters_id) VALUES (4,10);
INSERT INTO movie_characters (movies_id, characters_id) VALUES (4,11);
