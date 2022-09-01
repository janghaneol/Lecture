-- employees ���̺��� �޿��� 5000�̻� 15000���� ���̿� ���Ե��� �ʴ� ����� 
-- �����ȣ(employee_id), �̸�(last_name), �޿�(salary), �Ի�����(hire_date)�� ��ȸ�Ͻÿ�.
select employee_id, last_name, salary, hire_date
from employees
where NOT (salary >= 5000 AND salary <=15000);

-- �μ���ȣ(department_id) 50, ����(job_id) 'ST_MAN', �Ի��� 2004-07-18���� 
-- ����� �����ȣ(employee_id), �̸�(last_name), ������ȣ(job_id), �Ի���(hire_date)�� ��ȸ�Ͻÿ�
select employee_id, last_name, job_id, hire_date
from employees
where department_id = 50 and job_id = 'ST_MAN' and hire_date = '04/07/18';

--2002�� ���Ŀ�  �Ի��Ͽ���, ������ȣ�� 'ST_MAN' �Ǵ� 'ST_CLERK'�� ������� ��� �÷��� ��ȸ�Ͻÿ�.
select *
from employees
where hire_date > '02/01/01' and job_id in('ST_MAN','ST_CLERK');

--���(manager_id)�� ���� ����� ��� �÷��� ��ȸ�Ͻÿ�.
select *
from employees
where manager_id IS NULL;

--����̸�(last_name)�� J, A �Ǵ� M���� �����ϴ� ��� ����� last_name�� salary�� ��ȸ�Ͻÿ�.
--(��, last_name �������� ��ȸ)
select last_name , salary
from employees
where substr(last_name,1,1) in ('J','A','M')
order by last_name;

--�⵵�� �Ի��ο����� ��ȸ�Ͻÿ�.
select to_char(hire_date,'YYYY') year, count(*) count
from employees
group by to_char(hire_date,'YYYY')
order by year;

--�����ȣ(employee_id)�� Ȧ���� ����� ��� ������ ��ȸ�Ͻÿ�.
select *
from employees
where mod(employee_id,2)=1;

--���ú��� 6���� �� ���ƿ��� ù��° �ݿ����� ��¥�� ����Ͻÿ�
--(��¥ �������: 2002-06-05 15:23:10 �ݿ���)
select to_char(next_day(add_months(sysdate,6),'�ݿ���'),'YYYY-MM-DD HH:MI:SS DAY')
from dual;

--�����ȣ(employee_id), �����(first_name), ����ȣ(manager_id)�� ��ȸ�ϵ�
--��簡 ����(NULL) ��� ����ȣ�� '�뻧'�̶� ����Ͻÿ�.
select employee_id, first_name, manager_id, DECODE(manager_id, null, '�뻧')
from employees;

--10.������� 3���౸������ �з��ϱ� ���� ����� 3���� ������
--   �������� 0�̸� "��ȭ�����"
--   �������� 1�̸� "���׸���"
--   �������� 2�̸� "������"���� �з��Ͽ� ���̸�, �����ȣ, ������� ����Ͻÿ�.
select employee_id"�����ȣ", first_name"�����",
    CASE 
        WHEN mod(employee_id ,3)=0 THEN '��ȭ�����'
        WHEN mod(employee_id ,3)=1 THEN '���׸���'
        WHEN mod(employee_id ,3)=2 THEN '������' 
        
    END "���̸�"
from employees
order by employee_id;
        

--11.����� �޿��׷����� �Ʒ��� ���� ����Ͻÿ�(2�÷����� ���)
--   �̸�            �޿��׷���
--   -------------------------------------------------------
--   Steven King     *****($5,000) // $1000�޷��� �� 1���߰�.
--   Neena Kochhar   ***($3,000)--    .........
--   XXXX XXXXX      *****************($17,000)
select concat(concat(first_name, ' ' ) , last_name) "�̸�" ,
            RPAD(' ', ROUND(salary/1000)+1,'*') || '('|| TO_CHAR(salary,'99,999')||')' "�޿��׷���"
from employees
order by salary desc;


--12.2002�� 3������ 2003�� 2�� �Ⱓ ���� �Ի��� ����� ������� �μ��� �ο����� ��ȸ�Ͻÿ�(����� �ο����� ���� ������� �����Ͽ� ���)
select department_id, count(department_id) cnt
from employees
where to_char(hire_date,'YYYY-MM') >= '2002-03' and to_char(hire_date,'YYYY-MM') <= '2003-02'
group by department_id
order by department_id;

--13.������ ��� �޿��� ����϶�. ��, ��ձ޿��� 10000�� �ʰ��ϴ� ���� �����ϰ� ��� �޿��� ���� ������������ �����Ͻÿ�.
select department_id "�μ���ȣ" , avg(salary) "��ձ޿�"
from employees
group by department_id
having avg(salary)<=10000
order by avg(salary) desc;

--14.������ ������� ���� �Ի��� ������� �Ʒ��� ���� ����Ͻÿ�.
--1��  2�� ........................12��
---------------------------------------
--2     1  ........................ 5
SELECT to_char(hire_date,'MM')||'��' "�Ի��", count(*) || '��' "������"
from employees
group by to_char(hire_date,'MM')
order by to_char(hire_date,'MM');


--15.'London'���� �ٹ��ϴ� ��� ����� �����ȣ(employee_id), ����̸�(last_name), �����̸�(job_title), �μ��̸�(department_name), �μ���ġ(city)�� ��ȸ�Ͻÿ�.
--  --���� ���̺� : employees, jobs, departments, locations
select e.employee_id, e.last_name, j.job_title, d.department_name, l.city
from employees e 
    join jobs j
    on e.job_id = j.job_id
    join departments d
    on e.department_id = d.department_id
    join locations l
    on d.location_id = l.location_id;

--16.����̸�(last_name)�� 'A'�� ���Ե� ����� �̸�(last_name)�� �μ���(department_name)�� ��ȸ�Ͻÿ�.
select e.last_name, d.department_name
from employees e
    join departments d
    on e.department_id = d.department_id
where e.last_name like '%A%';
    
--17. �޿�(salary)�� 3000���� 5000 ������ ����� ��ȣ, �̸�, �޿�, �μ����� ��ȸ�϶�.
select e.employee_id, e.last_name, e.salary, d.department_name
from employees e
    join departments d
    on e.department_id = d.department_id
where salary between 3000 and 5000
order by salary;
--18. 'Accounting' �μ��� �ٹ��ϴ� ����� �̸��� �Ի����� ��ȸ�϶�.
--   -- �Ի��� ��� ���� - 2007�� 05�� 21��(������)
select e.first_name, e.last_name, to_char(e.hire_date,'""YYYY"�� "MM"�� "DD"��"(DAY)""'), d.department_name
from employees e
    join departments d
    on e.department_id = d.department_id
    where d.department_name = 'Accounting';
    
--19. 'Landry(last_name)'�� ���� �μ��� �ٹ��ϴ� ����� ��� ��� ������ ��ȸ�϶�(��. Landry�� ����)
select *
from departments d
    join employees e
    ON d.department_id = e.department_id
where d.department_id = (select department_id
                            from employees
                            where last_name = 'Landry')
        and last_name != 'Landry';
--20. 'Lee(last_name)'���� �ʰ� �Ի��� ����� �̸��� �Ի��� ��ȸ�϶�.
select last_name, hire_date
from employees
where hire_date > (select hire_date
                    from employees
                    where last_name = 'Lee');

--21. 'Lee(last_name)'���� ���� �޿��� �޴� ����� �̸��� �޿��� ��ȸ�϶�.
select last_name, salary
from employees
where salary > (select salary
                from employees
                where last_name = 'Lee')
                order by salary;
                
--22. 50�� �μ��� ������ ���� �޿��� �޴� ����� �̸��� �޿��� ��ȸ�϶�.
select last_name, salary
from employees
where salary in (select salary
                from employees
                where department_id = '50');
                
--23. ��� ����� ��ձ޿����� ���� �޿��� �޴� ������� ���, �̸�, �޿��� ��ȸ�϶�.
select employee_id, last_name, salary
from employees
where salary > (select avg(salary)
                from employees);
--24.�̸�(last_name)��  'T'�� ���ԵǾ� �ִ� ����� ������ �μ��� �ٹ��ϴ� ����� ��ȣ, �̸��� ��ȸ�϶�.
select employee_id, last_name, department_id
from employees
where department_id in (select department_id
                        from employees
                        where last_name like '%T%');
--25.10�� �μ� �ִ�޿��ڿ� ������ �޿��� �޴� ����� ��ȣ, �̸�, �޿��� ��ȸ�϶�.
select employee_id, last_name, salary
from employees
where salary > (select max(salary)
                from employees
                where department_id = '10')
                order by salary;
--26. 'IT_PROG' ������ �ִ� �޿��ں��� ���� �޿��� �޴� ��� ����(�μ���ȣ, �����ȣ, �̸�, �޿�)�� ����϶�.
select department_id, employee_id, last_name, salary, job_id
from employees
where salary > (select max(salary)
                from employees
                where job_id = 'IT_PROG');
--27. ��� �޿����� ���� �޿��� �ް� �̸��� u�� ���Ե� ����� ���� �μ��� �ٹ��ϴ� ��� ����� ��� ����(�����ȣ, �̸�, �޿�)�� ��ȸ�϶�.
select employee_id, last_name , salary
from employees
where salary > (select avg(salary)
                from employees)
        and last_name like '%u%';
--28. ��ձ޿��� ���� ���� ������ȣ(job_id)�� ��ձ޿��� ����϶�
--    ��) ������ȣ  ��ձ޿�
--       -------------------
--        CLERK      2300   
select job_id "������ȣ" , avg(salary) "��ձ޿�"
from employees
group by job_id
having avg(salary) = (select min(avg(salary))
                    from employees
                    group by job_id);
            

                

                
                    

                






