select salary
from employees
where upper(last_name) = 'SEO';
--서브쿼리
SELECT employee_id, last_name, salary
from employees
where salary = (select salary
                from employees
                where upper(last_name) = 'SEO');

--평균 급여(6461.83178) 이상을 받는 사원정보 출력
SELECT *
from employees
where salary > (select avg(salary)
                from employees);
                
--30번 부서에 소속된 사원들과 동일한 업무를 가지는 전체 사원목록 조회
SELECT *
from employees
where job_id in(select job_id
                from employees
                where department_id = 30);
                
-- 30번 부서의 최소급여자 보다 더 많은 급여를 받는 전체 사원목록 조회      
select *
from employees
where salary >ANY(select salary
                    from employees
                    where department_id = 30);
-- 30번 부서의 최대급여자 보다 더 많은 급여를 받는 전체 사원목록 조회
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
        
-- 부서별 최소급여를 받는 사원 정보
select *
from employees
where (department_id, salary) IN (select department_id , MIN(salary)
                                    from employees
                                    group by department_id)
order by department_id;

-- 부서별 최대급여를 받는 사원 정보
SELECT e.employee_id, e.department_id, e.first_name, e.salary
from employees e join (select department_id, max(salary) maxSal
                        from employees
                        group by department_id) i
                    on e.department_id = i.department_id
                    and e.salary = i.maxSal
order by department_id;
                    
-- 사원 번호, 사원 이름, 부서명 조회 (스칼라 서브쿼리 -> 웬만하면 사용을 하지 않는다 수행성능이 좋지않음)
SELECT employee_id,
first_name,
(SELECT department_name
FROM departments d
WHERE d.department_id = e.department_id) "department_name"
FROM employees e;
-- 가상 칼럼 (실행시마다 동적으로 생성됨)
select rowid,rownum
from employees;

-- 테이블의 같은 행이라도 서로 다른 ROWNUM을 가질 수 있다
SELECT ROWNUM, employee_id
FROM employees;

SELECT ROWNUM, employee_id
FROM employees
ORDER BY employee_id DESC;

-- 사원 3명 조회
SELECT ROWNUM, employee_id, first_name
FROM employees
WHERE ROWNUM <= 3;

-- 주의
-- 첫번째 행의 rownum이 1이므로
-- 1 > 1은 false가 되어 rownum은 더이상 증가하지 않으며, 하나의 행도 반환되지 않음
SELECT ROWNUM, employee_id, first_name
FROM employees
WHERE ROWNUM > 1;

/* 특정 컬럼을 기준으로 정렬하여 상위 5개(범위)를 조회하고자 한다면 */
-- 예)전체 사원의 급여순으로 5명 가져오기 
-- 전체 급여 순위가 아닌 처음 5명안에서의 급여순위가 됨 order by 절이 가장 나중에 실행되기때문에 그냥 상위5명의 값만 출려된 것
select ROWNUM, employee_id, salary
from employees
where rownum <=5
order by salary desc;

-- FROM절에서 서브쿼리(Inline View)를 사용해야 한다
SELECT *
FROM (SELECT *
        FROM employees
        order by salary desc)
where ROWNUM <=5;

-- 급여순으로 페이징 처리
SELECT employee_id, first_name, salary, page
    FROM(SELECT CEIL(ROWNUM/10) page, employee_id, first_name, salary
            FROM (SELECT ROWNUM , employee_id, first_name , salary
                    FROM employees
                    ORDER BY salary DESC))
where page = 1;



