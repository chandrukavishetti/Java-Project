-- use student_course_db;

-- create table admin(
-- admin_id int primary key auto_increment,
-- username varchar(50) not null unique ,
-- password varchar(100) not null 
-- );

-- create table students(
-- student_id int primary key auto_increment,
-- student_name varchar(100) not null,
-- email varchar(100) not null,
-- phone varchar(15) not null,
-- age int not null,
-- city varchar(50) not null
-- );

-- create table courses(
-- course_id int primary key auto_increment,
-- course_name varchar(100) not null,
-- duration varchar(50) not null,
-- fees double not null,
-- trainer_name varchar(100) not null
-- );

-- CREATE TABLE registrations (
--     student_id INT UNSIGNED NOT NULL,
--     course_id INT UNSIGNED NOT NULL,
--     registration_date DATE NOT NULL,
--     status VARCHAR(20) NOT NULL,
--     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--     
--     PRIMARY KEY (student_id, course_id),
--     FOREIGN KEY (student_id) REFERENCES students(student_id),
--     FOREIGN KEY (course_id) REFERENCES courses(course_id)
-- );
-- drop table admin;
-- drop table students;
-- drop table registrations;
-- drop table courses;


USE student_course_db;

CREATE TABLE admin (
    admin_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);
select * from admin;
insert into admin (username,password) values ('admin','admin123');

CREATE TABLE students (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    student_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,  
    phone VARCHAR(15) NOT NULL,
    age INT NOT NULL,
    city VARCHAR(50) NOT NULL,
    CHECK (age >= 18)  
);
select * from students;

CREATE TABLE courses (
    course_id INT PRIMARY KEY AUTO_INCREMENT,
    course_name VARCHAR(100) NOT NULL UNIQUE,  
    duration VARCHAR(50) NOT NULL,
    fees DOUBLE NOT NULL CHECK (fees > 0), 
    trainer_name VARCHAR(100) NOT NULL
);

CREATE TABLE registrations (
    student_id INT NOT NULL,
    course_id INT NOT NULL,
    registration_date DATE NOT NULL,
    status ENUM('active','completed') NOT NULL DEFAULT 'active',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    PRIMARY KEY (student_id, course_id),
    FOREIGN KEY (student_id) REFERENCES students(student_id) 
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (course_id) REFERENCES courses(course_id) 
        ON DELETE CASCADE ON UPDATE CASCADE
);