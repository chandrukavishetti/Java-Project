use studentdbquery;

-- 1. Display all columns for all students in the table. 
delimiter $$
create procedure get_all_students()
begin 
select * from student;
end $$
delimiter ;

-- to check the weather the studentdbquery present in the database or not
show procedure status where db = 'studentdbquery';

call get_all_students();

-- 2. Show the name and roll number of students who scored more than 75%. 
Delimiter $$
create procedure student_more_than_75()
begin 
select name,rollnumber from student where percentage>75;
end $$
delimiter ;

call student_more_than_75();

-- 3. List students who are older than 18 and have a percentage less than 50. 
delimiter $$
create procedure less_than_50_percent()
begin
select * from student where age>18 and percentage <50;
end $$
delimiter ;

call less_than_50_percent();

-- 4. Display all students sorted by percentage in descending order. 
delimiter //
create procedure sorted_by_percentage_desc()
begin 
select * from student order by percentage desc;
end//

call sorted_by_percentage_desc()//

--  5. Count the total number of students in the table. 
create procedure count_total_student()
begin
select count(studentid) from student;
end//

call count_total_student()//

-- 6. Find the average percentage of students who are younger than 20.
create procedure avg_perc_younger_than_20()
begin
select avg(percentage) from student where age<20;
end//

call avg_perc_younger_than_20()//

--  7. Find the student(s) who scored the highest percentage. 
create procedure highest_percentage_students()
begin
select * from student where percentage>90;
end//

call highest_percentage_students//

--  8. Display the number of students grouped by their age. 
drop procedure if exists group_by_age //

create procedure group_by_age()
begin 
select age ,count(*) number_of_students  from student group by age;
end//

call group_by_age()//

delimiter ;

--  9. List all students whose name starts with the letter 'A'. 
delimiter $$
create procedure name_start_with_A()
begin 
select * from student where name like 'A%';
end $$
delimiter ;

call name_start_with_A();

--  10. Show names and percentages of students who scored above the average percentage. 
delimiter $$
create procedure above_avg_percentage()
begin 
select * from student where percentage>(select avg(percentage) from student );
end $$
delimiter ;

call above_avg_percentage();


--  11. Assign grades to students based on percentage: 
-- A (>=90), 
-- B (75–89), 
-- C (60–74), 
-- D (<60) 
delimiter $$
create procedure grade_base_percentage()
begin
select name,age,percentage, case when percentage >= 90 then 'A' 
when percentage >=75 and percentage<=89 then 'B'
when percentage >=60 and percentage <=74 then 'C'
else 'D'
end as grade
from student ;
end $$
delimiter ;

call grade_base_percentage();

--  12. Find the second highest percentage scored by any student. 
delimiter $$
create procedure second_highest_percentage()
begin 
select * from student order by percentage desc limit 1 offset 1;
end $$
delimiter ;

call second_highest_percentage();

--  13. Create a view that contains details of all students who failed (percentage less than 40). 

--  14. Display the rank of each student based on their percentage using a window function. 

-- 15. Find the top 3 students with the highest percentage using a subquery and window function. 


select * from profile;
select * from subjects;
select * from course;

-- 1. List all students from ‘Pune’. 
delimiter $$
create procedure students_from_pune()
begin
select studentid,city from profile where city='pune';
end $$
delimiter ;

call students_from_pune();

-- 2. Count how many students are in each city. 
delimiter $$
create procedure each_city_number_of_students()
begin
select city,count(studentid) from profile group by city ;
end $$
delimiter ;

call each_city_number_of_students();

-- 3. Find students with percentage > 80. 
delimiter $$
create procedure students_with_above_80()
begin
select * from student where percentage>80;
end $$
delimiter ;

call students_with_above_80();

-- 4. List students who are enrolled in more than one course. 
select studentid,count(course_id) from student_course where count

-- 5. Show each student's name and their subjects. 
-- 6. Find students with no profile. 
-- 7. List students along with their mobile number and city. 
-- 8. List all subjects taken by students from Mumbai. 
-- 9. Get average percentage of students per city. 
-- 10. Find students who are enrolled in ‘BSc Mathematics’ and live in Pune. 
-- 11. Get names of students who have taken both ‘Physics’ and ‘Mathematics’. 
-- 12. Show students who are not enrolled in any course. 
-- 13. Display city-wise count of students enrolled in more than one subject. 
-- 14. For each student, show their name, city, all course names (comma separated if 
-- possible), and subjects. Number them. 
-- 15. Find the top 3 students with the highest percentage in each city. 
-- 16. List students who have taken exactly 3 subjects. 
-- 17. Show courses that no student has enrolled in. 
-- 18. List students who share the same percentage. 
-- 19. Display the number of courses and subjects each student is enrolled in. 

