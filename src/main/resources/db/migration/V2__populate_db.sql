INSERT INTO client (name)
VALUES
	('andrii'),
	('oleh'),
	('anna'),
	('serhii'),
	('volodymyr'),
	('marta'),
	('stepan'),
	('olha'),
	('dima'),
	('petro');

INSERT INTO planet (id, name)
VALUES
    ('TRE123', 'planet1'),
    ('JKG345', 'planet2'),
    ('KHH872', 'planet3'),
    ('TFD412', 'planet4'),
    ('KHJ211', 'planet5');

INSERT INTO ticket (client_id, from_planet_id, to_planet_id)
VALUES
    (1, 'TRE123', 'JKG345'),
    (2, 'TRE123', 'JKG345'),
    (3, 'JKG345', 'KHH872'),
    (4, 'JKG345', 'KHH872'),
    (5, 'KHH872', 'TFD412'),
    (5, 'TFD412', 'KHH872'),
    (1, 'JKG345', 'TRE123'),
    (2, 'JKG345', 'TRE123'),
    (3, 'KHH872', 'JKG345'),
    (4, 'KHH872', 'JKG345');