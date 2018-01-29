INSERT INTO user (type, city, email, name, number, password, surname, username) VALUES ('ADMINFAN', 'Novi Sad', 'adminfan@adminfan', 'Ivan', '0635569989', 'adminfan', 'Vukasinovic', 'adminfan');
INSERT INTO user (type, city, email, name, number, password, surname, username) VALUES ('ADMINSYS', 'Novi Sad', 'adminsys@adminsys', 'Vladimir', '063429989', 'adminsys', 'Jovicic', 'adminsys');
INSERT INTO user (type, city, email, name, number, password, surname, username) VALUES ('ADMINSHOW','Novi Sad', 'adminshow@adminshow', 'Marko', '0635565239', 'adminsys', 'Krajinovic', 'adminshow');
INSERT INTO user (type, city, email, name, number, password, surname, username) VALUES ('REGISTERED','Beograd', 'dejan@dejan', 'Dejan', '0615565239', 'dejan', 'Stojkic', 'dejan');
INSERT INTO user (type, city, email, name, number, password, surname, username) VALUES ('REGISTERED','Novi Sad', 'milan@milan', 'Milan', '0645565239', 'milan', 'Stankovic', 'milan');

INSERT INTO show_ct (id, name, type) VALUES (1, 'Arena Cineplex', 'CINEMA');
INSERT INTO show_ct (id, name, type) VALUES (2, 'Narodno pozoriste', 'THEATRE');

INSERT INTO prop_new (id, date_created, description, title, price, admin_fan_id, registered_user_id,show_id) VALUES (1, '2018-01-29 00:55:56', 'Veoma glasna sirena', 'Sirena', 500, 1, 4,1);
INSERT INTO prop_new (id, date_created, description, title, price, admin_fan_id, registered_user_id,show_id) VALUES (2, '2018-01-24 03:55:56', 'Sesir za film', 'Sesir', 150, 1, 4,1);

INSERT INTO prop_used (id, date_created, description, title, active_until,accepted_bid, status, registered_user_id) VALUES (1, '2018-01-29 02:32:40', 'Polovne naocare Star Wars', 'Naocare Star Wars', '2018-01-29 02:32:45',0, 'WAITING', 5);
INSERT INTO prop_used (id, date_created, description, title, active_until,accepted_bid, status, registered_user_id) VALUES (2, '2018-01-27 02:32:40', 'Polovna maska za maskembal damska.', 'Maska damska', '2018-02-15 02:32:45',0, 'WAITING', 4);

INSERT INTO bid (accepted, date_created, price, prop_used_id, registered_user_id) VALUES (0, '2018-01-29 03:25:24', 250, 1, 5);
INSERT INTO bid (accepted, date_created, price, prop_used_id, registered_user_id) VALUES (1, '2018-02-01 17:25:24', 260, 1, 4);