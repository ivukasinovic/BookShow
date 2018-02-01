INSERT INTO user (type, city, email, name, number, password, surname, username) VALUES ('ADMINFAN', 'Novi Sad', 'adminfan@adminfan', 'Ivan', '0635569989', 'adminfan', 'Vukasinovic', 'adminfan');
INSERT INTO user (type, city, email, name, number, password, surname, username) VALUES ('ADMINFAN', 'Beograd', 'adminfan2@adminfan2', 'Jovan', '0641569989', 'adminfan2', 'Jovic', 'adminfan2');
INSERT INTO user (type, city, email, name, number, password, surname, username) VALUES ('ADMINSYS', 'Novi Sad', 'adminsys@adminsys', 'Vladimir', '063429989', 'adminsys', 'Jovicic', 'adminsys');
INSERT INTO user (type, city, email, name, number, password, surname, username) VALUES ('ADMINSHOW','Novi Sad', 'adminshow@adminshow', 'Marko', '0635565239', 'adminsys', 'Krajinovic', 'adminshow');
INSERT INTO user (type, city, email, name, number, password, surname, username) VALUES ('REGISTERED','Beograd', 'dejan@dejan', 'Dejan', '0615565239', 'dejan', 'Stojkic', 'dejan');
INSERT INTO user (type, city, email, name, number, password, surname, username) VALUES ('REGISTERED','Novi Sad', 'milan@milan', 'Milan', '0645565239', 'milan', 'Stankovic', 'milan');

INSERT INTO show_ct (id, name, type) VALUES (1, 'Arena Cineplex', 'CINEMA');
INSERT INTO show_ct (id, name, type) VALUES (2, 'Narodno pozoriste', 'THEATRE');

INSERT INTO new_prop (id, date_created, description, title, price, admin_fan_id, registered_user_id,show_id,image) VALUES (4, '2018-01-29 00:55:56', 'Veoma glasna sirena', 'Sirena', 500, 1, 5,1,'https://www.hartsport.com.au/images/ProductImages/500/9-740.jpg');
INSERT INTO new_prop (id, date_created, description, title, price, admin_fan_id, registered_user_id,show_id,image) VALUES (2, '2018-01-24 03:55:56', 'Vise rekvizita po izboru', 'Sesir,naocare', 150, 1, 5,1,'https://img1.etsystatic.com/000/0/6335667/il_fullxfull.301526529.jpg');

INSERT INTO used_prop (id, date_created, description, title, active_until,accepted_bid, status, registered_user_id) VALUES (1, '2018-01-29 02:32:40', 'Polovne naocare Star Wars', 'Naocare Star Wars', '2018-01-29 02:32:45',0, 'WAITING', 5);
INSERT INTO used_prop (id, date_created, description, title, active_until,accepted_bid, status, registered_user_id) VALUES (2, '2018-01-27 02:32:40', 'Polovna maska za maskembal damska.', 'Maska damska', '2018-02-15 02:32:45',0, 'WAITING', 6);

INSERT INTO bid (accepted, date_created, price, used_prop_id, registered_user_id) VALUES (0, '2018-01-29 03:25:24', 250, 1, 5);
INSERT INTO bid (accepted, date_created, price, used_prop_id, registered_user_id) VALUES (1, '2018-02-01 17:25:24', 260, 1, 4);