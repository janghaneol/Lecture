-- 형 변환 함수(to_char())
SELECT TO_CHAR(12345), TO_CHAR(12345.67)
FROM dual;

SELECT TO_CHAR(12345, '999,999'), TO_CHAR(12345.677, '999,999.99')
FROM dual;

SELECT TO_CHAR(12345, '000,000'), TO_CHAR(12345.677, '000,000.00')
FROM dual;

SELECT TO_CHAR(150, '$9999'), TO_CHAR(150, '$0000')
FROM dual;

SELECT TO_CHAR(150, 'S9999'), TO_CHAR(150, 'S0000')
FROM dual;

SELECT TO_CHAR(150, '9999MI'), TO_CHAR(-150, '9999MI')
FROM dual;

SELECT TO_CHAR(150, '9999EEEE'), TO_CHAR(150, '99999B')
FROM dual;

--sysdate의 기본형은 yy/mm/dd
SELECT sysdate
from dual;
--TO_CHAR()로 원하는대로 보여줄 수 있음
SELECT TO_CHAR(sysdate, 'YYYY-MM-DD AM HH:MI:SS DAY')
from dual;

--입시년도가 2002년도인 사원들
SELECT first_name, hire_date
FROM employees
WHERE TO_CHAR(hire_date, 'YYYY') = '2002';

--TO_NUMBER()함수
SELECT TO_NUMBER('12345') + 1
FROM dual;

SELECT TO_NUMBER('12,345', '00,000') + 1
FROM dual;

SELECT TO_NUMBER('1000') + TO_NUMBER('2,000', '0,000') + 1
FROM dual;

--TO_DATE()함수  문자열을 DATE로 변환
SELECT TO_DATE('2021/12/31 18:45:23', 'YYYY/MM/DD HH24:MI:SS')
FROM dual;

SELECT first_name, hire_date
FROM employees
WHERE hire_date = TO_DATE('2003-06-17', 'YYYY-MM-DD');

SELECT first_name, hire_date
FROM employees
WHERE hire_date = TO_DATE(20030617, 'YYYY-MM-DD');

--일반함수 (nvl(), nvl2())
SELECT NVL(NULL, 10) FROM dual;

SELECT 10*NULL, 10*NVL(NULL, 1)
FROM dual;

SELECT first_name, salary, NVL(commission_pct, 0)
FROM employees;

--null도 하나의 값이기때문에 commission_pct의 값이 null인 사원들의 연봉은 null값이 표기된다.
SELECT first_name, salary, commission_pct, ( salary + ( salary * commission_pct ) ) * 12 "연봉"
FROM employees;

--사원의 salary에 commission_pct가 null값이면 0을 넣어줘서 계산하므로 연봉이 제대로 출력된다.
SELECT first_name, salary, commission_pct, ( salary + ( salary * NVL(commission_pct, 0) ) ) * 12 "연봉"
FROM employees;

SELECT first_name, salary, salary + TO_CHAR(salary *(NVL2(commission_pct, commission_pct, 0)))*12 ,'999,999' "연봉"
FROM employees;

SELECT first_name, salary, NVL2(TO_CHAR(commission_pct), TO_CHAR(commission_pct), '신입사원') "인센티브"
FROM employees;

SELECT first_name, salary, commission_pct, TO_CHAR(( salary + ( salary * NVL(commission_pct, 0) ) ) * 12,'999,999') "연봉"
FROM employees;

--DECODE()함수
SELECT first_name, job_id,
    DECODE(job_id, 'IT_PROG', '개발자',
            'AC_MRG', '관리자',
            'FI_ACCOUNT', '회계사',
            '직원')
FROM employees;

-- 회사 직종별 급여 인상
SELECT first_name, job_id, salary,
            DECODE(job_id, 'IT_PROG', salary * 1.5,
                'AC_MRG', salary * 1.3,
                'AC_ASST', salary * 1.1,
                salary) "인상급여"
FROM employees;

--CASE ~ WHEN 표현식
SELECT first_name,department_id,
        CASE
            WHEN department_id = 10 THEN '영업부'
            WHEN department_id = 20 THEN '총무부'
            WHEN department_id = 30 THEN '인사부'
            
        ELSE '인사발령'
        END "부서명"
FROM employees
ORDER BY department_id DESC;

-- 전체 사원수(NULL은 포함 안됨)
SELECT COUNT(department_id) FROM employees;

-- 전체 사원수(NULL 포함)
SELECT COUNT(*) FROM employees;

-- 커미션 받는 사원의 수
SELECT COUNT(commission_pct)
FROM employees;
SELECT COUNT(*) "전체사원수", COUNT(commission_pct) "커미션사원수"
FROM employees;

-- 급여 총액(NULL은 무시)
SELECT SUM(salary)
FROM employees;

-- 급여 평균(NULL은 무시)
SELECT AVG(salary+(salary*NVL(commission_pct,0)))
FROM employees;

-- 커미션 평균
SELECT AVG(commission_pct), AVG(NVL(commission_pct, 0))
FROM employees;

-- 최대값, 최소값
SELECT MAX(salary), MIN(salary), MAX(commission_pct), MIN(commission_pct)
FROM employees;

SELECT MAX(hire_date), MIN(hire_date), MAX(hire_date) - MIN(hire_date) "짬밥차"
FROM employees;

-- GROUP BY 절(특정 컬럼을 기준으로 그룹핑)
SELECT department_id
FROM employees
GROUP BY department_id;

-- 부서별 급여총액, 평균
SELECT department_id, SUM(salary), AVG(salary)
FROM employees
GROUP BY department_id;

-- HAVING 절(그룹에 대한 조건)
SELECT department_id, SUM(salary) "sum", AVG(salary) "avg"
FROM employees
GROUP BY department_id
--HAVING department_id = 10;
--ORDER BY department_id;
ORDER BY "avg"; --별칭을 정하면 order by절을 줄 수 있다.

--평균 급여가 3000 이상인 department_id 출력
SELECT department_id, SUM(salary), AVG(salary)
FROM employees
GROUP BY department_id
HAVING AVG(salary) >= 3000;

--평균급여 20000이상
SELECT department_id, MAX(salary), MIN(salary)
FROM employees
GROUP BY department_id
HAVING MAX(salary) > 20000;

--연도별 입사한 사원수
SELECT hire_date, COUNT(*)
FROM employees
GROUP BY hire_date
ORDER BY hire_date;
--ORDER BY COUNT(*);


