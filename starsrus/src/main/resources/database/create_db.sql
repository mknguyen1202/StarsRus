DROP DATABASE IF EXISTS starsrus;

CREATE DATABASE starsrus;

USE starsrus;

SET NAMES utf8;
-- SET character_set_client = utf8mb4;

CREATE TABLE IF NOT EXISTS User (
    username VARCHAR(30) NOT NULL,
    password VARCHAR(30),
    firstname VARCHAR(30),
    lastname VARCHAR(30),
    DOB DATE,
    address VARCHAR(70),
    state VARCHAR(2),
    phone VARCHAR(15),
    email VARCHAR(254),
    SSN VARCHAR(9),
    registration_date DATETIME,
    net_balance REAL,
    PRIMARY KEY (username)
);

-- symbol is from Stock API
CREATE TABLE IF NOT EXISTS UserWatchList (
    username VARCHAR(30),
    symbol VARCHAR(15) NOT NULL,
    FOREIGN KEY (username) REFERENCES User(username)
    ON DELETE SET NULL 
    ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS UserStockList(
    username VARCHAR(30),
    symbol VARCHAR(15) NOT NULL,
    shares REAL,
    purchase_price REAL,
    purchase_date DATETIME,
    FOREIGN KEY (username) REFERENCES User(username)
    ON DELETE SET NULL 
    ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS BuyStock (
    buy_id BIGINT UNSIGNED  NOT NULL AUTO_INCREMENT,
    buy_datetime DATETIME,
    buy_shares REAL,
    username VARCHAR(30),
    symbol VARCHAR(15),
    PRIMARY KEY (buy_id),
    FOREIGN KEY (username) REFERENCES User(username)
    ON DELETE SET NULL 
    ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS SellStock (
    sell_id BIGINT UNSIGNED  NOT NULL AUTO_INCREMENT,
    sell_datetime DATETIME,
    sell_shares REAL,
    earnings_from_sale REAL,
    username VARCHAR(30),
    symbol VARCHAR(15),
    PRIMARY KEY (sell_id),
    FOREIGN KEY (username) REFERENCES User(username)
    ON DELETE SET NULL 
    ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS Statement (
    statement_id INT UNSIGNED AUTO_INCREMENT,
    username VARCHAR(30),
    balance REAL,
    statement_date DATETIME,
    PRIMARY KEY(statement_id),
    FOREIGN KEY (username) REFERENCES User(username)
    ON DELETE SET NULL 
    ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS WalletTransaction (
    transaction_id BIGINT UNSIGNED AUTO_INCREMENT,
    transaction_date DATETIME,
    transaction_amount REAL,
    username VARCHAR(30),
    PRIMARY KEY (transaction_id),
    FOREIGN KEY (username) REFERENCES User(username)
    ON DELETE SET NULL 
    ON UPDATE CASCADE
);


-- ----------------------------------------------------------------------------------------
--                              ROLES
-- ----------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Roles(
    role_id INT NOT NULL AUTO_INCREMENT,
    role_name VARCHAR(50),
    PRIMARY KEY(role_id)
);

CREATE TABLE IF NOT EXISTS UserRole(
    username VARCHAR(30) NOT NULL,
    role_id INT NOT NULL,
    -- PRIMARY KEY(username, role_id)
    FOREIGN KEY (username) REFERENCES User(username)
        ON UPDATE CASCADE 
        ON DELETE RESTRICT,
    FOREIGN KEY (role_id) REFERENCES Roles(role_id)
        ON UPDATE CASCADE 
        ON DELETE RESTRICT,
    PRIMARY KEY (username, role_id)
);
