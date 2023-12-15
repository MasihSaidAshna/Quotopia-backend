use quotopia;

-- Authors INSERT statements
#INSERT INTO genre (genre_id, genre_name) VALUES (1, 'History');
#INSERT INTO genre (genre_id, genre_name) VALUES (2, 'Science fiction');
#INSERT INTO genre (genre_id, genre_name) VALUES (3, 'Science');
#INSERT INTO genre (genre_id, genre_name) VALUES (4, 'Sport');
#INSERT INTO genre (genre_id, genre_name) VALUES (5, 'Religion');

INSERT INTO genre (genre_id, genre_name) VALUES (1, 'Inspirational');
INSERT INTO genre (genre_id, genre_name) VALUES (2, 'Blessings');
INSERT INTO genre (genre_id, genre_name) VALUES (3, 'Motivational');
INSERT INTO genre (genre_id, genre_name) VALUES (4, 'Philosophical');
INSERT INTO genre (genre_id, genre_name) VALUES (5, 'Wisdom');


-- Authors INSERT statements
INSERT INTO author (author_id, author_name) VALUES (1, 'Steve Jobs');
INSERT INTO author (author_id, author_name) VALUES (2, 'Robert Frost');
INSERT INTO author (author_id, author_name) VALUES (3, 'Ralph Waldo Emerson');
INSERT INTO author (author_id, author_name) VALUES (4, 'Franklin D. Roosevelt');
INSERT INTO author (author_id, author_name) VALUES (5, 'Nelson Mandela');
INSERT INTO author (author_id, author_name) VALUES (6, 'Mother Teresa');
INSERT INTO author (author_id, author_name) VALUES (7, 'Eleanor Roosevelt');
INSERT INTO author (author_id, author_name) VALUES (8, 'Tony Robbins');
INSERT INTO author (author_id, author_name) VALUES (9, 'William Butler Yeats');
INSERT INTO author (author_id, author_name) VALUES (10, 'Winston Churchill');
INSERT INTO author (author_id, author_name) VALUES (11, 'Albert Einstein');
INSERT INTO author (author_id, author_name) VALUES (12, 'Thomas A. Edison');
INSERT INTO author (author_id, author_name) VALUES (13, 'Theodore Roosevelt');
INSERT INTO author (author_id, author_name) VALUES (14, 'Peter Drucker');
INSERT INTO author (author_id, author_name) VALUES (15, 'Nelson Mandela');
INSERT INTO author (author_id, author_name) VALUES (16, 'Sam Levenson');
INSERT INTO author (author_id, author_name) VALUES (17, 'Allen Saunders');
INSERT INTO author (author_id, author_name) VALUES (18, 'Abraham Lincoln');
INSERT INTO author (author_id, author_name) VALUES (19, 'Albert Einstein');
INSERT INTO author (author_id, author_name) VALUES (20, 'Johnathan Swift');


-- Quotes INSERT statements
INSERT INTO quotes (quote_text, author_id, genre_id) VALUES ('The only way to do great work is to love what you do.', 1, 1);
INSERT INTO quotes (quote_text, author_id, genre_id) VALUES ('In three words I can sum up everything I''ve learned about life: it goes on.', 2, 4);
INSERT INTO quotes (quote_text, author_id, genre_id) VALUES ('To be yourself in a world that is constantly trying to make you something else is the greatest accomplishment.', 3, 4);
INSERT INTO quotes (quote_text, author_id, genre_id) VALUES ('The only limit to our realization of tomorrow will be our doubts of today.', 4, 3);
INSERT INTO quotes (quote_text, author_id, genre_id) VALUES ('The greatest glory in living lies not in never falling, but in rising every time we fall.', 5, 3);
INSERT INTO quotes (quote_text, author_id, genre_id) VALUES ('Spread love everywhere you go. Let no one ever come to you without leaving happier.', 6, 3);
INSERT INTO quotes (quote_text, author_id, genre_id) VALUES ('The future belongs to those who believe in the beauty of their dreams.', 7, 3);
INSERT INTO quotes (quote_text, author_id, genre_id) VALUES ('The only impossible journey is the one you never begin.', 8, 1);
INSERT INTO quotes (quote_text, author_id, genre_id) VALUES ('Do not wait to strike till the iron is hot, but make it hot by striking.', 9, 5);
INSERT INTO quotes (quote_text, author_id, genre_id) VALUES ('Success is not final, failure is not fatal: It is the courage to continue that counts.', 10, 3);
INSERT INTO quotes (quote_text, author_id, genre_id) VALUES ('The only source of knowledge is experience.', 11, 5);
INSERT INTO quotes (quote_text, author_id, genre_id) VALUES ('I have not failed. I''ve just found 10,000 ways that won''t work.', 12, 3);
INSERT INTO quotes (quote_text, author_id, genre_id) VALUES ('Believe you can and you''re halfway there.', 13, 3);
INSERT INTO quotes (quote_text, author_id, genre_id) VALUES ('The best way to predict the future is to create it.', 14, 1);
INSERT INTO quotes (quote_text, author_id, genre_id) VALUES ('It always seems impossible until it''s done.', 15, 3);
INSERT INTO quotes (quote_text, author_id, genre_id) VALUES ('Don''t watch the clock; do what it does. Keep going.', 16, 3);
INSERT INTO quotes (quote_text, author_id, genre_id) VALUES ('Life is what happens when you''re busy making other plans.', 17, 5);
INSERT INTO quotes (quote_text, author_id, genre_id) VALUES ('Whatever you are, be a good one.', 18, 4);
INSERT INTO quotes (quote_text, author_id, genre_id) VALUES ('Strive not to be a success, but rather to be of value.', 19, 4);
INSERT INTO quotes (quote_text, author_id, genre_id) VALUES ('May you live all the days of your life.', 20, 4);







