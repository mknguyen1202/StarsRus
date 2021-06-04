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
VALUES("alfred","hi","Alfred Hitchcock","6667 El Colegio #40 SB","CA","(805)2574499","alfred@hotmail.com","1022","606-76-7900");
INSERT INTO Customer
VALUES("billy","cl","Billy Clinton","5777 Hollister SB","CA","(805)5629999","billy@yahoo.com","3045","606-76-7903");
INSERT INTO Customer
VALUES("cindy","la","Cindy Laugher","7000 Hollister SB","CA","(805)6930011","cindy@hotmail.com","2034","606-70-7900");


INSERT INTO Customer
VALUES("david","co","David Copperfill","1357 State St SB","CA","(805)8240011","david@yahoo.com","4093","506-78-7900");
INSERT INTO Customer
VALUES("sailor","sa","Elizabeth Sailor","4321 State St SB","CA","(805)1234567","sailor@hotmail.com","1234","436-76-7900");
INSERT INTO Customer
VALUES("brush","br","George Brush","5346 Foothill Av","CA","(805)1357999","george@hotmail.com","8956","632-45-7900");


INSERT INTO Customer
VALUES("ivan","st","Ivan Stock","1235 Johnson Dr","NJ","(805)3223243","ivan@yahoo.com","2341","609-23-7900 ");
INSERT INTO Customer
VALUES("joe","pe","Joe Pepsi","3210 State St","CA","(805)5668123","pepsi@pepsi.com","0456","646-76-3430");
INSERT INTO Customer
VALUES("magic","jo","Magic Jordon","3852 Court Rd","NJ","(805)4535539","jordon@jordon.org","3455","646-76-8843");


INSERT INTO Customer
VALUES("olive","st","Olive Stoner","6689 El Colegio #151","CA","(805)2574499","olive@yahoo.com","1123","645-34-7900");
INSERT INTO Customer
VALUES("frank","ol","Frank Olson","6910 Whittier Dr","CA","(805)3456789","frank@gmail.com","3306","345-23-2134");


-- CREATE TABLE IF NOT EXISTS ActorStock (
--     symbol CHAR(3) NOT NULL,
--     actor_name CHAR(30),
--     actor_dob CHAR(10),
--     PRIMARY KEY (symbol)

-- );

INSERT INTO ActorStock
VALUES("SKB", "Kim Basinger", "08-12-1958");

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




INSERT INTO Administrator
VALUES("admin","secret","John Admin","Stock Company SB","CA","(805)6374632","admin@stock.com","1000","606-60-6060")
;


INSERT INTO Administrator
VALUES("cindy","la","Cindy Laugher","7000 Hollister SB","CA","(805)6930011","cindy@hotmail.com","2034","606-70-7900")
;

-- MARKET ACCOUNT



-- CREATE TABLE IF NOT EXISTS MarketAccount (
--     market_account_id INTEGER NOT NULL,
--     balance REAL NOT NULL,
--     balance_date DATE,
--     account_date DATE,
--     username CHAR(30),
--     PRIMARY KEY (market_account_id),
--     FOREIGN KEY (username) REFERENCES Customer(username)
--         ON UPDATE CASCADE
--         ON DELETE CASCADE
-- );

-- 1022,001,10000       alfred
-- 3045,002,100000      billy
-- 2034,003,50000       cindy
-- 4093,004,45000       david
-- 1234,005,200000      sailor
-- 8956,006,5000        brush
-- 2341,007,2000        ivan
-- 0456,008,10000       joe
-- 3455,009,130200      magic
-- 1123,010,35000       olive
-- 3306,011,30500       frank
SELECT username FROM Customer WHERE tid="1022";
INSERT INTO MarketAccount(balance, balance_date, account_date, username)
VALUES(10000, '01-01-2000', '01-01-2000', 'alfred');
INSERT INTO MarketAccount(balance, balance_date, account_date, username)
VALUES(100000, '01-01-2000', '01-01-2000', 'billy');
INSERT INTO MarketAccount(balance, balance_date, account_date, username)
VALUES(50000, '01-01-2000', '01-01-2000', 'cidy');


INSERT INTO MarketAccount(balance, balance_date, account_date, username)
VALUES(45000, '01-01-2000', '01-01-2000', 'david');
INSERT INTO MarketAccount(balance, balance_date, account_date, username)
VALUES(20000, '01-01-2000', '01-01-2000', 'sailor');
INSERT INTO MarketAccount(balance, balance_date, account_date, username)
VALUES(5000, '01-01-2000', '01-01-2000', 'brush');


INSERT INTO MarketAccount(balance, balance_date, account_date, username)
VALUES(2000, '01-01-2000', '01-01-2000', 'ivan');
INSERT INTO MarketAccount(balance, balance_date, account_date, username)
VALUES(10000, '01-01-2000', '01-01-2000', 'joe');
INSERT INTO MarketAccount(balance, balance_date, account_date, username)
VALUES(130200, '01-01-2000', '01-01-2000', 'magic');


INSERT INTO MarketAccount(balance, balance_date, account_date, username)
VALUES(35000, '01-01-2000', '01-01-2000', 'olive');
INSERT INTO MarketAccount(balance, balance_date, account_date, username)
VALUES(30500, '01-01-2000', '01-01-2000', 'frank');


----------------------------------------------------------- STOCK MARKET

-- CREATE TABLE IF NOT EXISTS StockMarket(
--     stocktime TEXT,
--     current_price REAL,
--     closing_price REAL,
--     symbol CHAR(3),
--     PRIMARY KEY (symbol, stocktime),
--     FOREIGN KEY (symbol) REFERENCES ActorStock(symbol)
--         ON UPDATE CASCADE
--         ON DELETE CASCADE
-- );

INSERT INTO StockMarket
VALUES(DATETIME('now','-1 day'), 50, 60, 'SMD');
INSERT INTO StockMarket
VALUES(DATETIME('now','-1 day'), 220, 180, 'SKB');
INSERT INTO StockMarket
VALUES(DATETIME('now','-1 day'), 100, 110, 'STC');


INSERT INTO StockMarket
VALUES(DATETIME('now'), 55, 65, 'SMD');
INSERT INTO StockMarket
VALUES(DATETIME('now'), 225, 185, 'SKB');
INSERT INTO StockMarket
VALUES(DATETIME('now'), 105, 115, 'STC');


SELECT DISTINCT * FROM StockMarket
ORDER BY stocktime DESC;

SELECT DISTINCT S1.stocktime, S1.current_price, S1.closing_price, S1.symbol
FROM StockMarket S1, StockMarket S2
WHERE S1.symbol != S2.symbol
ORDER BY S1.stocktime DESC;


SELECT * FROM (SELECT * FROM StockMarket ORDER BY stocktime DESC)
GROUP BY symbol;
--------------------------------------------------------- STOCK ACCOUNT

-- CREATE TABLE IF NOT EXISTS StockAccount (
--     symbol CHAR(3),
--     balance REAL NOT NULL,
--     original_buying_price CHAR(20),
--     account_date DATE,
--     username CHAR(30),
--     PRIMARY KEY (symbol, username, original_buying_price),
--     FOREIGN KEY (username) REFERENCES Customer(username)
--         ON UPDATE CASCADE
--         ON DELETE CASCADE,
--     FOREIGN KEY (symbol) REFERENCES ActorStock(symbol)
--         ON UPDATE CASCADE
--         CHECK (balance >= 0)
-- );





-- CREATE TABLE IF NOT EXISTS Withdraw (
--     withdraw_id INTEGER AUTO INCREMENT,
--     withdraw_date DATE,
--     withdraw_amount REAL,
--     username CHAR(30),
--     PRIMARY KEY (withdraw_id),
--     FOREIGN KEY (username) REFERENCES Customer(username)
--         ON DELETE CASCADE
--         ON UPDATE CASCADE
-- );

INSERT INTO Withdraw(withdraw_id, withdraw_date, withdraw_amount, username)
VALUES(100, '01-01-2000', 101, 'olive');
INSERT INTO Withdraw(withdraw_id, withdraw_date, withdraw_amount, username)
VALUES(200, '02-02-2000', 201, 'frank');



-- CREATE TABLE IF NOT EXISTS Deposit (
--     deposit_id INTEGER AUTO INCREMENT,
--     deposit_date DATE,
--     deposit_amount REAL,
--     username CHAR(30),
--     PRIMARY KEY (deposit_id),
--     FOREIGN KEY (username) REFERENCES Customer(username)
--         ON DELETE CASCADE
--         ON UPDATE CASCADE
-- );

INSERT INTO Deposit(deposit_id, deposit_date, deposit_amount, username)
VALUES(100, '01-01-2000', 101, 'olive');
INSERT INTO Deposit(deposit_id, deposit_date, deposit_amount, username)
VALUES(200, '02-02-2000', 201, 'frank');


SELECT *
FROM Deposit,Withdraw
WHERE Deposit.deposit_id == Withdraw.withdraw_id;


SELECT deposit_id AS transaction_id, deposit_date AS date, deposit_amount AS amount, username AS username
FROM Deposit
WHERE username = 'olive'
UNION
SELECT withdraw_id AS transaction_id, withdraw_date AS date, withdraw_amount AS amount, username AS username
FROM Withdraw
WHERE username = 'olive';

SELECT * 
FROM Deposit D
JOIN (SELECT * FROM Withdraw) AS W
ON D.username = W.username
WHERE D.username = "olive";