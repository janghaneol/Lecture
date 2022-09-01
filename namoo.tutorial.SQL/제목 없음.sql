INSERT INTO departments (department_id, department_name)
VALUES (departments_seq.NEXTVAL, 'KOREA IT');

rollback;

SELECT * from departments
order by department_id;

SELECT employee_id, last_name, salary, hire_date
from employees;

SELECT e.employee_id, e.last_name, e.salary, TO_CHAR(hire_date,'YYYY-MM-DD DAY')hiredate,d.department_name dname
FROM employees e
    JOIN departments d
        ON e.department_id = d.department_id;
        
UPDATE departments 
    SET department_name = '±‚»πΩ«'
WHERE department_id = 290;

rollback;

select * from departments;