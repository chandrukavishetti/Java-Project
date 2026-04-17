-- CREATE DATABASE normalization_demo;
USE normalization_demo;
CREATE TABLE bank_data (
    customer_id INT,
    customer_name VARCHAR(100),
    phones VARCHAR(100),
    accounts VARCHAR(100),
    account_types VARCHAR(100),
    branch_name VARCHAR(100),
    branch_city VARCHAR(100),
    transactions VARCHAR(100)
);
INSERT INTO bank_data VALUES
(1,'Rahul','9876,9123','A1,A2','Savings,Current','SBI','Kanpur','T1-500,T2-200'),
(2,'Anjali','8765','A3','Savings','HDFC','Lucknow','T3-700'),
(3,'Vikas','7654,7012','A4,A5','Current,Savings','ICICI','Delhi','T4-300,T5-150'),
(4,'Neha','6543','A6','Savings','SBI','Kanpur','T6-800'),
(5,'Amit','9988,8877','A7,A8','Savings,Current','Axis','Mumbai','T7-250,T8-350'),
(6,'Pooja','9123','A9','Savings','ICICI','Delhi','T9-400'),
(7,'Rohit','9012,8899','A10,A11','Current,Savings','SBI','Kanpur','T10-100,T11-200'),
(8,'Sneha','8901','A12','Savings','HDFC','Lucknow','T12-600'),
(9,'Arjun','8790,7654','A13,A14','Savings,Current','Axis','Mumbai','T13-450,T14-550'),
(10,'Kavita','8689','A15','Savings','ICICI','Delhi','T15-300');
select * from bank_data;

-- for 1 NF conversion

CREATE TABLE bank_data_1nf (
    customer_id INT,
    customer_name VARCHAR(100),
    phone VARCHAR(20),
    account_no VARCHAR(10),
    account_type VARCHAR(20),
    branch_name VARCHAR(50),
    branch_city VARCHAR(50),
    transaction_id VARCHAR(10),
    amount INT
);

INSERT INTO bank_data_1nf VALUES
(1,'Rahul','9876','A1','Savings','SBI','Kanpur','T1',500),
(1,'Rahul','9123','A1','Savings','SBI','Kanpur','T2',200),
(1,'Rahul','9876','A2','Current','SBI','Kanpur','T1',500),
(1,'Rahul','9123','A2','Current','SBI','Kanpur','T2',200),

(2,'Anjali','8765','A3','Savings','HDFC','Lucknow','T3',700),

(3,'Vikas','7654','A4','Current','ICICI','Delhi','T4',300),
(3,'Vikas','7012','A5','Savings','ICICI','Delhi','T5',150);

SELECT * FROM bank_data_1nf;

-- 2NF

CREATE TABLE customers (
    customer_id INT PRIMARY KEY,
    customer_name VARCHAR(100),
    phone VARCHAR(20)
);

CREATE TABLE accounts (
    account_no VARCHAR(10) PRIMARY KEY,
    account_type VARCHAR(20),
    branch_name VARCHAR(50),
    branch_city VARCHAR(50),
    customer_id INT,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

CREATE TABLE transactions (
    transaction_id VARCHAR(10) PRIMARY KEY,
    amount INT,
    account_no VARCHAR(10),
    FOREIGN KEY (account_no) REFERENCES accounts(account_no)
);

CREATE TABLE customer_phones (
    customer_id INT,
    phone VARCHAR(20),
    PRIMARY KEY (customer_id, phone),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

INSERT INTO customers VALUES
(1,'Rahul','9876'),
(2,'Anjali','8765'),
(3,'Vikas','7654'),
(4,'Neha','6543'),
(5,'Amit','9988'),
(6,'Pooja','9123'),
(7,'Rohit','9012'),
(8,'Sneha','8901'),
(9,'Arjun','8790'),
(10,'Kavita','8689');

select * from customers;

INSERT INTO customer_phones VALUES
(1,'9876'),
(1,'9123'),
(2,'8765'),
(3,'7654'),
(3,'7012'),
(4,'6543'),
(5,'9988'),
(5,'8877'),
(6,'9123'),
(7,'9012'),
(7,'8899'),
(8,'8901'),
(9,'8790'),
(9,'7654'),
(10,'8689');

select * from customer_phones;

INSERT INTO accounts VALUES
('A1','Savings','SBI','Kanpur',1),
('A2','Current','SBI','Kanpur',1),
('A3','Savings','HDFC','Lucknow',2),
('A4','Current','ICICI','Delhi',3),
('A5','Savings','ICICI','Delhi',3),
('A6','Savings','SBI','Kanpur',4),
('A7','Savings','Axis','Mumbai',5),
('A8','Current','Axis','Mumbai',5),
('A9','Savings','ICICI','Delhi',6),
('A10','Current','SBI','Kanpur',7),
('A11','Savings','SBI','Kanpur',7),
('A12','Savings','HDFC','Lucknow',8),
('A13','Savings','Axis','Mumbai',9),
('A14','Current','Axis','Mumbai',9),
('A15','Savings','ICICI','Delhi',10);

select * from accounts;

INSERT INTO transactions VALUES
('T1',500,'A1'),
('T2',200,'A1'),
('T3',700,'A3'),
('T4',300,'A4'),
('T5',150,'A5'),
('T6',800,'A6'),
('T7',250,'A7'),
('T8',350,'A8'),
('T9',400,'A9'),
('T10',100,'A10'),
('T11',200,'A11'),
('T12',600,'A12'),
('T13',450,'A13'),
('T14',550,'A14'),
('T15',300,'A15');

-- start

CREATE TABLE bank_data (
    customer_id INT,
    customer_name VARCHAR(100),
    phones VARCHAR(100),
    accounts VARCHAR(100),
    account_types VARCHAR(100),
    branch_name VARCHAR(100),
    branch_city VARCHAR(100),
    transactions VARCHAR(100)
);
INSERT INTO bank_data VALUES
(1,'Rahul','9876,9123','A1,A2','Savings,Current','SBI','Kanpur','T1-500,T2-200'),
(2,'Anjali','8765','A3','Savings','HDFC','Lucknow','T3-700'),
(3,'Vikas','7654,7012','A4,A5','Current,Savings','ICICI','Delhi','T4-300,T5-150'),
(4,'Neha','6543','A6','Savings','SBI','Kanpur','T6-800'),
(5,'Amit','9988,8877','A7,A8','Savings,Current','Axis','Mumbai','T7-250,T8-350'),
(6,'Pooja','9123','A9','Savings','ICICI','Delhi','T9-400'),
(7,'Rohit','9012,8899','A10,A11','Current,Savings','SBI','Kanpur','T10-100,T11-200'),
(8,'Sneha','8901','A12','Savings','HDFC','Lucknow','T12-600'),
(9,'Arjun','8790,7654','A13,A14','Savings,Current','Axis','Mumbai','T13-450,T14-550'),
(10,'Kavita','8689','A15','Savings','ICICI','Delhi','T15-300');
select * from bank_data;

-- for 1 NF conversion

CREATE TABLE bank_data_1nf (
    customer_id INT,
    customer_name VARCHAR(100),
    phone VARCHAR(20),
    account_no VARCHAR(10),
    account_type VARCHAR(20),
    branch_name VARCHAR(50),
    branch_city VARCHAR(50),
    transaction_id VARCHAR(10),
    amount INT
);

INSERT INTO bank_data_1nf VALUES
(1,'Rahul','9876','A1','Savings','SBI','Kanpur','T1',500),
(1,'Rahul','9123','A1','Savings','SBI','Kanpur','T2',200),
(1,'Rahul','9876','A2','Current','SBI','Kanpur','T1',500),
(1,'Rahul','9123','A2','Current','SBI','Kanpur','T2',200),

(2,'Anjali','8765','A3','Savings','HDFC','Lucknow','T3',700),

(3,'Vikas','7654','A4','Current','ICICI','Delhi','T4',300),
(3,'Vikas','7012','A5','Savings','ICICI','Delhi','T5',150);

SELECT * FROM bank_data_1nf;

-- 2NF

CREATE TABLE customers (
    customer_id INT PRIMARY KEY,
    customer_name VARCHAR(100),
    phone VARCHAR(20)
);

CREATE TABLE accounts (
    account_no VARCHAR(10) PRIMARY KEY,
    account_type VARCHAR(20),
    branch_name VARCHAR(50),
    branch_city VARCHAR(50),
    customer_id INT,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

CREATE TABLE transactions (
    transaction_id VARCHAR(10) PRIMARY KEY,
    amount INT,
    account_no VARCHAR(10),
    FOREIGN KEY (account_no) REFERENCES accounts(account_no)
);

CREATE TABLE customer_phones (
    customer_id INT,
    phone VARCHAR(20),
    PRIMARY KEY (customer_id, phone),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

INSERT INTO customers VALUES
(1,'Rahul','9876'),
(2,'Anjali','8765'),
(3,'Vikas','7654'),
(4,'Neha','6543'),
(5,'Amit','9988'),
(6,'Pooja','9123'),
(7,'Rohit','9012'),
(8,'Sneha','8901'),
(9,'Arjun','8790'),
(10,'Kavita','8689');

INSERT INTO customer_phones VALUES
(1,'9876'),
(1,'9123'),
(2,'8765'),
(3,'7654'),
(3,'7012'),
(4,'6543'),
(5,'9988'),
(5,'8877'),
(6,'9123'),
(7,'9012'),
(7,'8899'),
(8,'8901'),
(9,'8790'),
(9,'7654'),
(10,'8689');

INSERT INTO accounts VALUES
('A1','Savings','SBI','Kanpur',1),
('A2','Current','SBI','Kanpur',1),
('A3','Savings','HDFC','Lucknow',2),
('A4','Current','ICICI','Delhi',3),
('A5','Savings','ICICI','Delhi',3),
('A6','Savings','SBI','Kanpur',4),
('A7','Savings','Axis','Mumbai',5),
('A8','Current','Axis','Mumbai',5),
('A9','Savings','ICICI','Delhi',6),
('A10','Current','SBI','Kanpur',7),
('A11','Savings','SBI','Kanpur',7),
('A12','Savings','HDFC','Lucknow',8),
('A13','Savings','Axis','Mumbai',9),
('A14','Current','Axis','Mumbai',9),
('A15','Savings','ICICI','Delhi',10);

INSERT INTO transactions VALUES
('T1',500,'A1'),
('T2',200,'A1'),
('T3',700,'A3'),
('T4',300,'A4'),
('T5',150,'A5'),
('T6',800,'A6'),
('T7',250,'A7'),
('T8',350,'A8'),
('T9',400,'A9'),
('T10',100,'A10'),
('T11',200,'A11'),
('T12',600,'A12'),
('T13',450,'A13'),
('T14',550,'A14'),
('T15',300,'A15');

select * from accounts;
select * from customer_phones;
select * from customers;
select * from transactions;

-- 3nf

CREATE TABLE branch (
    branch_id INT PRIMARY KEY,
    branch_name VARCHAR(50),
    branch_city
VARCHAR(50)
);

INSERT INTO branch VALUES
(1,'SBI','Kanpur'),
(2,'HDFC','Lucknow'),
(3,'ICICI','Delhi'),
(4,'Axis','Mumbai');

CREATE TABLE accounts_new (
    account_no VARCHAR(10) PRIMARY KEY,
    account_type VARCHAR(20),
    branch_id INT,
    customer_id INT,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
    FOREIGN KEY (branch_id) REFERENCES branch(branch_id)
);

INSERT INTO accounts_new VALUES
('A1','Savings',1,1),
('A2','Current',1,1),
('A3','Savings',2,2),
('A4','Current',3,3),
('A5','Savings',3,3),
('A6','Savings',1,4),
('A7','Savings',4,5),
('A8','Current',4,5),
('A9','Savings',3,6),
('A10','Current',1,7),
('A11','Savings',1,7),
('A12','Savings',2,8),
('A13','Savings',4,9),
('A14','Current',4,9),
('A15','Savings',3,10);

select * from accounts_new;
select * from customer_phones;
select * from customers;
select * from transactions;
select * from branch;