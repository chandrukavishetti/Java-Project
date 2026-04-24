use student_db;

create table student ( 
id INT PRIMARY KEY, 
name VARCHAR(50), 
age INT, 
branch VARCHAR(50) 
) ;

create table registration ( 
reg_id INT PRIMARY KEY AUTO_INCREMENT, 
student_id INT, 
course_name VARCHAR(50), 
fees_paid DOUBLE, 
FOREIGN KEY (student_id) REFERENCES student(id) 
) ;

-- Table for available branches
CREATE TABLE branches (
    branch_id INT PRIMARY KEY AUTO_INCREMENT,
    branch_name VARCHAR(50) UNIQUE NOT NULL
);

-- Table for available courses
CREATE TABLE courses (
    course_id INT PRIMARY KEY AUTO_INCREMENT,
    course_name VARCHAR(50) UNIQUE NOT NULL,
    base_fee DOUBLE NOT NULL
);
 
-- Insert initial data
INSERT INTO branches (branch_name) VALUES ('CS'), ('EC'), ('Civil'), ('Mech');
INSERT INTO courses (course_name, base_fee) VALUES ('Java Full Stack', 5000), ('Python Data Science', 4500), ('AWS Cloud', 6000);