select salary
from employees
where upper(last_name) = 'SEO';
--��������
SELECT employee_id, last_name, salary
from employees
where salary = (select salary
                from employees
                where upper(last_name) = 'SEO');

--��� �޿�(6461.83178) �̻��� �޴� ������� ���
SELECT *
from employees
where salary > (select avg(salary)
                from employees);
                
--30�� �μ��� �Ҽӵ� ������ ������ ������ ������ ��ü ������ ��ȸ
SELECT *
from employees
where job_id in(select job_id
                from employees
                where department_id = 30);
                
-- 30�� �μ��� �ּұ޿��� ���� �� ���� �޿��� �޴� ��ü ������ ��ȸ      
select *
from employees
where salary >ANY(select salary
                    from employees
                    where department_id = 30);
-- 30�� �μ��� �ִ�޿��� ���� �� ���� �޿��� �޴� ��ü ������ ��ȸ
select *
from employees
where salary > ALL(select salary
                from employees
                where department_id = 30);

select *
from employees
where EXISTS(SELECT *
             FROM departments
             where department_id = 30)
        AND department_id = 30;
        
-- �μ��� �ּұ޿��� �޴� ��� ����
select *
from employees
where (department_id, salary) IN (select department_id , MIN(salary)
                                    from employees
                                    group by department_id)
order by department_id;

-- �μ��� �ִ�޿��� �޴� ��� ����
SELECT e.employee_id, e.department_id, e.first_name, e.salary
from employees e join (select department_id, max(salary) maxSal
                        from employees
                        group by department_id) i
                    on e.department_id = i.department_id
                    and e.salary = i.maxSal
order by department_id;
                    
-- ��� ��ȣ, ��� �̸�, �μ��� ��ȸ (��Į�� �������� -> �����ϸ� ����� ���� �ʴ´� ���༺���� ��������)
SELECT employee_id,
first_name,
(SELECT department_name
FROM departments d
WHERE d.department_id = e.department_id) "department_name"
FROM employees e;
-- ���� Į�� (����ø��� �������� ������)
select rowid,rownum
from employees;

-- ���̺��� ���� ���̶� ���� �ٸ� ROWNUM�� ���� �� �ִ�
SELECT ROWNUM, employee_id
FROM employees;

SELECT ROWNUM, employee_id
FROM employees
ORDER BY employee_id DESC;

-- ��� 3�� ��ȸ
SELECT ROWNUM, employee_id, first_name
FROM employees
WHERE ROWNUM <= 3;

-- ����
-- ù��° ���� rownum�� 1�̹Ƿ�
-- 1 > 1�� false�� �Ǿ� rownum�� ���̻� �������� ������, �ϳ��� �൵ ��ȯ���� ����
SELECT ROWNUM, employee_id, first_name
FROM employees
WHERE ROWNUM > 1;

/* Ư�� �÷��� �������� �����Ͽ� ���� 5��(����)�� ��ȸ�ϰ��� �Ѵٸ� */
-- ��)��ü ����� �޿������� 5�� �������� 
-- ��ü �޿� ������ �ƴ� ó�� 5��ȿ����� �޿������� �� order by ���� ���� ���߿� ����Ǳ⶧���� �׳� ����5���� ���� ����� ��
select ROWNUM, employee_id, salary
from employees
where rownum <=5
order by salary desc;

-- FROM������ ��������(Inline View)�� ����ؾ� �Ѵ�
SELECT *
FROM (SELECT *
        FROM employees
        order by salary desc)
where ROWNUM <=5;

-- �޿������� ����¡ ó��
SELECT employee_id, first_name, salary, page
    FROM(SELECT CEIL(ROWNUM/10) page, employee_id, first_name, salary
            FROM (SELECT ROWNUM , employee_id, first_name , salary
                    FROM employees
                    ORDER BY salary DESC))
where page = 1;



