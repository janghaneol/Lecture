-- �� ��ȯ �Լ�(to_char())
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

--sysdate�� �⺻���� yy/mm/dd
SELECT sysdate
from dual;
--TO_CHAR()�� ���ϴ´�� ������ �� ����
SELECT TO_CHAR(sysdate, 'YYYY-MM-DD AM HH:MI:SS DAY')
from dual;

--�Խó⵵�� 2002�⵵�� �����
SELECT first_name, hire_date
FROM employees
WHERE TO_CHAR(hire_date, 'YYYY') = '2002';

--TO_NUMBER()�Լ�
SELECT TO_NUMBER('12345') + 1
FROM dual;

SELECT TO_NUMBER('12,345', '00,000') + 1
FROM dual;

SELECT TO_NUMBER('1000') + TO_NUMBER('2,000', '0,000') + 1
FROM dual;

--TO_DATE()�Լ�  ���ڿ��� DATE�� ��ȯ
SELECT TO_DATE('2021/12/31 18:45:23', 'YYYY/MM/DD HH24:MI:SS')
FROM dual;

SELECT first_name, hire_date
FROM employees
WHERE hire_date = TO_DATE('2003-06-17', 'YYYY-MM-DD');

SELECT first_name, hire_date
FROM employees
WHERE hire_date = TO_DATE(20030617, 'YYYY-MM-DD');

--�Ϲ��Լ� (nvl(), nvl2())
SELECT NVL(NULL, 10) FROM dual;

SELECT 10*NULL, 10*NVL(NULL, 1)
FROM dual;

SELECT first_name, salary, NVL(commission_pct, 0)
FROM employees;

--null�� �ϳ��� ���̱⶧���� commission_pct�� ���� null�� ������� ������ null���� ǥ��ȴ�.
SELECT first_name, salary, commission_pct, ( salary + ( salary * commission_pct ) ) * 12 "����"
FROM employees;

--����� salary�� commission_pct�� null���̸� 0�� �־��༭ ����ϹǷ� ������ ����� ��µȴ�.
SELECT first_name, salary, commission_pct, ( salary + ( salary * NVL(commission_pct, 0) ) ) * 12 "����"
FROM employees;

SELECT first_name, salary, salary + TO_CHAR(salary *(NVL2(commission_pct, commission_pct, 0)))*12 ,'999,999' "����"
FROM employees;

SELECT first_name, salary, NVL2(TO_CHAR(commission_pct), TO_CHAR(commission_pct), '���Ի��') "�μ�Ƽ��"
FROM employees;

SELECT first_name, salary, commission_pct, TO_CHAR(( salary + ( salary * NVL(commission_pct, 0) ) ) * 12,'999,999') "����"
FROM employees;

--DECODE()�Լ�
SELECT first_name, job_id,
    DECODE(job_id, 'IT_PROG', '������',
            'AC_MRG', '������',
            'FI_ACCOUNT', 'ȸ���',
            '����')
FROM employees;

-- ȸ�� ������ �޿� �λ�
SELECT first_name, job_id, salary,
            DECODE(job_id, 'IT_PROG', salary * 1.5,
                'AC_MRG', salary * 1.3,
                'AC_ASST', salary * 1.1,
                salary) "�λ�޿�"
FROM employees;

--CASE ~ WHEN ǥ����
SELECT first_name,department_id,
        CASE
            WHEN department_id = 10 THEN '������'
            WHEN department_id = 20 THEN '�ѹ���'
            WHEN department_id = 30 THEN '�λ��'
            
        ELSE '�λ�߷�'
        END "�μ���"
FROM employees
ORDER BY department_id DESC;

-- ��ü �����(NULL�� ���� �ȵ�)
SELECT COUNT(department_id) FROM employees;

-- ��ü �����(NULL ����)
SELECT COUNT(*) FROM employees;

-- Ŀ�̼� �޴� ����� ��
SELECT COUNT(commission_pct)
FROM employees;
SELECT COUNT(*) "��ü�����", COUNT(commission_pct) "Ŀ�̼ǻ����"
FROM employees;

-- �޿� �Ѿ�(NULL�� ����)
SELECT SUM(salary)
FROM employees;

-- �޿� ���(NULL�� ����)
SELECT AVG(salary+(salary*NVL(commission_pct,0)))
FROM employees;

-- Ŀ�̼� ���
SELECT AVG(commission_pct), AVG(NVL(commission_pct, 0))
FROM employees;

-- �ִ밪, �ּҰ�
SELECT MAX(salary), MIN(salary), MAX(commission_pct), MIN(commission_pct)
FROM employees;

SELECT MAX(hire_date), MIN(hire_date), MAX(hire_date) - MIN(hire_date) "«����"
FROM employees;

-- GROUP BY ��(Ư�� �÷��� �������� �׷���)
SELECT department_id
FROM employees
GROUP BY department_id;

-- �μ��� �޿��Ѿ�, ���
SELECT department_id, SUM(salary), AVG(salary)
FROM employees
GROUP BY department_id;

-- HAVING ��(�׷쿡 ���� ����)
SELECT department_id, SUM(salary) "sum", AVG(salary) "avg"
FROM employees
GROUP BY department_id
--HAVING department_id = 10;
--ORDER BY department_id;
ORDER BY "avg"; --��Ī�� ���ϸ� order by���� �� �� �ִ�.

--��� �޿��� 3000 �̻��� department_id ���
SELECT department_id, SUM(salary), AVG(salary)
FROM employees
GROUP BY department_id
HAVING AVG(salary) >= 3000;

--��ձ޿� 20000�̻�
SELECT department_id, MAX(salary), MIN(salary)
FROM employees
GROUP BY department_id
HAVING MAX(salary) > 20000;

--������ �Ի��� �����
SELECT hire_date, COUNT(*)
FROM employees
GROUP BY hire_date
ORDER BY hire_date;
--ORDER BY COUNT(*);


