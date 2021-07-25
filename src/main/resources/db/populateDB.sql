DELETE FROM user;

INSERT INTO user (id, email, password)
VALUES (1, 'admin_1@gmail.com', 'admin'),
       (2, 'admin_2@gmail.com', 'admin'),
       (3, 'john@yandex.ru', 'jpass'),
       (4, 'paul@yandex.ru', 'ppass'),
       (5, 'george@yandex.ru', 'gpass'),
       (6, 'user@yandex.ru', 'upass');