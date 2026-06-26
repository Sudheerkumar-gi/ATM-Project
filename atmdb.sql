CREATE DATABASE atmdb;
USE atmdb;

CREATE TABLE accounts (
    acc_no INT PRIMARY KEY,
    pin INT NOT NULL,
    balance DECIMAL(10,2) NOT NULL
);

CREATE TABLE transactions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    acc_no INT,
    type VARCHAR(20),
    amount DECIMAL(10,2),
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
