
insert into User
values(10001,'indra', 'E1234567');
insert into User
values(10002,'soumo', 'A1234568');

INSERT INTO role (role_id, role)
VALUES
	(1,'ADMIN');
INSERT INTO role (role_id, role)
VALUES
	(2,'USER');	

INSERT INTO ResisterUser (user_id, active, email, last_name, name, password)
VALUES
	(1,1,'admin@gmail.com','s','aaa','aaa'),
	(2,1,'user@gmail.com','s','bbb','bbb');

INSERT INTO user_role (user_id, role_id)
VALUES
	(1,1);
INSERT INTO user_role (user_id, role_id)
VALUES
	(2,2);

