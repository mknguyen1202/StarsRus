-- USER DATASET
INSERT INTO User(username, password, firstname, lastname, DOB, address, state, phone, email, SSN, registration_date, net_balance)
VALUES('alfred','123','Alfred','Hitchcock', '1990-01-01','6667 El Colegio #40 SB','CA','(805)2574499','alfred@hotmail.com','606767900', NOW(), 0.0);

INSERT INTO User
VALUES('billy','321','Billy', 'Clinton', '1979-02-03','5777 Hollister SB','CA','(805)5629999','billy@yahoo.com','606767903', '2021-03-02', 1.0);
INSERT INTO User
VALUES('cindy','213','Cindy', 'Laugher', '1995-12-15','7000 Hollister SB','CA','(805)6930011','cindy@hotmail.com','606707900', '2019-05-09', 100.0);


INSERT INTO User
VALUES('david','456','David', 'Copperfill', '1996-07-21','1357 State St SB','CA','(805)8240011','david@yahoo.com','506787900', '2021-12-15', 200.50);
INSERT INTO User
VALUES('sailor','654','Elizabeth', 'Sailor', '1982-06-25','4321 State St SB','CA','(805)1234567','sailor@hotmail.com','436767900', '2020-10-13', 300.75);
INSERT INTO User
VALUES('brush','546','George', 'Brush', '1968-05-05','5346 Foothill Av','CA','(805)1357999','george@hotmail.com','632457900', '2019-12-12', 150.90);


-- ROLES
INSERT INTO Roles(role_name)
VALUES('ROLE_USER');

INSERT INTO Roles(role_name)
VALUES('ROLE_MODERATOR');

INSERT INTO Roles(role_name)
VALUES('ROLE_ADMIN');

-- USER_ROLE
-- INSERT INTO UserRole
-- VALUES();