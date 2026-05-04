CREATE DATABASE employee_db;

USE employee_db;

CREATE TABLE leave_applications (
    id INT PRIMARY KEY AUTO_INCREMENT,
    emp_name VARCHAR(100),
    emp_id VARCHAR(50),
    department VARCHAR(100),
    leave_type VARCHAR(50),
    leave_days INT,
    reason TEXT
);