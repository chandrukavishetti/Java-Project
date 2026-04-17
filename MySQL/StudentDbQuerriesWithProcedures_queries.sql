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
delimiter $$
create procedure enrolled_more_than_one_course()
begin
select studentid,count(courseid) from student_course group by studentid having count(courseid)>1;
end $$
delimiter ;

call enrolled_more_than_one_course();

-- 5. Show each student's name and their subjects.
delimiter $$
create procedure student_name_and_subject()
begin
select s.name,su.subname from student s inner join subjects su on s.studentid=su.studentid;
 end $$
 delimiter ;
 
 call student_name_and_subject();
 
-- 6. Find students with no profile.
delimiter $$
create procedure student_with_no_profile()
begin
select s.* from student s left join profile p on s.studentid=p.studentid where p.studentid is null;  
end $$
delimiter ;

call student_with_no_profile();

-- 7. List students along with their mobile number and city.
delimiter $$
create procedure students_name_mobileno()
begin 
select s.name,p.city,p.mobileno from student s left join profile p on s.studentid=p.studentid;
end $$
delimiter ;

call students_name_mobileno();

-- 8. List all subjects taken by students from Mumbai. 
delimiter $$
CREATE PROCEDURE all_subjects_students_from_mumbai()
BEGIN
    SELECT s.name, su.subname, p.city 
    FROM Student s 
    INNER JOIN Profile p ON s.studentid = p.studentid 
    INNER JOIN Subjects su ON su.studentid = s.studentid 
    WHERE p.city = 'Mumbai';
END $$
DELIMITER ;

call all_subjects_students_from_mumbai();

-- 9. Get average percentage of students per city. 
delimiter $$
create procedure avg_percentage_on_each_city()
begin
select p.city,avg(s.percentage) from profile p inner join student s on p.studentid=s.studentid group by p.city;
end $$
delimiter ;

call avg_percentage_on_each_city();

-- 10. Find students who are enrolled in ‘BSc Mathematics’ and live in Pune. 
delimiter $$
create procedure enrolled_mathematics_lives_pune()
begin
select s.studentid,su.subname,p.city from student s inner join subjects su on s.studentid=su.studentid join profile p on p.studentid=s.studentid where su.subname='Mathematics' and p.city='pune';
end $$
delimiter ;

call enrolled_mathematics_lives_pune();

-- 11. Get names of students who have taken both ‘Physics’ and ‘Mathematics’. 
delimiter $$
create procedure student_taken_both_physics_and_mathematics()
begin
select s.name from student s inner join subjects su on s.studentid=su.studentid where su.subname in ('physics','Mathematics') group by s.studentid,s.name having count(distinct su.subname)=2;
end $$
delimiter ;

call student_taken_both_physics_and_mathematics();

-- 12. Show students who are not enrolled in any course. 
delimiter $$
create procedure not_enrolled_in_course()
begin
select s.* from student s left join student_course sc on s.studentid=sc.studentid where sc.courseid is null;
end $$
delimiter ;

call not_enrolled_in_course();

-- 13. Display city-wise count of students enrolled in more than one subject. 
delimiter $$
create procedure city_wise_student_enrolled_more_than_one_subject()
begin
select p.city,count(su.subname) from profile p left join subjects su on p.studentid=su.studentid group by p.city having count(su.subname)>1;
end $$
delimiter ;

call city_wise_student_enrolled_more_than_one_subject();

-- 14. For each student, show their name, city, all course names (comma separated if possible), and subjects. Number them. 
delimiter $$
create procedure all_student_details()
begin
SELECT 
    ROW_NUMBER() OVER (ORDER BY s.studentid) AS sr_no,
    s.name,
    p.city,
    GROUP_CONCAT(DISTINCT c.coursename SEPARATOR ', ') AS courses,
    GROUP_CONCAT(DISTINCT su.subname SEPARATOR ', ') AS subjects
FROM Student s
LEFT JOIN Profile p ON p.studentid = s.studentid
LEFT JOIN Student_Course sc ON sc.studentid = s.studentid
LEFT JOIN Course c ON c.courseid = sc.courseid
LEFT JOIN Subjects su ON su.studentid = s.studentid
GROUP BY s.studentid, s.name, p.city;
end $$
delimiter ;

call all_student_details();

-- 15. Find the top 3 students with the highest percentage in each city. 
delimiter $$
create procedure top_3_stud_with_hightest_percentage_each_city()
begin
SELECT city, name, percentage
FROM (
    SELECT 
        p.city,
        s.name,
        s.percentage,
        ROW_NUMBER() OVER (PARTITION BY p.city ORDER BY s.percentage DESC) AS rn
    FROM Student s
    JOIN Profile p ON s.studentid = p.studentid
) t
WHERE rn <= 3;
end $$
delimiter ;

call top_3_stud_with_hightest_percentage_each_city();

-- 16. List students who have taken exactly 3 subjects. 
delimiter $$
create procedure student_with_3_subjects()
begin
select s.name from student s inner join subjects su on s.studentid=su.studentid group by s.studentid,s.name having count(su.subname) =3;
end $$
delimiter ;
 
call student_with_3_subjects();

-- 17. Show courses that no student has enrolled in. 
delimiter $$
create procedure not_enrolled_in_course()
begin
select c.coursename from course c left join student_course sc on c.courseid=sc.courseid where sc.studentid is null;
end $$
delimiter ;

call not_enrolled_in_course();

-- 18. List students who share the same percentage. 
delimiter $$
create procedure sharing_same_percentage()
begin
select name from student where percentage in(select percentage from student group by percentage having count(percentage)>1) order by percentage;
end $$
delimiter ;

call sharing_same_percentage();

-- 19. Display the number of courses and subjects each student is enrolled in. 
delimiter $$
create procedure number_of_courses_subjects_each_student()
begin
SELECT 
    s.studentid,
    s.name,
    COUNT(DISTINCT sc.courseid) AS num_courses,
    COUNT(DISTINCT su.subid) AS num_subjects
FROM 
    student s
LEFT JOIN 
    student_course sc ON s.studentid = sc.studentid
LEFT JOIN 
    subjects su ON s.studentid = su.studentid
GROUP BY 
    s.studentid, s.name;
end $$
delimiter ;

call  number_of_courses_subjects_each_student();

-- 1. Write a stored procedure to insert a new student using parameters: roll number, name, age, and percentage. 
DELIMITER $$
CREATE PROCEDURE insert_new_student(
in p_studentid int,
    IN p_rollnumber INT,
    IN p_name VARCHAR(100),
    IN p_age INT,
    IN p_percentage DECIMAL(5,2)
)
BEGIN
    INSERT INTO Student (studentid,rollnumber, name, age, percentage)
    VALUES (p_studentid,p_rollnumber, p_name, p_age, p_percentage);
END $$
DELIMITER ;

CALL insert_new_student(16,116, 'Chandrashekhar', 21, 85.00);

-- 2. Write a procedure that takes a student’s roll number as input and returns the full student record.
delimiter $$
create procedure full_student_record(in p_rollnumber int)
begin
select * from student where rollnumber=p_rollnumber;
end $$
delimiter ;

call full_student_record(116);

-- 3. Create a procedure that updates the percentage of a student using student ID and  new percentage as input.
delimiter $$
create procedure update_percentage(in p_percentage decimal(5,2))
begin 
update student set percentage=p_percentage where studentid=16;
select * from student;
end $$
delimiter ;

call update_percentage(90.00);

-- 4. Write a procedure to return all subjects opted by a student whose student ID is given. 
delimiter $$
create procedure return_all_subjects(in p_studentid int)
begin
select subname from subjects where studentid=p_studentid;
end $$
delimiter ;

call return_all_subjects(1);

-- 5. Write a procedure that accepts student ID 
-- and returns (via OUT parameters) the name and percentage of that student. 
delimiter $$
create procedure get_student_details(
in p_studentid int,
out p_name varchar(100),
out p_percentage decimal(5,2))
begin
select name,percentage into p_name,p_percentage from student where studentid=p_studentid;
end $$
delimiter ;

call get_student_details(16,@name,@percentage);
select @name, @percentage;

-- 6. Create a procedure that returns the name, city, and mobile number of all
-- students by joining students and profile tables. 
delimiter $$
create procedure joining_student_profile_table(
out p_name varchar(100),
out p_city varchar(50),
out p_mobileno varchar(20)
)
begin
select s.name,p.city,p.mobileno from student s join profile p on s.studentid=p.studentid;
end $$
delimiter ;

call joining_student_profile_table(@name,@city,@mobileno);

-- 7. Write a procedure that returns all students who live in a specific city (input parameter). 
delimiter $$
create procedure student_lives_in_specific_city(
in p_city varchar(100)
)
begin
select s.* from student s join profile p on s.studentid=p.studentid where p.city=p_city;
end $$
delimiter ;

call student_lives_in_specific_city('Mumbai');

-- 8. Write a procedure that takes student ID as input and returns the 
-- total number of courses enrolled using an OUT parameter. 
delimiter $$
create procedure get_course_count(
in p_studentid int,
out p_total_courses int 
)
begin 
select count(*) into p_total_courses from student_course where studentid=p_studentid;
end $$
delimiter ;

call get_course_count(2,@total);
select @total;

-- 9. Write a procedure that returns the average percentage of students grouped by city. 
delimiter $$
create procedure get_avg_percentage_city_wise(
out p_percentage decimal (5,2), 
out p_city varchar(100)
)
begin 
select p.city,avg(s.percentage) from student s inner join profile p on s.studentid=p.studentid group by p.city;
end $$
delimiter ;

call get_avg_percentage_city_wise(@city,@percentage);

-- 10. Write a procedure to return the student IDs of students who are enrolled in more than one course. 
delimiter $$
create procedure get_studentid_who_enrolled_more_than_one_course(out p_studentid int)
begin
select s.studentid from student s inner join student_course sc on s.studentid=sc.studentid group by sc.studentid having count(sc.studentid)>1;
end $$
delimiter ;

call get_studentid_who_enrolled_more_than_one_course(@studentid);

-- 11. Create a procedure that accepts student ID and age as input. Use the age as an 
-- INOUT parameter: update the student’s age, then return the updated value back. 
delimiter $$
create procedure update_student_age(
in p_studentid int,
inout p_age int 
)
begin
update student set age=p_age where studentid =p_studentid ;
select age into p_age from student where studentid=p_studentid;
end $$
delimiter ;

set @age=26;
call update_student_age(15,@age);
select @age;
 
-- 12. Write a procedure that uses INOUT parameter to insert a new subject for a 
-- student only if it doesn’t already exist. If the subject exists, return a message 
-- like "Already exists" via the same parameter.
DELIMITER $$
CREATE PROCEDURE insert_new_subject(
    IN p_studentid INT,
    INOUT p_subname VARCHAR(100)
)
BEGIN
    DECLARE sub_count INT;

    -- Check if subject already exists for that student
    SELECT COUNT(*) INTO sub_count
    FROM Subjects
    WHERE studentid = p_studentid 
    AND subname = p_subname;

    IF sub_count > 0 THEN
        -- Subject already exists
        SET p_subname = 'Already exists';
    ELSE
        -- Insert new subject
        INSERT INTO Subjects (subid, studentid, subname)
        VALUES (
            (SELECT IFNULL(MAX(subid),0)+1 FROM Subjects),
            p_studentid,
            p_subname
        );
        SET p_subname = 'Inserted successfully';
    END IF;

END $$
DELIMITER ;

SET @sub = 'Mathematics';
CALL insert_new_subject(1, @sub);
SELECT @sub;

-- 13. Create a procedure that accepts student and profile details as input and inserts 
-- them into the students and profile tables. Ensure the student ID from the first insert is reused for the profile record. 
-- 14. Design an audit table percentage_audit(student_id, old_percentage, 
-- new_percentage, updated_at) and create a procedure that updates a student’s 
-- percentage and logs the old and new value into the audit table. 
-- 15. Write a procedure that deletes a student’s record from all related tables: 
-- student_course, subjects, profile, and finally students table. 