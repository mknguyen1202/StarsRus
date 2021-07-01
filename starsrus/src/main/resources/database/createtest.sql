DROP DATABASE IF EXISTS starsrus;

CREATE DATABASE starsrus;

USE starsrus;

SET NAMES utf8;
-- SET character_set_client = utf8mb4;

CREATE TABLE IF NOT EXISTS user (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(30) NOT NULL UNIQUE,
    password VARCHAR(30),
    firstname VARCHAR(30),
    lastname VARCHAR(30),
    dob DATE,
    address VARCHAR(70),
    state VARCHAR(2),
    phone VARCHAR(15),
    email VARCHAR(254),
    ssn VARCHAR(9),
    registration_date DATETIME,
    net_balance REAL,
    PRIMARY KEY (id)
);



-- symbol is from Stock API
CREATE TABLE IF NOT EXISTS user_watch_list (
    user_id BIGINT UNSIGNED,
    symbol VARCHAR(15) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES User(id)
    ON DELETE SET NULL 
    ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS user_stock_list(
    user_id BIGINT UNSIGNED,
    symbol VARCHAR(15) NOT NULL,
    shares REAL,
    purchase_price REAL,
    purchase_date DATETIME,
    FOREIGN KEY (user_id) REFERENCES User(id)
    ON DELETE SET NULL 
    ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS buy_stock (
    buy_id BIGINT UNSIGNED  NOT NULL AUTO_INCREMENT,
    buy_datetime DATETIME,
    buy_shares REAL,
    user_id BIGINT UNSIGNED,
    symbol VARCHAR(15),
    PRIMARY KEY (buy_id),
    FOREIGN KEY (user_id) REFERENCES User(id)
    ON DELETE SET NULL 
    ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS sell_stock (
    sell_id BIGINT UNSIGNED  NOT NULL AUTO_INCREMENT,
    sell_datetime DATETIME,
    sell_shares REAL,
    earnings_from_sale REAL,
    user_id BIGINT UNSIGNED,
    symbol VARCHAR(15),
    PRIMARY KEY (sell_id),
    FOREIGN KEY (user_id) REFERENCES User(id)
    ON DELETE SET NULL 
    ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS user_statement (
    statement_id INT UNSIGNED AUTO_INCREMENT,
    user_id BIGINT UNSIGNED,
    balance REAL,
    statement_date DATETIME,
    PRIMARY KEY(statement_id),
    FOREIGN KEY (user_id) REFERENCES User(id)
    ON DELETE SET NULL 
    ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS user_wallet_transaction (
    transaction_id BIGINT UNSIGNED AUTO_INCREMENT,
    transaction_date DATETIME,
    transaction_amount REAL,
    user_id BIGINT UNSIGNED,
    PRIMARY KEY (transaction_id),
    FOREIGN KEY (user_id) REFERENCES User(id)
    ON DELETE SET NULL 
    ON UPDATE CASCADE
);


-- ----------------------------------------------------------------------------------------
--                              ROLES
-- ----------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS role(
    role_id INT NOT NULL AUTO_INCREMENT,
    role_name VARCHAR(50),
    PRIMARY KEY(role_id)
);

CREATE TABLE IF NOT EXISTS user_role(
    user_id BIGINT UNSIGNED NOT NULL ,
    role_id INT NOT NULL,
    -- PRIMARY KEY(username, role_id)
    FOREIGN KEY (user_id) REFERENCES user(id)
        ON UPDATE CASCADE 
        ON DELETE RESTRICT,
    FOREIGN KEY (role_id) REFERENCES role(role_id)
        ON UPDATE CASCADE 
        ON DELETE RESTRICT,
    PRIMARY KEY (user_id, role_id)
);







CREATE TABLE IF NOT EXISTS User (
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    email VARCHAR(50) UNIQUE,
    password VARCHAR(120),
    username VARCHAR(20) UNIQUE ,
    PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS Roles(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50),
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS UserRole (
    user_id BIGINT(20) NOT NULL,
    role_id INT NOT NULL,
    -- PRIMARY KEY(username, role_id)
    FOREIGN KEY (user_id) REFERENCES User(id)
        ON UPDATE CASCADE 
        ON DELETE RESTRICT,
    FOREIGN KEY (role_id) REFERENCES Roles(id)
        ON UPDATE CASCADE 
        ON DELETE RESTRICT,
    PRIMARY KEY (user_id, role_id)
);



CREATE TABLE IF NOT EXISTS users (
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    email VARCHAR(50) UNIQUE,
    password VARCHAR(120),
    username VARCHAR(20) UNIQUE ,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS roles(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50),
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS user_roles(
    user_id BIGINT(20) NOT NULL,
    role_id INT NOT NULL,
    -- PRIMARY KEY(username, role_id)
    FOREIGN KEY (user_id) REFERENCES users(id)
        ON UPDATE CASCADE 
        ON DELETE RESTRICT,
    FOREIGN KEY (role_id) REFERENCES roles(id)
        ON UPDATE CASCADE 
        ON DELETE RESTRICT,
    PRIMARY KEY (user_id, role_id)
);



INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');



CREATE TABLE IF NOT EXISTS users (
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    email VARCHAR(50) UNIQUE,
    password VARCHAR(120),
    username VARCHAR(20) UNIQUE ,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS roles(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50),
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS users_roles(
    user_id BIGINT(20) NOT NULL,
    role_id INT NOT NULL,
    -- PRIMARY KEY(username, role_id)
    FOREIGN KEY (user_id) REFERENCES users(id)
        ON UPDATE CASCADE 
        ON DELETE RESTRICT,
    FOREIGN KEY (role_id) REFERENCES roles(id)
        ON UPDATE CASCADE 
        ON DELETE RESTRICT,
    PRIMARY KEY (user_id, role_id)
);

INSERT INTO Roles(name) VALUES('ROLE_USER');
INSERT INTO Roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO Roles(name) VALUES('ROLE_ADMIN');