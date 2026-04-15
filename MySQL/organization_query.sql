use organization;

--  show details of all employee
-- #1. Display all employee names in ascending order
select * from emp order by ename;

-- #2. Display all employees(all columns) in department 20 and 30
select * from emp where deptno in (20,30);

-- #3. Display all the employees who are managers
select * from emp where job='manager';

-- #4. Display all the employees whose salary is between 2000 and 5000
select * from emp where sal between 2000 and 5000;

-- #5. Display all the employees whose commission is null
select * from emp where comm is null;
select deptno,count(ename)  from emp where comm is null group by deptno ;

-- #6. Display emp_name,salary,comission,ctc(calculated column)

-- #7. Display hire_date, current_date, tenure(calculated col) of the empl


-- #8. Display all the employees whose name starts with s
select * from emp where ename like 'S%';

-- #9. Display unique department numbers from the employee table
select distinct deptno from emp;

--  #10. Display emp_name and job in lower case
select Lower(ename),lower(job) from emp;

-- 11. Select top 3 salary earning employee
select * from emp order by sal desc limit 3;

-- #12. Select clerks and Managers in department 10
select * from emp where job in('clerk','manager');

-- #13. Display all clerks in asscending order of the department number 
select * from emp where job in ('clerk') order by deptno;

-- #16. Display All employees in the same dept of 'SCOTT'
select * from emp; 

-- #17. Employees having same designation of SMITH
select * from emp where job='clerk';

-- #18. Employee who are reproting under KING

-- #19. Employees who have same salary of BLAKE
select * from emp where sal=2850;

-- #20. Display departmentwise number of employees
select d.dname,count(empno) number_of_emp from dept d left join emp e on d.deptno=e.deptno group by d.dname;

-- #21. Display jobwise number of employees
select job,count(empno) number_of_employee from emp group by job;

-- #22. Display deptwise jobwise number of employees
select deptno,job,count(*) employee_count from emp group by deptno,job order by deptno,job;

-- #23. Display deptwise  employees greater than  3 
select d.dname,count(empno) emp_count from dept d left join emp e on d.deptno=e.deptno group by d.dname having count(e.empno)>3;

-- #24. Display designation wise employees count greater than 3 
select job,count(empno) number_of_employee from emp  group by job having count(*)>3;
 
-- #25. Display Employee name,deptname and location
select e.ename,d.dname,d.loc from emp e left join dept d on e.deptno=d.deptno; 

-- 26. display all deptnames and corresponding employees if ANY
select d.dname,e.ename from dept d left join emp e on d.deptno=e.deptno; 

-- #27. dipslay all deptnames where there are no employees
select d.dname,count(e.empno) Zero_emp from dept d left join emp e on e.deptno=d.deptno group by d.dname having count(e.empno) =0;

-- #28. display deptname wise employee count greater than 3, display in descending order of deptname
select d.dname,count(e.empno) number_of_employees from dept d left join emp e on d.deptno=e.deptno group by d.dname having count(e.empno)>3 order by d.dname desc; 

-- #29. Display all the empname and their manager names
select ename,mgr from emp;

-- 30. Display empname,deptname and manager name as bossname , order by bossname
select e.ename,d.dname,e.mgr as bossname from emp e left join dept d on d.deptno=e.deptno order by bossname;

-- #31. Display Dname, employee name and names of their managers
select d.dname,e.ename,e.mgr from emp e left join dept d on d.deptno=e.deptno;

-- List all countries along with their region names.
SELECT 
    c.country_name, r.region_name
FROM
    countries c
        INNER JOIN
    regions r ON r.region_id = c.region_id;

-- List all locations along with their country names.
SELECT 
    l.street_address, c.country_name
FROM
    locations l
        INNER JOIN
    countries c ON c.country_id = c.country_id;

-- Find all regions, including those without any countries.
SELECT 
    r.region_name, c.country_name
FROM
    regions r
        LEFT JOIN
    countries c ON r.region_id = c.region_id;

-- Find all countries, including those without any locations.
SELECT 
    c.country_name, r.region_name
FROM
    countries c
        LEFT JOIN
    regions r ON r.region_id = c.region_id;
    
-- Get the count of countries in each region.
SELECT 
    r.region_name, COUNT(country_id) country_count
FROM
    regions r
        LEFT JOIN
    countries c ON r.region_id = c.region_id
GROUP BY region_name;

-- Get the count of locations in each country.
SELECT 
    c.country_name, COUNT(location_id) location_count
FROM
    locations l
        LEFT JOIN
    countries c ON c.country_id = l.country_id
GROUP BY country_name;

-- List regions that have more than 5 countries.
SELECT 
    r.region_name, COUNT(country_id) country_count
FROM
    regions r
        LEFT JOIN
    countries c ON c.region_id = r.region_id
GROUP BY region_name
HAVING COUNT(*) > 5;

-- Find all cities with their country and region names.
SELECT 
    l.city, c.country_name, r.region_name
FROM
    locations l
        JOIN
    countries c ON l.country_id = c.country_id
        JOIN
    regions r ON c.region_id = r.region_id;

-- List all countries that do not have any locations.
select c.country_name from countries c left join locations l on c.country_id=l.country_id group by c.country_name having count(c.country_name)=0;

-- List the region name, country name, and the number of locations per country.
select r.region_name,c.country_name,count(l.location_id) number_of_location from regions r inner join countries c on r.region_id=c.region_id left join locations l on l.country_id=c.country_id group by r.region_name,c.country_name;
--  
--  
--  
-- Which countries are located in the "Asia" region?
select c.country_name,r.region_name from countries c left join regions r on r.region_id=c.region_id where r.region_name in('Asia');
 
-- List the names of all countries in the "Americas" region that have at least one location.
SELECT 
    c.country_name
FROM 
    countries c
JOIN 
    regions r 
ON 
    r.region_id = c.region_id
JOIN 
    locations l 
ON 
    l.country_id = c.country_id
WHERE 
    r.region_name = 'Americas'
GROUP BY 
    c.country_name
HAVING 
    COUNT(l.location_id) > 0;

-- Find all cities in the "Europe" region along with their respective country names.
select l.city from locations l left join countries c on l.country_id=c.country_id join regions r on c.country_id=r.region_id where r.region_name='Europe' group by l.city;

-- How many countries are in the "Middle East and Asia" region?
-- List all regions along with the number of countries in each region.
-- Which countries do not have any associated locations?
-- Find all countries along with their region names, where the region name is either "Europe" or "Asia".
-- List all locations in "Italy" along with the city and postal code.
-- Which countries have more than one location?
-- Retrieve all locations in "Canada" and the United States along with the state/province information.