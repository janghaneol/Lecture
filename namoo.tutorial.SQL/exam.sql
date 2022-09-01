-- employees 테이블에서 급여가 5000이상 15000이하 사이에 포함되지 않는 사원의 
-- 사원번호(employee_id), 이름(last_name), 급여(salary), 입사일자(hire_date)를 조회하시오.
select employee_id, last_name, salary, hire_date
from employees
where NOT (salary >= 5000 AND salary <=15000);

-- 부서번호(department_id) 50, 업무(job_id) 'ST_MAN', 입사일 2004-07-18일인 
-- 사원의 사원번호(employee_id), 이름(last_name), 업무번호(job_id), 입사일(hire_date)을 조회하시오
select employee_id, last_name, job_id, hire_date
from employees
where department_id = 50 and job_id = 'ST_MAN' and hire_date = '04/07/18';

--2002년 이후에  입사하였고, 업무번호가 'ST_MAN' 또는 'ST_CLERK'인 사원들의 모든 컬럼을 조회하시오.
select *
from employees
where hire_date > '02/01/01' and job_id in('ST_MAN','ST_CLERK');

--상사(manager_id)가 없는 사원의 모든 컬럼을 조회하시오.
select *
from employees
where manager_id IS NULL;

--사원이름(last_name)이 J, A 또는 M으로 시작하는 모든 사원의 last_name과 salary를 조회하시오.
--(단, last_name 오름차순 조회)
select last_name , salary
from employees
where substr(last_name,1,1) in ('J','A','M')
order by last_name;

--년도별 입사인원수를 조회하시오.
select to_char(hire_date,'YYYY') year, count(*) count
from employees
group by to_char(hire_date,'YYYY')
order by year;

--사원번호(employee_id)가 홀수인 사원의 모든 정보를 조회하시오.
select *
from employees
where mod(employee_id,2)=1;

--오늘부터 6개월 후 돌아오는 첫번째 금요일의 날짜를 출력하시오
--(날짜 출력형식: 2002-06-05 15:23:10 금요일)
select to_char(next_day(add_months(sysdate,6),'금요일'),'YYYY-MM-DD HH:MI:SS DAY')
from dual;

--사원번호(employee_id), 사원명(first_name), 상사번호(manager_id)를 조회하되
--상사가 없는(NULL) 경우 상사번호를 '대빵'이라 출력하시오.
select employee_id, first_name, manager_id, DECODE(manager_id, null, '대빵')
from employees;

--10.사원들을 3개축구팀으로 분류하기 위해 사번을 3으로 나누어
--   나머지가 0이면 "영화배우팀"
--   나머지가 1이면 "개그맨팀"
--   나머지가 2이면 "가수팀"으로 분류하여 팀이름, 사원번호, 사원명을 출력하시오.
select employee_id"사원번호", first_name"사원명",
    CASE 
        WHEN mod(employee_id ,3)=0 THEN '영화배우팀'
        WHEN mod(employee_id ,3)=1 THEN '개그맨팀'
        WHEN mod(employee_id ,3)=2 THEN '가수팀' 
        
    END "팀이름"
from employees
order by employee_id;
        

--11.사원별 급여그래프를 아래와 같이 출력하시오(2컬럼으로 출력)
--   이름            급여그래프
--   -------------------------------------------------------
--   Steven King     *****($5,000) // $1000달러당 별 1개추가.
--   Neena Kochhar   ***($3,000)--    .........
--   XXXX XXXXX      *****************($17,000)
select concat(concat(first_name, ' ' ) , last_name) "이름" ,
            RPAD(' ', ROUND(salary/1000)+1,'*') || '('|| TO_CHAR(salary,'99,999')||')' "급여그래프"
from employees
order by salary desc;


--12.2002년 3월부터 2003년 2월 기간 동안 입사한 사원을 대상으로 부서별 인원수를 조회하시오(결과는 인원수가 많은 순서대로 정렬하여 출력)
select department_id, count(department_id) cnt
from employees
where to_char(hire_date,'YYYY-MM') >= '2002-03' and to_char(hire_date,'YYYY-MM') <= '2003-02'
group by department_id
order by department_id;

--13.업무별 평균 급여를 계산하라. 단, 평균급여가 10000을 초과하는 경우는 제외하고 평균 급여에 대해 내림차순으로 정렬하시오.
select department_id "부서번호" , avg(salary) "평균급여"
from employees
group by department_id
having avg(salary)<=10000
order by avg(salary) desc;

--14.연도에 상관없이 월별 입사한 사원수를 아래와 같이 출력하시오.
--1월  2월 ........................12월
---------------------------------------
--2     1  ........................ 5
SELECT to_char(hire_date,'MM')||'월' "입사달", count(*) || '명' "직원수"
from employees
group by to_char(hire_date,'MM')
order by to_char(hire_date,'MM');


--15.'London'에서 근무하는 모든 사원의 사원번호(employee_id), 사원이름(last_name), 업무이름(job_title), 부서이름(department_name), 부서위치(city)를 조회하시오.
--  --관련 테이블 : employees, jobs, departments, locations
select e.employee_id, e.last_name, j.job_title, d.department_name, l.city
from employees e 
    join jobs j
    on e.job_id = j.job_id
    join departments d
    on e.department_id = d.department_id
    join locations l
    on d.location_id = l.location_id;

--16.사원이름(last_name)에 'A'가 포함된 사원의 이름(last_name)과 부서명(department_name)을 조회하시오.
select e.last_name, d.department_name
from employees e
    join departments d
    on e.department_id = d.department_id
where e.last_name like '%A%';
    
--17. 급여(salary)가 3000에서 5000 사이인 사원의 번호, 이름, 급여, 부서명을 조회하라.
select e.employee_id, e.last_name, e.salary, d.department_name
from employees e
    join departments d
    on e.department_id = d.department_id
where salary between 3000 and 5000
order by salary;
--18. 'Accounting' 부서에 근무하는 사원의 이름과 입사일을 조회하라.
--   -- 입사일 출력 형식 - 2007년 05월 21일(월요일)
select e.first_name, e.last_name, to_char(e.hire_date,'""YYYY"년 "MM"월 "DD"일"(DAY)""'), d.department_name
from employees e
    join departments d
    on e.department_id = d.department_id
    where d.department_name = 'Accounting';
    
--19. 'Landry(last_name)'와 동일 부서에 근무하는 사원의 모든 모든 정보를 조회하라(단. Landry은 제외)
select *
from departments d
    join employees e
    ON d.department_id = e.department_id
where d.department_id = (select department_id
                            from employees
                            where last_name = 'Landry')
        and last_name != 'Landry';
--20. 'Lee(last_name)'보다 늦게 입사한 사원의 이름과 입사일 조회하라.
select last_name, hire_date
from employees
where hire_date > (select hire_date
                    from employees
                    where last_name = 'Lee');

--21. 'Lee(last_name)'보다 많은 급여를 받는 사원의 이름과 급여을 조회하라.
select last_name, salary
from employees
where salary > (select salary
                from employees
                where last_name = 'Lee')
                order by salary;
                
--22. 50번 부서의 사원들과 같은 급여를 받는 사원의 이름과 급여를 조회하라.
select last_name, salary
from employees
where salary in (select salary
                from employees
                where department_id = '50');
                
--23. 모든 사원의 평균급여보다 많은 급여를 받는 사원들의 사번, 이름, 급여를 조회하라.
select employee_id, last_name, salary
from employees
where salary > (select avg(salary)
                from employees);
--24.이름(last_name)에  'T'가 포함되어 있는 사원과 동일한 부서에 근무하는 사원의 번호, 이름을 조회하라.
select employee_id, last_name, department_id
from employees
where department_id in (select department_id
                        from employees
                        where last_name like '%T%');
--25.10번 부서 최대급여자와 동일한 급여를 받는 사원의 번호, 이름, 급여를 조회하라.
select employee_id, last_name, salary
from employees
where salary > (select max(salary)
                from employees
                where department_id = '10')
                order by salary;
--26. 'IT_PROG' 업무의 최대 급여자보다 많은 급여를 받는 사원 정보(부서번호, 사원번호, 이름, 급여)를 출력하라.
select department_id, employee_id, last_name, salary, job_id
from employees
where salary > (select max(salary)
                from employees
                where job_id = 'IT_PROG');
--27. 평균 급여보다 많은 급여를 받고 이름에 u가 포함된 사원과 같은 부서에 근무하는 모든 사원의 사원 정보(사원번호, 이름, 급여)를 조회하라.
select employee_id, last_name , salary
from employees
where salary > (select avg(salary)
                from employees)
        and last_name like '%u%';
--28. 평균급여가 가장 적은 업무번호(job_id)와 평균급여를 출력하라
--    예) 업무번호  평균급여
--       -------------------
--        CLERK      2300   
select job_id "업무번호" , avg(salary) "평균급여"
from employees
group by job_id
having avg(salary) = (select min(avg(salary))
                    from employees
                    group by job_id);
            

                

                
                    

                






