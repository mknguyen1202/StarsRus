

CREATE TABLE Administrator (
    admin_username CHAR(30),
    admin_password CHAR(30),
    admin_name CHAR(30),
    admin_address CHAR(30),
    admin_state CHAR(2),
    admin_phone CHAR(20),
    admin_email CHAR(30),
    admin_tid CHAR(30),
    admin_ssn CHAR(20),
    PRIMARY KEY (admin_username)
);

CREATE TABLE Customer (
    username CHAR(30),
    password CHAR(30),
    name CHAR(30),
    address CHAR(30),
    state CHAR(2),
    phone CHAR(20),
    email CHAR(30),
    tid CHAR(30),
    ssn CHAR(20),
    PRIMARY KEY (username)
);

CREATE TABLE MarketAccount (
    market_account_id INTEGER NOT NULL,
    balance REAL NOT NULL,
    balance_date DATE,
    account_date DATE,
    username CHAR(30),
    PRIMARY KEY (market_account_id),
    FOREIGN KEY (username) REFERENCES Customer(username)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE StockAccount (
    symbol CHAR(3),
    balance REAL NOT NULL,
    original_buying_price CHAR(20),
    account_date DATE,
    username CHAR(30),
    PRIMARY KEY (symbol, username, original_buying_price),
    FOREIGN KEY (username) REFERENCES Customer(username)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    FOREIGN KEY (symbol) REFERENCES ActorStock(symbol)
        ON UPDATE CASCADE
        CHECK (balance >= 0)
);

CREATE TABLE ActorStock (
    symbol CHAR(3) NOT NULL,
    actor_name CHAR(30),
    actor_dob CHAR(10),
    actor_movie_title CHAR(30),
    actor_role CHAR(10),
    actor_movie_contract REAL NOT NULL,
    PRIMARY KEY (symbol)
);

-- CREATE TABLE ActorsAndStocks(
-- actor_name CHAR(20),
-- date_of_birth CHAR(10),
-- symbol CHAR(3),
-- daily_closing_price REAL,
-- current_price REAL,
-- PRIMARY KEY (symbol)
-- )

CREATE TABLE ActorMovie (
    contract_id INTEGER,
    contract_year INTEGER,
    actor_role CHAR(20),
    title CHAR(20),
    total_value REAL,
    symbol INTEGER NOT NULL,
    PRIMARY KEY (contract_id),
    FOREIGN KEY (symbol) REFERENCES ActorsAndStocks
    ON DELETE CASCADE
	ON UPDATE CASCADE
);

-- these tables record transactions
CREATE TABLE Buy (
    buy_id INTEGER,
    buy_date DATE,
    buy_shares REAL,
    username CHAR(30) NOT NULL,
    symbol CHAR(3) NOT NULL,
    PRIMARY KEY (buy_id),
    FOREIGN KEY (username) REFERENCES Customer(username)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (symbol) REFERENCES ActorStock(symbol)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE Sell (
    sell_id INTEGER,
    sell_date DATE,
    sell_shares REAL,
    earnings_from_sale REAL,
    username CHAR(30),
    symbol CHAR(3) NOT NULL,
    PRIMARY KEY (sell_id),
    FOREIGN KEY (username) REFERENCES Customer(username)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (symbol) REFERENCES ActorsStock(symbol)
        ON DELETE CASCADE
        ON UPDATE CASCADE

);

CREATE TABLE Deposit (
    deposit_id INTEGER,
    deposit_date DATE,
    deposit_amount REAL,
    username CHAR(30),
    PRIMARY KEY (deposit_id),
    FOREIGN KEY (username) REFERENCES Customer(username)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE Withdraw (
    withdraw_id INTEGER,
    withdraw_date DATE,
    withdraw_amount REAL,
    username CHAR(30),
    PRIMARY KEY (withdraw_id),
    FOREIGN KEY (username) REFERENCES Customer(username)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE AccrueInterest (
    interest_id INT,
    interest_date DATE,
    total_earnings REAL,
    username CHAR(20),
    PRIMARY KEY (interest_id),
    FOREIGN KEY (username) REFERENCES Customer(username)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
