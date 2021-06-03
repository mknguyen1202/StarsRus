-- CREATE TABLE Customer (
--     username CHAR(30),
--     password CHAR(30),
--     name CHAR(30),
--     address CHAR(30),
--     state CHAR(2),
--     phone CHAR(20),
--     email CHAR(30),
--     tid CHAR(30),
--     ssn CHAR(20)
-- );

-- Name,username,password,Address,STATE,Phone,email,TAXID,SSN

INSERT INTO Customer 
VALUES("alfred","hi","Alfred Hitchcock","6667 El Colegio #40 SB","CA","(805)2574499","alfred@hotmail.com","1022","606-76-7900")
;


INSERT INTO Customer
VALUES("billy","cl","Billy Clinton","5777 Hollister SB","CA","(805)5629999","billy@yahoo.com","3045","606-76-7903")
;

INSERT INTO Customer
VALUES("cindy","la","Cindy Laugher","7000 Hollister SB","CA","(805)6930011","cindy@hotmail.com","2034","606-70-7900")
;




-- CREATE TABLE IF NOT EXISTS ActorStock (
--     symbol CHAR(3) NOT NULL,
--     actor_name CHAR(30),
--     actor_dob CHAR(10),
--     PRIMARY KEY (symbol)

-- );

INSERT INTO ActorStock
VALUES("SKB", "Kim Basinger", "8-12-1958");

INSERT INTO ActorStock
VALUES("SMD", "Michael Douglas", "25-09-1944");

INSERT INTO ActorStock
VALUES("STC", "Tom Cruise", "03-07-1962");



-- CREATE TABLE IF NOT EXISTS ActorMovie (
--     contract_id INTEGER,
--     contract_year INTEGER,
--     actor_role CHAR(20),
--     title CHAR(20),
--     total_value REAL,
--     symbol INTEGER NOT NULL,
--     PRIMARY KEY (contract_id),
--     FOREIGN KEY (symbol) REFERENCES ActorStock(symbol)
--         ON DELETE CASCADE
--         ON UPDATE CASCADE
-- );
-- SKB,40.00,Kim Basinger,8 December 1958,L.A. Confidential,Actor,1997,5000000
-- SMD,71.00,Michael Douglas,25 September 1944,A Perfect Murder,Actor,1998,10000000
-- STC,32.50,Tom Cruise,3 July 1962,Jerry Maguire,Actor,1996,5000000


INSERT INTO ActorMovie(contract_year, actor_role, title, total_value, symbol)
VALUES(1997, "Actor", "L.A. Confidential", 5000000, "SKB");

INSERT INTO ActorMovie(contract_year, actor_role, title, total_value, symbol)
VALUES(1998, "Actor", "A Perfect Murder", 10000000, "SMD");

INSERT INTO ActorMovie(contract_year, actor_role, title, total_value, symbol)
VALUES(1996, "Actor", "Jerry Maguire", 5000000, "STC");
