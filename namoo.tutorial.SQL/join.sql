--CROSS JOIN (�̷л� ����) ����Ŭ����
select e.employee_id, e.last_name, d.department_name
from employees e, departments d;

--ANSI ǥ�� ���� ����
select e.employee_id, e.last_name, d.department_name
from employees e cross join departments d;

--INNER JOIN (����Ŭ ����)
select e.employee_id, e.last_name, d.department_name
from employees e, departments d
where e.department_id = d.department_id
    AND e.salary>=3000
order by employee_id;

--INNER JOIN (ANSI ǥ��)
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
    
-- OUTER JOIN (����Ŭ ����)
SELECT e.employee_id, e.last_name, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id(+);

-- OUTER JOIN (ANSI ǥ��) �μ��� ���� ����� ��µȴ�.
SELECT e.employee_id, e.last_name, d.department_name
FROM employees e
    left outer join departments d
        on e.department_id = d.department_id;

-- ����� ���� �μ��� ���
SELECT e.employee_id, e.last_name, d.department_name
FROM employees e
    right outer join departments d
        on e.department_id = d.department_id;

--�μ������»��, ����̾��ºμ��� ��� 
SELECT e.employee_id, e.last_name, d.department_name
FROM employees e
    full outer join departments d
        on e.department_id = d.department_id;
        
-- ANSI ǥ�� SELF JOIN(����� ��縦 ���)
SELECT e.first_name , m.first_name
FROM EMPLOYEES e
left OUTER JOIN EMPLOYEES m
ON e.manager_id = m.employee_id;
        
    


