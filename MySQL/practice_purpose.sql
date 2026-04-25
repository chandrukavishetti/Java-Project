use practice;

create table student(
student_id int primary key,
name varchar(50),
marks decimal(5,2),
age int ,
branch varchar(50)
);

alter table student modify marks decimal(5,2);