/* #1. HR ���Դ� ����� ���� ������ ���� ������ DBA ����(sys or system)���� ���� �� User ���� */
-- sqlplus ���� : conn /as sysdba;
SELECT *
FROM hr.employees;

/* #2. User ���� */
CREATE USER bangry IDENTIFIED BY bangry;

/* #3. ������ User�� �ý��� ���� / ��ü(���̺�, �� ��)�� ���� ���� �ο� */
-- �ý��� ���� ���� �ο�
GRANT CREATE SESSION TO bangry;

-- ��ü�� ���� ���� �ο�(sys�� bangry���� hr��Ű���� employees ���̺� ���� CRUD ������ �ο�)
GRANT SELECT, INSERT, UPDATE, DELETE ON hr.employees
TO bangry;

/* #4. �ʿ信 ���� User���� �ο��� ���� ȸ�� */
REVOKE SELECT, INSERT, UPDATE, DELETE ON hr.employees
FROM bangry;