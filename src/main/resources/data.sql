INSERT INTO users (id, name, email) VALUES (100, 'Arnaud', 'arnaud@example.com');
INSERT INTO users (id, name, email) VALUES (200, 'kaninda', 'kaninda@example.com');

INSERT INTO orders (id, amounts, currency, user_id) VALUES (1, 49.99, 'EUR', 100);
INSERT INTO orders (id, amounts, currency, user_id) VALUES (2, 19.50, 'CHF',100);

INSERT INTO loyalties (id, tier, points, user_id) VALUES (1, 'GOLD', 2450,100);

