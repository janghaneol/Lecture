--CROSS JOIN (이론상 조인) 오라클구문
select e.employee_id, e.last_name, d.department_name
from employees e, departments d;

--ANSI 표준 조인 구문
select e.employee_id, e.last_name, d.department_name
from employees e cross join departments d;

--INNER JOIN (오라클 구문)
select e.employee_id, e.last_name, d.department_name
from employees e, departments d
where e.department_id = d.department_id
    AND e.salary>=3000
order by employee_id;

--INNER JOIN (ANSI 표준)
select e.employee_id, e.last_name, d.department_name
from employees e join departments d
--on e.department_id = d.department_id;
using(department_id);

select * 
from user_tables;

SELECT *
FROM departments;

DESCRIBE departments;

select *
from locations;

select *
from countries;

select e.employee_id, e.last_name, d.department_name, l.city, l.state_province, c.country_name
from employees e 
    join departments d
    on e.department_id = d.department_id
    join locations l
    on d.location_id = l.location_id
    join countries c
    on l.country_id = c.country_id;
    
select *
from jobs;
    
select e.employee_id, e.last_name, e.salary
from employees e
    join jobs j
    on e.salary between j.min_salary and j.max_salary
    order by salary;
    
-- OUTER JOIN (오라클 구문)
SELECT e.employee_id, e.last_name, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id(+);

-- OUTER JOIN (ANSI 표준) 부서가 없는 사원도 출력된다.
SELECT e.employee_id, e.last_name, d.department_name
FROM employees e
    left outer join departments d
        on e.department_id = d.department_id;

-- 사원이 없는 부서도 출력
SELECT e.employee_id, e.last_name, d.department_name
FROM employees e
    right outer join departments d
        on e.department_id = d.department_id;

--부서가없는사원, 사원이없는부서도 출력 
SELECT e.employee_id, e.last_name, d.department_name
FROM employees e
    full outer join departments d
        on e.department_id = d.department_id;
        
-- ANSI 표준 SELF JOIN(사원별 상사를 출력)
SELECT e.first_name , m.first_name
FROM EMPLOYEES e
left OUTER JOIN EMPLOYEES m
ON e.manager_id = m.employee_id;
        
    


