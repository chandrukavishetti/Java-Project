use jdbc;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT,
    branch VARCHAR(50),
    marks DECIMAL(5, 2)
);

INSERT INTO students (name, age, branch, marks) VALUES
('Alice', 20, 'CS', 85),
('Bob', 21, 'IT', 78),
('Charlie', 22, 'ME', 92),
('David', 20, 'EE', 74),
('Eve', 21, 'CS', 88),
('Frank', 23, 'IT', 65),
('Grace', 22, 'CE', 81),
('Heidi', 20, 'ME', 95),
('Ivan', 21, 'EE', 70),
('Judy', 22, 'CS', 89);


select * from students;
select * from students where branch ="IT";
select * from students where age between 30 and 40;