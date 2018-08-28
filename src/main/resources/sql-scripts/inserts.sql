INSERT INTO spring_security.users (username, password, enabled) VALUES ('Angel', '{noop}test123', 1);
INSERT INTO spring_security.users (username, password, enabled) VALUES ('McCoy', '{noop}test123', 1);
INSERT INTO spring_security.users (username, password, enabled) VALUES ('PR', '{noop}test123', 1);

INSERT INTO spring_security.authorities (username, authority) VALUES ('Angel', 'Awesome');
INSERT INTO spring_security.authorities (username, authority) VALUES ('Angel', 'USER');
INSERT INTO spring_security.authorities (username, authority) VALUES ('McCoy', 'PLEB');
INSERT INTO spring_security.authorities (username, authority) VALUES ('McCoy', 'USER');
INSERT INTO spring_security.authorities (username, authority) VALUES ('PR', 'Awesome');
INSERT INTO spring_security.authorities (username, authority) VALUES ('PR', 'OVERLORD');
INSERT INTO spring_security.authorities (username, authority) VALUES ('PR', 'USER');

INSERT INTO spring_security.users_normalized (id, user_name, password) VALUES (1, 'PR', '{noop}test123');
INSERT INTO spring_security.users_normalized (id, user_name, password) VALUES (2, 'McCoy', '{noop}test123');
INSERT INTO spring_security.users_normalized (id, user_name, password) VALUES (3, 'Angel', '{noop}test123');

INSERT INTO spring_security.roles_normalized (id, role_name) VALUES (3, 'Awesome');
INSERT INTO spring_security.roles_normalized (id, role_name) VALUES (2, 'OVERLORD');
INSERT INTO spring_security.roles_normalized (id, role_name) VALUES (4, 'PLEB');
INSERT INTO spring_security.roles_normalized (id, role_name) VALUES (1, 'USER');

INSERT INTO spring_security.user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO spring_security.user_roles (user_id, role_id) VALUES (1, 2);
INSERT INTO spring_security.user_roles (user_id, role_id) VALUES (1, 3);
INSERT INTO spring_security.user_roles (user_id, role_id) VALUES (2, 4);
INSERT INTO spring_security.user_roles (user_id, role_id) VALUES (3, 3);