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