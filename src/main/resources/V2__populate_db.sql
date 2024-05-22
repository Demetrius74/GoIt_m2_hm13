INSERT INTO client (name) VALUES ('Client1'), ('Client2'), ('Client3'), ('Client4'), ('Client5'), ('Client6'), ('Client7'), ('Client8'), ('Client9'), ('Client10');

INSERT INTO planet (id, name) VALUES ('MARS', 'Mars'), ('VEN', 'Venus'), ('EARTH', 'Earth'), ('JUP', 'Jupiter'), ('SAT', 'Saturn');

INSERT INTO ticket (client_id, from_planet_id, to_planet_id) VALUES
(1, 'EARTH', 'MARS'), (2, 'MARS', 'VEN'), (3, 'VEN', 'EARTH'), (4, 'EARTH', 'JUP'), (5, 'JUP', 'SAT'),
(6, 'SAT', 'EARTH'), (7, 'MARS', 'JUP'), (8, 'VEN', 'SAT'), (9, 'EARTH', 'VEN'), (10, 'MARS', 'EARTH');
