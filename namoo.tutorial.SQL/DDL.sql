/* #1. ���̺� ���� - NOT NULL �������Ǹ� �߰� */
CREATE TABLE sawon (
        id NUMBER(5),
        name VARCHAR2(10) NOT NULL,
        gender CHAR(1) NOT NULL,
        hiredate DATE DEFAULT SYSDATE,
        manager_id NUMBER(6)
);

select * from user_constraints
where table_name = 'SAWON';

/* #2. ������ ���̺� �������� �߰� */
ALTER TABLE sawon
    ADD ( CONSTRAINT sawon_id_pk          PRIMARY KEY(id),
          CONSTRAINT sawon_gender_ck      CHECK (gender IN('M', 'F')),
          CONSTRAINT sawon_mgid_fk        FOREIGN KEY(manager_id) REFERENCES employees(employee_id));
        
SELECT * FROM user_constraints
WHERE table_name = 'SAWON';

/* #3. ���� ���Ǹ� ���� �������� ��Ȱ��ȭ/Ȱ��ȭ */
ALTER TABLE sawon
DISABLE CONSTRAINT sawon_id_pk CASCADE
DISABLE CONSTRAINT sawon_gender_ck
DISABLE CONSTRAINT sawon_mgid_fk;

ALTER TABLE sawon
ENABLE CONSTRAINT sawon_id_pk
ENABLE CONSTRAINT sawon_gender_ck
ENABLE CONSTRAINT sawon_mgid_fk;

--�׽�Ʈ�� �� �߰�
INSERT INTO sawon (id, name, gender, manager_id)
values (1, '���Ѿ�', 'M', 100);

select *
from sawon;

create table emp3
as
select * from employees
where 0 = 1; -- ������ ����

select * from emp3;

drop table emp3;

drop table employees; -- employees ���̺��� �ܷ�Ű������ ������ �ȵȴ�.

-- drop table�� ���� �ε����� ������ �ȵǰ� �����ִ�. ������� ����������
-- TRUNCATE TABLE�� ��°�� ���� �����̱⶧���� �ε������� �����ǰ� ���� ������ü�� �����ȴ�.

-- �������� ����
create sequence sawon_seq
start with 10
increment by 10;

-- ������ ��ȸ
select * from user_sequences;

-- ������ ����
drop SEQUENCE sawon_seq;

-- �������� �̿��� ���̺� ���� �ִ� ���
insert into sawon(id, name, gender, manager_id)
values(sawon_seq.nextval, '���Ѿ�', 'M', 100);

select * from sawon;

select * from user_views;

select * from emp_details_view;

-- 10�� �μ��� ��� ������ ��ȸ�� �� �ִ� �� ����
CREATE OR REPLACE VIEW emp_view
     AS SELECT employee_id, last_name, department_id
        FROM employees
        WHERE department_id = 10;

-- emp_view �� ��ȸ
SELECT * FROM emp_view;

-- 10�� �μ��� ����� ���ؼ��� INSERT, UPDATE �� �� �ִ� �� ����
CREATE OR REPLACE VIEW emp_view
    AS SELECT employee_id, last_name, email, hire_date, job_id, department_id
        FROM employees
        WHERE department_id = 10    --department_id�� 10���� �μ����� �۵��ϴ� ��
            WITH CHECK OPTION;
            
INSERT INTO emp_view (employee_id, last_name, email, hire_date, job_id, department_id)
VALUES (employees_seq.nextval, 'jack', 'jack@korea.com', sysdate, 'AD_VP', 10);

-- department_id�� 20�̱⶧���� INSERT_ERROR�� ���
INSERT INTO emp_view (employee_id, last_name, email, hire_date, job_id, department_id)
VALUES (employees_seq.nextval, 'king', 'jack@korea.com', sysdate, 'AD_VP', 20);

select * from emp_view
where department_id =10;

-- �б� ���� �� ����
CREATE OR REPLACE VIEW emp_view
    AS SELECT employee_id, last_name, email, hire_date, job_id, department_id
    FROM employees
    WHERE department_id = 10
        WITH READ ONLY;

-- INSERT ERROR read only ���̱⶧���� �����͸� �߰��� �� ����.
INSERT INTO emp_view (employee_id, last_name, email, hire_date, job_id, department_id)
VALUES (employees_seq.nextval, 'jack', 'jack@korea.com', sysdate, 'AD_VP', 10);
-- ������ SQL ������ ���� �� ����
CREATE OR REPLACE VIEW emp_view
    AS SELECT e.employee_id id,
        e.first_name name,
        j.job_title,
        d.department_name dname,
        l.city city
            FROM employees e
                JOIN jobs j
                    ON e.job_id = j.job_id
                JOIN departments d
                    ON e.department_id = d.department_id
                JOIN locations l
                    ON d.location_id = l.location_id;
                    
-- �� ��ȸ
select * from emp_view;

-- ������ ���� ���޺� �� ����
CREATE OR REPLACE VIEW emp_jjang_view
        AS SELECT *
            FROM employees;

CREATE OR REPLACE VIEW emp_bujang_view
        AS SELECT employee_id, first_name, salary
            FROM employees;

SELECT *
FROM emp_jjang_view;

SELECT *
FROM emp_bujang_view;

-- Ư�� ���̺��� �ε����� ��ȸ
select *
from user_indexes
where table_name = 'EMPLOYEES';

-- �ε������� ����ϴ� �����÷�(rowid) ��ȸ
SELECT rowid, employee_id
FROM employees;

-- ��ųʸ��κ��� �ε��� ��ȸ
SELECT *
FROM user_indexes
WHERE table_name = 'EMPLOYEES';

-- ���� �ε��� ����
CREATE INDEX emp_salary_idx
    ON employees(salary);

-- salary�� ���� �ε����� �����Ǿ��⶧���� salary�� ����Ҷ� ���������� �ε����� �����.
SELECT employee_id, last_name, salary
FROM employees
WHERE salary BETWEEN 10000 AND 12000;

-- �ڵ� �ε��� ���
SELECT employee_id, last_name, salary, email
FROM employees
WHERE email = 'JSEO';

--�ó���� �����ͺ��̽� ��ü(���̺�, ��, ������ ��)�� ���� ��ü�̸�(Alias)�� ���Ѵ� synonym = ���Ǿ�
-- ��Ű���� ���̺� �̸��� ����ȭ�� �� �ֱ⶧���� �ڡڵ��������̺� ���������� �����ϴ�.
create synonym emp
for hr.employees;

select * from emp;