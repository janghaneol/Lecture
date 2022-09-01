/* #1. 테이블 생성 - NOT NULL 제약조건만 추가 */
CREATE TABLE sawon (
        id NUMBER(5),
        name VARCHAR2(10) NOT NULL,
        gender CHAR(1) NOT NULL,
        hiredate DATE DEFAULT SYSDATE,
        manager_id NUMBER(6)
);

select * from user_constraints
where table_name = 'SAWON';

/* #2. 생성된 테이블에 제약조건 추가 */
ALTER TABLE sawon
    ADD ( CONSTRAINT sawon_id_pk          PRIMARY KEY(id),
          CONSTRAINT sawon_gender_ck      CHECK (gender IN('M', 'F')),
          CONSTRAINT sawon_mgid_fk        FOREIGN KEY(manager_id) REFERENCES employees(employee_id));
        
SELECT * FROM user_constraints
WHERE table_name = 'SAWON';

/* #3. 개발 편의를 위한 제약조건 비활성화/활성화 */
ALTER TABLE sawon
DISABLE CONSTRAINT sawon_id_pk CASCADE
DISABLE CONSTRAINT sawon_gender_ck
DISABLE CONSTRAINT sawon_mgid_fk;

ALTER TABLE sawon
ENABLE CONSTRAINT sawon_id_pk
ENABLE CONSTRAINT sawon_gender_ck
ENABLE CONSTRAINT sawon_mgid_fk;

--테스트용 행 추가
INSERT INTO sawon (id, name, gender, manager_id)
values (1, '장한얼', 'M', 100);

select *
from sawon;

create table emp3
as
select * from employees
where 0 = 1; -- 구조만 복사

select * from emp3;

drop table emp3;

drop table employees; -- employees 테이블은 외래키때문에 삭제가 안된다.

-- drop table은 행의 인덱스는 삭제가 안되고 남아있다. 행단위로 삭제되지만
-- TRUNCATE TABLE은 통째로 들어내는 개념이기때문에 인덱스까지 삭제되고 사용된 공간자체가 해제된다.

-- 시퀀스의 생성
create sequence sawon_seq
start with 10
increment by 10;

-- 시퀀스 조회
select * from user_sequences;

-- 시퀀스 삭제
drop SEQUENCE sawon_seq;

-- 시퀀스를 이용한 테이블에 값을 넣는 방법
insert into sawon(id, name, gender, manager_id)
values(sawon_seq.nextval, '장한얼', 'M', 100);

select * from sawon;

select * from user_views;

select * from emp_details_view;

-- 10번 부서의 사원 정보만 조회할 수 있는 뷰 생성
CREATE OR REPLACE VIEW emp_view
     AS SELECT employee_id, last_name, department_id
        FROM employees
        WHERE department_id = 10;

-- emp_view 뷰 조회
SELECT * FROM emp_view;

-- 10번 부서의 사원에 대해서만 INSERT, UPDATE 할 수 있는 뷰 생성
CREATE OR REPLACE VIEW emp_view
    AS SELECT employee_id, last_name, email, hire_date, job_id, department_id
        FROM employees
        WHERE department_id = 10    --department_id가 10번인 부서에만 작동하는 뷰
            WITH CHECK OPTION;
            
INSERT INTO emp_view (employee_id, last_name, email, hire_date, job_id, department_id)
VALUES (employees_seq.nextval, 'jack', 'jack@korea.com', sysdate, 'AD_VP', 10);

-- department_id가 20이기때문에 INSERT_ERROR가 뜬다
INSERT INTO emp_view (employee_id, last_name, email, hire_date, job_id, department_id)
VALUES (employees_seq.nextval, 'king', 'jack@korea.com', sysdate, 'AD_VP', 20);

select * from emp_view
where department_id =10;

-- 읽기 전용 뷰 생성
CREATE OR REPLACE VIEW emp_view
    AS SELECT employee_id, last_name, email, hire_date, job_id, department_id
    FROM employees
    WHERE department_id = 10
        WITH READ ONLY;

-- INSERT ERROR read only 뷰이기때문에 데이터를 추가할 수 없다.
INSERT INTO emp_view (employee_id, last_name, email, hire_date, job_id, department_id)
VALUES (employees_seq.nextval, 'jack', 'jack@korea.com', sysdate, 'AD_VP', 10);
-- 복잡한 SQL 저장을 위한 뷰 생성
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
                    
-- 뷰 조회
select * from emp_view;

-- 보안을 위한 직급별 뷰 생성
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

-- 특정 테이블의 인덱스를 조회
select *
from user_indexes
where table_name = 'EMPLOYEES';

-- 인덱스에서 사용하는 가상컬럼(rowid) 조회
SELECT rowid, employee_id
FROM employees;

-- 딕셔너리로부터 인덱스 조회
SELECT *
FROM user_indexes
WHERE table_name = 'EMPLOYEES';

-- 수동 인덱스 생성
CREATE INDEX emp_salary_idx
    ON employees(salary);

-- salary에 관한 인덱스가 생성되었기때문에 salary를 사용할때 내부적으로 인덱스를 사용함.
SELECT employee_id, last_name, salary
FROM employees
WHERE salary BETWEEN 10000 AND 12000;

-- 자동 인덱스 사용
SELECT employee_id, last_name, salary, email
FROM employees
WHERE email = 'JSEO';

--시노님은 데이터베이스 객체(테이블, 뷰, 시퀀스 등)에 대한 대체이름(Alias)를 말한다 synonym = 동의어
-- 스키마의 테이블 이름을 간소화할 수 있기때문에 ★★데이터테이블 유지보수에 용이하다.
create synonym emp
for hr.employees;

select * from emp;