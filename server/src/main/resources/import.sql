-- password == username
INSERT INTO user (role, city, email, name, number, password_hash, surname, username, points,type, first_time_logged, activated) VALUES ('ADMINFAN', 'Novi Sad', 'adminfan@adminfan', 'Ivan', '0635569989', '$2a$10$2z.t0mwY4P0/k7cHSQwMzu5Cj9usMkPLEN7ZHXbzNT7U4CEQk5vP2', 'Vukasinovic', 'adminfan',245,'DEFAULT', true, true);
INSERT INTO user (role, city, email, name, number, password_hash, surname, username, points,type, first_time_logged, activated) VALUES ('ADMINFAN', 'Beograd', 'adminfan2@adminfan2', 'Jovan', '0641569989', '$2a$10$ujoKDHyPmfaI.fQp1hCUo.hOY69jcjhPKiIRZbBnJhCY59aOohCIm', 'Jovic', 'adminfan2',100,'DEFAULT', true, true);
INSERT INTO user (role, city, email, name, number, password_hash, surname, username, points,type, first_time_logged, activated) VALUES ('ADMINSYS', 'Novi Sad', 'adminsys@adminsys', 'Vladimir', '063429989', '$2a$10$RO7l/vTjVfhh12dl5ax40uni/DuHzB/53kVxov/F6bM6hKzoIAxlC', 'Jovicic', 'adminsys',314,'DEFAULT', true, true);
INSERT INTO user (role, city, email, name, number, password_hash, surname, username, points,type, first_time_logged, activated) VALUES ('ADMINSHOW','Novi Sad', 'adminshow@adminshow', 'Marko', '0635565239', '$2a$10$CW3M.a.ikZbsvDVkwcTQfOKmluBCFM6oUjglbAWQIXYRplm0d/XIC', 'Krajinovic', 'adminshow',2,'DEFAULT', true, true);
INSERT INTO user (role, city, email, name, number, password_hash, surname, username, points,type, first_time_logged, activated) VALUES ('USER','Beograd', 'dejan@dejan', 'Dejan', '0615565239', '$2a$10$RiHre9rM0U19KWXUukNyWeNITpwVwPV98WyGpbHm4YqwGPpLE.VWy', 'Stojkic', 'dejan',22,'DEFAULT', true, true);
INSERT INTO user (role, city, email, name, number, password_hash, surname, username, points,type, first_time_logged, activated) VALUES ('USER','Novi Sad', 'milan@milan', 'Milan', '0645565239', '$2a$10$fbc8Mb9ec0Ig1M5D0R8zT.xMgF0E1r6li04ynzi/CKY3eev/vezH2', 'Stankovic', 'milan',45,'DEFAULT', true, true);
INSERT INTO user (role, city, email, name, number, password_hash, surname, username, points,type, first_time_logged, activated) VALUES ('ADMINSYS','Novi Grad', 'grad@milan', 'Grad', '0644565239', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'Stankovic', 'admin',567,'DEFAULT', true, true);

INSERT INTO show_ct (name, type, address, description, rating) VALUES ('Arena Cineplex', 'CINEMA', 'Bulevar Mihajla Pupina 3, Novi Sad', 'opis', 0);
INSERT INTO show_ct (name, type, address, description, rating) VALUES ('Narodno pozoriste', 'THEATRE', 'Pozorisni trg 1, Novi Sad', 'opis', 0);
INSERT INTO show_ct (name, type, address, description, rating) VALUES ('Narodni bioskop', 'CINEMA', 'Kralja Petra I, Sombor', 'opis', 0);
INSERT INTO show_ct (name, type, address, description, rating) VALUES ('Sinestar', 'CINEMA', 'Sentandrejski put 11, Novi Sad', 'opis', 0);
INSERT INTO show_ct (name, type, address, description, rating) VALUES ('Fontana', 'CINEMA', 'Pariske komune 13, Beograd', 'opis', 0);
INSERT INTO show_ct (name, type, address, description, rating) VALUES ('Krstarica', 'THEATRE', 'Trg Republike 1, Beograd', 'opis', 0);
INSERT INTO show_ct (name, type, address, description, rating) VALUES ('Narodno pozoriste', 'THEATRE', 'Francuska 3, Beograd, Beograd', 'opis', 0);

INSERT INTO new_prop (id, date_created, description, title, price, fan_admin_fk,show_fk,image) VALUES (4, '2018-01-29 00:55:56', 'Veoma glasna sirena', 'Sirena', 500, 1, 1,'https://www.hartsport.com.au/images/ProductImages/500/9-740.jpg');
INSERT INTO new_prop (id, date_created, description, title, price, fan_admin_fk,show_fk,image) VALUES (2, '2018-01-24 03:55:56', 'Vise rekvizita po izboru', 'Sesir,naocare', 150, 1,1,'https://img1.etsystatic.com/000/0/6335667/il_fullxfull.301526529.jpg');

INSERT INTO used_prop (id, date_created, description, title, active_until, status, user_fk,image) VALUES (1, '2018-01-29 02:32:40', 'Polovne naocare Star Wars', 'Naocare Star Wars', '2018-05-29 02:32:45', 'WAITING', 5,'http://www.3dom3deyewear.com/wp-content/uploads/2012/07/LK3DSWEP1Angle.jpg');
INSERT INTO used_prop (id, date_created, description, title, active_until, status, user_fk,fan_admin_fk,image) VALUES (2, '2018-01-29 02:32:40', 'Polovna plisana casa, pivo got.', 'Game of Thrones pivo ', '2018-4-29 02:32:45', 'APPROVED', 5,1,'https://pimg.tradeindia.com/02485272/b/2/Party-Prop-Got-Beer-Hat.jpg');
INSERT INTO used_prop (id, date_created, description, title, active_until, status, user_fk,fan_admin_fk,image) VALUES (3, '2018-01-27 02:32:40', 'Polovna puska star wars.', 'Puska SW', '2018-05-15 02:32:45', 'APPROVED', 6,2,'http://www.volpinprops.com/wp-content/uploads/2012/07/AER9_3.jpg');

INSERT INTO bid (accepted, date_created, price, used_prop_fk, user_fk) VALUES (0, '2018-01-29 03:25:24', 250, 2, 5);
INSERT INTO bid (accepted, date_created, price, used_prop_fk, user_fk) VALUES (1, '2018-02-01 17:25:24', 260, 2, 6);